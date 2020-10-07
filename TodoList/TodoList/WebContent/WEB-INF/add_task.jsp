<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
header {
    background-color:black;
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
</style>
</head>

<body>
<header>
<h1>Add New Task</h1>
</header>

<nav>
<a href="/TodoList/">View Current Tasks</a> <br>
</nav>

<section>
	<h1>User Input</h1>
	
	<form action="AddTask" method="POST">
	
		Task Name: <input type="text" name="name"> <br />
		Description: <input type="text" name="description"> <br />
		Due Date: <input type="date" name="dueDate"> <br />
		Tag: <input type="text" name="tag"> <br />
		
		<input type="submit" value="Submit" />
	</form>

</section>

</body>
</html>