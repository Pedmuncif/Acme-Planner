package acme.features.authenticated.tasks;


import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.tasks.Task;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedTaskRepository extends AbstractRepository{
	
	@Query("select a from Task a")
	Collection<Task> findMany();
	
	//@Query("select a from Task a where a.finishMoment => ?1")
	//Collection<Task> finishTask(Date finished);

}
