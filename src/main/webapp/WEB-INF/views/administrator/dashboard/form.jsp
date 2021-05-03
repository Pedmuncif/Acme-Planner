<%--
- form.jsp
-
- Copyright (C) 2012-2021 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<h2>
	<acme:message code="administrator.dashboard.form.title.general-indicators"/>
</h2>

<table class="table table-sm">
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.nTasksPublic"/>
		</th>
		<td>
			<acme:print value="${nTasksPublic}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.nTasksPrivate"/>
		</th>
		<td>
			<acme:print value="${nTasksPrivate}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.nTasksFinished"/>
		</th>
		<td>
			<acme:print value="${nTasksFinished}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.nTasksNoFinished"/>
		</th>
		<td>
			<acme:print value="${nTasksNoFinished}"/>
		</td>
	</tr>		
</table>

<h2>
	<acme:message code="administrator.dashboard.form.title.workload-indicators"/>
</h2>

<table class="table table-sm">
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.averageWorkload"/>
		</th>
		<td>
			<acme:print value="${averageWorkload}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.standardDeviationWorkload"/>
		</th>
		<td>
			<acme:print value="${standardDeviationWorkload}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.maxWorkload"/>
		</th>
		<td>
			<acme:print value="${maxWorkload}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.minWorkload"/>
		</th>
		<td>
			<acme:print value="${minWorkload}"/>
		</td>
	</tr>		
</table>

<h2>
	<acme:message code="administrator.dashboard.form.title.executionPeriod-indicators"/>
</h2>

<table class="table table-sm">
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.averageExecutionPeriod"/>
		</th>
		<td>
			<acme:print value="${averageExecutionPeriod}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.standardDeviationExecutionPeriod"/>
		</th>
		<td>
			<acme:print value="${standardDeviationExecutionPeriod}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.maxExecutionPeriod"/>
		</th>
		<td>
			<acme:print value="${maxExecutionPeriod}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.minExecutionPeriod"/>
		</th>
		<td>
			<acme:print value="${minExecutionPeriod}"/>
		</td>
	</tr>		
</table>