<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="anonymous.task.form.label.title" path="title"/>
	<acme:form-password code="anonymous.task.form.label.description" path="description"/>
	<acme:form-password code="anonymous.task.form.label.startMoment" path="startMoment"/>
	<acme:form-textbox code="anonymous.task.form.label.finishMoment" path="finishMoment"/>
	<acme:form-textbox code="anonymous.task.form.label.workload" path="workload"/>
	<acme:form-textbox code="anonymous.task.form.label.link" path="link"/>
	<acme:form-option code="PUBLIC" value="PUBLIC" selected="${status == 'PUBLIC'}"/>
	<acme:form-option code="PRIVATE" value="PRIVATE" selected="${status == 'PRIVATE'}"/>
	
  	<acme:form-return code="anonymous.task.form.button.return"/>
</acme:form>
