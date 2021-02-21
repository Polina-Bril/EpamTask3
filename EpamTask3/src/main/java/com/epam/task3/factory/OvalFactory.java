package com.epam.task3.factory;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.task3.entity.Oval;
import com.epam.task3.entity.SemiAxis;
import com.epam.task3.exception.OvalException;

public class OvalFactory {
public static Logger logger = LogManager.getLogger();
	
	public Oval createOval(SemiAxis[] semiAxises) throws OvalException {
		if (semiAxises == null || semiAxises.length!=2) {
			throw new OvalException("incorrect data for creating a oval");
		}
		Oval oval = new Oval(semiAxises);
		logger.log(Level.INFO, "oval created: " + oval.toString());
		return oval;
	}
}