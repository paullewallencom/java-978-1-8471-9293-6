/**
 * Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.SmartPayments;

public class Response  implements java.io.Serializable {
    private int result;

    private java.lang.String respMSG;

    private java.lang.String message;

    private java.lang.String message1;

    private java.lang.String message2;

    private java.lang.String authCode;

    private java.lang.String PNRef;

    private java.lang.String hostCode;

    private java.lang.String hostURL;

    private java.lang.String receiptURL;

    private java.lang.String getAVSResult;

    private java.lang.String getAVSResultTXT;

    private java.lang.String getStreetMatchTXT;

    private java.lang.String getZipMatchTXT;

    private java.lang.String getCVResult;

    private java.lang.String getCVResultTXT;

    private java.lang.String getGetOrigResult;

    private java.lang.String getCommercialCard;

    private java.lang.String workingKey;

    private java.lang.String keyPointer;

    private java.lang.String extData;

    public Response() {
    }

    public Response(
           int result,
           java.lang.String respMSG,
           java.lang.String message,
           java.lang.String message1,
           java.lang.String message2,
           java.lang.String authCode,
           java.lang.String PNRef,
           java.lang.String hostCode,
           java.lang.String hostURL,
           java.lang.String receiptURL,
           java.lang.String getAVSResult,
           java.lang.String getAVSResultTXT,
           java.lang.String getStreetMatchTXT,
           java.lang.String getZipMatchTXT,
           java.lang.String getCVResult,
           java.lang.String getCVResultTXT,
           java.lang.String getGetOrigResult,
           java.lang.String getCommercialCard,
           java.lang.String workingKey,
           java.lang.String keyPointer,
           java.lang.String extData) {
           this.result = result;
           this.respMSG = respMSG;
           this.message = message;
           this.message1 = message1;
           this.message2 = message2;
           this.authCode = authCode;
           this.PNRef = PNRef;
           this.hostCode = hostCode;
           this.hostURL = hostURL;
           this.receiptURL = receiptURL;
           this.getAVSResult = getAVSResult;
           this.getAVSResultTXT = getAVSResultTXT;
           this.getStreetMatchTXT = getStreetMatchTXT;
           this.getZipMatchTXT = getZipMatchTXT;
           this.getCVResult = getCVResult;
           this.getCVResultTXT = getCVResultTXT;
           this.getGetOrigResult = getGetOrigResult;
           this.getCommercialCard = getCommercialCard;
           this.workingKey = workingKey;
           this.keyPointer = keyPointer;
           this.extData = extData;
    }


    /**
     * Gets the result value for this Response.
     * 
     * @return result
     */
    public int getResult() {
        return result;
    }


    /**
     * Sets the result value for this Response.
     * 
     * @param result
     */
    public void setResult(int result) {
        this.result = result;
    }


    /**
     * Gets the respMSG value for this Response.
     * 
     * @return respMSG
     */
    public java.lang.String getRespMSG() {
        return respMSG;
    }


    /**
     * Sets the respMSG value for this Response.
     * 
     * @param respMSG
     */
    public void setRespMSG(java.lang.String respMSG) {
        this.respMSG = respMSG;
    }


    /**
     * Gets the message value for this Response.
     * 
     * @return message
     */
    public java.lang.String getMessage() {
        return message;
    }


    /**
     * Sets the message value for this Response.
     * 
     * @param message
     */
    public void setMessage(java.lang.String message) {
        this.message = message;
    }


    /**
     * Gets the message1 value for this Response.
     * 
     * @return message1
     */
    public java.lang.String getMessage1() {
        return message1;
    }


    /**
     * Sets the message1 value for this Response.
     * 
     * @param message1
     */
    public void setMessage1(java.lang.String message1) {
        this.message1 = message1;
    }


    /**
     * Gets the message2 value for this Response.
     * 
     * @return message2
     */
    public java.lang.String getMessage2() {
        return message2;
    }


    /**
     * Sets the message2 value for this Response.
     * 
     * @param message2
     */
    public void setMessage2(java.lang.String message2) {
        this.message2 = message2;
    }


    /**
     * Gets the authCode value for this Response.
     * 
     * @return authCode
     */
    public java.lang.String getAuthCode() {
        return authCode;
    }


    /**
     * Sets the authCode value for this Response.
     * 
     * @param authCode
     */
    public void setAuthCode(java.lang.String authCode) {
        this.authCode = authCode;
    }


    /**
     * Gets the PNRef value for this Response.
     * 
     * @return PNRef
     */
    public java.lang.String getPNRef() {
        return PNRef;
    }


    /**
     * Sets the PNRef value for this Response.
     * 
     * @param PNRef
     */
    public void setPNRef(java.lang.String PNRef) {
        this.PNRef = PNRef;
    }


    /**
     * Gets the hostCode value for this Response.
     * 
     * @return hostCode
     */
    public java.lang.String getHostCode() {
        return hostCode;
    }


    /**
     * Sets the hostCode value for this Response.
     * 
     * @param hostCode
     */
    public void setHostCode(java.lang.String hostCode) {
        this.hostCode = hostCode;
    }


    /**
     * Gets the hostURL value for this Response.
     * 
     * @return hostURL
     */
    public java.lang.String getHostURL() {
        return hostURL;
    }


    /**
     * Sets the hostURL value for this Response.
     * 
     * @param hostURL
     */
    public void setHostURL(java.lang.String hostURL) {
        this.hostURL = hostURL;
    }


    /**
     * Gets the receiptURL value for this Response.
     * 
     * @return receiptURL
     */
    public java.lang.String getReceiptURL() {
        return receiptURL;
    }


    /**
     * Sets the receiptURL value for this Response.
     * 
     * @param receiptURL
     */
    public void setReceiptURL(java.lang.String receiptURL) {
        this.receiptURL = receiptURL;
    }


    /**
     * Gets the getAVSResult value for this Response.
     * 
     * @return getAVSResult
     */
    public java.lang.String getGetAVSResult() {
        return getAVSResult;
    }


    /**
     * Sets the getAVSResult value for this Response.
     * 
     * @param getAVSResult
     */
    public void setGetAVSResult(java.lang.String getAVSResult) {
        this.getAVSResult = getAVSResult;
    }


    /**
     * Gets the getAVSResultTXT value for this Response.
     * 
     * @return getAVSResultTXT
     */
    public java.lang.String getGetAVSResultTXT() {
        return getAVSResultTXT;
    }


    /**
     * Sets the getAVSResultTXT value for this Response.
     * 
     * @param getAVSResultTXT
     */
    public void setGetAVSResultTXT(java.lang.String getAVSResultTXT) {
        this.getAVSResultTXT = getAVSResultTXT;
    }


    /**
     * Gets the getStreetMatchTXT value for this Response.
     * 
     * @return getStreetMatchTXT
     */
    public java.lang.String getGetStreetMatchTXT() {
        return getStreetMatchTXT;
    }


    /**
     * Sets the getStreetMatchTXT value for this Response.
     * 
     * @param getStreetMatchTXT
     */
    public void setGetStreetMatchTXT(java.lang.String getStreetMatchTXT) {
        this.getStreetMatchTXT = getStreetMatchTXT;
    }


    /**
     * Gets the getZipMatchTXT value for this Response.
     * 
     * @return getZipMatchTXT
     */
    public java.lang.String getGetZipMatchTXT() {
        return getZipMatchTXT;
    }


    /**
     * Sets the getZipMatchTXT value for this Response.
     * 
     * @param getZipMatchTXT
     */
    public void setGetZipMatchTXT(java.lang.String getZipMatchTXT) {
        this.getZipMatchTXT = getZipMatchTXT;
    }


    /**
     * Gets the getCVResult value for this Response.
     * 
     * @return getCVResult
     */
    public java.lang.String getGetCVResult() {
        return getCVResult;
    }


    /**
     * Sets the getCVResult value for this Response.
     * 
     * @param getCVResult
     */
    public void setGetCVResult(java.lang.String getCVResult) {
        this.getCVResult = getCVResult;
    }


    /**
     * Gets the getCVResultTXT value for this Response.
     * 
     * @return getCVResultTXT
     */
    public java.lang.String getGetCVResultTXT() {
        return getCVResultTXT;
    }


    /**
     * Sets the getCVResultTXT value for this Response.
     * 
     * @param getCVResultTXT
     */
    public void setGetCVResultTXT(java.lang.String getCVResultTXT) {
        this.getCVResultTXT = getCVResultTXT;
    }


    /**
     * Gets the getGetOrigResult value for this Response.
     * 
     * @return getGetOrigResult
     */
    public java.lang.String getGetGetOrigResult() {
        return getGetOrigResult;
    }


    /**
     * Sets the getGetOrigResult value for this Response.
     * 
     * @param getGetOrigResult
     */
    public void setGetGetOrigResult(java.lang.String getGetOrigResult) {
        this.getGetOrigResult = getGetOrigResult;
    }


    /**
     * Gets the getCommercialCard value for this Response.
     * 
     * @return getCommercialCard
     */
    public java.lang.String getGetCommercialCard() {
        return getCommercialCard;
    }


    /**
     * Sets the getCommercialCard value for this Response.
     * 
     * @param getCommercialCard
     */
    public void setGetCommercialCard(java.lang.String getCommercialCard) {
        this.getCommercialCard = getCommercialCard;
    }


    /**
     * Gets the workingKey value for this Response.
     * 
     * @return workingKey
     */
    public java.lang.String getWorkingKey() {
        return workingKey;
    }


    /**
     * Sets the workingKey value for this Response.
     * 
     * @param workingKey
     */
    public void setWorkingKey(java.lang.String workingKey) {
        this.workingKey = workingKey;
    }


    /**
     * Gets the keyPointer value for this Response.
     * 
     * @return keyPointer
     */
    public java.lang.String getKeyPointer() {
        return keyPointer;
    }


    /**
     * Sets the keyPointer value for this Response.
     * 
     * @param keyPointer
     */
    public void setKeyPointer(java.lang.String keyPointer) {
        this.keyPointer = keyPointer;
    }


    /**
     * Gets the extData value for this Response.
     * 
     * @return extData
     */
    public java.lang.String getExtData() {
        return extData;
    }


    /**
     * Sets the extData value for this Response.
     * 
     * @param extData
     */
    public void setExtData(java.lang.String extData) {
        this.extData = extData;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Response)) return false;
        Response other = (Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.result == other.getResult() &&
            ((this.respMSG==null && other.getRespMSG()==null) || 
             (this.respMSG!=null &&
              this.respMSG.equals(other.getRespMSG()))) &&
            ((this.message==null && other.getMessage()==null) || 
             (this.message!=null &&
              this.message.equals(other.getMessage()))) &&
            ((this.message1==null && other.getMessage1()==null) || 
             (this.message1!=null &&
              this.message1.equals(other.getMessage1()))) &&
            ((this.message2==null && other.getMessage2()==null) || 
             (this.message2!=null &&
              this.message2.equals(other.getMessage2()))) &&
            ((this.authCode==null && other.getAuthCode()==null) || 
             (this.authCode!=null &&
              this.authCode.equals(other.getAuthCode()))) &&
            ((this.PNRef==null && other.getPNRef()==null) || 
             (this.PNRef!=null &&
              this.PNRef.equals(other.getPNRef()))) &&
            ((this.hostCode==null && other.getHostCode()==null) || 
             (this.hostCode!=null &&
              this.hostCode.equals(other.getHostCode()))) &&
            ((this.hostURL==null && other.getHostURL()==null) || 
             (this.hostURL!=null &&
              this.hostURL.equals(other.getHostURL()))) &&
            ((this.receiptURL==null && other.getReceiptURL()==null) || 
             (this.receiptURL!=null &&
              this.receiptURL.equals(other.getReceiptURL()))) &&
            ((this.getAVSResult==null && other.getGetAVSResult()==null) || 
             (this.getAVSResult!=null &&
              this.getAVSResult.equals(other.getGetAVSResult()))) &&
            ((this.getAVSResultTXT==null && other.getGetAVSResultTXT()==null) || 
             (this.getAVSResultTXT!=null &&
              this.getAVSResultTXT.equals(other.getGetAVSResultTXT()))) &&
            ((this.getStreetMatchTXT==null && other.getGetStreetMatchTXT()==null) || 
             (this.getStreetMatchTXT!=null &&
              this.getStreetMatchTXT.equals(other.getGetStreetMatchTXT()))) &&
            ((this.getZipMatchTXT==null && other.getGetZipMatchTXT()==null) || 
             (this.getZipMatchTXT!=null &&
              this.getZipMatchTXT.equals(other.getGetZipMatchTXT()))) &&
            ((this.getCVResult==null && other.getGetCVResult()==null) || 
             (this.getCVResult!=null &&
              this.getCVResult.equals(other.getGetCVResult()))) &&
            ((this.getCVResultTXT==null && other.getGetCVResultTXT()==null) || 
             (this.getCVResultTXT!=null &&
              this.getCVResultTXT.equals(other.getGetCVResultTXT()))) &&
            ((this.getGetOrigResult==null && other.getGetGetOrigResult()==null) || 
             (this.getGetOrigResult!=null &&
              this.getGetOrigResult.equals(other.getGetGetOrigResult()))) &&
            ((this.getCommercialCard==null && other.getGetCommercialCard()==null) || 
             (this.getCommercialCard!=null &&
              this.getCommercialCard.equals(other.getGetCommercialCard()))) &&
            ((this.workingKey==null && other.getWorkingKey()==null) || 
             (this.workingKey!=null &&
              this.workingKey.equals(other.getWorkingKey()))) &&
            ((this.keyPointer==null && other.getKeyPointer()==null) || 
             (this.keyPointer!=null &&
              this.keyPointer.equals(other.getKeyPointer()))) &&
            ((this.extData==null && other.getExtData()==null) || 
             (this.extData!=null &&
              this.extData.equals(other.getExtData())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getResult();
        if (getRespMSG() != null) {
            _hashCode += getRespMSG().hashCode();
        }
        if (getMessage() != null) {
            _hashCode += getMessage().hashCode();
        }
        if (getMessage1() != null) {
            _hashCode += getMessage1().hashCode();
        }
        if (getMessage2() != null) {
            _hashCode += getMessage2().hashCode();
        }
        if (getAuthCode() != null) {
            _hashCode += getAuthCode().hashCode();
        }
        if (getPNRef() != null) {
            _hashCode += getPNRef().hashCode();
        }
        if (getHostCode() != null) {
            _hashCode += getHostCode().hashCode();
        }
        if (getHostURL() != null) {
            _hashCode += getHostURL().hashCode();
        }
        if (getReceiptURL() != null) {
            _hashCode += getReceiptURL().hashCode();
        }
        if (getGetAVSResult() != null) {
            _hashCode += getGetAVSResult().hashCode();
        }
        if (getGetAVSResultTXT() != null) {
            _hashCode += getGetAVSResultTXT().hashCode();
        }
        if (getGetStreetMatchTXT() != null) {
            _hashCode += getGetStreetMatchTXT().hashCode();
        }
        if (getGetZipMatchTXT() != null) {
            _hashCode += getGetZipMatchTXT().hashCode();
        }
        if (getGetCVResult() != null) {
            _hashCode += getGetCVResult().hashCode();
        }
        if (getGetCVResultTXT() != null) {
            _hashCode += getGetCVResultTXT().hashCode();
        }
        if (getGetGetOrigResult() != null) {
            _hashCode += getGetGetOrigResult().hashCode();
        }
        if (getGetCommercialCard() != null) {
            _hashCode += getGetCommercialCard().hashCode();
        }
        if (getWorkingKey() != null) {
            _hashCode += getWorkingKey().hashCode();
        }
        if (getKeyPointer() != null) {
            _hashCode += getKeyPointer().hashCode();
        }
        if (getExtData() != null) {
            _hashCode += getExtData().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://localhost/SmartPayments/", "Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost/SmartPayments/", "Result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("respMSG");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost/SmartPayments/", "RespMSG"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost/SmartPayments/", "Message"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost/SmartPayments/", "Message1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost/SmartPayments/", "Message2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost/SmartPayments/", "AuthCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PNRef");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost/SmartPayments/", "PNRef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hostCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost/SmartPayments/", "HostCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hostURL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost/SmartPayments/", "HostURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiptURL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost/SmartPayments/", "ReceiptURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getAVSResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost/SmartPayments/", "GetAVSResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getAVSResultTXT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost/SmartPayments/", "GetAVSResultTXT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getStreetMatchTXT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost/SmartPayments/", "GetStreetMatchTXT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getZipMatchTXT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost/SmartPayments/", "GetZipMatchTXT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getCVResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost/SmartPayments/", "GetCVResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getCVResultTXT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost/SmartPayments/", "GetCVResultTXT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getGetOrigResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost/SmartPayments/", "GetGetOrigResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getCommercialCard");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost/SmartPayments/", "GetCommercialCard"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workingKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost/SmartPayments/", "WorkingKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keyPointer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost/SmartPayments/", "KeyPointer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://localhost/SmartPayments/", "ExtData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
