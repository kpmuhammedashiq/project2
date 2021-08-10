<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>
</head>
<body>
<div align="right">
		<form action="/project2">
			<button type="submit">Home Page</button>
		</form>
	</div>
	<%ArrayList<JSONObject> selectedStudent = 
            (ArrayList<JSONObject>)request.getAttribute("selectedStudent");%>
	<div>
	<h3>Student Details</h3>
		<label for="regNo"><b>Reg No.: </b></label> 
		<%=selectedStudent.get(0).get("regNo")%>
		<br><br>
		
		<label for="regNo"><b>Name.: </b></label>
		<%=selectedStudent.get(0).get("name")%>
		<br><br>
		
		<label for="regNo"><b>Marks in Language: </b></label>
		<%=selectedStudent.get(0).get("language")%>
		<br><br>
		
		<label for="regNo"><b>Marks in Maths: </b></label>
		<%=selectedStudent.get(0).get("maths")%>
		<br><br>
		
		<label for="regNo"><b>Marks in Physics: </b></label>
		<%=selectedStudent.get(0).get("physics")%>
		<br><br>
		
		<label for="regNo"><b>Marks in Biology: </b></label>
		<%=selectedStudent.get(0).get("biology")%>
		<br><br>
		
		<label for="regNo"><b>Marks in Chemistry: </b></label>
		<%=selectedStudent.get(0).get("chemistry")%>
		<br><br>
		
		<label for="regNo"><b>Marks in History: </b></label>
		<%=selectedStudent.get(0).get("history")%>
		<br><br>
		
		<label for="regNo"><b>Marks in Geography: </b></label>
		<%=selectedStudent.get(0).get("geography")%>
		<br><br>
		
		<label for="regNo"><b>Total Marks: </b></label>
		<%=selectedStudent.get(0).get("total")%>
		<br><br>
		
		<label for="regNo"><b>Average: </b></label>
		<%=selectedStudent.get(0).get("average")%>
	</div>
</body>
</html>