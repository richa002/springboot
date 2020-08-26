<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.Date,java.text.SimpleDateFormat,java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


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
	.issuebook-form {
		width: 340px;
    	margin: 50px auto;
	}
    .issuebook-form form {
    	margin-bottom: 15px;
        background: #f7f7f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
    .issuebook-form h2 {
        margin: 0 0 15px;
    }
    .form-control, .btn {
        min-height: 38px;
        border-radius: 2px;
    }
    .btn {        
        font-size: 15px;
        font-weight: bold;
    }
</style>
</head>
<body>
     
    <h1 align="center">Return Book </h1>
<div class="issuebook-form">
    <form action="returnbook">
           <div class="form-group">
               Issue Id:
            <input type="text" class="form-control" value="${issued.issueId}"  name="issueid"  >
        </div>
         
         <div class="form-group">
             User Id:
            <input type="text" class="form-control" value="${issued.user.uid}"  name="uid" >
        </div>
        <div class="form-group">
            Book Id:
            <input type="text" class="form-control" value="${issued.book.bid}"  name="bid" >
        </div>
       
  
        <div class="form-group">
            Issue Date:
            <input type="date" class="form-control"    value="<fmt:formatDate value="${issued.issueDate}" pattern="yyyy-MM-dd" />"  name="issueDate" >
        </div>
         Issued till :
          <div class="form-group">
            <input type="date" class="form-control"  name="toBeReturnedOn" value="<fmt:formatDate value="${issued.toBeReturnedOn}" pattern="yyyy-MM-dd"/>" >
        </div>
        Return Date:
          <div class="form-group">
          
           <input type="date" class="form-control"   id="today"  placeholder="Returning Date"  name="returnDate" >
        
          </div>
      
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Return</button>
        </div>
                
    </form>
   </div>
              <script>
        let today = new Date().toISOString().substr(0, 10);
document.querySelector("#today").value = today;

              </script>
              
    

</body>
</html>                               		