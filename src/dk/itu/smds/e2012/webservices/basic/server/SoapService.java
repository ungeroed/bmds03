package dk.itu.smds.e2012.webservices.basic.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name="SoapService", targetNamespace = "SoapService",serviceName="SoapService")
public class SoapService {
	
	@WebMethod(operationName="GetAttendantTasks")
	public String GetAttendantTasks(String attendantId, int serviceOption){return "";}
	
	@WebMethod(operationName="GetAttendantTasks")
	public void CreateTask(String taskXml, int serviceOption){}
	
	@WebMethod(operationName="GetAttendantTasks")
	public void DeleteTask(String taskId, int serviceOption){}	

}
