package com.epam.task3.repository.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.testng.annotations.Test;

import com.epam.task3.entity.Oval;
import com.epam.task3.entity.Point2D;
import com.epam.task3.entity.SemiAxis;

public class PerimeterBetweenOvalSpecificationTest {
	@Test
    public void PerimeterBetweenOvalSpecificationPositiveTest() {
		Oval oval = new Oval(
                new SemiAxis(new Point2D(2, 1), new Point2D(2,7)),
                new SemiAxis(new Point2D(2, 5), new Point2D(4,5))
        );
		boolean result = new PerimeterBetweenOvalSpecification(20,30).specify(oval);
        assertTrue(result);
    }

    @Test
    public void PerimeterBetweenOvalSpecificationNegativeTest() {
    	Oval oval = new Oval(
                new SemiAxis(new Point2D(2, 1), new Point2D(2,7)),
                new SemiAxis(new Point2D(2, 5), new Point2D(4,5))
        );
    	boolean result = new PerimeterBetweenOvalSpecification(50,51).specify(oval);
        assertFalse(result);
    }
}
