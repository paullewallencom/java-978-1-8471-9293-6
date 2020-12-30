package samples;

public class FormHandler {

	public boolean submitOrder(String name,String address,String creditCardNumber,String expiryDate)
	{
		boolean validExpiryDate=checkExpiryFormat(expiryDate);
		boolean validCreditCardNumber=isValidCreditCard(creditCardNumber);
		//submit order to orderprocessing system
		boolean orderSubmitted=true;
		
		return validCreditCardNumber && validExpiryDate && orderSubmitted;
	}
	
	public boolean checkExpiryFormat(String expiryDate) {
		if (expiryDate.length() != 5) {
			return false;
		}
		if (expiryDate.indexOf("/") == -1) {
			return false;
		}
		String[] expDate = expiryDate.split("/");
		try {
			int month = Integer.parseInt(expDate[0]);
			int year = Integer.parseInt(expDate[1]);
			if ((month >= 1 && month <= 12) && (year >= 8 && year <= 99)) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/*
	 * The next two method perform credit card validation.
	 * Only the format is checked, it is not checked
	 * against a card holder.
	 * 
	 * Methods provided by Michael Gilleland in his essay
	 * "Anatomy of Credit Card Numbers" 
	 * http://www.merriampark.com/anatomycc.htm
	 */
	private String getDigitsOnly(String s) {
		StringBuffer digitsOnly = new StringBuffer();
		char c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (Character.isDigit(c)) {
				digitsOnly.append(c);
			}
		}
		return digitsOnly.toString();
	}

	public boolean isValidCreditCard(String cardNumber) {
		String digitsOnly = getDigitsOnly(cardNumber);
		int sum = 0;
		int digit = 0;
		int addend = 0;
		boolean timesTwo = false;

		for (int i = digitsOnly.length() - 1; i >= 0; i--) {
			digit = Integer.parseInt(digitsOnly.substring(i, i + 1));
			if (timesTwo) {
				addend = digit * 2;
				if (addend > 9) {
					addend -= 9;
				}
			} else {
				addend = digit;
			}
			sum += addend;
			timesTwo = !timesTwo;
		}
		int modulus = sum % 10;
		return modulus == 0;
	}
}