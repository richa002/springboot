

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
	.searchbook-form {
		width: 340px;
    	margin: 50px auto;
	}
    .searchbook-form form {
    	margin-bottom: 15px;
        background: #f7f7f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
    .searchbook-form h2 {
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
    <h1 align="center">Search A Book </h1>
<div class="searchbook-form">
    <form action="searchby">
            <% if(request.getParameter("searchby").equals("bid")) {%>
         <div class="form-group">
   <input type="text" class="form-control" placeholder=" Enter Book Id to be searched"  name="bid" required="required">
       
             </div>
        <%}%>
               <% if(request.getParameter("searchby").equals("bookname")) {%>
     
        <div class="form-group">
       <input type="text" class="form-control" placeholder=" Enter Book Name to be searched"  name="bookname" required="required">
  
        </div>
         <%}%>
      
         <% if(request.getParameter("searchby").equals("genre")) {%>
      
        <div class="form-group">
         <input type="text" class="form-control" placeholder=" Enter Genre to be searched"  name="genre" required="required">
  
        </div>
 <%}%>
      
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Search</button>
        </div>
                
    </form>
   </div>
</body>
</html>                                		