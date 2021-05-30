<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir ="/WEB-INF/tags"%>

<acme:form>

	<acme:form-money code="anonymous.XXX.form.label.amount" path="amount"/>
	<acme:form-moment code="anonymous.XXX.form.label.fecha" path="fecha"/>
	<acme:form-moment code="anonymous.XXX.form.label.moment" path="moment"/>
	<acme:form-select code="anonymous.XXX.form.label.flag" path="flag">
		<acme:form-option code="true" value="true" selected="True"/>
		<acme:form-option code="false" value="false" selected="False"/>
	</acme:form-select>
	<acme:form-submit code="anonymous.XXX.form.button.create" action="/anonymous/XXX/create"/>

	<acme:form-return code="anonymous.XXX.form.button.return"/>

</acme:form>