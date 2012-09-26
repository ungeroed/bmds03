package dk.itu.smds.e2012.webservices.basic.server.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dk.itu.smds.e2012.webservices.basic.xml.Task;

@Path("/test")
public class TestRessource {
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Task getTaskXML(){
		Task task = new Task("task1", "A task of stuff", "20-02-2012", "Assigned", "IT's assigned");
		
		return task;
	}
	
	@GET
	@Produces({ MediaType.TEXT_XML })
	public Task getTaskHTML(){
		Task task = new Task();
		task.name = "A test task";
		
		return task;
	}
	
}
