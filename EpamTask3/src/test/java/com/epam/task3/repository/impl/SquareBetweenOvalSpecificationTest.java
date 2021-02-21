package com.epam.task3.repository.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.testng.annotations.Test;

import com.epam.task3.entity.Oval;
import com.epam.task3.entity.Point2D;
import com.epam.task3.entity.SemiAxis;

public class SquareBetweenOvalSpecificationTest {
	@Test
	public void SquareBetweenEllipseSpecificationPositiveTest() {
		Oval oval = new Oval(
                new SemiAxis(new Point2D(2, 1), new Point2D(2,7)),
                new SemiAxis(new Point2D(2, 5), new Point2D(4,5))
        );
		boolean result = new SquareBetweenOvalSpecification(37, 38).specify(oval);
		assertTrue(result);
	}
	@Test
	public void SquareBetweenEllipseSpecificationNegativeTest() {
		Oval oval = new Oval(
                new SemiAxis(new Point2D(2, 1), new Point2D(2,7)),
                new SemiAxis(new Point2D(2, 5), new Point2D(4,5))
        );
		boolean result = new SquareBetweenOvalSpecification(10, 12).specify(oval);
		assertFalse(result);
	}
}