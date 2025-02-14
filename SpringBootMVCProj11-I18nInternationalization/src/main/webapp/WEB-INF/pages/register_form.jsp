<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8"
     %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="sp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 style="color:green;text-align:center"><sp:message code="customer.register.title"/></h1>

<form:form action="register" method="POST" modelAttribute="cust">

<table align="center" bgcolor="orange" border=2>
<tr>
<td><sp:message code="customer.register.name"/></td>
<td><form:input path="cname" /></td>
</tr>
<tr>
<td><sp:message code="customer.register.addrs"/></td>
<td><form:input path="caddrs" /></td>
</tr>
<tr>
<td><sp:message code="customer.register.billAmt"/></td>
<td><form:input path="billAmt" /></td>
</tr>

<tr>
<td><input type="submit" value="<sp:message code="customer.btn.name"/>" /></td>

</tr>
</table>

</form:form>
<br><br>
<p align="center">
<a href="?lang=en_US">English</a>&nbsp;&nbsp;&nbsp;
<a href="?lang=zh_CN">Chinese</a>&nbsp;&nbsp;&nbsp;
<a href="?lang=fr_FR">French</a>&nbsp;&nbsp;&nbsp;
<a href="?lang=hi_IN">Hindi</a>&nbsp;&nbsp;&nbsp;
<a href="?lang=de_DE">Zerman</a>&nbsp;&nbsp;&nbsp;
<a href="?lang=te_TE">Telugu</a>&nbsp;&nbsp;&nbsp;
</p>