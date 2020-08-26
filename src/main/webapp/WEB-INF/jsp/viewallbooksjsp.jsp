<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
       
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
  <jsp:include page="welcomejsp.jsp"></jsp:include> 

<style>

table{
margin:100px;
}
table, th, td {
padding:5px;
  border: 1px solid black;
  text-align: left;

}
th{
    background-color: gold;
height:40px;
}
tr{
background-color: buttonface;
height:40px;
}
</style>


</head>
<body>
    <br>
       <%  
           String msg=(String)request.getAttribute("msg");
 
        if(msg!=null){
          %>
       <script language="javascript">
             var Value ="<%= msg%>";
       alert(Value);
   
    
       </script>
         
     <%}%>
       
  
       <%  String n=(String)session.getAttribute("logintype"); %>
                   

   <% String search=(String)request.getAttribute("msg1");
       if(search=="yes"){
       
  %>
    <h1 style="margin-left:500px;">Search Result</h1>
    <%} else{%>  
    <h1 style="margin-left:500px;">List of books</h1>
    <%}%>
    <table style="width:60%">
		<tr>
			<th> Book Id</th>
			<th> Book Name</th>
			<th> Genre</th>
                                                          <th> No.Of copies currently available </th>
			<th> Price</th>
                       <%	                        if(n.equals("admin")){
       %>
                        <th> Action </th>
	<%}%>		
			</tr>
		<c:forEach var="book" items="${list}">
			<tr>
				<td>${book.bid}</td>
				<td>${book.bookname}</td>
				<td>${book.genre}</td>
				<td>${book.copies}</td>
				  <td>${book.price}</td>
	<%	                        if(n.equals("admin")){
       %>		
                                  <td><a href="gotoupdatebookjsp?id=<c:out value='${book.bid}'/>">Update</a> | <a
					href="deletebook?id=<c:out value='${book.bid}'/>">Delete</a></td>
	<%}%>		
                        </tr>
		</c:forEach>
	</table>
    
    
</body>
</html>                                		