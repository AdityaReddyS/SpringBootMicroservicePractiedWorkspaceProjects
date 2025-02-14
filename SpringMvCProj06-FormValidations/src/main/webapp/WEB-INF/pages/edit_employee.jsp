<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<link rel="stylesheet" type="text/css" href="css/style.css"/>

<script type="text/javascript" src="js/validation.js">

</script>
<h1 style="color:green;text-align:center">Employee Updation Form</h1>



 <form:form method="POST" modelAttribute="emp" onsubmit="return doValidation(this)" >
<%-- <p style="color:red;text-align:center">
<form:errors path="*"/> 

</p> --%>
<table align="center" bgcolor="orange" border=2>
<tr>
<td>Employee N0</td>
<td><form:input path="empno" readonly="true" /></td>
</tr>
<tr>
<td>Employee Name</td>
<td><form:input path="ename" /><form:errors path="ename"/><span id="enameErr"></span></td>
</tr>
<tr>
<td>Employee Job</td>
<td><form:input path="job" /><form:errors path="job"/><span id="jobErr"></span></td>
</tr>
<tr>
<td>Employee Salary</td>
<td><form:input path="sal" /><form:errors path="sal"/><span id="salErr"></span></td>
</tr>
<tr>
<td>Employee DeptNo</td>
<td><form:input path="deptno" /><form:errors path="deptno"/><span id="deptnoErr"></span></td>
</tr>
<tr>
<form:hidden path="vflag1"/>

<td><input type="submit" value="SUBMIT" /></td>
<td><input type="reset" value="CANCEL" /></td>
</tr>
</table>

</form:form>
<center>
<a href="./"><img class="img_class" src="images/home.png" width="40" height=40 /></a>&nbsp;&nbsp;&nbsp;
</center>