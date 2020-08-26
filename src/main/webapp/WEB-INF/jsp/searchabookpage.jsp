

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
<%  
           String msg=(String)request.getAttribute("msg");
 
        if(msg!=null){
          %>
       <script language="javascript">
             var Value ="<%= msg%>";
       alert(Value);
   
    
       </script>
         
     <%}%>
<body>
    <h1 align="center">Search A Book </h1>
<div class="searchbook-form">
    <form action="searchbyjsppage">
            
         <div class="form-group">
         <input type="radio" id="bid" name="searchby" value="bid">
<label for="bid">Book Id</label><br>
         </div>
        
        <div class="form-group">
        <input type="radio" id="bookname" name="searchby" value="bookname">
<label for="bookname">Book Name</label><br>
           </div>
       
        
        <div class="form-group">
        <input type="radio" id="genre" name="searchby" value="genre">
<label for="genre">Genre</label> 
 </div>
 
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Done</button>
        </div>
                
    </form>
   </div>
</body>
</html>                                		