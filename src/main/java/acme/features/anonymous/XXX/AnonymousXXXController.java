package acme.features.anonymous.XXX;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.XXX.XXX;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/XXX/")
public class AnonymousXXXController extends AbstractController<Anonymous, XXX>{
	
	@Autowired
	private AnonymousXXXCreateService createService;
	
	@Autowired
	private AnonymousXXXListService listService;
	
	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.LIST, this.listService);
	}

}
