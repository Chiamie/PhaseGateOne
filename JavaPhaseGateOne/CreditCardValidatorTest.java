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
}

