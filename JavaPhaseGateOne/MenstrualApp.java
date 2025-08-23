public class MenstrualApp {
public static void main(String[] args){

int numberOfMonth = 1;
int numberOfDays = getDaysIn(numberOfMonth);
String startDay = "Mon";
System.out.println(displayCalendar(numberOfDays, startDay));
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




public static String getDaysOfWeek(){
	String[] daysOfTheWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};	
	return String.join("\t", daysOfTheWeek);
}

public static int getStartDayIndex(String startDay){
	String[] daysOfTheWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};	
	int startIndex = 0;
	for(int number = 1; number < daysOfTheWeek.length ; number++){
		if(startDay.equals(daysOfTheWeek[number])) 
		startIndex = number;
	}
	return startIndex;
}


public static String displayCalendar(int numberOfDays, String startDay){
	System.out.println(getDaysOfWeek());
	int startIndex = getStartDayIndex(startDay);
	String calendar = "";
	for (int index = 0; index < startIndex; index++) {
		calendar += "\t";     	
       }

	for(int number = 1; number <= numberOfDays; number++){
		calendar += String.format("%d \t", number);
		if((number + startIndex) % 7 == 0) {
			calendar += "\n";
		}
			
	}

	return calendar;

}




    













}