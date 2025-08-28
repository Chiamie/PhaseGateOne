function getProductDetails(itemName, itemQuantity, itemPrice, itemTotal){
	let productDetails = {};
	productDetails.ITEM = itemName;
	productDetails.QTY = itemQuantity;
	productDetails.PRICE = itemPrice;
	productDetails.TOTAL = itemTotal;
	return productDetails;
}

function getSubTotal(userCart){
	let sum = 0;
	for(let index = 0; index < userCart.length; index++){
		for(let detail in userCart[index]){
			if (detail == "TOTAL"){
				sum += userCart[index][detail];
			}
		}
	}
	return sum;
}
	
function getDiscountOf(subTotal, discount){
	let discountAmount = subTotal * (discount / 100);
	return discountAmount;
}

function getVATOf(subTotal){
	let VATAmount = subTotal * (17.50 / 100);
		return VATAmount;
}


function getBillTotal(subTotal, discountAmount, VATAmount){
	return (subTotal - discountAmount) + VATAmount;
}

function getBalance(amountReceived, billTotal){
	return amountReceived - billTotal;
}



const prompt = require('prompt-sync')();
//let productDetails = {};
let userCart = [];




let userName;
let itemName;
let itemQuantity;
let itemPrice;
let itemTotal;
let discount;
let cashierName;


userName = prompt("What is the customer's Name? ");

itemName = prompt("What did the customer buy? ");
itemQuantity = prompt("How many pieces? ");
itemPrice = prompt("How much per unit? ");
itemTotal = itemPrice * itemQuantity;


userCart.push(getProductDetails(itemName, itemQuantity, itemPrice, itemTotal));
let addMoreItems = prompt("Add more Items? ");
while(addMoreItems.toLowerCase() == "yes"){
	itemName = prompt("What did the customer buy? ");
	itemQuantity = prompt("How many pieces? ");
	itemPrice = prompt("How much per unit? ");
	itemTotal = itemPrice * itemQuantity;
	userCart.push(getProductDetails(itemName, itemQuantity, itemPrice, itemTotal));
	addMoreItems = prompt("Add more Items? ");
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















































