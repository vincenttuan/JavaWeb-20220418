<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.1.0/build/pure-min.css">
<meta charset="UTF-8">
<title>Message result</title>
</head>
<body style="padding: 20px">
	<form class="pure-form">
		<fieldset>
			<legend>Message result:</legend>
			訊息內容: ${ content }<p />
			回應碼(Http Code): ${ httpCode }<p />
		</fieldset>
	</form>
</body>
</html>