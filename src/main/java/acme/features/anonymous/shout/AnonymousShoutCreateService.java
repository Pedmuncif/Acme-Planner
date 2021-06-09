package acme.features.anonymous.shout;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
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
		Calendar c;
		c=Calendar.getInstance();
	
		System.out.println(Calendar.WEEK_OF_MONTH);
		c.add(Calendar.DATE, +7);
		moment = new Date(System.currentTimeMillis()-1);
		result = new Shout();
//		result.setAuthor("John Doe");
//		result.setText("Lorem ipsum!");
		result.setMoment(moment);
//		result.setInfo("http://example.org");
		XXX x;
		x = new XXX();
		x.setMoment(c.getTime());
		result.setXxx(x);
		
		
		return result;
		
	}

	@Override
	public void validate(final Request<Shout> request, final Shout entity, final Errors errors) {
		//Validacion de fecha unica.
		final String fechaAux = request.getModel().getString("xxx.fecha");
		errors.state(request, !fechaAux.isEmpty(), "xxx.fecha", "anonymous.xxx.error.null");
		final XXX x = this.repository2.findXXXByFecha(fechaAux);
		errors.state(request, x==null, "xxx.fecha", "anonymous.xxx.error.fechaIgual");
		
		
		
		////
		
		final String xxxDateString = entity.getXxx().getFecha();
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        final LocalDate xxxDate = LocalDate.parse(xxxDateString, dtf);

        //Get current date as LocalDate
        final LocalDate today = LocalDate.now();

       errors.state(request, xxxDate.isEqual(today), "xxx.fecha", "anonymous.xxx.error.dateCurrent");

  
		
		////
		
		
		
		
		//Validacion de cantidad vacia.
		final String amount =  request.getModel().getString("xxx.amount");
		errors.state(request, !amount.isEmpty(), "xxx.amount", "anonymous.xxx.error.amountVacio");
		//Validacion de la moneda (lenguaje).
		final String[] trozo =  request.getModel().getString("xxx.amount").split(" ");
		boolean bc;
		bc = false;	
		if(request.getLocale().toString().equals("en")) {
			if(trozo[0].equals("EUR") || trozo[0].equals("USD") ) {
				bc = true;
			}
		}else {
			if(trozo[1].equals("EUR") || trozo[1].equals("USD") ) {
				bc = true;
			}
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
		
		
	
		this.repository.save(entity);
		this.repository2.save(entity.getXxx());
		
	}

	
}