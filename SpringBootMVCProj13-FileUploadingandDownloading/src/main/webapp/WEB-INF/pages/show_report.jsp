<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1 style="color:red;text-align:center;">GetAll Job Seekers Page</h1>
<br>
<c:choose>
<c:when test="${!empty jsList }">
<table align="center" bgcolor="wheat" border=2>
<tr>
<th>JSID</th><th>Job Seeker Name</th><th>Job Seeker Address</th><th>Job Seeker Resume </th><th>Job Seeker Photo</th>
</tr>
<c:forEach var="info" items="${jsList}">
<tr>
<td>${info.jsid}</td>
<td>${info.jsName}</td>
<td>${info.jsAddress}</td>
<td><a href="download?jsid=${info.jsid}&type=resume">Download Resume</a></td>
<td><a href="download?jsid=${info.jsid}&type=photo">Download photo</a></td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<h1 style="color:red;text-align:center;">job Seekers Data not Found</h1>

</c:otherwise>
</c:choose>

<center>
<a href="./">home</a>&nbsp;&nbsp;&nbsp;
</center>