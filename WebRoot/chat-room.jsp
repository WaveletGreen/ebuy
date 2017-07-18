<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'chat-room.jsp' starting page</title>
<meta http-equiv="expires" content="0">
<script type="text/javascript" src="scripts/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="scripts/jquery-form.js"></script>

<script type="text/javascript">
	$(function() {

		(function longPolling() {

			$.ajax({
				url : "${pageContext.request.contextPath}/json/ajaxReq.action",
				data : {
					"timed" : new Date().getTime()
				},
				dataType : "text",
				timeout : 5000,
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					$("#state").append("[state: " + textStatus + ", error: " + errorThrown + " ]<br/>");
					if (textStatus == "timeout") { // 请求超时
						longPolling(); // 递归调用
					// 其他错误，如网络错误等
					} else {
						longPolling();
					}
				},
				success : function(data, textStatus) {
					alert(data);
					$("#state").append("[state: " + textStatus + ", ----------data: { " + data + "} ]<br/>");
					if (textStatus == "success") { // 请求成功
						longPolling();
					}
				}
			});
		})();

	});
</script>
</head>

<body>
	<div id="state"></div>
</body>
</html>
