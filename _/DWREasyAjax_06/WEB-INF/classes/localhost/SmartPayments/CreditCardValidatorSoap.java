/**
 * CreditCardValidatorSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.SmartPayments;

public interface CreditCardValidatorSoap extends java.rmi.Remote {

    /**
     * Returns the card issuer Visa, MasterCard, AMEX, etc., based
     * on the card number.
     */
    public java.lang.String getCardType(java.lang.String cardNumber) throws java.rmi.RemoteException;

    /**
     * Returns (T/F) if the card is a known commercial card (commercial
     * cards require customer code and sales tax amount to receive preferred
     * discount rate pricing.)
     */
    public boolean isCommercialCard(java.lang.String cardNumber) throws java.rmi.RemoteException;

    /**
     * Validates the credit card by checking the card length based
     * on the card type, performs a mod 10 checksum and validates the expiration
     * date. Returns 0 if good, 1001 - no card number, 1002 - no exp date,
     * 1003 - invalid card type, 1004 - invalid card length, 1005 - bad mod
     * 10 check, 1006 - bad expiration date.
     */
    public int validCard(java.lang.String cardNumber, java.lang.String expDate) throws java.rmi.RemoteException;

    /**
     * Validates the credit card length by checking the card length
     * based on the card type, Returns (T/F).
     */
    public boolean validCardLength(java.lang.String cardNumber) throws java.rmi.RemoteException;

    /**
     * Validates the expiration date by making sure it is a valid
     * date and the card has not expired, Returns (T/F).
     */
    public boolean validExpDate(java.lang.String expDate) throws java.rmi.RemoteException;

    /**
     * Validates the credit card by performing a mod 10 checksum on
     * the card number, Returns (T/F).
     */
    public boolean validMod10(java.lang.String cardNumber) throws java.rmi.RemoteException;

    /**
     * Lookup the Debit Network ID using a Card Number. Network ID
     * is a 3 characters string. If there is a match, the card can likely
     * be used as a Debit Card and processed through the Debit network. Possible
     * Network ID: ACL – Accel, AFN - AFFN, AKO – Alaska Option, C24 – CU24,
     * ILK – Interlink, JEN - Jeanie, MAC – Star Northeast (MAC), MAE – Maestro,
     * NET - NETS, NYC – NYCE, PUL – Pulse, SES – Star Southeast, SHZ – Shazam,
     * STX – Star West, TYM - TYME
     */
    public localhost.SmartPayments.Response getNetworkID(java.lang.String userName, java.lang.String password, java.lang.String cardNumber) throws java.rmi.RemoteException;
}
