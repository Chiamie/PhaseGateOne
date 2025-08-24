public class CreditCardValidator{
public static void main(String[] args){





}

public static int getArrayFormOf(int cardNumber){
	String cardNumberAsString = "" + cardNumber;
	String[] cardNumberAsStringArray = cardNumberAsString.split("");
	int[] cardNumberAsArray = new int[cardNumberAsStringArray.length];
	for(int index = 0; index < cardNumberAsArray.length; index++){
		cardNumberAsArray[index] = Integer.parseInt(cardNumberAsArray[index]);
	}
	return cardNumberAsArray;
		
}









}