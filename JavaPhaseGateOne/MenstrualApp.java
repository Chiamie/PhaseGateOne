public class MenstrualApp {
public static void main(String[] args){

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

public static int getOvulationDay(int nextFlowDay, int nextFlowMonth, int lengthOfLastCycle) {
	int ovulationDay = nextFlowDay - (lengthOfLastCycle / 2);
	int ovulationMonth = nextFlowMonth;

	if (ovulationDay <= 0) {
		ovulationMonth--;
		int daysInPreviousMonth = getDaysIn(ovulationMonth);
		ovulationDay += daysInPreviousMonth;
        }
	return ovulationDay;
}

public static int getLutealPhase(int nextFlowDay, int nextFlowMonth, int ovulationDay, int ovulationMonth) {
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










    













}