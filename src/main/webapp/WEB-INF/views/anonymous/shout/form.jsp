<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir ="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="anonymous.shout.form.label.author" path="author"/>
	<acme:form-textarea code="anonymous.shout.form.label.text" path="text"/>
	<acme:form-textbox code="anonymous.shout.form.label.info" path="info"/>

    <acme:form-textbox code="anonymous.xxx.form.label.fecha" path="xxx.fecha"/>
	
	
	<acme:form-money code="anonymous.xxx.form.label.amount" path="xxx.amount"/>
	
	<acme:form-moment code="anonymous.xxx.form.label.deadline" path="xxx.moment"/>
	
	<acme:form-checkbox code="anonymous.xxx.form.label.flag" path="xxx.flag"/>
	
	
	<acme:form-submit code="anonymous.shout.form.button.create" action="/anonymous/shout/create"/>
	<acme:form-return code="anonymous.shout.form.button.return"/>
</acme:form>