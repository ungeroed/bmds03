package dk.itu.smds.e2012.webservices.basic.services;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.JAXBException;

import dk.itu.smds.e2012.webservices.basic.client.TrustcareRestClient;
import dk.itu.smds.e2012.webservices.basic.xml.Task;
import dk.itu.smds.e2012.webservices.basic.xml.TaskSerializer;
import dk.itu.smds.e2012.webservices.basic.xml.Tasks;
import dk.itu.smds_e2012.lab.week_04.ITaskManagerService;
import dk.itu.smds_e2012.lab.week_04.ITaskManagerServiceProxy;

@WebService(name="SoapService", targetNamespace = "SoapService",serviceName="SoapService")
public class SoapService {
	
	ITaskManagerService proxy = new ITaskManagerServiceProxy();
	
	TrustcareRestClient trc = TrustcareRestClient.getInstance(); 
	
	TaskSerializer ser = new TaskSerializer();
	
	@WebMethod(operationName="getAttendantTasks")
	public String getAttendantTasks(String attendantId, int serviceOption) throws RemoteException, JAXBException{
	
		if(serviceOption == 1) return proxy.getAttendantTasks(attendantId);
		
		if(serviceOption == 2) {
			ArrayList<Task> taskList = trc.getAttendantTasks(attendantId);
			Tasks tasks = new Tasks();
			for(Task task : taskList)
				tasks.tasks.add(task);
					
			return ser.serialize(tasks);
		}
		
		if(serviceOption == 3){
			String soapResponse = getAttendantTasks(attendantId, 1);
			String restResponse = getAttendantTasks(attendantId, 2);
			
			return "Soap response: \n"+soapResponse+"\n REST response: \n"+restResponse;
		}
		
		return "Error";
	}
	
	@WebMethod(operationName="createTask")
	public void createTask(String taskXml, int serviceOption) throws RemoteException{
		
		if(serviceOption == 1) proxy.createTask(taskXml);
		if(serviceOption == 2) trc.createTask(taskXml);
		if(serviceOption == 3){
			proxy.createTask(taskXml);
			trc.createTask(taskXml);
		}
	}
	
	@WebMethod(operationName="deleteTask")
	public void deleteTask(String taskId, int serviceOption) throws RemoteException{
		if(serviceOption == 1) proxy.deleteTask(taskId);
		if(serviceOption == 2) trc.deleteTask(taskId);
		if(serviceOption == 3){
			proxy.deleteTask(taskId);
			trc.deleteTask(taskId);
		}
	}	

}