package acme.features.anonymous.shout;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.XXX.XXX;
import acme.entities.shouts.Shout;
import acme.features.anonymous.XXX.AnonymousXXXRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousShoutCreateService implements AbstractCreateService<Anonymous, Shout> {
	
	@Autowired
	protected AnonymousShoutRepository repository;
	
	@Autowired
	protected AnonymousXXXRepository repository2;

	@Override
	public boolean authorise(final Request<Shout> request) {
		assert request != null;
	
		return true;
	}

	@Override
	public void bind(final Request<Shout> request, final Shout entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors);
	}

	
	
	@Override
	public void unbind(final Request<Shout> request, final Shout entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "author","text","info","xxx.fecha","xxx.amount","xxx.flag");
		
	}

	@Override
	public Shout instantiate(final Request<Shout> request) {
		assert request != null;
		
		Shout result;
		Date moment;
		
		moment = new Date(System.currentTimeMillis()-1);
		
		result = new Shout();
//		result.setAuthor("John Doe");
//		result.setText("Lorem ipsum!");
		result.setMoment(moment);
//		result.setInfo("http://example.org");
		final XXX x = new XXX();
		x.setMoment(moment);
		result.setXxx(x);
		
		
		return result;
		
	}

	@Override
	public void validate(final Request<Shout> request, final Shout entity, final Errors errors) {
		final Collection<XXX> co = this.repository2.findMany();
		boolean b = true;
		final String fechaAux = request.getModel().getString("xxx.fecha");
		errors.state(request, !fechaAux.isEmpty(), "xxx.fecha", "anonymous.xxx.error.null");
		for(final XXX x: co) {
			if(x.getFecha().equals(fechaAux)) {
				b=false;
				break;
			}
			
		}
		errors.state(request, b, "xxx.fecha", "anonymous.xxx.error.fechaIgual");
		
		
		
		final String amount =  request.getModel().getString("xxx.amount");
		errors.state(request, !amount.isEmpty(), "xxx.amount", "anonymous.xxx.error.amountVacio");
		
		
		
		final String[] trozo =  request.getModel().getString("xxx.amount").split(" ");
		boolean bc = false;
		if(trozo[0].equals("EUR") || trozo[0].equals("USD") ) {
			bc = true;
		}
		errors.state(request, bc, "xxx.amount", "anonymous.xxx.error.currency");
		
		assert request != null;
		assert entity != null;
		assert errors != null;

	
	}

	@Override
	public void create(final Request<Shout> request, final Shout entity) {
		assert request != null;
		assert entity != null;
		
		
		
		Date moment;
		
		moment = new Date(System.currentTimeMillis() -1);
				
		entity.setMoment(moment);
		entity.getXxx().setMoment(moment);
		
	
		this.repository.save(entity);
		this.repository2.save(entity.getXxx());
		
	}

	
}