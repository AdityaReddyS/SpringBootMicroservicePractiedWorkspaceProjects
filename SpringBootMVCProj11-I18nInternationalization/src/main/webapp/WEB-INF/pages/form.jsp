<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8"
     %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="sp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h1 style="color:red;text-align:center;"><sp:message code="home.title"/></h1>
<br><br>

<a href="register"><h2 style="color:green;text-align:center;"><sp:message code="home.link"/></h2></a>
<br><br>

<h1 >Current Active Locale is::${pageContext.response.locale}</h1>
<fmt:setLocale value="${pageContext.response.locale}"/>
<jsp:useBean id ="dt" class="java.util.Date" />
<fmt:formatDate var="fdt" value="${dt}" type="both" dateStyle="FULL" timeStyle="FULL"/>
<b>formated Date:::${fdt}</b><br><br>
<fmt:formatDate var="ftime" value="${dt}" type="time"  timeStyle="FULL"/>
<b>formated Time:::${ftime}</b><br><br>
<fmt:formatNumber var="fnumber" value="1000000" type="number"/>
<b>formated Number:::${fnumber}</b><br><br>
<fmt:formatNumber var="fcurrency" value="1000000" type="currency"/>
<b>formated Number:::${fcurrency}</b><br><br>
<fmt:formatNumber var="fpercentage" value="0.211" type="PERCENT"/>
<b>formated Number:::${fpercentage}</b><br><br>





<p align="center">
<a href="?lang=en_US">English</a>&nbsp;&nbsp;&nbsp;
<a href="?lang=zh_CN">Chinese</a>&nbsp;&nbsp;&nbsp;
<a href="?lang=fr_FR">French</a>&nbsp;&nbsp;&nbsp;
<a href="?lang=hi_IN">Hindi</a>&nbsp;&nbsp;&nbsp;
<a href="?lang=de_DE">Zerman</a>&nbsp;&nbsp;&nbsp;
<a href="?lang=te_TE">Telugu</a>&nbsp;&nbsp;&nbsp;
</p>