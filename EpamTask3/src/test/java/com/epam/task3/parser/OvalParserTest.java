package com.epam.task3.parser;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.task3.entity.Point2D;
import com.epam.task3.entity.SemiAxis;
import com.epam.task3.exception.OvalException;

public class OvalParserTest {
	OvalParser parser;
	List<String> lines;

	@BeforeClass
	public void setUp() {
		parser = new OvalParser();
		lines = new ArrayList<>();
		lines.add("5 -2 7 -9");
		lines.add("12 1 7");
		lines.add("0.0 0.0 0.0 0.0");
		lines.add("17 22 72 -19");
	}

	@AfterClass
	public void tearDown() {
		parser = null;
		lines = null;
	}

	@Test
	public void parseListPositiveTest() throws OvalException {
		List<SemiAxis[]> expected = new ArrayList<>();
		SemiAxis semiAxisA = new SemiAxis(new Point2D(2, 1), new Point2D(2, 7));
		SemiAxis semiAxisB = new SemiAxis(new Point2D(2, 5), new Point2D(4, 5));
		SemiAxis[] semiAxises = { semiAxisA, semiAxisB };
		expected.add(semiAxises);
		List<SemiAxis[]> actual = parser.parseList(lines);
		assertEquals(expected, actual);
	}

	@Test
	public void parseListNegativeTest() throws OvalException {
		List<SemiAxis[]> expected = new ArrayList<>();
		SemiAxis semiAxisA = new SemiAxis(new Point2D(2, 1), new Point2D(2, 7));
		SemiAxis[] semiAxises = { semiAxisA };
		expected.add(semiAxises);
		List<SemiAxis[]> actual = parser.parseList(lines);
		assertNotEquals(expected, actual);
	}
}