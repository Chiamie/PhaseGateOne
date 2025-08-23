import java.util.Scanner;

public class MenstrualApp {
public static void main(String[] args){
Scanner input = new Scanner(System.in);



String menu = """
			1. Check next period date
			2. Check next ovulation date
			3. Check safe period
			4. Check fertile period
		""";
System.out.println(menu);
System.out.println("Choose an option: ");
int option = input.nextInt();


System.out.println("Enter the month number: ");
int month = input.nextInt();
System.out.println("Enter the day the last flow started: ");
int flowStartDate = input.nextInt();
System.out.println("Enter your average flow cycle: ");
int lengthOfFlow = input.nextInt();

switch(option){
	case 1:
		System.out.println(getFlowDate(month, flowStartDate, lengthOfFlow));
		break;
	
	case 2:
		String flowDate = getFlowDate(month, flowStartDate, lengthOfFlow);
		System.out.println(getOvulationDay(flowDate, lengthOfFlow));
		break;
	
	case 3:
		flowDate = getFlowDate(month, flowStartDate, lengthOfFlow);
		String ovulationDate = getOvulationDay(flowDate, lengthOfFlow);
		System.out.println(getLutealPhase(flowDate, ovulationDate));
		break;	
	case 4:
		flowDate = getFlowDate(month, flowStartDate, lengthOfFlow);
		ovulationDate = getOvulationDay(flowDate, lengthOfFlow);
		System.out.println(getFertilePeriod(ovulationDate));
		break;
}
}



public static int getDaysIn(int numberOfMonth){
	int numberOfDaysPerMonth = 0;
	if (numberOfMonth == 4 || numberOfMonth == 6 || numberOfMonth == 9 || numberOfMonth == 11)
		numberOfDaysPerMonth = 30;
	else if (numberOfMonth == 1 || numberOfMonth == 3 || numberOfMonth == 5 || numberOfMonth == 7 || numberOfMonth == 8 || numberOfMonth == 10 || numberOfMonth == 11)
		numberOfDaysPerMonth = 31;
	else
		numberOfDaysPerMonth = 28;
	return numberOfDaysPerMonth;
}

public static String getFlowDate(int numberOfMonth, int startDayOfLastPeriod, int lengthOfLastCycle){
	int numberOfDaysInMonth = getDaysIn(numberOfMonth);
	int nextFlowDay = startDayOfLastPeriod + lengthOfLastCycle;
	int nextFlowMonth = numberOfMonth;

	if (nextFlowDay > numberOfDaysInMonth) {
		nextFlowDay -= numberOfDaysInMonth;
		nextFlowMonth++;
		if (nextFlowMonth > 12) {
			nextFlowMonth = 1;													
            }
        }

        return nextFlowDay + "/" + nextFlowMonth;
    }

public static String getOvulationDay(String getFlowDate, int lengthOfLastCycle) {
	String[] flowDateInArray = getFlowDate.split("/");
	int nextFlowDay = Integer.parseInt(flowDateInArray[0]);
	int nextFlowMonth = Integer.parseInt(flowDateInArray[1]);

	int ovulationDay = nextFlowDay - (lengthOfLastCycle / 2);
	int ovulationMonth = nextFlowMonth;

	if (ovulationDay <= 0) {
		ovulationMonth--;
		int daysInPreviousMonth = getDaysIn(ovulationMonth);
		ovulationDay += daysInPreviousMonth;
        }
	return ovulationDay + "/" + ovulationMonth;
}

public static int getLutealPhase(String getFlowDate, String getOvulationDay) {
	String[] flowDateInArray = getFlowDate.split("/");
	int nextFlowDay = Integer.parseInt(flowDateInArray[0]);
	int nextFlowMonth = Integer.parseInt(flowDateInArray[1]);

	String[] ovulationDateInArray = getOvulationDay.split("/");
	int ovulationDay = Integer.parseInt(ovulationDateInArray[0]);
	int ovulationMonth = Integer.parseInt(ovulationDateInArray[1]);

	int lutealPhase;
	if (nextFlowMonth == ovulationMonth) {
		lutealPhase = nextFlowDay - ovulationDay;
		return lutealPhase;
	} else {
		int daysInOvulationMonth = getDaysIn(ovulationMonth);
		lutealPhase = daysInOvulationMonth - ovulationDay + nextFlowDay;
		return lutealPhase;
        }
}
public static String getFertilePeriod(String ovulationDate) {
	String[] ovulationDateInArray = ovulationDate.split("/");
	int ovulationDay = Integer.parseInt(ovulationDateInArray[0]);
	int fertileWindowStart = ovulationDay - 3;
	int fertileWindowEnd = ovulationDay + 3;
	int ovulationMonth = Integer.parseInt(ovulationDateInArray[1]);
	
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
}
