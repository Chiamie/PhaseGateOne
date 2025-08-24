import java.util.Scanner;

public class CreditCardValidator{
public static void main(String[] args){

Scanner input = new Scanner(System.in);
System.out.println("Hello, Kindly Enter Card details to verify");

String cardNumber = input.next();
String cardType = checkTypeOfCard(cardNumber);
String cardLength = checkCardNumberLength(cardNumber);
String validityStatus = getValidityStatusOf(cardNumber);

if(cardType.startsWith("Invalid") || cardLength.startsWith("Invalid")) {
	System.out.println("Invalid Card Details");
} else {
	System.out.println("Credit Card Type: " + cardType);
	System.out.println("Credit Card Number: " + cardNumber);
	System.out.println("Credit Digit Length: " + cardLength);
	System.out.println("Credit Digit Validity Status: " + validityStatus);
}

}


public static String checkTypeOfCard(String cardNumber){
	if (cardNumber.charAt(0) == '4')
		return "Visa Card";
	else if (cardNumber.charAt(0) == '5')
		return "MasterCard";
	else if (cardNumber.charAt(0) == ('6'))
		return "Discover cards";
	else if ((cardNumber.charAt(0) == '3') && (cardNumber.charAt(1) == '7'))
		return "American Express Card";
	else
		return "Invalid card";
}

public static String checkCardNumberLength(String cardNumber){
	if ((cardNumber.length() >= 13) && (cardNumber.length() <= 16)){
		String cardLength = cardNumber.length() + "";
		return cardLength;
	}else
		return "Invalid Card Number";
	
}







public static int[] getArrayFormOf(String cardNumber){
	String[] cardNumberAsStringArray = cardNumber.split("");
	int[] cardNumberAsArray = new int[cardNumberAsStringArray.length];
	for(int index = 0; index < cardNumberAsArray.length; index++){
		cardNumberAsArray[index] = Integer.parseInt(cardNumberAsStringArray[index]);
	}
	return cardNumberAsArray;
		
}

public static int doubleDigitsAtEvenIndexIn(int[] cardNumberAsArray){
	int sum = 0;
	for(int index = cardNumberAsArray.length - 1; index >= 0; index--){
		int product = 1;
		if(index % 2 == 0){
			if (cardNumberAsArray[index] % 10 != 0){
				product = cardNumberAsArray[index] * 2;
				sum += (product % 10) + (product / 10);
			}else{
				sum += cardNumberAsArray[index] * 2;
			}
		}
	}
	return sum;
}
	
public static int getSumOfDigitAtOddIndexOf(int[] cardNumberAsArray){
	int sum = 0;
	for(int index = cardNumberAsArray.length - 1; index >= 0; index--){
		if(index % 2 != 0){
			sum += cardNumberAsArray[index];
		}
	}
	return sum;

}

public static String checkDivisibilityBy10(int total){
	if(total % 10 == 0){
		return "Valid";
	} else
		return "Invalid";
}

public static String getValidityStatusOf(String cardNumber){

	int[] cardNumberAsArray = getArrayFormOf(cardNumber);
	int evenIndexSum = doubleDigitsAtEvenIndexIn(cardNumberAsArray);
	int oddIndexSum = getSumOfDigitAtOddIndexOf(cardNumberAsArray);
	int total = evenIndexSum + oddIndexSum;
	return checkDivisibilityBy10(total);

}




}