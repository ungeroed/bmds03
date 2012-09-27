/**
 * SoapService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package dk.itu.smds.e2012.webservices.basic.services;

public interface SoapService extends java.rmi.Remote {
    public java.lang.String getAttendantTasks(java.lang.String attendantId, int serviceOption) throws java.rmi.RemoteException;
    public void createTask(java.lang.String taskXml, int serviceOption) throws java.rmi.RemoteException;
    public void deleteTask(java.lang.String taskId, int serviceOption) throws java.rmi.RemoteException;
}
