package localhost.SmartPayments;

public class CreditCardValidatorSoapProxy implements localhost.SmartPayments.CreditCardValidatorSoap {
  private String _endpoint = null;
  private localhost.SmartPayments.CreditCardValidatorSoap creditCardValidatorSoap = null;
  
  public CreditCardValidatorSoapProxy() {
    _initCreditCardValidatorSoapProxy();
  }
  
  public CreditCardValidatorSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initCreditCardValidatorSoapProxy();
  }
  
  private void _initCreditCardValidatorSoapProxy() {
    try {
      creditCardValidatorSoap = (new localhost.SmartPayments.CreditCardValidatorLocator()).getCreditCardValidatorSoap();
      if (creditCardValidatorSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)creditCardValidatorSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)creditCardValidatorSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (creditCardValidatorSoap != null)
      ((javax.xml.rpc.Stub)creditCardValidatorSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public localhost.SmartPayments.CreditCardValidatorSoap getCreditCardValidatorSoap() {
    if (creditCardValidatorSoap == null)
      _initCreditCardValidatorSoapProxy();
    return creditCardValidatorSoap;
  }
  
  public java.lang.String getCardType(java.lang.String cardNumber) throws java.rmi.RemoteException{
    if (creditCardValidatorSoap == null)
      _initCreditCardValidatorSoapProxy();
    return creditCardValidatorSoap.getCardType(cardNumber);
  }
  
  public boolean isCommercialCard(java.lang.String cardNumber) throws java.rmi.RemoteException{
    if (creditCardValidatorSoap == null)
      _initCreditCardValidatorSoapProxy();
    return creditCardValidatorSoap.isCommercialCard(cardNumber);
  }
  
  public int validCard(java.lang.String cardNumber, java.lang.String expDate) throws java.rmi.RemoteException{
    if (creditCardValidatorSoap == null)
      _initCreditCardValidatorSoapProxy();
    return creditCardValidatorSoap.validCard(cardNumber, expDate);
  }
  
  public boolean validCardLength(java.lang.String cardNumber) throws java.rmi.RemoteException{
    if (creditCardValidatorSoap == null)
      _initCreditCardValidatorSoapProxy();
    return creditCardValidatorSoap.validCardLength(cardNumber);
  }
  
  public boolean validExpDate(java.lang.String expDate) throws java.rmi.RemoteException{
    if (creditCardValidatorSoap == null)
      _initCreditCardValidatorSoapProxy();
    return creditCardValidatorSoap.validExpDate(expDate);
  }
  
  public boolean validMod10(java.lang.String cardNumber) throws java.rmi.RemoteException{
    if (creditCardValidatorSoap == null)
      _initCreditCardValidatorSoapProxy();
    return creditCardValidatorSoap.validMod10(cardNumber);
  }
  
  public localhost.SmartPayments.Response getNetworkID(java.lang.String userName, java.lang.String password, java.lang.String cardNumber) throws java.rmi.RemoteException{
    if (creditCardValidatorSoap == null)
      _initCreditCardValidatorSoapProxy();
    return creditCardValidatorSoap.getNetworkID(userName, password, cardNumber);
  }
  
  
}