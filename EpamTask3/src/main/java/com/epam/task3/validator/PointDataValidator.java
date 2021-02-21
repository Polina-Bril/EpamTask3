package com.epam.task3.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.task3.entity.Point2D;

public class PointDataValidator {
	public static Logger logger = LogManager.getLogger();
	private static final int MAX_COORDINATE = 1000;
	private static final int MIN_COORDINATE = -1000;

	public static boolean validatePoint(Point2D point) {
		boolean result = validateValue(point.getX()) && validateValue(point.getY());
		return result;
	}
	private static boolean validateValue(double value) {
		boolean result = value < MAX_COORDINATE && value > MIN_COORDINATE;
		logger.log(Level.INFO, "Data was checked. Result: " + result);
		return result;
	}
}