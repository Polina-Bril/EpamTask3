package com.epam.task3.repository;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.epam.task3.comparator.OvalComparator;
import com.epam.task3.entity.AbstractFigure;
import com.epam.task3.entity.Oval;
import com.epam.task3.entity.Point2D;
import com.epam.task3.entity.SemiAxis;
import com.epam.task3.repository.impl.FirstQuadrantOvalSpecification;
import com.epam.task3.repository.impl.IdSpecification;
import com.epam.task3.repository.impl.PerimeterBetweenOvalSpecification;
import com.epam.task3.repository.impl.SquareBetweenOvalSpecification;

public class FigureRepositoryTest {
	private FigureRepository repository;
	
    @BeforeClass
    public void setUp() {
        repository = new FigureRepository();
        repository.saveFigure(new Oval(new SemiAxis(new Point2D(10, 10), new Point2D(12, 12)),
        		new SemiAxis(new Point2D(7, 5), new Point2D(12, 12))));
        repository.saveFigure(new Oval(new SemiAxis(new Point2D(8, 8), new Point2D(12, 12)),
        		new SemiAxis(new Point2D(10, 10), new Point2D(8, 8))));
        repository.saveFigure(new Oval(new SemiAxis(new Point2D(7, 7), new Point2D(12, 12)),
        		new SemiAxis(new Point2D(6, 1), new Point2D(12, 12))));
        repository.saveFigure(new Oval(new SemiAxis(new Point2D(10, 10), new Point2D(11, 7)),
        		new SemiAxis(new Point2D(10, 10), new Point2D(8, 4))));
    }
    @AfterClass
    public void tearDown() {
        repository = null;
    }
    @DataProvider(name = "dataSpecificationAndResultValid")
    public Object[][] createDataSpecificationValid() {
        List<Oval> quadrantSpecification = new ArrayList<>();
        Oval oval1 = new Oval(new SemiAxis(new Point2D(2, 1), new Point2D(2, 7)),
        		new SemiAxis(new Point2D(2, 5), new Point2D(4, 5)));
        quadrantSpecification.add(oval1);
        Oval oval2 = new Oval(new SemiAxis(new Point2D(7, 2), new Point2D(7, 9)),
        		new SemiAxis(new Point2D(7, 9), new Point2D(12, 9)));
        quadrantSpecification.add(oval2);

        List<Oval> idSpecification = new ArrayList<>();
        idSpecification.add(oval1);

        List<Oval> perimeterSpecification = new ArrayList<>();
        perimeterSpecification.add(oval1);

        List<Oval> squareSpecification = new ArrayList<>();
        squareSpecification.add(oval1);

        return new Object[][]{
                {new FirstQuadrantOvalSpecification(), quadrantSpecification},
                {new IdSpecification(1), idSpecification},
                {new PerimeterBetweenOvalSpecification(28, 28.2), perimeterSpecification},
                {new SquareBetweenOvalSpecification(37.5, 37.8), squareSpecification},
        };
    }

    @DataProvider(name = "dataSpecificationAndResultInvalid")
    public Object[][] createDataSpecificationInvalid() {
        List<Oval> quadrantSpecification = new ArrayList<>();
        Oval oval1 = new Oval(new SemiAxis(new Point2D(2, 1), new Point2D(2, 7)),
        		new SemiAxis(new Point2D(2, 5), new Point2D(4, 5)));
        quadrantSpecification.add(oval1);
        Oval oval2 = new Oval(new SemiAxis(new Point2D(7, 2), new Point2D(7, 9)),
        		new SemiAxis(new Point2D(7, 9), new Point2D(12, 9)));
        quadrantSpecification.add(oval2);

        List<Oval> idSpecification = new ArrayList<>();
        idSpecification.add(oval1);
        idSpecification.add(oval2);

        List<Oval> perimeterSpecification = new ArrayList<>();
        perimeterSpecification.add(oval1);
        perimeterSpecification.add(oval2);

        List<Oval> squareSpecification = new ArrayList<>();
        squareSpecification.add(oval1);
        squareSpecification.add(oval2);

        return new Object[][]{
                {new FirstQuadrantOvalSpecification(), quadrantSpecification},
                {new IdSpecification(2), idSpecification},
                {new PerimeterBetweenOvalSpecification(3, 3.2), perimeterSpecification},
                {new SquareBetweenOvalSpecification(0.5, 0.8), squareSpecification},
        };
    }
    @Test(dataProvider = "dataSpecificationAndResultValid")
    public void queryTestValid(Specification specification, List<Oval> expected) {
        List<Oval> actual = repository.query(specification);
        assertEquals(expected, actual);
    }
    @Test(dataProvider = "dataSpecificationAndResultInvalid")
    public void queryTestInvalid(Specification specification, List<Oval> expected) {
        List<Oval> actual = repository.query(specification);
        assertNotEquals(expected, actual);
    }
    @Test
    public void sortPositiveTest() {
        List<AbstractFigure> expected = new ArrayList<>();
        expected.add(new Oval(new SemiAxis(new Point2D(10, 10), new Point2D(12, 12)),
        		new SemiAxis(new Point2D(7, 5), new Point2D(12, 12))));
        expected.add(new Oval(new SemiAxis(new Point2D(8, 8), new Point2D(12, 12)),
        		new SemiAxis(new Point2D(10, 10), new Point2D(8, 8))));
        expected.add(new Oval(new SemiAxis(new Point2D(7, 7), new Point2D(12, 12)),
        		new SemiAxis(new Point2D(6, 1), new Point2D(12, 12))));
        expected.add(new Oval(new SemiAxis(new Point2D(10, 10), new Point2D(11, 7)),
        		new SemiAxis(new Point2D(10, 10), new Point2D(8, 4))));
        Comparator<AbstractFigure> comparator = OvalComparator.PERIMETER.getComparator();
        List<AbstractFigure> actual = repository.sort(comparator);
        assertEquals(expected, actual);
    }
    @Test
    public void sortNegativeTest() {
        List<AbstractFigure> expected = new ArrayList<>();
        expected.add(new Oval(new SemiAxis(new Point2D(10, 10), new Point2D(12, 12)),
        		new SemiAxis(new Point2D(7, 5), new Point2D(12, 12))));
        expected.add(new Oval(new SemiAxis(new Point2D(8, 8), new Point2D(12, 12)),
        		new SemiAxis(new Point2D(10, 10), new Point2D(8, 8))));
        expected.add(new Oval(new SemiAxis(new Point2D(7, 7), new Point2D(12, 12)),
        		new SemiAxis(new Point2D(6, 1), new Point2D(12, 12))));
        expected.add(new Oval(new SemiAxis(new Point2D(10, 10), new Point2D(11, 7)),
        		new SemiAxis(new Point2D(10, 10), new Point2D(8, 4))));
        Comparator<AbstractFigure> comparator = OvalComparator.ID.getComparator();
        List<AbstractFigure> actual = repository.sort(comparator);
        assertNotEquals(expected, actual);
    }
}