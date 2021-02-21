package com.epam.task3.comparator;

import java.util.Comparator;

import com.epam.task3.entity.AbstractFigure;
import com.epam.task3.entity.Oval;
import com.epam.task3.entity.OvalWarehouse;

public enum OvalComparator {
	ID((oval1, oval2) -> oval1.getId() - oval2.getId()),
	SEMIAXIS_A(
			(oval1, oval2) -> Double.compare(((Oval) oval1).getA().getLength(), ((Oval) oval2).getA().getLength())),
	SEMIAXIS_B(
			(oval1, oval2) -> Double.compare(((Oval) oval1).getB().getLength(), ((Oval) oval2).getB().getLength())),
	PERIMETER((oval1, oval2) -> Double.compare(OvalWarehouse.getInstance().getData(oval1.getId()).getPerimeter(),
			OvalWarehouse.getInstance().getData(oval2.getId()).getPerimeter())),
	SQUARE((oval1, oval2) -> Double.compare(OvalWarehouse.getInstance().getData(oval1.getId()).getSquare(),
			OvalWarehouse.getInstance().getData(oval2.getId()).getSquare()));

	private final Comparator<AbstractFigure> comparator;

	OvalComparator(Comparator<AbstractFigure> comparator) {
		this.comparator = comparator;
	}
	public Comparator<AbstractFigure> getComparator() {
		return comparator;
	}
}