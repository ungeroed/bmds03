package dk.itu.smds.e2012.webservices.basic.client;

import dk.itu.smds.e2012.webservices.basic.common.Utils;
import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

public class HelloServiceClientModified {
	private final String URI = "http://smds-e2012.itu.dk/webservices/basicsample";
	
	
	private final String prefix = "itu";

	private QName service;
	private QName port;
	
	private Service webservice;
	private String endpointAddress;
    
	
	public HelloServiceClientModified(){
		service = new QName(URI, "helloService");
        port = new QName(URI, "helloServicePort");
        endpointAddress = "http://localhost:8085/labexercises/hello";
        webservice = Service.create(service);
        webservice.addPort(port, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
	}

	
	public String call(String argument, String localMethodName) throws SOAPException{
		String argumentName = "arg0";
		
		SOAPMessage request = getRequest();
        SOAPBody body = getSOAPBody(request);
        
        SOAPElement helloElement = getOperation(body, URI, localMethodName,prefix);
        addArguments(helloElement, argumentName, argument);
       
        //Utils.print(request);

        SOAPMessage response = getSOAPResponseMessage(webservice, port, request);
        
        String text = response.getSOAPBody().getTextContent();

//        Utils.print(response);

        return text;
	}
	
	public static void main(String[] args) {
		String helloMethod = "helloOperation";
		String getMethod = "get";
		String putMethod = "put";
		String deleteMethod = "delete";
		
		try
		{
			String person = "Love Doctor";
			HelloServiceClientModified client = new HelloServiceClientModified();
			String responseHello = client.call(person, helloMethod);
			String responseGet = client.call(person, getMethod);
			String responsePut = client.call(person, putMethod);
			String responseDelete = client.call(person, deleteMethod);
			
			System.out.println(responseHello);
			System.out.println(responseGet);
			System.out.println(responsePut);
			System.out.println(responseDelete);
			
			
		} catch (SOAPException soapE){
			
			System.out.println("SOAP fucked up!");
		}
	}
    
    private static SOAPBody getSOAPBody(SOAPMessage request) throws SOAPException{
    	SOAPPart soap = request.getSOAPPart();
        SOAPEnvelope envelope = soap.getEnvelope();
        SOAPBody body = envelope.getBody();
        
    	return body;
    }
    
    private static SOAPMessage getRequest() throws SOAPException{
    	MessageFactory factory =
                MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
        SOAPMessage request = factory.createMessage();
        
        return request;
    }
    
    private static SOAPElement getOperation(SOAPBody body, String URI, String localPart, String prefix) throws SOAPException{
    	SOAPElement content = body.addBodyElement(
                new QName(URI,
                localPart,
                prefix));

    	return content;
    }
    
    private static void addArguments(SOAPElement element, String argName, String argValue) throws SOAPException{
    	SOAPElement name = element.addChildElement(argName);
        name.setTextContent(argValue);
    }
    
    private static SOAPMessage getSOAPResponseMessage(Service webservice, QName port, SOAPMessage request){
    	Dispatch<SOAPMessage> dispatch =
                webservice.createDispatch(port, SOAPMessage.class,
                Service.Mode.MESSAGE);
        SOAPMessage response = dispatch.invoke(request);
        
    	return response;
    }
}
