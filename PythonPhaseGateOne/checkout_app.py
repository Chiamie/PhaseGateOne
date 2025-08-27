def get_product_details(item_name, item_quantity, item_price, item_total):
	let product_details = {};
	product_details.ITEM = item_name;
	product_details.QTY = item_quantity;
	product_details.PRICE = item_price;
	product_details.TOTAL = item_total;
	return product_details


def get_sub_total(user_cart):
	sum = 0;
	for number in range(0, len(user_cart)):
		for detail in user_cart[number]:
			if detail == "TOTAL":
				sum += user_cart[number][detail]
	return sum

	
def get_discount_of(sub_total, discount){
	discount_amount = sub_total * (discount / 100);
	return discount_amount;


def get_vat_of(sub_total):
	vat_amount = sub_total * (17.50 / 100)
		return vat_amount



def get_bill_total(sub_total, discount_amount, vat_amount){
	return (sub_total - discount_amount) + vat_amount;
}

def get_balance(amount_received, bill_total){
	return bill_total - amount_received;
}



//let productDetails = {};
userCart = []



userName = input("What is the customer's Name? ")

item_name = input("What did the customer buy? ")
item_quantity = int(input("How many pieces? "))
item_price = int(input("How much per unit? ")
item_total = item_price * item_quantity;


user_cart.append(get_product_details(item_name, item_quantity, item_price, item_total)
add_more_items = input("Add more Items? ")
while(add_more_items.lower() == "yes"){
	item_name = input("What did the customer buy? ");
	item_quantity = int(input("How many pieces? "));
	item_price = int(input("How much per unit? "));
	item_total = itemPrice * itemQuantity;
	userCart.append(get_product_details(item_name, item_quantity, item_price, item_total);
	add_more_items = input("Add more Items? ")
}

cashierName = prompt("What is your name? ");
discount = prompt("How much discount will he get? ");
let subTotal = getSubTotal(userCart);
let discountAmount = getDiscountOf(subTotal, discount);
let VATAmount = getVATOf(subTotal);
let billTotal = getBillTotal(subTotal, discountAmount, VATAmount);

let nameOfStore = `SEMICOLON STORES
				MAIN BRANCH
			`;
let storeAddress = "312, HERBERT MACAULAY WAY, SABO YABA, LAGOS"
let contact = "03293828343";
let date = new Date();


console.log(nameOfStore);
console.log("LOCATION: " + storeAddress);
console.log("TEL: " + contact);
console.log("Date: " + date);
console.log("Cashier: " + cashierName);

console.log("Customer Name: " + userName);




console.log("--".repeat(10));
let columns = Object.keys(userCart[0]);
console.log("\t".repeat(5) + columns.join("\t"));
userCart.forEach(row => {console.log("\t".repeat(4) + Object.values(row).join("\t"));
});
console.log("\t".repeat(4) + "Sub Total" + subTotal);
console.log("\t".repeat(4) + "Discount" + discountAmount);
console.log("\t".repeat(4) + "VAT @ 17.50%" + VATAmount);
console.log("\t".repeat(4) + "Bill Total" + billTotal);

console.log("THIS IS NOT A RECEIPT KINDLY PAY" + billTotal);





let amountReceived = prompt("How much did the customer give to you? ");
let balance = getBalance(amountReceived, billTotal)

console.log("--".repeat(10));
columns = Object.keys(userCart[0]);
console.log("\t".repeat(5) + columns.join("\t"));
userCart.forEach(row => {console.log("\t".repeat(4) + Object.values(row).join("\t"));
});
console.log("\t".repeat(4) + "Sub Total: " + subTotal);
console.log("\t".repeat(4) + "Discount: " + discountAmount);
console.log("\t".repeat(4) + "VAT @ 17.50%: " + VATAmount);
console.log("\t".repeat(4) + "Bill Total: " + billTotal);
console.log("\t".repeat(4) + "Amount Paid: " + amountReceived);
console.log("\t".repeat(4) + "Balance: " + balance);


console.log("THANK YOU FOR YOUR PATRONAGE");
















































