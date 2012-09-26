package tests;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.xml.bind.JAXBException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import dk.itu.smds.e2012.webservices.basic.xml.Task;
import dk.itu.smds.e2012.webservices.basic.xml.TaskSerializer;
import dk.itu.smds.e2012.webservices.basic.xml.Tasks;

public class TestREST {
	public static void main(String[] args) throws JAXBException {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		
		TaskSerializer ser = new TaskSerializer();
		
		Tasks tasks = new Tasks();
		Task task = new Task("task1", "A task of stuff", "20-02-2012", "Assigned", "IT's assigned");
		task.attendants.add("E aal");
		
		tasks.tasks.add(task);
		
		WebResource service = client.resource(getBaseURI());
		String xml = ser.serialize(task);
		System.out.println("SENDING "+xml);
		try {

			service .path("tasks")
					.path("createtask")
					.accept(MediaType.APPLICATION_XML)
					.post(xml);

		} catch (UniformInterfaceException e ) {
			e.printStackTrace();
		}


	}

	private static URI getBaseURI() {
	    return UriBuilder.fromUri("http://trustcare.itu.dk/task-manager-rest/").build();
	}
}
