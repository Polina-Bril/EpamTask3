package com.epam.task3.entity;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OvalWarehouse {
	static Logger logger = LogManager.getLogger();
	private static OvalWarehouse instance;
	private Map<Integer, OvalParameters> data;

	private OvalWarehouse() {
		data = new HashMap<>();
	}
	public static OvalWarehouse getInstance() {
		if (instance == null) {
			instance = new OvalWarehouse();
		}
		return instance;
	}
	public OvalParameters getData(int key) {
		OvalParameters recorder = data.get(key);
		return recorder;
	}
	public void put(int id, OvalParameters parameters) {
		data.put(id, parameters);
		logger.log(Level.INFO, "Successful addition");
	}
	public void remove(int id) {
		data.remove(id);
		logger.log(Level.INFO, "Successful removing");
	}
}
