package com.epam.task3.validator;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.epam.task3.entity.Point2D;

public class PointDataValidatorTest {
	@Test
    public void isPointsFromEllipsePositiveTest() {
        Point2D point = new Point2D(1,1);
        boolean result = PointDataValidator.validatePoint(point);
        assertTrue(result);
    }

    @Test
    public void isPointsFromEllipseNegativeTest() {
    	Point2D point = new Point2D(-2001,2);
        boolean result = PointDataValidator.validatePoint(point);
        assertFalse(result);
    }
}
