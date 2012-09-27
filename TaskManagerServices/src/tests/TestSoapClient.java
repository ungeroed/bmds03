package tests;

import java.net.URI;
import java.rmi.RemoteException;

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

import dk.itu.smds_e2012.lab.week_04.*;
public class TestSoapClient {
	


	
	public static void main(String[] args) throws JAXBException {
		
		ITaskManagerService soapProxy = new ITaskManagerServiceProxy();
				
		TaskSerializer ser = new TaskSerializer();
		
		Task task = new Task();
		task.name = "A test";
		
		String xml = ser.serialize(task);
		
		try {
			soapProxy.createTask(xml);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("SENDING "+xml);
		
	}
}
