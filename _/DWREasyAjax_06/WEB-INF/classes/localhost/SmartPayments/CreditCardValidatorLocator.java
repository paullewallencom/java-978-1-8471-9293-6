/**
 * CreditCardValidatorLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.SmartPayments;

public class CreditCardValidatorLocator extends org.apache.axis.client.Service implements localhost.SmartPayments.CreditCardValidator {

/**
 * Credit Card Validation and Card Type Web Service
 */

    public CreditCardValidatorLocator() {
    }


    public CreditCardValidatorLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CreditCardValidatorLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CreditCardValidatorSoap12
    private java.lang.String CreditCardValidatorSoap12_address = "http://www.tpisoft.com/smartpayments/validate.asmx";

    public java.lang.String getCreditCardValidatorSoap12Address() {
        return CreditCardValidatorSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CreditCardValidatorSoap12WSDDServiceName = "CreditCardValidatorSoap12";

    public java.lang.String getCreditCardValidatorSoap12WSDDServiceName() {
        return CreditCardValidatorSoap12WSDDServiceName;
    }

    public void setCreditCardValidatorSoap12WSDDServiceName(java.lang.String name) {
        CreditCardValidatorSoap12WSDDServiceName = name;
    }

    public localhost.SmartPayments.CreditCardValidatorSoap getCreditCardValidatorSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CreditCardValidatorSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCreditCardValidatorSoap12(endpoint);
    }

    public localhost.SmartPayments.CreditCardValidatorSoap getCreditCardValidatorSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            localhost.SmartPayments.CreditCardValidatorSoap12Stub _stub = new localhost.SmartPayments.CreditCardValidatorSoap12Stub(portAddress, this);
            _stub.setPortName(getCreditCardValidatorSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCreditCardValidatorSoap12EndpointAddress(java.lang.String address) {
        CreditCardValidatorSoap12_address = address;
    }


    // Use to get a proxy class for CreditCardValidatorSoap
    private java.lang.String CreditCardValidatorSoap_address = "http://www.tpisoft.com/smartpayments/validate.asmx";

    public java.lang.String getCreditCardValidatorSoapAddress() {
        return CreditCardValidatorSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CreditCardValidatorSoapWSDDServiceName = "CreditCardValidatorSoap";

    public java.lang.String getCreditCardValidatorSoapWSDDServiceName() {
        return CreditCardValidatorSoapWSDDServiceName;
    }

    public void setCreditCardValidatorSoapWSDDServiceName(java.lang.String name) {
        CreditCardValidatorSoapWSDDServiceName = name;
    }

    public localhost.SmartPayments.CreditCardValidatorSoap getCreditCardValidatorSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CreditCardValidatorSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCreditCardValidatorSoap(endpoint);
    }

    public localhost.SmartPayments.CreditCardValidatorSoap getCreditCardValidatorSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            localhost.SmartPayments.CreditCardValidatorSoapStub _stub = new localhost.SmartPayments.CreditCardValidatorSoapStub(portAddress, this);
            _stub.setPortName(getCreditCardValidatorSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCreditCardValidatorSoapEndpointAddress(java.lang.String address) {
        CreditCardValidatorSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (localhost.SmartPayments.CreditCardValidatorSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                localhost.SmartPayments.CreditCardValidatorSoap12Stub _stub = new localhost.SmartPayments.CreditCardValidatorSoap12Stub(new java.net.URL(CreditCardValidatorSoap12_address), this);
                _stub.setPortName(getCreditCardValidatorSoap12WSDDServiceName());
                return _stub;
            }
            if (localhost.SmartPayments.CreditCardValidatorSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                localhost.SmartPayments.CreditCardValidatorSoapStub _stub = new localhost.SmartPayments.CreditCardValidatorSoapStub(new java.net.URL(CreditCardValidatorSoap_address), this);
                _stub.setPortName(getCreditCardValidatorSoapWSDDServiceName());
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
        if ("CreditCardValidatorSoap12".equals(inputPortName)) {
            return getCreditCardValidatorSoap12();
        }
        else if ("CreditCardValidatorSoap".equals(inputPortName)) {
            return getCreditCardValidatorSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://localhost/SmartPayments/", "CreditCardValidator");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://localhost/SmartPayments/", "CreditCardValidatorSoap12"));
            ports.add(new javax.xml.namespace.QName("http://localhost/SmartPayments/", "CreditCardValidatorSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CreditCardValidatorSoap12".equals(portName)) {
            setCreditCardValidatorSoap12EndpointAddress(address);
        }
        else 
if ("CreditCardValidatorSoap".equals(portName)) {
            setCreditCardValidatorSoapEndpointAddress(address);
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
