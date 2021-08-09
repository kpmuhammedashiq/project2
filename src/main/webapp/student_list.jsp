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
<title>Object List</title>
</head>
<body>
<div align="right">
		<form action="create">
			<button type="submit">Add Student</button>
		</form>
	</div>
<%=request.getAttribute("studentList")%>
	<h1>Displaying Object List</h1>
	<table border="1" width="500" align="center">
		<tr bgcolor="00FF7F">
			<th><b>Object Name</b></th>
			<th><b>Object Age</b></th>
			<th><b>Course Undertaken</b></th>
		</tr>
		<%ArrayList<JSONObject> stdList = 
            (ArrayList<JSONObject>)request.getAttribute("studentList");

        for(JSONObject s:stdList)
        {%>
		<tr>
			<td><%=s%></td>
		 <%-- <td><%=s.get(regNo)%></td> --%>
<%-- 			<td><%=s.maths%></td>   --%>
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