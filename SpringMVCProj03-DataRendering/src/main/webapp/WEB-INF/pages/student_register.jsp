<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<h1 style='color:red;text-align:center'>Student Registration Page</h1>
<form action="register" method="POST">
<table border="1" bgcolor="wheat" align="center">
<tr>
<td>Student Number</td>
<td><input type="text" name="sno"></td>
</tr>
<tr>
<td>Student Name</td>
<td><input type="text" name="sname"></td>
</tr>
<tr>
<td>Student Address</td>
<td><input type="text" name="saddrs"></td>
</tr>
<tr>
<td>Student Average</td>
<td><input type="text" name="avg"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="Register a Student"></td>
</tr>

</table>
</form>

