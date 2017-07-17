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
<meta http-equiv="expires" content="0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 正在浏览<s:property value="product.name" /></title>
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
		您现在的位置：<a href="index.html">易买网</a> &gt; <a href="product-list.html">图书音像</a>
		&gt; 图书
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
			<div class="spacer"></div>
			<div class="last-view">
				<h2>最近浏览</h2>
				<dl class="clearfix">
					<dt>
						<img src="images/product/0_tiny.gif" />
					</dt>
					<dd>
						<a href="product-view.html">法国德菲丝松露精品巧克力500g/盒</a>
					</dd>
					<dt>
						<img src="images/product/0_tiny.gif" />
					</dt>
					<dd>
						<a href="product-view.html">法国德菲丝松露精品巧克力500g/盒</a>
					</dd>
				</dl>
				<script type="text/javascript">
					document.write("Cookie中记录的购物车商品ID：" + getCookie("product") + "，可以在动态页面中进行读取");
				</script>
			</div>
		</div>
		<div class="main">
			<div class="product-list">
				<h2>全部商品</h2>
				<div class="pager">
					<ul class="clearfix">
						<!-- 					上一页 -->
						<s:if test="page.prePageIndex!=page.pageIndex">
							<li><a
								href="common_ProductCommon_viewByPage_product-list_error.action?type=TProduct&page.pageIndex=<s:property value="page.prePageIndex"/>&page.maxResult=12">上一页</a></li>
						</s:if>
						<!-- 						上上一页 -->
						<s:if test="page.pageIndex-1>0">
							<li><a
								href="common_ProductCommon_viewByPage_product-list_error.action?type=TProduct&page.pageIndex=<s:property value="page.prePageIndex-1"/>&page.maxResult=12"><s:property
										value="page.pageIndex-1" /></a></li>
						</s:if>
						<!-- 						上一页 -->
						<s:if test="page.pageIndex-1>=0">
							<li><a
								href="common_ProductCommon_viewByPage_product-list_error.action?type=TProduct&page.pageIndex=<s:property value="page.prePageIndex"/>&page.maxResult=12"><s:property
										value="page.pageIndex" /></a></li>
						</s:if>
						<!-- 						当前页 -->
						<li class="current"><s:property value="page.pageIndex+1" /></li>
						<!-- 						下一页 -->
						<s:if test="page.pageIndex+1<=page.totalPages">
							<li><a
								href="common_ProductCommon_viewByPage_product-list_error.action?type=TProduct&page.pageIndex=<s:property value="page.nextPageIndex"/>&page.maxResult=12"><s:property
										value="page.nextPageIndex+1" /></a></li>
						</s:if>
						<!-- 						下下一页 -->
						<s:if test="page.pageIndex+1<page.totalPages">
							<li><a
								href="common_ProductCommon_viewByPage_product-list_error.action?type=TProduct&page.pageIndex=<s:property value="page.nextPageIndex+1"/>&page.maxResult=12"><s:property
										value="page.nextPageIndex+2" /></a></li>
						</s:if>
						<!-- 						下一页 -->
						<s:if test="page.nextPageIndex>page.pageIndex">
							<li><a
								href="common_ProductCommon_viewByPage_product-list_error.action?type=TProduct&page.pageIndex=<s:property value="page.nextPageIndex"/>&page.maxResult=12">下一页</a></li>
						</s:if>
					</ul>
				</div>
				<div class="clear"></div>
				<ul class="product clearfix">
					<s:iterator value="products" var="p">
						<li>
							<dl>
								<dt>
									<a
										href="common_ViewerCommon_view_product-view_index.action?type=TProduct&product.id=<s:property value='#p.id'/>"
										target="_blank"><img src='<s:property value="#p.proPic"/>' />
									</a>
								</dt>
								<dd class="title">
									<a
										href="common_ViewerCommon_view_product-view_index.action?type=TProduct&product.id=<s:property value='#p.id'/>"
										target="_blank"><s:property value="#p.name" /></a>
								</dd>
								<dd class="price">
									￥
									<s:property value="#p.price" />
								</dd>
							</dl>
						</li>
					</s:iterator>
				</ul>
				<div class="clear"></div>
				<div class="pager">
					<ul class="clearfix">
						<!-- 					上一页 -->
						<s:if test="page.prePageIndex!=page.pageIndex">
							<li><a
								href="common_ProcductCommon_viewByPage_product-list_error.action?type=TProduct&page.pageIndex=<s:property value="page.prePageIndex"/>&page.maxResult=12">上一页</a></li>
						</s:if>
						<!-- 						上上一页 -->
						<s:if test="page.pageIndex-1>0">
							<li><a
								href="common_ProcductCommon_viewByPage_product-list_error.action?type=TProduct&page.pageIndex=<s:property value="page.prePageIndex-1"/>&page.maxResult=12"><s:property
										value="page.pageIndex-1" /></a></li>
						</s:if>
						<!-- 						上一页 -->
						<s:if test="page.pageIndex-1>=0">
							<li><a
								href="common_ProcductCommon_viewByPage_product-list_error.action?type=TProduct&page.pageIndex=<s:property value="page.prePageIndex"/>&page.maxResult=12"><s:property
										value="page.pageIndex" /></a></li>
						</s:if>
						<!-- 						当前页 -->
						<li class="current"><s:property value="page.pageIndex+1" /></li>
						<!-- 						下一页 -->
						<s:if test="page.pageIndex+1<=page.totalPages">
							<li><a
								href="common_ProcductCommon_viewByPage_product-list_error.action?type=TProduct&page.pageIndex=<s:property value="page.nextPageIndex"/>&page.maxResult=12"><s:property
										value="page.nextPageIndex+1" /></a></li>
						</s:if>
						<!-- 						下下一页 -->
						<s:if test="page.pageIndex+1<page.totalPages">
							<li><a
								href="common_ProcductCommon_viewByPage_product-list_error.action?type=TProduct&page.pageIndex=<s:property value="page.nextPageIndex+1"/>&page.maxResult=12"><s:property
										value="page.nextPageIndex+2" /></a></li>
						</s:if>
						<!-- 						下一页 -->
						<s:if test="page.nextPageIndex>page.pageIndex">
							<li><a
								href="common_ProcductCommon_viewByPage_product-list_error.action?type=TProduct&page.pageIndex=<s:property value="page.nextPageIndex"/>&page.maxResult=12">下一页</a></li>
						</s:if>
					</ul>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2010 华育国际 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>
