package dk.itu.smds.e2012.webservices.basic.server.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

import dk.itu.smds.e2012.webservices.basic.client.TrustcareRestClient;
import dk.itu.smds.e2012.webservices.basic.xml.Task;

@Path("/task/{PARAM}")
public class TaskParamRessource {
	
	TrustcareRestClient trc = TrustcareRestClient.getInstance();
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
//	@Consumes({MediaType.TEXT_PLAIN})
	public List<Task> getTaskByAttendant(@PathParam("PARAM") String attendantId) throws JAXBException{
		
		List<Task> tasks =  trc.getAttendantTasks(attendantId);
		
		return tasks;
	}
	
	@DELETE
	public void deleteTask(@PathParam("PARAM") String taskId){
		trc.deleteTask(taskId);
	}
}
