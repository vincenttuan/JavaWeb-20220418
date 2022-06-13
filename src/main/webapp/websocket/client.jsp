<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
	<meta charset="UTF-8">
	<title>WebSocket 聊天室</title>
	<script>
		// 當網頁元件載入完成之後才執行
		window.onload = function() {
			var webSocket = null;
			// 獲取 DOM 元件
			var username = document.getElementById("username");
			var loginBtn = document.getElementById("loginBtn");
			
			// 註冊元件的監聽器
			loginBtn.addEventListener("click", function() {
				setWebSocket();
			});
			
			// 設置 WebSocket
			function setWebSocket() {
				var url = 'ws://' + window.location.hostname + ':8080${pageContext.request.contextPath}/websockettest'
				// 開始 WebSocket 連線
				webSocket = new WebSocket(url);
				// 以下就可以開始偵測 WebSocket 的各種事件
				// 連線成功
				webSocket.onopen = function(event) {
					console.log('連線成功');
					// 關閉 loginBtn
					loginBtn.disabled = true;
					var message = {
						username: username.value,
						message: '大家好! 我進來了~~'
					};
					// JSON.stringfly 將 message 物件傳成 json 字串
					webSocket.send(JSON.stringify(message));
				};
				// 連線失敗
				webSocket.onerror = function(event) {
					console.log('連線失敗');
				};
				// 接收訊息
				webSocket.onmessage = function(event) {
					// JSON.parse 將 json 字串變成物件, 以便分析
					var messageObject = JSON.parse(event.data); 
					console.log(messageObject); // 訊息資料
					messageDisplay.innerHTML += messageObject.username + " 說: " +  messageObject.message + "<br>";
				};
			}
			
			// 傳送訊息
			function sendMessage() {
				
			}
		}
	</script>
</head>
<body style="padding: 10px">
	<form class="pure-form">
		<fieldset>
			<legend>WebSocket Client</legend>
			<input type="text" id="username" placeholder="請輸入名稱">
			<button type="button" class="pure-button pure-button-primary" id="loginBtn">
				Socket 登入
			</button>
		</fieldset>
	</form>
	<div id="messageDisplay"></div>
</body>
</html>