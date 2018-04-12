<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<meta name="viewport" content="width=device-width, initial-scale=1  maximum-scale=1">
	<meta name="mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-touch-fullscreen" content="yes">
	<meta name="HandheldFriendly" content="True">
	<link rel="stylesheet" href="resource/css/materialize.css">
	<link rel="stylesheet" href="resource/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="resource/css/normalize.css">
	<link rel="stylesheet" href="resource/css/owl.carousel.css">
	<link rel="stylesheet" href="resource/css/owl.theme.css">
	<link rel="stylesheet" href="resource/css/owl.transitions.css">
	<link rel="stylesheet" href="resource/css/fakeLoader.css">
	<link rel="stylesheet" href="resource/css/magnific-popup.css">
	<link rel="stylesheet" href="resource/css/style.css">
	<link rel="shortcut icon" href="resource/img/favicon.png">
	<!-- scripts -->
	<script src="resource/js/jquery.min.js"></script>
	<script src="resource/js/materialize.min.js"></script>
	<script src="resource/js/owl.carousel.min.js"></script>
	<script src="resource/js/jquery.filterizr.js"></script>
	<script src="resource/js/jquery.magnific-popup.min.js"></script>
	<script src="resource/js/portfolio.js"></script>
	<script src="resource/js/owl.carousel.min.js"></script>
	<script src="resource/js/fakeLoader.min.js"></script>
	<script src="resource/js/main.js"></script>
</head>
<body>
<!-- navbar top -->
	<div class="navbar-top">
		<div class="side-nav-panel-left">
        <!-- 侧边弹出窗口 -->
			<a href="#" data-activates="slide-out-left" class="side-nav-left"><i class="fa fa-bars"></i></a>
		</div>
		<!-- site brand	 -->
		<div class="site-brand">
			<a href="index.html"><h1>我的博客</h1></a>
		</div>
        <!-- 右边信封跳转 -->
		<!-- end site brand	 -->
		<div class="side-nav-panel-right">
			<a href="contact.html" class="side-nav-right"><i class="fa fa-envelope"></i></a>
		</div>
	</div>
	<!-- end navbar top -->

