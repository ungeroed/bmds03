package test;

import java.rmi.RemoteException;

import dk.itu.smds.e2012.webservices.basic.services.*;

public class TestSoapClient {
	public static void main(String[] args){
		SoapService proxy = new SoapServiceProxy();
		
		try {
			System.out.println(proxy.getAttendantTasks("rao", 1));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
