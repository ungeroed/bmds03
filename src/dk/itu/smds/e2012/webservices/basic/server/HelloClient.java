package dk.itu.smds.e2012.webservices.basic.server;

import dk.itu.smds.e2012.webservices.basic.client.TrustcareRestClient;

import javax.xml.bind.JAXBException;

/*
* Author: csp
*
*/
public class HelloClient {
  public static void main(String[] argv) {
      TrustcareRestClient tc = new TrustcareRestClient();
      try {
          System.out.println(tc.getAllTasks());
          System.out.println(tc.getAttendantTasks("hilde"));
      } catch (JAXBException e) {
          e.printStackTrace();
      }
  }
}