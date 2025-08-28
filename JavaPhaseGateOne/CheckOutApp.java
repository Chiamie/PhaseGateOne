import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class CheckOutApp{
public static void main(String[] args){
Scanner input = new Scanner(System.in);
LocalDateTime currentTime = LocalDateTime.now();


ArrayList<String> items = new ArrayList<String>();
ArrayList<Integer> itemsQuantity = new ArrayList<Integer>();
ArrayList<Integer> itemsPrice = new ArrayList<Integer>();
ArrayList<Integer> total = new ArrayList<Integer>();


System.out.println("What is the customer's Name? ");
String userName = input.next();

System.out.println("What did the customer buy? ");
String itemName = input.next();

System.out.println("How many pieces? ");
int itemQuantity = input.nextInt();

System.out.println("How much per unit? ");
int itemPrice = input.nextInt();


int itemTotal = itemPrice * itemQuantity;

items.add(itemName);
itemsQuantity.add(itemQuantity);
itemsPrice.add(itemPrice);
total.add(itemTotal);

System.out.println("Add more Items? ");
String addMoreItems = input.next();
while(addMoreItems.toLowerCase().equals("yes")){

	System.out.println("What did the customer buy? ");
	itemName = input.next();

	System.out.println("How many pieces? ");
	itemQuantity = input.nextInt();

	System.out.println("How much per unit? ");
	itemPrice = input.nextInt();

	itemTotal = itemPrice * itemQuantity;

	items.add(itemName);
	itemsQuantity.add(itemQuantity);
	itemsPrice.add(itemPrice);
	total.add(itemTotal);

	System.out.println("Add more Items? ");
	addMoreItems = input.next();
}

System.out.println("What is your name? ");
String cashierName = input.next();

System.out.println("How much discount will he get? ");
int discount = input.nextInt();

int subTotal = getSubTotal(total);
double discountAmount = getDiscountOf(subTotal, discount);
double VATAmount = getVATOf(subTotal);
double billTotal = getBillTotal(subTotal, discountAmount, VATAmount);

String nameOfStore = """ 
				SEMICOLON STORES
				MAIN BRANCH
				""";
			
String storeAddress = "312, HERBERT MACAULAY WAY, SABO YABA, LAGOS";
String contact = "03293828343";



System.out.println(nameOfStore);
System.out.println("LOCATION: " + storeAddress);
System.out.println("TEL: " + contact);
System.out.println(currentTime);
System.out.println("Cashier: " + cashierName);

System.out.println("Customer Name: " + userName);


System.out.println("-----------".repeat(10));
System.out.println("\t\tITEM\tQTY\tPRICE\tTOTAL(NGN)");
for(int index = 0; index < items.size(); index++){
	System.out.printf("\t\t%s\t%d\t%d\t%d%n", items.get(index), itemsQuantity.get(index), itemsPrice.get(index), total.get(index));
}


System.out.println("\t\t" + "Sub Total" + subTotal);
System.out.println("\t".repeat(4) + "Discount" + discountAmount);
System.out.println("\t".repeat(4) + "VAT @ 17.50%" + VATAmount);
System.out.println("\t".repeat(4) + "Bill Total" + billTotal);

System.out.println("THIS IS NOT A RECEIPT KINDLY PAY: " + billTotal);




System.out.println("How much did the customer give to you? ");
int amountReceived = input.nextInt();
double balance = getBalance(amountReceived, billTotal);

System.out.println("-------------".repeat(10));

System.out.println("--------------".repeat(10));
System.out.println("ITEM\tQTY\tPRICE\tTOTAL(NGN)");
for(int index = 0; index < items.size(); index++){
	System.out.printf("\t\t%s\t%d\t%d\t%d%n", items.get(index), itemsQuantity.get(index), itemsPrice.get(index), total.get(index));
}


System.out.println("\t".repeat(4) + "Sub Total: " + subTotal);
System.out.println("\t".repeat(4) + "Discount: " + discountAmount);
System.out.println("\t".repeat(4) + "VAT @ 17.50%: " + VATAmount);
System.out.println("\t".repeat(4) + "Bill Total: " + billTotal);
System.out.println("\t".repeat(4) + "Amount Paid: " + amountReceived);
System.out.println("\t".repeat(4) + "Balance: " + balance);


System.out.println("THANK YOU FOR YOUR PATRONAGE");


}	
		
	
public static int getSubTotal(ArrayList<Integer> total){
	int sum = 0;
	for(int index = 0; index < total.size(); index++){
		sum += total.get(index);
	}
	return sum;
}
	
public static double getDiscountOf(int subTotal, int discount){
	int discountAmount = subTotal * (discount / 100);
	return discountAmount;
}

public static double getVATOf(int subTotal){
	double VATAmount = subTotal * (17.50 / 100);
	return VATAmount;
}

public static double getBillTotal(int subTotal, double discountAmount, double VATAmount ){
	return (subTotal - discountAmount) + VATAmount;
}

public static double getBalance(int amountReceived, double billTotal){
	return amountReceived - billTotal;
}



}













































