package acme.features.anonymous.tasks;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.tasks.Task;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/task")
public class AnonymousTaskController extends AbstractController<Anonymous, Task>{
	
	@Autowired
	protected AnonymousTaskShowService showService;
  
  	@Autowired
	protected AnonymousTaskListService	listService;
	
	@PostConstruct
	protected void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
    super.addBasicCommand(BasicCommand.LIST, this.listService);
	}
}
