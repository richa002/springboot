<%-- 
    Document   : newjsf
    Created on : 27 Jul, 2020, 5:11:59 AM
    Author     : Acer
--%>
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap Simple Login Form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<jsp:include page="welcomejsp.jsp"></jsp:include>
<style>
	.login-form {
		width: 340px;
    	margin: 50px auto;
	}
    .login-form form {
    	margin-bottom: 15px;
        background: #f7f7f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
    .login-form h2 {
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
    .main{
        	width: 500px;
    	margin: 10px auto;
	height:400px;
         background-color: background;
 
    }
    div{
        height:60px;
        width:360px;
        margin:20px auto;
        border: 5px grey;
  background-color: aquamarine;
  text-align: center;
  padding-top: 25px;
  text-height: 20px;
  font-weight: bold;
  font-size: 18px;
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
      <h1>LIBRARY MANAGEMENT SYSTEM</h1>
    
    <div class="main">
         <div><a href ="gotosearchpage"> Search a book</a></div>  
      <div><a href="viewlistofbooks" >View list of all books</a></div>   
        <div><a href ="gotoissuehistory"> View Issue History</a></div>   
              
    </div> 
      
</body>
</html>                              