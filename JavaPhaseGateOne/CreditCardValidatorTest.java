import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CreditCardValidatorTest{
@Test	
public void testGetDaysInFunction(){
	String cardNumber = "5399831619690403";
		
	CreditCardValidator creditCardValidator = new CreditCardValidator();
	int[] result = creditCardValidator.getArrayFormOf(cardNumber);
	int[] expected = new int[]{5, 3, 9, 9, 8, 3, 1, 6, 1, 9, 6, 9, 0, 4, 0, 3};
	
	assertArrayEquals(result, expected);
							
}

@Test	
public void testdoubleDigitsAtEvenIndexInFunction(){
	int[] cardNumberAsArray = {5, 3, 9, 9, 8, 3, 1, 6, 1, 9, 6, 9, 0, 4, 0, 3};
		
	CreditCardValidator creditCardValidator = new CreditCardValidator();
	int result = creditCardValidator.doubleDigitsAtEvenIndexIn(cardNumberAsArray);
	
	
	assertEquals(result, 24);
							
}

@Test	
public void testdoubleDigitsAtEvenIndexInFunction1(){
	int[] cardNumberAsArray = {4, 3, 8, 8, 5, 7, 6, 0, 1, 8, 4, 0, 2, 6, 2, 6};
		
	CreditCardValidator creditCardValidator = new CreditCardValidator();
	int result = creditCardValidator.doubleDigitsAtEvenIndexIn(cardNumberAsArray);
	
	
	assertEquals(result, 37);
							
}

@Test	
public void testGetSumOfDigitAtOddIndexOfFunction(){
	int[] cardNumberAsArray = {4, 3, 8, 8, 5, 7, 6, 0, 1, 8, 4, 0, 2, 6, 2, 6};
		
	CreditCardValidator creditCardValidator = new CreditCardValidator();
	int result = creditCardValidator.getSumOfDigitAtOddIndexOf(cardNumberAsArray);
	
	
	assertEquals(result, 38);

}

@Test	
public void testGetSumOfDigitAtOddIndexOfFunction1(){
	int[] cardNumberAsArray = {5, 3, 9, 9, 8, 3, 1, 6, 1, 9, 6, 9, 0, 4, 0, 3};
		
	CreditCardValidator creditCardValidator = new CreditCardValidator();
	int result = creditCardValidator.getSumOfDigitAtOddIndexOf(cardNumberAsArray);
	
	
	assertEquals(result, 46);
							
}

@Test	
public void testCheckDivisibilityBy10Function(){
	int total = 46 + 24;
		
	CreditCardValidator creditCardValidator = new CreditCardValidator();
	String result = creditCardValidator.checkDivisibilityBy10(total);
	
	
	assertEquals(result, "Valid");
							
}

@Test	
public void testCheckDivisibilityBy10Function1(){
	int total = 38 + 37;
		
	CreditCardValidator creditCardValidator = new CreditCardValidator();
	String result = creditCardValidator.checkDivisibilityBy10(total);
	
	
	assertEquals(result, "Invalid");
							
}

@Test	
public void testCheckTypeOfCardFuncyion(){
	String cardNumber = "5399831619690403";
		
	CreditCardValidator creditCardValidator = new CreditCardValidator();
	String result = creditCardValidator.checkTypeOfCard(cardNumber);
	
	
	assertEquals(result, "MasterCard");
							
}

@Test	
public void testCheckCardNumberLengthFunction(){
	String cardNumber = "5399831619690403";
		
	CreditCardValidator creditCardValidator = new CreditCardValidator();
	int result = creditCardValidator.checkCardNumberLength(cardNumber);
	
	
	assertEquals(result, 16);
							
}

@Test	
public void testGetValidityStatusOfFunction(){
	String cardNumber = "5399831619690404";
		
	CreditCardValidator creditCardValidator = new CreditCardValidator();
	String result = creditCardValidator.getValidityStatusOf(cardNumber);
	
	
	assertEquals(result, "Invalid");

}

@Test	
public void testGetValidityStatusOfFunction1(){
	String cardNumber = "4388576018410707";
		
	CreditCardValidator creditCardValidator = new CreditCardValidator();
	String result = creditCardValidator.getValidityStatusOf(cardNumber);
	
	
	assertEquals(result, "Valid");

}

}



