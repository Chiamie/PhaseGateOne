import java.util.Scanner;

public class CreditCardValidator{
public static void main(String[] args){


System.out.println(checkTypeOfCard("5399831619690403"));



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
		return "valid";
	} else
		return "invalid";
}







}