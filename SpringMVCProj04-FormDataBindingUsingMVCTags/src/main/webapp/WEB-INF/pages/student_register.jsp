<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<h1 style='color:red;text-align:center'>Student Registration Page</h1>
<frm:form  modelAttribute="stud">
<table border="1" bgcolor="wheat" align="center">
<tr>
<td>Student Number</td>
<td><frm:input path="sno"/></td>
</tr>
<tr>
<td>Student Name</td>
<td><frm:input path="sname"/></td>
</tr>
<tr>
<td>Student Address</td>
<td><frm:input path="saddrs"/></td>
</tr>
<tr>
<td>Student Average</td>
<td><frm:input path="avg"/></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="Register a Student">
<input type="reset" value="Cancel">
</td>
</tr>

</table>
</frm:form>

