<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
    <head>
		<meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <title>登陆</title>
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <link rel="stylesheet" type="text/css" href="css/googleFontsRaleway.css" />
		<script src="js/modernizr.custom.63321.js"></script>
		<!--[if lte IE 7]><style>.main{display:none;} .support-note .note-ie{display:block;}</style>
		<![endif]-->
		<style>	

			body {
				background: #7f9b4e url(images/bg2.jpg) no-repeat center top;
				-webkit-background-size: cover;
				-moz-background-size: cover;
				background-size: cover;
			}
			.container > header h1,
			.container > header h2 {
				color: #fff;
				text-shadow: 0 1px 1px rgba(0,0,0,0.7);
			}
		</style>
    </head>
    <body>
        <div class="container">
			
			<header>

				<div class="support-note">
					<span class="note-ie">Sorry, only modern browsers.</span>
				</div>
				
			</header>
			
			<div class="main">
				<form class="form-4" method="post" action="login.do" >
				    <h1>系统登录</h1>
				    <p>
				        <label for="login">用户编码：</label>
				        <input type="text" name="userCode" placeholder="用户编码" value="<s:property value='userCode'/>" required>
				    </p>
				    <p>
				        <label for="password">用户口令：</label>
				        <input type="password" name='password' placeholder="口令" required> 
				    </p>
				    
				    <!-- 
				    <p>
				    	<input type="text" name='yzm' placeholder="" style="float:left;width:45%;display:inline-block;"/>
				    	<img src="images/yzm.jpg" style="float:right;height:32px;width:45%;"/>
				    </p>
 					-->
 					
				    <p>
				        <input type="submit" value="登录">
				    </p>    
				    
				    <p>
				    <br>
				    <s:fielderror />
				    </p>
				       
				</form>
			</div>
			
        </div>

    </body>
</html>