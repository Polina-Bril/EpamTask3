package com.epam.task3.repository.impl;

import com.epam.task3.entity.Oval;
import com.epam.task3.repository.Specification;

public class FirstQuadrantOvalSpecification implements Specification<Oval> {
	@Override
	public boolean specify(Oval oval) {
		boolean result = oval.getA().getA().getX() > 0 && oval.getA().getA().getY() > 0 && oval.getA().getB().getX() > 0
				&& oval.getA().getB().getY() > 0 && oval.getB().getA().getX() > 0 && oval.getB().getA().getY() > 0
				&& oval.getB().getB().getX() > 0 && oval.getB().getB().getY() > 0;
		return result;
	}
}