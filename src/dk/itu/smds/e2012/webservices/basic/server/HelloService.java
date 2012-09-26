package dk.itu.smds.e2012.webservices.basic.server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import dk.itu.smds.e2012.webservices.basic.common.Utils;


@WebService(name="helloService", targetNamespace = "ourService",serviceName="helloService")
public class HelloService 
{	
	

    QName service =
            new QName("http://trustcare.itu.dk/task-manager-soap/TaskManagerService.svc", "getAllTasks", "getAllTasks");
    QName port =
            new QName("http://trustcare.itu.dk/task-manager-soap/TaskManagerService.svc", "getAllTasksPort", "getAllTasks");
    String endpointAddress = "http://trustcare.itu.dk/task-manager-soap/TaskManagerService.svc";
    Service webservice = Service.create(service);
    

	
	
	public HelloService(){
		webservice.addPort(port, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);

	}
	
	@WebMethod(operationName="one")
	public String helloOperation(String name) {
		return "Hello " + name + "!";
	}
	
	@WebMethod(operationName="two")
	public String hellotwoOperation(String arg) {
		try {
            MessageFactory factory =
                    MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
            SOAPMessage request = factory.createMessage();
            SOAPPart soap = request.getSOAPPart();
            SOAPEnvelope envelope = soap.getEnvelope();
            SOAPHeader header = envelope.getHeader();//not used
            SOAPBody body = envelope.getBody();
            SOAPElement content = body.addBodyElement(
                    new QName("http://trustcare.itu.dk/task-manager-soap/TaskManagerService.svc",
                    "getAllTasks",
                    "m"));

            SOAPElement name;


            name = content.addChildElement("m");
            name.setTextContent("getAllTasks");




            Utils.print(request);



            Dispatch<SOAPMessage> dispatch =
                    webservice.createDispatch(port, SOAPMessage.class,
                    Service.Mode.MESSAGE);
            SOAPMessage response = dispatch.invoke(request);
            String text = response.getSOAPBody().getTextContent();

            return text;

            

        } catch (SOAPException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return "did not receive server answer";
	}
	/**
	* Publish the service end point.
	* @param args not used.
	*/
	public static void main(String[] args) 
	{
		Endpoint.publish("http://localhost:8085/labexercises/hello", new HelloService());
	}
}