package acme.features.anonymous.tasks;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.tasks.Task;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousTaskRepository extends AbstractRepository{

	@Query("select t from Task t where t.id = ?1")
	Task findTaskById(int id);
	
	@Query("select t from Task t where t.finishMoment >= ?1")
	Collection<Task> findTaskNonFinished(Date nonFinished);
}
