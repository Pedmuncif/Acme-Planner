package acme.features.anonymous.XXX;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.XXX.XXX;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousXXXRepository extends AbstractRepository {
	
	@Query("select s from XXX s")
	Collection<XXX> findMany();
	
	@Query("select x from XXX x where x.id = ?1")
	XXX findXXXById(int id);
}
