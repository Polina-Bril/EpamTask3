package com.epam.task3.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.task3.entity.Point2D;
import com.epam.task3.entity.SemiAxis;
import com.epam.task3.exception.OvalException;
import com.epam.task3.validator.OvalDataValidator;
import com.epam.task3.validator.OvalValidator;

public class OvalParser {
	public static Logger logger = LogManager.getLogger();
	public final static int OVAL_NUMBER_SEMIAXIS = 2;
	public final static int SEMIAXIS_NUMBER_POINTS = 2;
	public final static String DELIMETER = " ";

	public List<SemiAxis[]> parseList(List<String> ovalsData) throws OvalException {
		if (ovalsData == null || ovalsData.isEmpty()) {
			throw new OvalException("argument is null or empty");
		}
		List<SemiAxis[]> ovals = new ArrayList<>();
		SemiAxis[] semiAxises;
		for (String lineData : ovalsData) {
			try {
				semiAxises = parseLine(lineData);
				ovals.add(semiAxises);
			} catch (OvalException e) {
				logger.log(Level.ERROR, lineData + " is not suitable for creating an oval");
			}
		}
		if (ovals.isEmpty()) {
			throw new OvalException("no data to create a oval");
		}
		return ovals;
	}
	private SemiAxis[] parseLine(String lineData) throws OvalException {
		if (!OvalDataValidator.ovalDataValidator(lineData)) {
			throw new OvalException(lineData + " is not suitable for creating an oval");
		}
		String[] lineSemiAxis = lineData.split(DELIMETER);
		SemiAxis[] semiAxises = new SemiAxis[OVAL_NUMBER_SEMIAXIS];
		int numberSemiAxis = 0;
		int numberCoordinate = 0;
		while (numberSemiAxis < semiAxises.length) {
			Point2D[] points = new Point2D[SEMIAXIS_NUMBER_POINTS];
			int numberPoint = 0;
			while (numberPoint < points.length) {
				points[numberPoint] = new Point2D(Double.parseDouble(lineSemiAxis[numberCoordinate]),
						Double.parseDouble(lineSemiAxis[numberCoordinate + 1]));
				numberPoint++;
				numberCoordinate = numberCoordinate + 2;
			}
			semiAxises[numberSemiAxis] = new SemiAxis(points[0], points[1]);
		}
		if (!OvalValidator.semiAxisesFormOval(semiAxises[0], semiAxises[1])) {
			throw new OvalException(Arrays.toString(semiAxises) + " don't form oval");
		}
		return semiAxises;
	}
}