<!-- 左侧弹出内容 -->
	<!-- side nav left-->
	<div class="side-nav-panel-left">
		<ul id="slide-out-left" class="side-nav side-nav-panel collapsible">
			<li class="profil">
				<img src="resource/img/profile.jpg" alt="头像">
				<h2>姓名</h2>
				<h6>职业</h6>
			</li>
			<li class="li-top">
				<div class="collapsible-header"><i class="fa fa-home"></i>主页<span><i class="fa fa-caret-down"></i></span></div>
				<div class="collapsible-body">
					<ul class="side-nav-panel">
						<li><a href="index.htm">主页</a></li>
						<li><a href="home-shop.htm">商店</a></li>
					</ul>
				</div>
			</li>
			<li>
				<div class="collapsible-header"><i class="fa fa-shopping-cart"></i>Shop <span><i class="fa fa-caret-down"></i></span></div>
				<div class="collapsible-body">
					<ul class="side-nav-panel">
						<li><a href="home-shop.html">Shop</a></li>
						<li><a href="shop-single.html">Shop Single</a></li>
						<li><a href="checkout.html">Checkout</a></li>
					</ul>
				</div>
			</li>
			<li>
				<div class="collapsible-header"><i class="fa fa-file-o"></i>Pages <span><i class="fa fa-caret-down"></i></span></div>
				<div class="collapsible-body">
					<ul class="side-nav-panel">
						<li><a href="pricing.html">Pricing</a></li>
						<li><a href="error404.html">404</a></li>
						<li><a href="team.html">Team</a></li>
						<li><a href="testimonial.html">Testimonial</a></li>
					</ul>
				</div>
			</li>
			<li>
				<div class="collapsible-header"><i class="fa fa-bold"></i>Blog <span><i class="fa fa-caret-down"></i></span></div>
				<div class="collapsible-body">
					<ul class="side-nav-panel">
						<li><a href="blog.html">Blog</a></li>
						<li><a href="blog-single.html">Blog Single</a></li>
					</ul>
				</div>
			</li>
			<li><a href="about-us.html"><i class="fa fa-user"></i>About Us</a></li>
			<li><a href="contact.html"><i class="fa fa-envelope-o"></i>Contact Us</a></li>
			<li><a href="login.html"><i class="fa fa-sign-in"></i>Login</a></li>
			<li><a href="register.html"><i class="fa fa-user-plus"></i>Register</a></li>
		</ul>
	</div>
	<!-- end side nav left-->

	<!-- slider -->
	<div class="slider">

		<ul class="slides">
			<li>
				<img src="resource/img/slide1.jpg" alt="">
				<div class="caption slider-content center-align ">
					<div class="container">
						<h2>欢迎来到我的博客(一)</h2>
						<h4>详细介绍</h4>
						<a href="" class="button-default">了解更多</a>
					</div>
				</div>
			</li>
			<li>
				<img src="resource/img/slide2.jpg" alt="">
				<div class="caption slider-content center-align">
					<div class="container">
						<h2>欢迎来到我的博客(二)</h2>
                        <h4>详细介绍</h4>
						<a href="" class="button-default">了解更多</a>
					</div>
				</div>
			</li>
			<li>
				<img src="resource/img/slide3.jpg" alt="">
				<div class="caption slider-content center-align">
					<div class="container">
					<h2>欢迎来到我的博客(三)</h2>
                        <h4>详细介绍</h4>
                        <a href="" class="button-default">了解更多</a>
					</div>
				</div>
			</li>
		</ul>
	</div>
	<!-- end slider -->
	<!-- home portfolio -->
	<div class="section bg-second">
	    <div class="container">
	    	<div class="section-head">
				<h4>详细介绍</h4>
			</div>
	        <div class="portfolio">
		        <div class="row">
		            <div class="filtr-container">
		                <div class="col s6 filtr-item col-pd" data-category="1, 3">
		                    <a href="resource/img/portfolio1.jpg" class="image-popup">
		                    <img class="responsive-img" src="resource/img/portfolio1.jpg" alt="sample image"></a>
		                </div>
		                <div class="col s6 filtr-item col-pd" data-category="2, 3">
		                   <a href="resource/img/portfolio2.jpg" class="image-popup">
		                   <img class="responsive-img" src="resource/img/portfolio2.jpg" alt="sample image"></a>
		                </div>
		                <div class="col s6 filtr-item col-pd" data-category="3, 3">
		                   <a href="resource/img/portfolio3.jpg" class="image-popup">
		                   <img class="responsive-img" src="resource/img/portfolio3.jpg" alt="sample image"></a>
		                </div>
		                <div class="col s6 filtr-item col-pd" data-category="1, 2">
		                   <a href="resource/img/portfolio4.jpg" class="image-popup">
		                   <img class="responsive-img" src="resource/img/portfolio4.jpg" alt="sample image"></a>
		                </div>
		                <div class="col s6 filtr-item col-pd" data-category="2, 1">
		                   <a href="resource/img/portfolio5.jpg" class="image-popup">
		                   <img class="responsive-img" src="resource/img/portfolio5.jpg" alt="sample image"></a>
		                </div>
		                <div class="col s6 filtr-item col-pd" data-category="1, 1">
		                   <a href="resource/img/portfolio6.jpg" class="image-popup">
		                   <img class="responsive-img" src="resource/img/portfolio6.jpg" alt="sample image"></a>
		                </div>
		            </div>
		        </div>
	        </div>
	    </div>
	</div>
	<!-- end home portfolio -->
	<!-- footer -->
	<div class="footer">
		<div class="container">
			<div class="copyright">
				<span>© 2018 All Right Reserved</span>
			</div>
		</div>
	</div>
	<!-- end footer -->
</body>
</html>