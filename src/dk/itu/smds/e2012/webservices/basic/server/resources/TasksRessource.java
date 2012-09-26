package dk.itu.smds.e2012.webservices.basic.server.resources;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import dk.itu.smds.e2012.webservices.basic.xml.Task;
import dk.itu.smds.e2012.webservices.basic.xml.Tasks;
import dk.itu.smds.e2012.webservices.basic.client.TrustcareRestClient;
import dk.itu.smds_e2012.lab.week_04.*;

@Path("/task")
public class TasksRessource {
	
	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;
	
	ITaskManagerService soapProxy = new ITaskManagerServiceProxy();
	
	TrustcareRestClient trc = TrustcareRestClient.getInstance();
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public ArrayList<Task> getTaskXML() throws JAXBException{
		
		ArrayList<Task> tasks =  trc.getAllTasks();
		
		return tasks;
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes({MediaType.TEXT_PLAIN})
	public ArrayList<Task> getTaskXML(String attendantId) throws JAXBException{
		
		ArrayList<Task> tasks =  trc.getAttendantTasks(attendantId);
		
		return tasks;
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_XML})
	public void createTask(JAXBElement<Task> task) throws JAXBException{
		
		// trc.createTask(task.getValue()); // DOESN't WORK???
		
	}
	
	/* @POST
	@Consumes({MediaType.APPLICATION_XML})
	public void createTasks(JAXBElement<Tasks> tasks) throws JAXBException{
		
		// trc.createTask(tasks.getValue()); // Doesn't work ?!?!?
	}*/
	
	@DELETE
	@Consumes({MediaType.TEXT_PLAIN})
	public void deleteTask(String taskId){
		trc.deleteTask(taskId);
	}
}
