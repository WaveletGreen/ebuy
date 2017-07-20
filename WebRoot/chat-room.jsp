<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>易买网 - 聊天室</title>
<meta http-equiv="expires" content="0">
<script type="text/javascript" src="scripts/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="scripts/jquery-form.js"></script>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript">
	$(function() {
		//发送数据
		$("#send").click(function() {
			if ($(this).val() == null) {
				return;
			} else {
				$.ajax({
					url : "${pageContext.request.contextPath}/json/ajaxReq_pushContent.action",
					data : {
						"content" : $("#content").val(),
						"talker" : $("#talker").val(),
					},
					dataType : "text",
					timeout : 10000,
					success : function() {
						$("#content").val('');
						if ($("#status").text() != "状态：在线") {
							$("#status").text("状态：在线");
						}
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						$("#status").text("状态：网络连接错误，请稍后重试");
					},
				})
			}
		});
		(function longPolling() {

			$.ajax({
				url : "${pageContext.request.contextPath}/json/ajaxReq_pullContent.action",
				data : {
					"timed" : new Date().getTime(),
					"appIndex" : $("#index").val(),
				},
				dataType : "text",
				timeout : 5000,
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					$("#status").text("状态：网络连接错误，请稍后重试");
					if (textStatus == "timeout") { // 请求超时
						window.setTimeout(longPolling(), 3000);
					// 其他错误，如网络错误等
					} else {
						window.setTimeout(longPolling(), 3000);
					}
				},
				success : function(data, textStatus) {
					if (textStatus == "success") { // 请求成功
						var v = eval(data);
						if (v == null) {
							window.setTimeout(longPolling(), 2000);
						} else {
							var contents = JSON.parse(v);
							for (var i = 0; i < contents.length; i++) {
								var index = parseInt($("#index").val());
								$("#index").val(index + 1);
								if ($("#index").val() > 10) {
									$("#index").val(1);
								}
								$("#history").append("----------data: { " + contents[i] + "} ]<br/>");
							}
							window.setTimeout(longPolling(), 2000);
						}

					}
				}
			});
		})();

	});

	function setReceiver(obj) {
		document.getElementById("reply-to").innerHTML = "接收人：" + obj.innerHTML;
	}
</script>
</head>

<body>
	<div id="chat-room">
		<div class="lefter">
			<h2>在线用户列表</h2>
			<ul>
				<s:iterator value="userList" var="user">
					<s:if test="#user==#session.user">
						<li>我</li>
					</s:if>
					<s:else>
						<li><a href="javascript:void(0)" onclick="setReceiver(this);"><s:property
									value="#user.username" /></a></li>
					</s:else>

				</s:iterator>
			</ul>
		</div>
		<div class="righter">
			<input type="hidden" id="index" value=0 /> <input type="hidden"
				id="talker" value="<s:property value="#session.user"/>" />

			<div id="history"></div>
			<div class="spacer"></div>
			<div id="reply-to">
				接收人：所有 <span id="status" style="color:red;margin-left:10%">状态：在线</span>
			</div>
			<div class="reply">
				<input type="text" class="text" id="content" /><label
					class="ui-blue"><input id="send" type="button" value="发送" /></label>
			</div>
		</div>
	</div>
</body>
</html>
