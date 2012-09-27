package tests;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.xml.bind.JAXBException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import dk.itu.smds.e2012.webservices.basic.xml.Task;
import dk.itu.smds.e2012.webservices.basic.xml.TaskSerializer;
import dk.itu.smds.e2012.webservices.basic.xml.TaskList;

public class TestREST {
	public static void main(String[] args) throws JAXBException {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		
		TaskSerializer ser = new TaskSerializer();
		
		//Tasks tasks = new Tasks();
		//Task task = new Task("assn-01", "mandatory assignment 01", "17-09-2012", "not-executed", "Work out mandatory assignment and submit");
		//task.attendants.add("stud01");
		
		//tasks.tasks.add(task);
		
		Task task = new Task();
		task.id = "assn-05";
		task.name = "mandatory assignment 01";
		task.date = "17-09-2012";
		task.status = "not-executed";
		task.description = "Work out mandatory assignment and submit";
		task.attendants = "stud01";
		
		//Tasks tasks = new Tasks();
		
		WebResource service = client.resource(getBaseURI());
		//String xml = ser.serialize(tasks);
		System.out.println("SENDING "+task);
		try {

			service .path("tasks")
					.path("createtask")
					.accept(MediaType.APPLICATION_XML)
					.post(task);

		} catch (UniformInterfaceException e ) {
			e.printStackTrace();
		}


	}

	private static URI getBaseURI() {
	    return UriBuilder.fromUri("http://trustcare.itu.dk/task-manager-rest/").build();
	}
}
