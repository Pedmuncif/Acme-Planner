<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list readonly="true">
	<acme:list-column code = "anonymous.task.list.label.title" path = "title" width="60%"/>
	<acme:list-column code = "anonymous.task.list.label.description" path = "description" width="60%"/>
	<acme:list-column code = "anonymous.task.list.label.startMoment" path = "startMoment" width="60%"/>
	<acme:list-column code = "anonymous.task.list.label.finishMoment" path = "finishMoment" width="60%"/>
	<acme:list-column code = "anonymous.task.list.label.workload" path = "workload" width="60%"/>
	<acme:list-column code = "anonymous.task.list.label.link" path = "link" width="60%"/>
</acme:list>