package acme.features.anonymous.XXX;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.XXX.XXX;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousXXXListService implements AbstractListService<Anonymous, XXX> {

	@Autowired
	protected AnonymousXXXRepository repository;
	
	@Override
	public boolean authorise(final Request<XXX> request) {
		assert request != null;
		
		return true;	
	}

	@Override
	public void unbind(final Request<XXX> request, final XXX entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "fecha","moment","amount","flag");
		
	}

	@Override
	public Collection<XXX> findMany(final Request<XXX> request) {
		assert request !=null;
		
		final Collection<XXX> result;

		
		result = this.repository.findMany();
	
		return result;
		
	}
	

}
