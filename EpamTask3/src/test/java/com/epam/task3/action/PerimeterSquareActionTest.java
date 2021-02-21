package com.epam.task3.action;

import com.epam.task3.entity.Point2D;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.task3.entity.Oval;
import com.epam.task3.entity.SemiAxis;
import com.epam.task3.exception.OvalException;

public class PerimeterSquareActionTest {
	PerimeterSquareAction action;
	SemiAxis semiAxisA;
	SemiAxis semiAxisB;
	Oval oval;

	@BeforeClass
	public void setUp() {
		action = new PerimeterSquareAction();
		semiAxisA = new SemiAxis(new Point2D(2, 1), new Point2D(2, 7));
		semiAxisB = new SemiAxis(new Point2D(2, 5), new Point2D(4, 5));
		oval = new Oval(semiAxisA, semiAxisB);
	}

	@Test
	public void findPerimeter() throws OvalException {
		double expected = 28.099;
		double actual = action.findPerimeter(oval);
		Assert.assertEquals(actual, expected, 0.1);
	}

	@Test(expectedExceptions = OvalException.class)
	public void findPerimeterExceptionTest() throws OvalException {
		action.findPerimeter(null);
	}

	@Test
	public void findSquare() throws OvalException {
		double expected = 37.699;
		double actual = action.findSquare(oval);
		Assert.assertEquals(actual, expected, 0.1);
	}

	@Test(expectedExceptions = OvalException.class)
	public void findSquareExceptionTest() throws OvalException {
		action.findSquare(null);
	}

	@AfterClass
	public void tierDown() {
		action = null;
	}
}