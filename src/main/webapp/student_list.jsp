<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
  <%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Table</title>
</head>
<body>
<div align="right">
		<form action="/project2">
			<button type="submit">Home Page</button>
		</form>
	</div>
<div align="left">
		<form action="create">
			<button type="submit">Add Student</button>
		</form>
		<br>
	</div>
<!-- 	<h3>Students Table</h3> -->
	<table border="1" width="1300" align="center">
		<tr >
		<th><b>Reg No.</b></th>
			<th><b>Name</b></th>
			<th><b>Language</b></th>
			<th><b>Maths</b></th>
			
			<th><b>Physics</b></th>
			<th><b>Biology</b></th>
			<th><b>Chemistry</b></th>
			<th><b>History</b></th>
			<th><b>Geography</b></th>
			<th><b>Total Marks</b></th>
			<th><b>Average</b></th>
		</tr>
		<%ArrayList<JSONObject> stdList = 
            (ArrayList<JSONObject>)request.getAttribute("studentList");

        for(JSONObject s:stdList)
        {%>
		<tr>
			<td><%=s.get("regNo")%></td>
		 <td><%=s.get("name")%></td>
		 <td><%=s.get("language")%></td>
		 <td><%=s.get("maths")%></td>
		 <td><%=s.get("physics")%></td>
		 <td><%=s.get("biology")%></td>
		 <td><%=s.get("chemistry")%></td>
		 <td><%=s.get("history")%></td>
		 <td><%=s.get("geography")%></td>
		 <td><%=s.get("total")%></td>
		 <td><%=s.get("average")%></td>
		</tr>
		<%}%>
	</table>
	<%--  <table>
        <c:forEach items="${studentList}" var="user">
            <tr>
                <td>${user.name}</user>
            </tr>
        </c:forEach>
    </table> --%>
	<hr />
</body>
</html>