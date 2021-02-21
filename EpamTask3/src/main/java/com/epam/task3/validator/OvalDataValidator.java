package com.epam.task3.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OvalDataValidator {
	public static Logger logger = LogManager.getLogger();
	final static String STRING_DOUBLE_REGEX = "((\\-)?\\d+(\\.\\d+)?\\s){7}(\\-)?\\d+(\\.\\d+)?";

	public static boolean ovalDataValidator(String lineData) {
		boolean result = lineData.matches(STRING_DOUBLE_REGEX);
        logger.log(Level.INFO, "Data was checked. Result: " + result);
		return result;
	}
}