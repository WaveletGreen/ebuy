<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'comment.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
	<div id="header" class="wrap">
		<div id="logo">
			<img src="images/logo.gif" />
		</div>
		<div class="help">
			<a href="#" class="shopping">购物车</a><a href="login.html">登录</a><a
				href="register.html">注册</a><a href="guestbook.html">留言</a>
		</div>
		<div class="navbar">
			<ul class="clearfix">
				<li class="current"><a href="#">首页</a></li>
				<li><a href="#">图书</a></li>
				<li><a href="#">百货</a></li>
				<li><a href="#">品牌</a></li>
				<li><a href="#">促销</a></li>
			</ul>
		</div>
	</div>
	<div id="childNav">
		<div class="wrap">
			<ul class="clearfix">
				<li class="first"><a href="#">音乐</a></li>
				<li><a href="#">影视</a></li>
				<li><a href="#">少儿</a></li>
				<li><a href="#">动漫</a></li>
				<li><a href="#">小说</a></li>
				<li><a href="#">外语</a></li>
				<li><a href="#">数码相机</a></li>
				<li><a href="#">笔记本</a></li>
				<li><a href="#">羽绒服</a></li>
				<li><a href="#">秋冬靴</a></li>
				<li><a href="#">运动鞋</a></li>
				<li><a href="#">美容护肤</a></li>
				<li><a href="#">家纺用品</a></li>
				<li><a href="#">婴幼奶粉</a></li>
				<li><a href="#">饰品</a></li>
				<li class="last"><a href="#">Investor Relations</a></li>
			</ul>
		</div>
	</div>
	<div id="position" class="wrap">
		您现在的位置：<a href="index.html">易买网</a> &gt; 在线留言
	</div>
	<div id="main" class="wrap">
		<div class="lefter">
			<div class="box">
				<h2>商品分类</h2>
				<dl>
					<dt>图书音像</dt>
					<dd>
						<a href="product-list.html">图书</a>
					</dd>
					<dd>
						<a href="product-list.html">音乐</a>
					</dd>
					<dt>百货</dt>
					<dd>
						<a href="product-list.html">运动健康</a>
					</dd>
					<dd>
						<a href="product-list.html">服装</a>
					</dd>
					<dd>
						<a href="product-list.html">家居</a>
					</dd>
					<dd>
						<a href="product-list.html">美妆</a>
					</dd>
					<dd>
						<a href="product-list.html">母婴</a>
					</dd>
					<dd>
						<a href="product-list.html">食品</a>
					</dd>
					<dd>
						<a href="product-list.html">手机数码</a>
					</dd>
					<dd>
						<a href="product-list.html">家具首饰</a>
					</dd>
					<dd>
						<a href="product-list.html">手表饰品</a>
					</dd>
					<dd>
						<a href="product-list.html">鞋包</a>
					</dd>
					<dd>
						<a href="product-list.html">家电</a>
					</dd>
					<dd>
						<a href="product-list.html">电脑办公</a>
					</dd>
					<dd>
						<a href="product-list.html">玩具文具</a>
					</dd>
					<dd>
						<a href="product-list.html">汽车用品</a>
					</dd>
				</dl>
			</div>
		</div>
		<div class="main">
			<div class="guestbook">
				<h2>全部留言</h2>
				<ul>
					<s:iterator value="comments" var="cmt">
						<li>
							<dl>
								<dt>
									<s:property value="#cmt.content" />
								</dt>
								<dd class="author">
									网友：
									<s:property value="#cmt.nickName" />
									<span class="timer"> <s:property value="#cmt.replyTime" />
									</span>
								</dd>
								<dd>
									<s:property value="#cmt.replyContent" />
								</dd>
							</dl></li>
					</s:iterator>
				</ul>
				<div class="clear"></div>
				<div class="pager">
					<s:property value="page.totalPages" />
					<s:property value="page.pageIndex" />
					<s:property value="page.nextPageIndex" />
					<ul class="clearfix">
						<!-- 					上一页 -->
						<s:if test="page.prePageIndex!=page.pageIndex">
							<li><a
								href="common_CommentCommon_getUserComment_comment_error.action?page.pageIndex=<s:property value="page.prePageIndex"/>&page.maxResult=5">上一页</a>
							</li>
						</s:if>
						<!-- 						上上一页 -->
						<s:if test="page.prePageIndex-1>0">
							<li><a
								href="common_CommentCommon_getUserComment_comment_error.action?page.pageIndex=<s:property value="page.prePageIndex-1"/>&page.maxResult=5"><s:property
										value="page.prePageIndex-1" /> </a>
							</li>
						</s:if>
						<!-- 						上一页 -->
						<s:if test="page.pageIndex-1>0">
							<li><a
								href="common_CommentCommon_getUserComment_comment_error.action?page.pageIndex=<s:property value="page.prePageIndex"/>&page.maxResult=5"><s:property
										value="page.prePageIndex" /> </a>
							</li>
						</s:if>
						<!-- 						当前页 -->
						<li class="current"><s:property value="page.pageIndex" />
						</li>
						<!-- 						下一页 -->
						<s:if test="page.pageIndex+1<=page.totalPages">
							<li><a
								href="common_CommentCommon_getUserComment_comment_error.action?page.pageIndex=<s:property value="page.nextPageIndex"/>&page.maxResult=5"><s:property
										value="page.nextPageIndex" /> </a>
							</li>
						</s:if>
						<!-- 						下下一页 -->
						<s:if test="page.pageIndex+1<page.totalPages">
							<li><a
								href="common_CommentCommon_getUserComment_comment_error.action?page.pageIndex=<s:property value="page.nextPageIndex+1"/>&page.maxResult=5"><s:property
										value="page.nextPageIndex+1" /> </a>
							</li>
						</s:if>
						<!-- 						下一页 -->
						<s:if test="page.nextPageIndex>page.pageIndex">
							<li><a
								href="common_CommentCommon_getUserComment_comment_error.action?page.pageIndex=<s:property value="page.nextPageIndex"/>&page.maxResult=5">下一页</a>
							</li>
						</s:if>
					</ul>

				</div>
				<div id="reply-box">
					<form
						action="common_CommentCommon_publishComment_comment_error.action?page.pageIndex=1&page.maxResult=5"
						method="post">
						<table>
							<tr>
								<td class="field">昵称：</td>
								<td><input class="text" type="text" name="comment.nickName" />
								</td>
							</tr>
							<tr>
								<td class="field">留言标题：</td>
								<td><input class="text" type="text" name="title" /></td>
							</tr>
							<tr>
								<td class="field">留言内容：</td>
								<td><textarea name="comment.content"></textarea></td>
							</tr>
							<tr>
								<td></td>
								<td><label class="ui-blue"><input type="submit"
										name="submit" value="提交留言" /> </label></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2010 华育国际 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>
