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
	int nextFlowDay = 18;
	int nextFlowMonth = 9;
	int lengthOfLastCycle = 25;
		
	MenstrualApp menstrualApp = new MenstrualApp();
	String result = menstrualApp.getOvulationDay(nextFlowDay, nextFlowMonth, lengthOfLastCycle);
	
	assertEquals (result, "6/9");

}

@Test	
public void testGetOvulationDayFunctionWhenOvulationDayIsLessThanZero(){
	int nextFlowDay = 5;
	int nextFlowMonth = 9;
	int lengthOfLastCycle = 28;
		
	MenstrualApp menstrualApp = new MenstrualApp();
	String result = menstrualApp.getOvulationDay(nextFlowDay, nextFlowMonth, lengthOfLastCycle);
	
	assertEquals (result, "22/8");

}

@Test	
public void testGetLutealPhaseFunction1(){
	int nextFlowDay = 5;
	int nextFlowMonth = 9;
	int ovulationDay = 22;
	int ovulationMonth = 8;
		
	MenstrualApp menstrualApp = new MenstrualApp();
	int result = menstrualApp.getLutealPhase(nextFlowDay, nextFlowMonth, ovulationDay, ovulationMonth);
	
	assertEquals (result, 14);

}

@Test	
public void testGetLutealPhaseFunction2(){
	int nextFlowDay = 18;
	int nextFlowMonth = 9;
	int ovulationDay = 4;
	int ovulationMonth = 9;
		
	MenstrualApp menstrualApp = new MenstrualApp();
	int result = menstrualApp.getLutealPhase(nextFlowDay, nextFlowMonth, ovulationDay, ovulationMonth);
	
	assertEquals (result, 14);

}
} 