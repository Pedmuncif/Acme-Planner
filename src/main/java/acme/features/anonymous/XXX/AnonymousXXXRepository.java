package acme.features.anonymous.XXX;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.shouts.Shout;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousXXXRepository extends AbstractRepository {
	
	@Query("select x from XXX x")
	Collection<Shout> findMany();

}
