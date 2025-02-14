<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<h1 style="color:green;text-align:center">Job Seeker Registration Form</h1>

<form:form action="register" method="POST" modelAttribute="js" enctype="multipart/form-data" >

<table align="center" bgcolor="orange" border=2>
<%-- <tr>
<td>Job Seeker No</td>
<td><form:input path="jsno" /></td>
</tr> --%>
<tr>
<td>Job Seeker Name</td>
<td><form:input path="jsName" /></td>
</tr>
<tr>
<td>Job Seeker Address</td>
<td><form:input path="jsAddress" /></td>
</tr>
<tr>
<td>Upload The Resume</td>
<td><form:input  type="file" path="resume" /></td>
</tr>
<tr>
<td>Upload The Photo</td>
<td><form:input  type="file" path="photo" /></td>
</tr>
<tr>


<td><input type="submit" value="SUBMIT" /></td>
<td><input type="reset" value="CANCEL" /></td>
</tr>
</table>

</form:form>
<center>
<a href="./">home</a>&nbsp;&nbsp;&nbsp;
</center>