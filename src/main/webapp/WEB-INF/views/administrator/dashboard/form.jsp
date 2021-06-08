<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">

<h2>
	<acme:message code="administrator.dashboard.form.title.shouts-indicators"/>
</h2>

	<acme:form-textbox code="administrator.dashboard.form.label.nShoutPublic" path="nShoutPublic"/>
	<acme:form-textbox code="administrator.dashboard.form.label.nShoutNoPublic" path="nShoutNoPublic"/>
	<acme:form-textbox code="administrator.dashboard.form.label.stdevpShoutaverageEur" path="stdevpShoutaverageEur"/>
	<acme:form-textbox code="administrator.dashboard.form.label.averageShoutaverageEur" path="averageShoutaverageEur"/>
	<acme:form-textbox code="administrator.dashboard.form.label.stdevpShoutaverageUsd" path="stdevpShoutaverageUSD"/>
	<acme:form-textbox code="administrator.dashboard.form.label.averageShoutaverageUsd" path="averageShoutaverageUSD"/>

<h2>
	<acme:message code="administrator.dashboard.form.title.general-indicators"/>
</h2>
	<acme:form-textbox code="administrator.dashboard.form.label.nTasksPublic" path="nTasksPublic"/>
	<acme:form-textbox code="administrator.dashboard.form.label.nTasksPrivate" path="nTasksPrivate"/>
	<acme:form-textbox code="administrator.dashboard.form.label.nTasksFinished" path="nTasksFinished"/>
	<acme:form-textbox code="administrator.dashboard.form.label.nTasksNoFinished" path="nTasksNoFinished"/>
	
<h2>
	<acme:message code="administrator.dashboard.form.title.workload-indicators"/>
</h2>

	<acme:form-textbox code="administrator.dashboard.form.label.averageWorkload" path="averageWorkload"/>
	<acme:form-textbox code="administrator.dashboard.form.label.standardDeviationWorkload" path="standardDeviationWorkload"/>
	<acme:form-textbox code="administrator.dashboard.form.label.maxWorkload" path="maxWorkload"/>
	<acme:form-textbox code="administrator.dashboard.form.label.minWorkload" path="minWorkload"/>
	
<h2>
	<acme:message code="administrator.dashboard.form.title.executionPeriod-indicators"/>
</h2>

	<acme:form-textbox code="administrator.dashboard.form.label.averageExecutionPeriod" path="averageExecutionPeriod"/>
	<acme:form-textbox code="administrator.dashboard.form.label.standardDeviationExecutionPeriod" path="standardDeviationExecutionPeriod"/>
	<acme:form-textbox code="administrator.dashboard.form.label.maxExecutionPeriod" path="maxExecutionPeriod"/>
	<acme:form-textbox code="administrator.dashboard.form.label.minExecutionPeriod" path="minExecutionPeriod"/>
	
	<acme:form-return code="administrator.dashboard.form.button.return"/>
	
	
	
</acme:form>