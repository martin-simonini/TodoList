<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{ background-color: #d9d9d9;}
header {
    background-color: #0099cc;
    color:white;
    text-align:center;
    padding:5px;	 
}
nav {
    line-height:30px;
    background-color:#eeeeee;
    height:300px;
    width:100px;
    float:left;
    padding:5px;	      
}
section {
    width:350px;
    float:left;
    padding:10px;	 	 
}
footer {
    background-color:black;
    color:white;
    clear:both;
    text-align:center;
    padding:5px;	 	 
}
a:link {
  text-decoration: none;
}
a:visited {
  text-decoration: none;
}

a:hover {
  text-decoration: underline;
}

a:active {
  text-decoration: underline;
}


</style>
</head>

<body>
<header>
<h1> Search For a Task</h1>
</header>

<nav>
<button><a href="/TodoList/">Home</a></button>
</nav>

<section>
	<h1>Search for Task</h1>
	
	<form action="SearchTask" method="POST">
	
		Task Name: <input type="text" name="name"> <br />
		Due Date: <input type="date" name="dueDate"> <br />
		Tag: <input type="text" name="tag"> <br />
		
		<input type="submit" value="Search" />
	</form>

</section>

</body>
</html>