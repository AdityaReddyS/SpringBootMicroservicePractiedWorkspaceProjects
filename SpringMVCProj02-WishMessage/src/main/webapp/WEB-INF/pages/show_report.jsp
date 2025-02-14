<%@ page isELIgnored="false" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 style="color:blue;text-align:center">Show report From Controller </h1>
<br>

<h2 style="color:violet;text-align:center">Model Attributes Collections Data is</h2>
<br>

<c:choose>
	<c:when test="${!empty empListInfo}">
		<table border="2" bgcolor="wheat" align="center">
			<tr>
				<th>eno</th>
				<th>ename</th>
				<th>eddrs</th>
				<th>salary</th>
				<th>Department</th>
			</tr>
			<c:forEach var="emp" items="${empListInfo}">
				<tr>
					<td>${emp.eno}</td>
					<td>${emp.ename}</td>
					<td>${emp.eddrs}</td>
					<td>${emp.salary}</td>
					<td>${emp.dept}</td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h5 style="color: blue; text-align: center">Employee Data Not
			Found</h5>
	</c:otherwise>

</c:choose>
<%-- <%-- <c:if test="${!empty EmpInfo }">
<b>Employee Information is::${EmpInfo.eno},${EmpInfo.ename},${EmpInfo.salary},${EmpInfo.eddrs},${EmpInfo.dept}</b>
</c:if> --%>

<%-- <b>Favourite Colors are</b><br>
<c:forEach var="color" items="${favcolors}">

${color},
</c:forEach>
<br>
<b>NickNames are</b><br>
<c:forEach var="name" items="${nickNames}">

${name},
</c:forEach>
<br>
<b> Phone Numbers Are</b><br>
<c:forEach var="number" items="${phoneNumbers}">

${number},
</c:forEach>
<br>
<b>Identity Details are</b><br>
<c:forEach var="ids" items="${idDetails}">

${ids.key},${ids.value} <br>
</c:forEach>
<br>
 --%>
<h3 style="color:violet;text-align:center"><a href="./">home</a></h3>