

<!DOCTYPE html>
<html lang="en">
<head>
    
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap Simple Login Form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
    <h1 align="center">Re-Issue a Book </h1>
<div class="issuebook-form">
    <form action="reissuebook">
            <div class="form-group">
                Issue Id:
            <input type="text" class="form-control" placeholder=" Issue Id"  value="${issued.issueId}" name="issueid" required="required">
        </div> 
         <div class="form-group">
             User Id:
            <input type="text" class="form-control" placeholder=" User Id"  value="${issued.user.uid}" name="uid" required="required">
        </div>
        <div class="form-group">
            Book Id:
            <input type="text" class="form-control" placeholder=" Book Id" value="${issued.book.bid}"  name="bid" required="required">
        </div>
       
        
        <div class="form-group">
            Issue Date:
            <input type="date" class="form-control"   id="today"  placeholder="Issue Date"  name="issueDate" >
        </div>
        Return Date:
          <div class="form-group">
            <input type="date" class="form-control" placeholder=" To be Returned on :"  name="toBeReturnedOn" required="required">
        </div>
      
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block"> Re-Issue</button>
        </div>
                
    </form>
   </div>
    <script>
    let today = new Date().toISOString().substr(0, 10);
document.querySelector("#today").value = today;

</script>
</body>
</html>                                		