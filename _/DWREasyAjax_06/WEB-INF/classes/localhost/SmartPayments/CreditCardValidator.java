/**
 * CreditCardValidator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.SmartPayments;

public interface CreditCardValidator extends javax.xml.rpc.Service {

/**
 * Credit Card Validation and Card Type Web Service
 */
    public java.lang.String getCreditCardValidatorSoap12Address();

    public localhost.SmartPayments.CreditCardValidatorSoap getCreditCardValidatorSoap12() throws javax.xml.rpc.ServiceException;

    public localhost.SmartPayments.CreditCardValidatorSoap getCreditCardValidatorSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getCreditCardValidatorSoapAddress();

    public localhost.SmartPayments.CreditCardValidatorSoap getCreditCardValidatorSoap() throws javax.xml.rpc.ServiceException;

    public localhost.SmartPayments.CreditCardValidatorSoap getCreditCardValidatorSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
