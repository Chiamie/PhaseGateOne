const prompt = require('prompt-sync')();
 

let menstrualAppOptions = true;
while(menstrualAppOptions){


let menu = `
			1. Check next period date
			2. Check next ovulation date
			3. Check safe period
			4. Check fertile period
			0. Exit
		`;
console.log(menu);
let optionSelect = prompt("Choose an option: ");
if (optionSelect == 0) {
	menstrualAppOptions = false;
	continue;
}

let monthNumber = parseInt(prompt("Enter the month number: "));
let flowStartDate = parseInt(prompt("Enter the day the last flow started: "));
let lengthOfFlow = parseInt(prompt("Enter your average flow cycle: "));

switch(optionSelect){
	case '1':
		console.log(getFlowDate(monthNumber, flowStartDate, lengthOfFlow));
		break;
	
	case '2':
		let flowDate = getFlowDate(monthNumber, flowStartDate, lengthOfFlow);
		console.log(getOvulationDay(flowDate, lengthOfFlow));
		break;
	
	case '3':
		let flowDate1 = getFlowDate(monthNumber, flowStartDate, lengthOfFlow);
		let ovulationDate = getOvulationDay(flowDate1, lengthOfFlow);
		console.log(getLutealPhase(flowDate1, ovulationDate));
		break;	
	case '4':
		flowDate = getFlowDate(monthNumber, flowStartDate, lengthOfFlow);
		ovulationDate = getOvulationDay(flowDate, lengthOfFlow);
		console.log(getFertilePeriod(ovulationDate));
		break;
	
}
}



function getDaysIn(numberOfMonth){
	let numberOfDaysPerMonth = 0;
	if (numberOfMonth == 4 || numberOfMonth == 6 || numberOfMonth == 9 || numberOfMonth == 11)
		numberOfDaysPerMonth = 30;
	else if (numberOfMonth == 1 || numberOfMonth == 3 || numberOfMonth == 5 || numberOfMonth == 7 || numberOfMonth == 8 || numberOfMonth == 10 || numberOfMonth == 11)
		numberOfDaysPerMonth = 31;
	else
		numberOfDaysPerMonth = 28;
	return numberOfDaysPerMonth;
}

function  getFlowDate(numberOfMonth, startDayOfLastPeriod, lengthOfLastCycle){
	let numberOfDaysInMonth = getDaysIn(numberOfMonth);
	let nextFlowDay = (startDayOfLastPeriod + lengthOfLastCycle);
	console.log(nextFlowDay);
	let nextFlowMonth = numberOfMonth;

	if (nextFlowDay > numberOfDaysInMonth) {
		nextFlowDay = nextFlowDay - numberOfDaysInMonth;
		nextFlowMonth++;
		if (nextFlowMonth > 12) {
			nextFlowMonth = 1;													
            }
        }

        return nextFlowDay + "/" + nextFlowMonth;
    }

function getOvulationDay(getFlowDate, lengthOfLastCycle) {
	let flowDateInArray = getFlowDate.split("/");
	let nextFlowDay = flowDateInArray[0];
	let nextFlowMonth = flowDateInArray[1];

	let ovulationDay = nextFlowDay - Math.round((lengthOfLastCycle / 2));
	let ovulationMonth = nextFlowMonth;

	if (ovulationDay <= 0) {
		ovulationMonth--;
		let daysInPreviousMonth = getDaysIn(ovulationMonth);
		ovulationDay += daysInPreviousMonth;
        }
	return ovulationDay + "/" + ovulationMonth;
}

function getLutealPhase(getFlowDate, getOvulationDay) {
	let flowDateInArray = getFlowDate.split("/");
	let nextFlowDay = flowDateInArray[0];
	let nextFlowMonth = flowDateInArray[1];

	let ovulationDateInArray = getOvulationDay.split("/");
	let ovulationDay = ovulationDateInArray[0];
	let ovulationMonth = ovulationDateInArray[1];

	let lutealPhase;
	if (nextFlowMonth == ovulationMonth) {
		lutealPhase = nextFlowDay - ovulationDay;
		return lutealPhase;
	} else {
		let daysInOvulationMonth = getDaysIn(ovulationMonth);
		lutealPhase = daysInOvulationMonth - ovulationDay + nextFlowDay;
		return lutealPhase;
        }
}
function getFertilePeriod(ovulationDate) {
	let ovulationDateInArray = ovulationDate.split("/");
	let ovulationDay = ovulationDateInArray[0];
	let fertileWindowStart = ovulationDay - 3;
	let fertileWindowEnd = ovulationDay + 3;
	let ovulationMonth = ovulationDateInArray[1];
	
	if (fertileWindowStart <= 0) {
		ovulationMonth--;
		if (ovulationMonth < 1) {
			ovulationMonth = 12;
		}
		fertileWindowStart += getDaysIn(ovulationMonth);
	}
	if (fertileWindowEnd > getDaysIn(ovulationMonth)) {
		fertileWindowEnd -= getDaysIn(ovulationMonth);
		ovulationMonth++;
		if (ovulationMonth > 12) {
			ovulationMonth = 1;
		}
	}
	return "Fertile period: " + fertileWindowStart + " to " + fertileWindowEnd + " of month " + ovulationMonth;
}




