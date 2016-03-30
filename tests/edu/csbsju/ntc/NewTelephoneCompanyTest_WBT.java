package edu.csbsju.ntc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NewTelephoneCompanyTest_WBT {

	private NewTelephoneCompany ntc;
	
	@Before
	public void testSetUp() throws Exception{
		ntc = new NewTelephoneCompany();
	}

	@Test
	public void testTestGetHours() {
		int expResult = 0;
        int result = ntc.getStartTime();
        assertEquals("Hours is " + expResult,expResult, result); ;
	}


	@Test
	public void testTestSetHours() {
		ntc.setStartTime(1100);
		assertEquals("The start time is 1100", 1100, ntc.getStartTime());
	}

	@Test
	public void testTestGetDuration() {
		assertEquals("Length is" + 0,0, ntc.getDuration());
	}

	@Test
	public void testTestSetDuration() {
		ntc.setDuration(10);
		assertEquals("The duration is " + ntc.getDuration(), 10, ntc.getDuration());
	}

	@Test (expected = UnsupportedOperationException.class)
	public void testTestComputeCharge_InvalidStartTime_Case1() {
		ntc.setStartTime(-5);
		ntc.setDuration(10);
		ntc.computeCharge();
	}

	@Test (expected = UnsupportedOperationException.class)
	public void testTestComputeCharge_InvalidStartTime_Case2() {
		ntc.setStartTime(-1);
		ntc.setDuration(10);
		ntc.computeCharge();
	}

	@Test (expected = UnsupportedOperationException.class)
	public void testTestComputeCharge_InvalidStartTime_Case3() {
		ntc.setStartTime(2544);
		ntc.setDuration(10);
		ntc.computeCharge();
	}

	@Test (expected = UnsupportedOperationException.class)
	public void testTestComputeCharge_InvalidStartTime_Case4() {
		ntc.setStartTime(2400);
		ntc.setDuration(10);
		ntc.computeCharge();
	}

	@Test (expected = UnsupportedOperationException.class)
	public void testTestComputeCharge_InvalidStartTime_Case5() {
		ntc.setStartTime(2401);
		ntc.setDuration(10);
		ntc.computeCharge();
	}

	@Test (expected = UnsupportedOperationException.class)
	public void testTestComputeCharge_InvalidStartTime_Case6() {
		ntc.setStartTime(1578);
		ntc.setDuration(10);
		ntc.computeCharge();
	}

	@Test (expected = UnsupportedOperationException.class)
	public void testTestComputeCharge_InvalidStartTime_Case7() {
		ntc.setStartTime(1160);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test (expected = UnsupportedOperationException.class)
	public void testTestComputeCharge_InvalidStartTime_Case8(){
		ntc.setStartTime(1161);
		ntc.setDuration(10);
		ntc.computeCharge();
	}

	@Test
	public void testTestComputeCharge_StartTimeDiscount() {
		ntc.setStartTime(0);
		ntc.setDuration(60);
		assertEquals("Charge is" + ntc.computeCharge(), (long) 1248.00, (long)ntc.computeCharge());
		ntc.setStartTime(400);
		ntc.setDuration(59);
		assertEquals("Charge is" + ntc.computeCharge(), (long) 1227.20, (long)ntc.computeCharge());
		ntc.setStartTime(759);
		ntc.setDuration(1);
		assertEquals("Charge is" + ntc.computeCharge(), (long) 20.80, (long)ntc.computeCharge());
		ntc.setStartTime(1800);
		ntc.setDuration(10);
		assertEquals("Charge is" + ntc.computeCharge(), (long) 208.80, (long)ntc.computeCharge());
		ntc.setStartTime(1801);
		ntc.setDuration(10);
		assertEquals("Charge is" + ntc.computeCharge(), (long) 208.80, (long)ntc.computeCharge());
		ntc.setStartTime(2359);
		ntc.setDuration(10);
		assertEquals("Charge is" + ntc.computeCharge(), (long) 208.80, (long)ntc.computeCharge());
	}

	@Test (expected = UnsupportedOperationException.class)
	public void testTestComputeCharge_InvalidDuration_Case1() {
		ntc.setDuration(-5);
		ntc.setStartTime(1800);
		ntc.computeCharge();
	}

	@Test (expected = UnsupportedOperationException.class)
	public void testTestComputeCharge_InvalidDuration_Case2() {
		ntc.setDuration(-1);
		ntc.setStartTime(1801);
		ntc.computeCharge();
	}

	@Test (expected = UnsupportedOperationException.class)
	public void testTestComputeCharge_InvalidDuration_Case3() {
		ntc.setDuration(1801);
		ntc.setStartTime(-1);
		ntc.computeCharge();
	}

	@Test
	public void testTestComputeCharge_BothDiscounts() {
		ntc.setStartTime(500);
		ntc.setDuration(100);
		assertEquals("Charge is" + ntc.computeCharge(), (long) 1768.00, (long)ntc.computeCharge());
		ntc.setStartTime(759);
		ntc.setDuration(61);
		assertEquals("Charge is" + ntc.computeCharge(), (long) 1078.48, (long)ntc.computeCharge());
		ntc.setStartTime(1959);
		ntc.setDuration(61);
		assertEquals("Charge is" + ntc.computeCharge(), (long) 1078.48, (long)ntc.computeCharge());
		ntc.setStartTime(2359);
		ntc.setDuration(65);
		assertEquals("Charge is" + ntc.computeCharge(), (long) 1149.20, (long)ntc.computeCharge());
	}

	@Test
	public void testTestComputeCharge_NoDiscounts() {
		ntc.setStartTime(1000);
		ntc.setDuration(40);
		assertEquals("Charge is" + ntc.computeCharge(), (long) 1664.00, (long)ntc.computeCharge());
		ntc.setStartTime(800);
		ntc.setDuration(1);
		assertEquals("Charge is" + ntc.computeCharge(), (long) 41.60, (long)ntc.computeCharge());
		ntc.setStartTime(801);
		ntc.setDuration(59);
		assertEquals("Charge is" + ntc.computeCharge(), (long) 2454.40, (long)ntc.computeCharge());
		ntc.setStartTime(1759);
		ntc.setDuration(60);
		assertEquals("Charge is" + ntc.computeCharge(), (long) 2496.00, (long)ntc.computeCharge());
	}

	@Test
	public void testTestComputeCharge_DurationDiscount() {
		ntc.setStartTime(800);
		ntc.setDuration(65);
		assertEquals("Charge is" + ntc.computeCharge(), (long) 2298.40, (long)ntc.computeCharge());
		ntc.setStartTime(900);
		ntc.setDuration(61);
		assertEquals("Charge is" + ntc.computeCharge(), (long) 2156.96, (long)ntc.computeCharge());
	}

}
