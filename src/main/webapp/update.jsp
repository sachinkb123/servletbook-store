<%@page import="com.js.dto.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Enter Details to Update </h1>
	<% Book b = (Book)request.getAttribute("book"); %>
	<form action="update2">
		Book Id: <input type="number" name="id" value="<%=b.getBook_id()%>" readonly="readonly"> <br> <br>
		Book Name: <input type="text" name="bookname" value="<%=b.getBook_name()%>"><br><br>
		Author Name: <input type="text" name="authorname" value="<%=b.getAuthor_name()  %>"><br><br>
		No Of Pages: <input type="number" name="nop" value="<%=b.getNo_of_pages()  %>"><br><br>
		Price : <input type="text" name="price" value="<%=b.getPrice()  %>"><br><br>
		<input type="submit" value="update">




	</form>

</body>
</html>