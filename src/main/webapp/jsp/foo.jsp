<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<%!
	int x = 0;
	public void jspInit() {
		x = new Random().nextInt(100) + 1;
	}
	
	class Lotto {
		int getNumber() {
			return x;
		}			
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我是 foo.jsp</title>
</head>
<body>
	<h1><%=x %></h1>
	<h1>
		<%
			Lotto lotto = new Lotto();
			out.println(lotto.getNumber());
		%>
	</h1>
	
</body>
</html>