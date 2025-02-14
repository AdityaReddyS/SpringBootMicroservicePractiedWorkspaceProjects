<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<h1 style="color:green;text-align:center">Employee Registration Form</h1>

<form:form  modelAttribute="cust">

<table align="center" bgcolor="orange" border=2>
<tr>
<td>Customer Number</td>
<td><form:input path="cno" /></td>
</tr>
<tr>
<td>Customer Name</td>
<td><form:input path="cName" /></td>
</tr>
<tr>
<td>Customer Address</td>
<td><form:input path="cAddrs" /></td>
</tr>
<tr>
<td>Customer Bill Amount</td>
<td><form:input path="billAmt" /></td>
</tr>
<tr>
<td>Date of Birth(dob)(mm/dd/yyyy)</td>
<td><form:input path="dob" type="date" /></td>
</tr>

<tr>
<td>Date of Joining(doj)</td>
<td><form:input path="doj" type="date"/></td>
</tr>

<tr>
<td>Date of Purchase(dop)</td>
<td><form:input path="dop" type="datetime-local"/></td>
</tr>

<tr>

<tr>
<td>Time of Birth (tob)</td>
<td><form:input path="tob" type="time" /></td>
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