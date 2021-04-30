package acme.features.anonymous.shout;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.shouts.Shout;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousShoutRepository extends AbstractRepository {
	
	@Query("select s from Shout s")
	Collection<Shout> findMany();
	
	@Query("select s from Shout s where s.moment >= ?1 order by s.moment asc")
	Collection<Shout> findSortedByMoment(Date deadline);

}
