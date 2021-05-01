<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code = "anonymous.task.list.label.title" path = "title"/>
	<acme:list-column code = "anonymous.task.list.label.description" path = "description"/>
	<acme:list-column code = "anonymous.task.list.label.startMoment" path = "startMoment"/>
	<acme:list-column code = "anonymous.task.list.label.finishMoment" path = "finishMoment"/>
	<acme:list-column code = "anonymous.task.list.label.workload" path = "workload"/>
	<acme:list-column code = "anonymous.task.list.label.link" path = "link"/>
	<acme:list-column code = "anonymous.task.list.label.status" path = "status"/>
</acme:list>