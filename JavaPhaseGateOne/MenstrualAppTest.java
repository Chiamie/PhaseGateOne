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
public void testGetOvulationDayFunctionWhenOvulationDayIsGreaterThanZero(){
	String getFlowDate = "18/9";
	int lengthOfLastCycle = 25;
		
	MenstrualApp menstrualApp = new MenstrualApp();
	String result = menstrualApp.getOvulationDay(getFlowDate, lengthOfLastCycle);
	
	assertEquals (result, "6/9");

}

@Test	
public void testGetOvulationDayFunctionWhenOvulationDayIsLessThanZero(){
	String getFlowDate = "5/9";
	int lengthOfLastCycle = 28;
		
	MenstrualApp menstrualApp = new MenstrualApp();
	String result = menstrualApp.getOvulationDay(getFlowDate, lengthOfLastCycle);
	
	assertEquals (result, "22/8");

}
@Test	
public void testGetLutealPhaseFunction1(){
	String getFlowDate = "5/9";
	String getOvulationDay = "22/8";
			
	MenstrualApp menstrualApp = new MenstrualApp();
	int result = menstrualApp.getLutealPhase(getFlowDate, getOvulationDay);
	
	assertEquals (result, 14);

}

@Test	
public void testGetLutealPhaseFunction2(){
	String getFlowDate = "18/9";
	String getOvulationDay = "4/9";

			
	MenstrualApp menstrualApp = new MenstrualApp();
	int result = menstrualApp.getLutealPhase(getFlowDate, getOvulationDay);
	
	assertEquals (result, 14);

}

@Test	
public void testGetFertilePeriodFunction2(){
		
	String ovulationDate = "4/9";
			
	MenstrualApp menstrualApp = new MenstrualApp();
	String result = menstrualApp.getFertilePeriod(ovulationDate);
	
	assertEquals (result, "Fertile period: 1 to 7 of month 9");

} 

}