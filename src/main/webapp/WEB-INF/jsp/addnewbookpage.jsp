

<!DOCTYPE html>
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
    <h1 align="center">Add New Book </h1>
<div class="addbook-form">
    <form action="addbook" method="post">
            
         <div class="form-group">
            <input type="text" class="form-control" placeholder="Book Name"  name="bookname" required="required">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Book Genre"  name="genre" required="required">
        </div>
         <div class="form-group">
            <input type="number" class="form-control" placeholder="No of copies available"  name="copies" required="required">
        </div>
      
        
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Price"  name="price" required="required">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Add</button>
        </div>
                
    </form>
   </div>
</body>
</html>                                		