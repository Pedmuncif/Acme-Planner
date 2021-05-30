package acme.features.anonymous.XXX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.XXX.XXX;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousXXXCreateService implements AbstractCreateService<Anonymous, XXX> {
	
	@Autowired
	protected AnonymousXXXRepository repository;
	

	@Override
	public boolean authorise(final Request<XXX> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public void bind(final Request<XXX> request, final XXX entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<XXX> request, final XXX entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "amount","fecha","moment","flag");
		
	}

	@Override
	public XXX instantiate(final Request<XXX> request) {
		assert request != null;
		
		XXX result;
	
		
	
		
		result = new XXX();
	
		return result;
		
	}

	@Override
	public void validate(final Request<XXX> request, final XXX entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
	}

	@Override
	public void create(final Request<XXX> request, final XXX entity) {
		assert request != null;
		assert entity != null;
		
	
		this.repository.save(entity);
	}

	
}