package dk.itu.smds.e2012.webservices.basic.client;

import dk.itu.smds.e2012.webservices.basic.common.RestClient;
import dk.itu.smds.e2012.webservices.basic.xml.*;

import javax.xml.bind.JAXBException;
import java.io.PipedOutputStream;
import java.util.ArrayList;
/*
 * Author: csp
 *
 */

public class TrustcareRestClient {

    private RestClient rc;
    
    private TaskSerializer taskSer;
    
    private static TrustcareRestClient instance;
    
    private TrustcareRestClient(){
        rc = new RestClient();
        taskSer = new TaskSerializer();
    }

    public ArrayList<Task> getAllTasks() throws JAXBException {
        String xml = rc.DoRestCall("http://trustcare.itu.dk/task-manager-rest/tasks/", "GET", "");

        Tasks tasks = taskSer.deserialize(xml);

        return tasks.tasks;
    }

    public ArrayList<Task> getAttendantTasks(String attendantId) throws JAXBException {
        String xml = rc.DoRestCall("http://trustcare.itu.dk/task-manager-rest/tasks/attendant/"+attendantId, "GET", "");

        Tasks tasks = taskSer.deserialize(xml);

        return tasks.tasks;
    }

    public void deleteTask(String taskId){
        rc.DoRestCall("http://trustcare.itu.dk/task-manager-rest/tasks/DeleteTask?taskId="+taskId, "DELETE", "");
    }

    public void createTask(Tasks task) throws JAXBException {
        String taskXml = taskSer.serialize(task);

        rc.DoRestCall("http://trustcare.itu.dk/task-manager-rest/tasks/createtask", "POST", taskXml);
    }
    
    public void createTask(Task task) throws JAXBException {
        String taskXml = taskSer.serialize(task);

        rc.DoRestCall("http://trustcare.itu.dk/task-manager-rest/tasks/createtask", "POST", taskXml);
    }

    public void createTask(String taskXml){
    	System.out.println("SENDING "+taskXml);
        rc.DoRestCall("http://trustcare.itu.dk/task-manager-rest/tasks/createtask", "POST", taskXml);
    }

    public static TrustcareRestClient getInstance(){
    	if(instance == null) instance = new TrustcareRestClient();
    	return instance;
    }



}
