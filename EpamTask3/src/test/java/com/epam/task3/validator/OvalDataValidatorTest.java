package com.epam.task3.validator;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class OvalDataValidatorTest {

	@Test
	public void isEllipseDataPositiveTest() {
		boolean result = OvalDataValidator.ovalDataValidator("2 10 -10 -2 -8 -15 6 2.8");
		assertTrue(result);
	}
	@Test
	public void isEllipseDataNegativeTest() {
		boolean result = OvalDataValidator.ovalDataValidator("2d 10 -10 -2 ");
		assertFalse(result);
	}
}