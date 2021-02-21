package com.epam.task3.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.task3.exception.OvalException;

public class FileReader {
	public static Logger logger = LogManager.getLogger();

	public List<String> readFromFile(String filePath) throws OvalException {
		if (filePath == null) {
			throw new OvalException("FilePath is null");
		}
		Path path = Paths.get(filePath);
		List<String> linesForOvals = new ArrayList<>();
		try (Stream<String> strings = Files.lines(path)) {
			linesForOvals = strings.collect(Collectors.toList());
		} catch (IOException e) {
			logger.log(Level.ERROR, "file " + filePath + " not found", e);
			throw new OvalException("file " + filePath + " not found", e);
		}
		logger.log(Level.INFO, "read data for ovals from file : " + linesForOvals);
		return linesForOvals;
	}
}