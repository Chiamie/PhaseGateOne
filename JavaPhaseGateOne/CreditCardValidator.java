public class CreditCardValidator{
public static void main(String[] args){





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








}