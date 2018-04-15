<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zxx">
<head>
<meta charset="UTF-8">
<title>博客</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1  maximum-scale=1">
<meta name="mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="HandheldFriendly" content="True">
<!-- scripts -->
<script src="resource/js/jquery.min.js"></script>
<script src="resource/js/materialize.min.js"></script>
<script src="resource/js/owl.carousel.min.js"></script>
<script src="resource/js/fakeLoader.min.js"></script>
<script src="resource/js/main.js"></script>
<link rel="stylesheet" href="resource/css/materialize.css">
<link rel="stylesheet"
	href="resource/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="resource/css/normalize.css">
<link rel="stylesheet" href="resource/css/owl.carousel.css">
<link rel="stylesheet" href="resource/css/owl.theme.css">
<link rel="stylesheet" href="resource/css/owl.transitions.css">
<link rel="stylesheet" href="resource/css/fakeLoader.css">
<link rel="stylesheet" href="resource/css/magnific-popup.css">
<link rel="stylesheet" href="resource/css/style.css">
<link rel="shortcut icon" href="resource/img/favicon.png">
</head>
<body>
	<div class="navbar-top">
		<!-- site brand	 -->
		<div class="site-brand">
			<a href="index.htm"><h1>博客</h1></a>
		</div>
	</div>
	<!-- contact us -->
	<div class="pages section">
		<div class="container">
			<div class="pages-head">
				<h3>联系我</h3>
			</div>
			<div class="contact-us">
				<div class="row">
					<div class="col s12">
						<form action="send-mail.php" class="contact-form"
							id="contact-form" method="post">
							<div class="form-group" id="name-field">
								<input type="text" class="validate" id="form-name"
									name="form-name" placeholder="Name" required>
							</div>
							<div class="form-group" id="email-field">
								<input type="email" class="validate" id="form-email"
									name="form-email" placeholder="Email" required>
							</div>
							<div class="form-group" id="subject-field">
								<input type="text" class="validate" id="form-subject"
									name="form-subject" placeholder="Subject" required>
							</div>
							<div class="form-group" id="message-field">
								<textarea name="form-message" id="form-message" cols="30"
									rows="10" class="materialize-textarea"
									placeholder="Your Message" required></textarea>
							</div>
							<div class="form-group">
								<button class="button-default" type="submit" id="submit"
									name="submit">发送</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end contact us -->
</body>
</html>