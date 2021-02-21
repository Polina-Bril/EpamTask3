package com.epam.task3.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.task3.entity.Oval;
import com.epam.task3.entity.Point2D;
import com.epam.task3.entity.SemiAxis;

public class OvalValidatorTest {
	SemiAxis semiAxisA;
	SemiAxis semiAxisB;
	Oval oval;

	@Test
	public void semiAxisesFormOvalTest01() {
		semiAxisA = new SemiAxis(new Point2D(2, 1), new Point2D(2, 7));
		semiAxisB = new SemiAxis(new Point2D(2, 5), new Point2D(4, 5));
		Assert.assertFalse(OvalValidator.semiAxisesFormOval(semiAxisA, semiAxisB));
	}
	@Test
	public void semiAxisesFormOvalTest02() {
		semiAxisA = new SemiAxis(new Point2D(2, 1), new Point2D(2, 7));
		semiAxisB = null;
		Assert.assertFalse(OvalValidator.semiAxisesFormOval(semiAxisA, semiAxisB));
	}
	@Test
	public void semiAxisesFormOvalTest03() {
		semiAxisA = new SemiAxis(new Point2D(2, 1), new Point2D(2, 7));
		semiAxisB = new SemiAxis(new Point2D(2, 5), new Point2D(4, 5));
		Assert.assertTrue(OvalValidator.semiAxisesFormOval(semiAxisA, semiAxisB));
	}
}
