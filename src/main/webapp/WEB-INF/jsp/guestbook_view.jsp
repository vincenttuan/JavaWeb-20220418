<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.1.0/build/pure-min.css">
<meta charset="UTF-8">
<title>Guestbook</title>
</head>
<body style="padding: 20px">
	<form class="pure-form" method="post" action="/JavaWeb-20220418/guestbook/${ button_name }">
		<fieldset>
			<legend>Guestbook Form</legend>
			姓名: <input type="text" name="username" placeholder="請輸入 username" /><p /> 
			內容: <input type="text" name="content" placeholder="請輸入內容" /><p /> 
			<button type="submit" class="pure-button pure-button-primary">${ button_name }</button>
		</fieldset>
	</form>
	<form class="pure-form">
		<fieldset>
			<legend>Guestbook List</legend>
			<table class="pure-table pure-table-bordered">
				<thead>
					<th>id</th><th>姓名</th><th>內容</th><th>留言時間</th><th>修改</th><th>刪除</th>
				</thead>
				<tbody>
					${ guestbooks }
				</tbody>
			</table>
		</fieldset>	
	</form>
</body>
</html>