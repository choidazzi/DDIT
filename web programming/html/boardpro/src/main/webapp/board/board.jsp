<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="../js/jquery-3.7.0.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="../js/board.js"></script>
  
<style>
body * {
	box-sizing: border-box;
}

p {
	border: 1px solid lightgray;
	margin: 2px;
	padding: 5px;
}
.card-body {
	display: flex;
	flex-direction: column;
}

.pWrap {
	display: flex;
	flex-direction: row;
}

.pWrap .p1 {
	flex: 7;
}

.pWrap .p2 {
	flex: 3;
	text-align: right;
}

input[name=reply] {
	height: 50px;
	vertical-align: top;
}

nav a {
	display: none;
	visibility: hidden;
}
</style>
</head>
<body>

	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="javascript:void(0)">Logo</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="mynavbar">
	      <ul class="navbar-nav me-auto">
	        <li class="nav-item">
	          <a class="nav-link" href="javascript:void(0)">Link</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="javascript:void(0)">Link</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="javascript:void(0)">Link</a>
	        </li>
	      </ul>
	      <form class="d-flex">
	        <input class="form-control me-2" type="text" ip="sword" laceholder="Search">
	        <button class="btn btn-primary" type="button">Search</button>
	      </form>
	    </div>
	  </div>
	</nav>

<div id="result">
	
</div>
<br>
<br>
<div id="pageList">
</div>
<script>
myPath = '<%= request.getContextPath() %>';
console.log(myPath);
currentPage = 1;

listPageServer(1);

</script>
</body>
</html>