public class MenstrualApp {





public static int getDaysIn(int numberOfMonth){
	int numberOfDaysPerMonth = 0;
	if (numberOfMonth == 4 || numberOfMonth == 6 || numberOfMonth == 9 || numberOfMonth == 11)
		numberOfDaysPerMonth = 30;
	else if (numberOfMonth == 1 || numberOfMonth == 3 || numberOfMonth == 5 || numberOfMonth == 7 || numberOfMonth == 8 || numberOfMonth == 10 || numberOfMonth == 11)
		numberOfDaysPerMonth = 31;
	else
		numberOfDaysPerMonth = 28 || numberOfDaysPerMonth = 29;
	return numberOfDaysPerMonth
}




public static String getDaysOfWeek(){
	String[] daysOfTheWeek = {'Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'};
	for(int index = 0; index < daysOfTheWeek.length; index++){
		return String.join(" ", daysOfTheWeek);
	}
}

public static int displayCalendar(int numberOfDays,  ){
	getDaysOfWeek();
	


}























}