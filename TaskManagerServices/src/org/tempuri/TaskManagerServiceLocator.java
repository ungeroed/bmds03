/**
 * TaskManagerServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class TaskManagerServiceLocator extends org.apache.axis.client.Service implements org.tempuri.TaskManagerService {

    public TaskManagerServiceLocator() {
    }


    public TaskManagerServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TaskManagerServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicHttpBinding_ITaskManagerService
    private java.lang.String BasicHttpBinding_ITaskManagerService_address = "http://trustcare.itu.dk/task-manager-soap/TaskManagerService.svc";

    public java.lang.String getBasicHttpBinding_ITaskManagerServiceAddress() {
        return BasicHttpBinding_ITaskManagerService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BasicHttpBinding_ITaskManagerServiceWSDDServiceName = "BasicHttpBinding_ITaskManagerService";

    public java.lang.String getBasicHttpBinding_ITaskManagerServiceWSDDServiceName() {
        return BasicHttpBinding_ITaskManagerServiceWSDDServiceName;
    }

    public void setBasicHttpBinding_ITaskManagerServiceWSDDServiceName(java.lang.String name) {
        BasicHttpBinding_ITaskManagerServiceWSDDServiceName = name;
    }

    public dk.itu.smds_e2012.lab.week_04.ITaskManagerService getBasicHttpBinding_ITaskManagerService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicHttpBinding_ITaskManagerService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicHttpBinding_ITaskManagerService(endpoint);
    }

    public dk.itu.smds_e2012.lab.week_04.ITaskManagerService getBasicHttpBinding_ITaskManagerService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.BasicHttpBinding_ITaskManagerServiceStub _stub = new org.tempuri.BasicHttpBinding_ITaskManagerServiceStub(portAddress, this);
            _stub.setPortName(getBasicHttpBinding_ITaskManagerServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicHttpBinding_ITaskManagerServiceEndpointAddress(java.lang.String address) {
        BasicHttpBinding_ITaskManagerService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (dk.itu.smds_e2012.lab.week_04.ITaskManagerService.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.BasicHttpBinding_ITaskManagerServiceStub _stub = new org.tempuri.BasicHttpBinding_ITaskManagerServiceStub(new java.net.URL(BasicHttpBinding_ITaskManagerService_address), this);
                _stub.setPortName(getBasicHttpBinding_ITaskManagerServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BasicHttpBinding_ITaskManagerService".equals(inputPortName)) {
            return getBasicHttpBinding_ITaskManagerService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "TaskManagerService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "BasicHttpBinding_ITaskManagerService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicHttpBinding_ITaskManagerService".equals(portName)) {
            setBasicHttpBinding_ITaskManagerServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
