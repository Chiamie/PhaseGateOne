const prompt = require('prompt-sync')();



let cardNumber = prompt("Hello, Kindly Enter Card details to verify");

let cardType = checkTypeOfCard(cardNumber);
let cardLength = checkCardNumberLength(cardNumber);
let validityStatus = getValidityStatusOf(cardNumber);

if(cardType.startsWith("Invalid") && cardLength.startsWith("Invalid")) {
	console.log("Invalid Card Details");
} else {
	console.log("Credit Card Type: " + cardType);
	console.log("Credit Card Number: " + cardNumber);
	console.log("Credit Digit Length: " + cardLength);
	console.log("Credit Digit Validity Status: " + validityStatus);
}




function checkTypeOfCard(cardNumber){
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

function checkCardNumberLength(cardNumber){
	if ((cardNumber.length >= 13) && (cardNumber.length <= 16)){
		let cardLength = cardNumber.length + "";
		return cardLength;
	}else
		return "Invalid Card Number";
	
}

function getArrayFormOf(cardNumber){
	let cardNumberAsStringArray = cardNumber.split("");
	let cardNumberAsArray = cardNumberAsStringArray.map(Number);
	return cardNumberAsArray;
		
}


function doubleDigitsAtEvenIndexIn(cardNumberAsArray){
	let sum = 0;
	for(let index = cardNumberAsArray.length - 1; index >= 0; index--){
		let product = 1;
		if(index % 2 == 0){
			if (cardNumberAsArray[index] % 10 != 0){
				product = cardNumberAsArray[index] * 2;
				sum += (product % 10) + Math.trunc((product / 10));
			}else{
				sum += cardNumberAsArray[index] * 2;
			}
		}
	}
	return sum;
}
	
function getSumOfDigitAtOddIndexOf(cardNumberAsArray){
	let sum = 0;
	for(let index = cardNumberAsArray.length - 1; index >= 0; index--){
		if(index % 2 != 0){
			sum += cardNumberAsArray[index];
		}
	}
	return sum;

}

function checkDivisibilityBy10(total){
	if(total % 10 == 0){
		return "Valid";
	} else
		return "Invalid";
}

function getValidityStatusOf(cardNumber){

	let cardNumberAsArray = getArrayFormOf(cardNumber);
	let evenIndexSum = doubleDigitsAtEvenIndexIn(cardNumberAsArray);
	let oddIndexSum = getSumOfDigitAtOddIndexOf(cardNumberAsArray);
	let total = evenIndexSum + oddIndexSum;
	return checkDivisibilityBy10(total);

}







