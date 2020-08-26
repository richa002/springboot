

<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap Simple Login Form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<jsp:include page="welcomejsp.jsp"></jsp:include>
<style>
	.addbook-form {
		width: 340px;
    	margin: 50px auto;
	}
    .addbook-form form {
    	margin-bottom: 15px;
        background: #f7f7f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
    .addbook-form h2 {
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
    <script>
function myFunction() {
  alert("Hello! I am an alert box!");
}
</script>
    <h1 style="margin-left:650px;">Update Book </h1>
<div class="addbook-form">
    <form action="updatebook" method="post">
          <div class="form-group">
            <input type="text" class="form-control"  value="Book Id : ${Book.bid}"  disabled="disabled">
        </div>
        <div class="form-group">
            <input type="hidden"   name="bid" value='${Book.bid}' >
        </div>
          
         <div class="form-group">
            <input type="text" class="form-control" placeholder="Book Name"  name="bookname" value='${Book.bookname}' required="required">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Book Genre"  value='${Book.genre}'   name="genre" required="required">
        </div>
       
         <div class="form-group">
            <input type="text" class="form-control" placeholder="Book Copies"  value='${Book.copies}'   name="copies" required="required">
        </div>
       
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Price"  value='${Book.price}'   name="price" required="required">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Update</button>
        </div>
                
    </form>
   </div>
</body>
</html>                                		