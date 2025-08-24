import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class CreditCardValidatorTest{
@Test	
public void testgetDaysInFunction(){
	int cardNumber = 5399831619690403;
		
	CreditCardValidator creditCardValidator = new CreditCardValidator();
	int result = creditCardValidator.getArrayFormOf(cardNumber);
	
	assertEquals(result, {5, 3, 9, 9, 8, 3, 1, 6, 1, 9, 6, 9, 0, 4, 0, 3});
}


}

