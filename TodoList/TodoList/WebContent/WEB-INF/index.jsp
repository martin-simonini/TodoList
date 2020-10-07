<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<title>Todo List</title>
</head>
<body>
	<center><h1>Todo List</h1></center>
	<br><br>
	<button><a href="/TodoList/addTask">Add Task</a></button>
	<table>
		<tr>
			<td><b>Name</b></td>
			<td><b>Description</b></td>
			<td><b>Due Date</b></td>
			<td><b>Tag</b></td>
		</tr>
   		<c:forEach items="${Tasks}" var="task">
        	<tr>
	        	<td>${task.getName()}</td>
	        	<td>${task.getDescription()}</td>
	        	<td>${task.getDueDate() }</td>
	        	<td>${task.getTag()}</td>
	        	<td><c:out value = "${task.getId()}"/></td>
	        	<c:url value="/deleteTask" var="delTask">
   					<c:param name="id" value="${task.getId()}"/>
				</c:url>
	        	<td><button><a href="<c:out value="${delTask}"/>">Mark as Complete</a></button></td>
        	</tr>
    	</c:forEach>
</table>

</body>
</html>