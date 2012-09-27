package dk.itu.smds.e2012.webservices.basic.services;

public class SoapServiceProxy implements dk.itu.smds.e2012.webservices.basic.services.SoapService {
  private String _endpoint = null;
  private dk.itu.smds.e2012.webservices.basic.services.SoapService soapService = null;
  
  public SoapServiceProxy() {
    _initSoapServiceProxy();
  }
  
  public SoapServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initSoapServiceProxy();
  }
  
  private void _initSoapServiceProxy() {
    try {
      soapService = (new dk.itu.smds.e2012.webservices.basic.services.SoapServiceServiceLocator()).getSoapService();
      if (soapService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)soapService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)soapService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (soapService != null)
      ((javax.xml.rpc.Stub)soapService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public dk.itu.smds.e2012.webservices.basic.services.SoapService getSoapService() {
    if (soapService == null)
      _initSoapServiceProxy();
    return soapService;
  }
  
  public java.lang.String getAttendantTasks(java.lang.String attendantId, int serviceOption) throws java.rmi.RemoteException{
    if (soapService == null)
      _initSoapServiceProxy();
    return soapService.getAttendantTasks(attendantId, serviceOption);
  }
  
  public void createTask(java.lang.String taskXml, int serviceOption) throws java.rmi.RemoteException{
    if (soapService == null)
      _initSoapServiceProxy();
    soapService.createTask(taskXml, serviceOption);
  }
  
  public void deleteTask(java.lang.String taskId, int serviceOption) throws java.rmi.RemoteException{
    if (soapService == null)
      _initSoapServiceProxy();
    soapService.deleteTask(taskId, serviceOption);
  }
  
  
}