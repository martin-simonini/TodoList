<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
body{ background-color: #d9d9d9;}
header {
    background-color: #3366ff;
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

.styled-table {
    border-collapse: collapse;
    margin: 25px 0;
    font-size: 0.9em;
    font-family: sans-serif;
    min-width: 500px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}

.styled-table thead tr {
    background-color: #009879;
    color: #ffffff;
    text-align: left;
}

.styled-table th,
.styled-table td {
    padding: 12px 15px;
}
</style>
<body>
<title>Todo List</title>
</head>
<body>
	<header><h1>Search Results</h1></header>
	<br><br>
	<center>
		<button><a href="/TodoList/addTask">Add Task</a></button>
		<button><a href="/TodoList/index">Home</a></button>
	</center>
	<center>
	<table class="styled-table">
		<thead>
			<td><b>Name</b></td>
			<td><b>Description</b></td>
			<td><b>Due Date</b></td>
			<td><b>Tag</b></td>
			<td></td>
		</thead>
   		<c:forEach items="${Tasks}" var="task">
        	<tr>
	        	<td>${task.getName()}</td>
	        	<td>${task.getDescription()}</td>
	        	<td>${task.getDueDate() }</td>
	        	<td>${task.getTag()}</td>
	        	<c:url value="/deleteTask" var="delTask">
   					<c:param name="id" value="${task.getId()}"/>
				</c:url>
	        	<td><button><a href="<c:out value="${delTask}"/>">Mark as Complete</a></button></td>
        	</tr>
    	</c:forEach>
</table>
</center>

</body>
</html>