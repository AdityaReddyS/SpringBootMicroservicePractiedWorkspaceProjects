<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
<c:when test="${!empty empsInfo}">
<h1 style="color:blue;text-align:center">Employee Report</h1>
<table bgcolor="wheat" border=1 align="center">
<tr style="color:green">
<th>ENO</th><th>ENAME</th><th>JOB</th><th>SALARY</th><th>DEPTNO</th><th>Operations</th>
</tr>
<c:forEach var="emp" items="${empsInfo}">
<tr style="color:black;">
<td>${emp.empno}</td>
<td>${emp.ename}</td>
<td>${emp.job}</td>
<td>${emp.sal}</td>
<td>${emp.deptno}</td>
<td><a href="edit?no=${emp.empno}"><img alt="Edit Image" src="images/edit.png" width="50" height="50" ></a>&nbsp;&nbsp;&nbsp;
<a href="delete?no=${emp.empno}"><img alt="Delete Image" src="images/delete.jpg" width="50" height="50" onclick="confirm('are sure you want to delete the record')"></a>
</td>
</tr>
</c:forEach>


</table>

</c:when>
<c:otherwise>
<h1 style="color:red;">Employees Not Found</h1>
</c:otherwise>
</c:choose>
<br>
<h2 style="color:green;text-align:center">${resultMsg}</h2>

<center>
<a href="./"><img class="img_class" src="images/home.png" width="40" height=40 /></a>&nbsp;&nbsp;&nbsp;
<a href="register"><img class="img_class" src="images/add1.png" width="40" height=40 /></a>

</center>