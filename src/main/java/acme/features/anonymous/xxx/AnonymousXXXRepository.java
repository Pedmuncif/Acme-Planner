package acme.features.anonymous.xxx;


import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.xxx.XXX;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousXXXRepository extends AbstractRepository {
	
	@Query("select x from XXX x")
	Collection<XXX> findMany();
	
	@Query("select x from XXX x where x.id = ?1")
	XXX findXXXById(int id);
	
	@Query("select x from XXX x where x.keylet =?1")
	XXX findXXXByFecha(String fecha);

}