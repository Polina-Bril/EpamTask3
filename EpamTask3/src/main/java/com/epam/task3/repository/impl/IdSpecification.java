package com.epam.task3.repository.impl;

import com.epam.task3.entity.AbstractFigure;
import com.epam.task3.repository.Specification;

public class IdSpecification implements Specification<AbstractFigure> {
	private int id;

	public IdSpecification(int id) {
		this.id = id;
	}

	@Override
	public boolean specify(AbstractFigure figure) {
		boolean result = figure.getId() == id;
		return result;
	}
}
