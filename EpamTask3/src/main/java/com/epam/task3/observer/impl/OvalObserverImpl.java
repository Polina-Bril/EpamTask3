package com.epam.task3.observer.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.task3.action.PerimeterSquareAction;
import com.epam.task3.entity.Oval;
import com.epam.task3.entity.OvalParameters;
import com.epam.task3.entity.OvalWarehouse;
import com.epam.task3.exception.OvalException;
import com.epam.task3.observer.ObserverOval;
import com.epam.task3.observer.OvalEvent;

public class OvalObserverImpl implements ObserverOval {
	static Logger logger = LogManager.getLogger();

	@Override
	public void parameterChanged(OvalEvent event) {
		Oval oval = event.getSource();
		PerimeterSquareAction action = new PerimeterSquareAction();
		OvalWarehouse warehouse = OvalWarehouse.getInstance();
		Double currentPerimeter = null;
		Double currentSquare = null;
		try {
			currentPerimeter = action.findPerimeter(oval);
			currentSquare = action.findSquare(oval);
		} catch (OvalException e) {
			logger.log(Level.ERROR, "oval " + oval + " is null", e);

			e.printStackTrace();
		}
		OvalParameters recorder = warehouse.getData(oval.getId());
		if (recorder != null) {
			recorder.setPerimeter(currentPerimeter);
			recorder.setSquare(currentSquare);
		} else {
			recorder = new OvalParameters(currentPerimeter, currentSquare);
		}
		warehouse.put(oval.getId(), recorder);
		logger.log(Level.INFO, "Data was updated.");
	}
}