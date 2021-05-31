<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir ="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="anonymous.xxx.form.label.fecha" path="fecha" placeholder="yyyy-MM-dd"/>
	<acme:form-money code="anonymous.xxx.form.label.amount" path="amount"/>
	<acme:form-select code="anonymous.xxx.form.label.flag" path="flag">
		<acme:form-option code="false" value="false"/>
		<acme:form-option code="true" value="true"/>
	</acme:form-select>
	
	<acme:form-submit code="anonymous.xxx.form.button.create" action="/anonymous/xxx/create"/>
	<acme:form-return code="anonymous.xxx.form.button.return"/>
</acme:form>