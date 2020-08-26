<!DOCTYPE html>
<html>
<head>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}
li p{
    color:white;
    text-align: center;
}

li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #4CAF50;
}
</style>
</head>
<body>
 <%  String n=(String)session.getAttribute("logintype"); %>
                     
<ul>
        <% if(n.equals("admin")){   %>
      
      
  <li><a href="admin_panel">Home</a></li>
  <li><a href ="gotosearchpage"> Search book</a></li>  
     
        <li><a href="viewlistofbooks" >View /update /delete books</a></li>   
        <li><a href ="gotoaddnewbookpage"> Add new book</a></li>   
         <li><a href ="gotoissuebookform"> Issue book</a></li>   
          <li><a href ="gotoissuehistory"> View Issue History</a></li>   
              <li><a href ="gotoissuehistory"> Return Book</a></li>   

  <li> <p style="padding:14px 180px">Welcome Admin</p>
      </li>
  <%} else{%>
  <li><a href="user_panel">Home</a></li>
    <li><a href ="gotosearchpage"> Search a book</a></li>  
      <li><a href="viewlistofbooks" >View list of all books</a></li>   
        <li><a href ="gotoissuehistory"> View Issue History</a></li>   
              
  <li> <p style="padding:14px 150px">Welcome User</p>
      </li>
  <%}%>
  <li style="float:right"><a class="active" href="logout">Logout</a></li>
</ul>

</body>
</html>
    
                               		