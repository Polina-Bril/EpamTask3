package com.epam.task3.action;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.task3.entity.Oval;
import com.epam.task3.exception.OvalException;

public class PerimeterSquareAction {
	public static Logger logger = LogManager.getLogger();

	public double findPerimeter(Oval o) throws OvalException {
		if (o == null) {
			throw new OvalException("Incompatible figure");
		}
		double squaredSemiAxisLengthA = Math.pow(o.getA().getLength(), 2);
		double squaredSemiAxisLengthB = Math.pow(o.getB().getLength(), 2);
		double perimeter = 2 * Math.PI * Math.sqrt((squaredSemiAxisLengthA + squaredSemiAxisLengthB) / 2);
		logger.log(Level.INFO, "perimeter of the oval is:" + perimeter);
		return perimeter;
	}
	public double findSquare(Oval o) throws OvalException {
		if (o == null) {
			throw new OvalException("Incompatible figure");
		}
		double square = Math.PI * o.getA().getLength() * o.getB().getLength();
		logger.log(Level.INFO, "square of the oval is:" + square);
		return square;
	}
}
