import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class MenstrualAppTest{
@Test	
public void testgetDaysInFunction(){
	int month = 5;
		
	MenstrualApp menstrualApp = new MenstrualApp();
	int result = menstrualApp.getDaysIn(month);
	
	assertEquals(result, 31);
}

@Test	
public void testgetFlowDateFunctionWhenNextFlowDayIsGreaterThanNumberOfDaysInMonth(){
	int month = 8;
	int startDayOfLastPeriod = 24;
	int lengthOfLastCycle = 25;
		
	MenstrualApp menstrualApp = new MenstrualApp();
	String result = menstrualApp.getFlowDate(month, startDayOfLastPeriod, lengthOfLastCycle);
	
	assertEquals (result, "18/9");

}

@Test	
public void testGetOvulationDayFunction(){
	int nextFlowDay = 18;
	int nextFlowMonth = 9;
	int lengthOfLastCycle = 25;
		
	MenstrualApp menstrualApp = new MenstrualApp();
	int result = menstrualApp.getOvulationDay(nextFlowDay, nextFlowMonth, lengthOfLastCycle);
	
	assertEquals (result, 6);

}

@Test	
public void testGetOvulationDayFunctionWhenOvulationIsGreaterThanZero(){
	int nextFlowDay = 18;
	int nextFlowMonth = 9;
	int lengthOfLastCycle = 25;
		
	MenstrualApp menstrualApp = new MenstrualApp();
	int result = menstrualApp.getOvulationDay(nextFlowDay, nextFlowMonth, lengthOfLastCycle);
	
	assertEquals (result, 6);

}


} 