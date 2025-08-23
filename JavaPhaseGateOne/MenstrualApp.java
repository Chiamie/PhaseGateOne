public class MenstrualApp {
public static void main(String[] args){

System.out.println(getFlowDate(8, 21, 28));
System.out.println(getOvulationDay(8, 21, 28));
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

public static int getFlowDate(int numberOfMonth, int startDayOfLastPeriod, int lengthOfLastCycle){
	int numberOfDaysInMonth = getDaysIn(numberOfMonth);
	int nextFlowDay = lengthOfLastCycle - (numberOfDaysInMonth - startDayOfLastPeriod);
	if (nextFlowDay < 0){
		nextFlowDay =  numberOfDaysInMonth + nextFlowDay;
		return nextFlowDay;
	}else{
		return nextFlowDay;
	}
}


public static int getOvulationDay(int numberOfMonth, int startDayOfLastPeriod, int lengthOfLastCycle){
	int ovulationDay = getFlowDate(numberOfMonth, startDayOfLastPeriod, lengthOfLastCycle) - (lengthOfLastCycle / 2);
	return ovulationDay;
	
}






    













}