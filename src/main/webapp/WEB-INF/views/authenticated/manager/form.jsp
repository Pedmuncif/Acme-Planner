<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-submit test="${command == 'create'}" code="authenticated.manager.form.button.create" action="/authenticated/manager/create"/>
</acme:form>