function displayQuestion(question) {
	return `A. ${question.A}\nB. ${question.B}\n`;
}

function getUserResponses(userResponse, optionsSelected){
	optionsSelected.push(userResponse);
	return optionsSelected;
}		

function getOptionsOf(userResponse, question, trait) {
	if (userResponse.toLowerCase() == "a") {
		trait.push(`A. ${question.A}`);
	} else if (userResponse.toLowerCase() == "b") {
		trait.push(`B. ${question.B}`);
  	}
}

function getTheCountOf(optionsSelected){
	let optionACount = 0;
	let optionBCount = 0;
	for(let index = 0; index < optionsSelected.length; index++){
		if(optionsSelected[index] == 'a') optionACount++;
		else optionBCount++;
  	}
	return [optionACount, optionBCount];
}

function getThePersonality(optionCountForTrait1, optionCountForTrait2, optionCountForTrait3, optionCountForTrait4){
	let personality = "";
	let count = getTheCountOf(optionCountForTrait1);
	personality += count[0] > count[1] ? "E" : "I";
	count = getTheCountOf(optionCountForTrait2);
	personality += count[0] > count[1] ? "S" : "N";
	count = getTheCountOf(optionCountForTrait3);
	personality += count[0] > count[1] ? "T" : "F";
	count = getTheCountOf(optionCountForTrait4);
	personality += count[0] > count[1] ? "J" : "P";
	return personality;
}


const prompt = require('prompt-sync')();


let questionBank = [
	{A: "expend energy, enjoy groups", B: "conserve energy, enjoy one-on-one"},
	{A: "interpret literally", B: "look for meaning and possibilities"},
	{A: "logical, thinking, questioning", B: "flexible, adaptable"},
	{A: "organized, orderly", B: "flexible, adaptable"},
	{A: "more outgoing, think out loud", B: "more reserved, think to yourself"},
 	{A: "practical, realistic, experiential", B: "imaginative, innovative, theoretical"},
	{A: "candid, straight forward, frank", B: "tactful, kind, encouraging"},
	{A: "plan, schedule", B: "unplanned, spontaneous"},
	{A: "seek many tasks, public activities, interaction with others", B: "seek private, solitary activities with quiet to concentrate"},
	{A: "standard, usual, conventional", B: "different, novel, unique"},
 	{A: "firm, tend to criticize, hold the line", B: "gentle, tend to appreciate, conciliate"},
 	{A: "regulated, structured", B: "easy-going, live and let live"},
	{A: "external, comunicative, express yourself", B: "internal, reticent, keep to yourself"},
	{A: "focus on here-and-now", B: "look to the future, global perspective, big picture"},   
	{A: "tough-minded, just", B: "tender-hearted, merciful"},
	{A: "preparartion, plan ahead", B: "go with the flow, adapt as you go"},
	{A: "active, initiate", B: "reflective, deliberate"},
	{A: "facts, things, what is", B: "ideas, dreams, what could be, philosophical"},
	{A: "matter of fact, issue-oriented", B: "latitude, freedom"}, 
	{A: "control, govern", B: "latitude, freedom"}
];

let userName = prompt("What is your name: ");
let EvsI = [];
let SvsN = [];
let TvsF = [];
let JvsP = [];

let optionCountForEvsI = [];
let optionCountForSvsN = [];
let optionCountForTvsF = [];
let optionCountForJvsP = [];

let optionsSelectedForEvsI = [];
let optionsSelectedForSvsN = [];
let optionsSelectedForTvsF = [];
let optionsSelectedForJvsP = [];


for (let number = 0; number < questionBank.length; number++) {
	console.log(displayQuestion(questionBank[number]));
	let userResponse = prompt("Select (A or B): ");
	while(userResponse.toLowerCase() != "a" && userResponse.toLowerCase() != "b") {
		console.log(`
		Expected A or B as Response
		I know this is an error, Please retry again
		`);
		console.log(displayQuestion(questionBank[number]));
		userResponse = prompt("Select (A or B): ");
		
	}
// Process the user's response here
	if (number == 0 || number == 4 || number == 8 || number == 12 || number == 16) {
		optionsSelectedForEvsI = getUserResponses(userResponse, optionsSelectedForEvsI);
		getOptionsOf(userResponse, questionBank[number], EvsI);
	}else if (number == 1 || number == 5 || number == 9 || number == 13 || number == 17) {
		optionsSelectedForSvsN = getUserResponses(userResponse, optionsSelectedForSvsN);
		getOptionsOf(userResponse, questionBank[number], SvsN);
	} else if (number == 2 || number == 6 || number == 10 || number == 14 || number == 18) {
		optionsSelectedForTvsF = getUserResponses(userResponse, optionsSelectedForTvsF);
		getOptionsOf(userResponse, questionBank[number], TvsF);
	} else if (number == 3 || number == 7 || number == 11 || number == 15 || number == 19) {
		optionsSelectedForJvsP = getUserResponses(userResponse, optionsSelectedForJvsP);
		getOptionsOf(userResponse, questionBank[number], JvsP);
	}
 }
optionCountForEvsI = getTheCountOf(optionsSelectedForEvsI);
optionCountForSvsN = getTheCountOf(optionsSelectedForSvsN);
optionCountForTvsF = getTheCountOf(optionsSelectedForTvsF);
optionCountForJvsP = getTheCountOf(optionsSelectedForJvsP);
let personality = (getThePersonality(optionCountForEvsI, optionCountForSvsN, optionCountForTvsF, optionCountForJvsP));


console.log(userName + " You selected");

console.log(EvsI.join("\n"));
console.log("Number of A selected: " + optionCountForEvsI[0]);
console.log("Number of B selected: " + optionCountForEvsI[1]);

console.log(SvsN.join("\n"));
console.log("Number of A selected: " + optionCountForSvsN[0]);
console.log("Number of B selected: " + optionCountForSvsN[1]);

console.log(TvsF.join("\n"));
console.log("Number of A selected: " + optionCountForTvsF[0]);
console.log("Number of B selected: " + optionCountForTvsF[1]);

console.log(JvsP.join("\n"));
console.log("Number of A selected: " + optionCountForJvsP[0]);
console.log("Number of B selected: " + optionCountForJvsP[1]);

console.log(personality);






