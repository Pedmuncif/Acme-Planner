package acme.features.anonymous.tromem;


import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.tromem.Tromem;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousTromemRepository extends AbstractRepository {
	
	@Query("select x from Tromem x")
	Collection<Tromem> findMany();
	
	@Query("select x from Tromem x where x.id = ?1")
	Tromem findTromemById(int id);
	
	@Query("select x from Tromem x where x.keylet =?1")
	Tromem findTromemByFecha(String fecha);

}