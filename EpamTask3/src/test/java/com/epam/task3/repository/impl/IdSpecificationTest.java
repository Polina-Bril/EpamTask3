package com.epam.task3.repository.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.testng.annotations.Test;

import com.epam.task3.entity.Oval;
import com.epam.task3.entity.Point2D;
import com.epam.task3.entity.SemiAxis;

public class IdSpecificationTest {
	@Test
	public void IdSpecificationPositiveTest() {
		Oval oval = new Oval(
                new SemiAxis(new Point2D(1, 1), new Point2D(2,2)),
                new SemiAxis(new Point2D(2, 2), new Point2D(3,2))
        );
		boolean result = new IdSpecification(1).specify(oval);
		assertTrue(result);
	}
	@Test
	public void IdSpecificationNegativeTest() {
		Oval oval = new Oval(
                new SemiAxis(new Point2D(1, 1), new Point2D(2,2)),
                new SemiAxis(new Point2D(2, 2), new Point2D(3,2))
        );
		boolean result = new IdSpecification(-1).specify(oval);
		assertFalse(result);
	}
}