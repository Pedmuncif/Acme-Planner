package acme.features.anonymous.shout;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.shouts.Shout;
import acme.entities.tromem.Tromem;
import acme.features.anonymous.tromem.AnonymousTromemRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.datatypes.Money;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousShoutCreateService implements AbstractCreateService<Anonymous, Shout> {
	
	@Autowired
	protected AnonymousShoutRepository repository;
	
	@Autowired
	protected AnonymousTromemRepository repository2;

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
		request.unbind(entity, model, "author","text","info","tromem.keylet","tromem.deadline","tromem.budget","tromem.important");
		
	}

	@Override
	public Shout instantiate(final Request<Shout> request) {
		assert request != null;
		
		Shout result;
		Date moment;
		
		moment = new Date(System.currentTimeMillis()-1);
		result = new Shout();

		result.setMoment(moment);

		Tromem x;
		x = new Tromem();

		result.setTromem(x);
		
		
		return result;
		
	}

	@Override
	public void validate(final Request<Shout> request, final Shout entity, final Errors errors) {
		//Validacion de fecha unica KeyLet.
		final String fechaAux = request.getModel().getString("tromem.keylet");
		final Tromem x = this.repository2.findTromemByFecha(fechaAux);
		errors.state(request, x==null, "tromem.keylet", "anonymous.xxx.error.fechaIgual");
		
		//validacion pattern KeyLet.
		final String fechaShout = entity.getMoment().toString();
		final String[] trozos = fechaShout.split(" ");
		final String dd = trozos[2];
		final String yy = trozos[trozos.length-1].substring(2, 4);
		final String mm;
		switch(trozos[1]) {
			case "Jan":
				mm="01";
				break;
			case "Feb":
				mm="02";
				break;
			case "Mar":
				mm="03";
				break;
			case "Apr":
				mm="04";
				break;
			case "May":
				mm="05";
				break;
			case "Jun":
				mm="06";
				break;
			case "Jul":
				mm="07";
				break;
			case "Aug":
				mm="08";
				break;
			case "Sep":
				mm="09";
				break;
			case "Oct":
				mm="10";
				break;
			case "Nov":
				mm="11";
				break;
			default:
				mm="12";			
		}
		
		//Patron
		final String pattern = "^\\w{5}-"+dd+"/"+mm+"/"+yy;
		final boolean bp = fechaAux.matches(pattern);
		errors.state(request, bp, "tromem.keylet", "anonymous.xxx.error.pattern");
		
		//validacion vacio KeyLet.
		errors.state(request, !fechaAux.isEmpty(), "tromem.keylet", "anonymous.xxx.error.null");
		
		
		//validacion vacio deadline
		final String fechaAux1 = request.getModel().getString("tromem.deadline");		
		errors.state(request, !fechaAux1.isEmpty(), "tromem.deadline", "anonymous.xxx.error.null");

		//validacion errores formato deadline
		if(!errors.hasErrors("tromem.deadline")) {
			final Date deadlineAux = request.getModel().getDate("tromem.deadline");			
			if(deadlineAux!=null) {
				Calendar c;
				c=Calendar.getInstance();
				c.add(Calendar.DATE, +7);
				final Date aux = c.getTime();
				
				errors.state(request, deadlineAux.after(aux), "tromem.deadline", "anonymous.xxx.error.mas");
			}
		}	
		
		//Validacion de cantidad vacia.
		final Money budget = entity.getTromem().getBudget();
		errors.state(request, budget!=null, "tromem.budget", "anonymous.xxx.error.amountVacio");
		
		//Validacion de la moneda.
		boolean bc = false;
		if(budget!=null) {
			final String currency =entity.getTromem().getBudget().getCurrency();
			if(currency.equals("EUR") || currency.equals("USD") || currency.equals("GBP")) {
				bc = true;
			}
			errors.state(request, bc, "tromem.budget", "anonymous.xxx.error.currency");	
			final Double amount1 = entity.getTromem().getBudget().getAmount() ;	
			if(amount1<0) {
			  errors.state(request, false, "tromem.budget", "must be greater or equal to 0");
			}
		}
		
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
		
		
	
		this.repository.save(entity);
		this.repository2.save(entity.getTromem());
		
	}

	
}