/**
 * SoapServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package dk.itu.smds.e2012.webservices.basic.services;

public interface SoapServiceService extends javax.xml.rpc.Service {
    public java.lang.String getSoapServiceAddress();

    public dk.itu.smds.e2012.webservices.basic.services.SoapService getSoapService() throws javax.xml.rpc.ServiceException;

    public dk.itu.smds.e2012.webservices.basic.services.SoapService getSoapService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
