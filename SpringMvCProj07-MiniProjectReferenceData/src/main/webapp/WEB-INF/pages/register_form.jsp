<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<h1 style="color:green;text-align:center">Employee Registration Form</h1>

<form:form action="register" method="POST" modelAttribute="empl">

<table align="center" bgcolor="orange" border=2>
<tr>
<td>Employee Name</td>
<td><form:input path="ename" /></td>
</tr>
<tr>
<td>Employee Job</td>
<td><form:input path="job" /></td>
</tr>
<tr>
<td>Employee Salary</td>
<td><form:input path="sal" /></td>
</tr>
<tr>
<td>Employee DeptNo</td>
<td><form:select path="deptno" >
<form:options items="${deptNoInfo }"/>
</form:select>
</td>
</tr>
<tr>

<tr>
<td>Employee Status</td>
<td><form:input path="status" /></td>
</tr>
<tr>

<td><input type="submit" value="SUBMIT" /></td>
<td><input type="reset" value="CANCEL" /></td>
</tr>
</table>

</form:form>
<center>
<a href="./"><img class="img_class" src="images/home.png" width="40" height=40 /></a>&nbsp;&nbsp;&nbsp;
</center>