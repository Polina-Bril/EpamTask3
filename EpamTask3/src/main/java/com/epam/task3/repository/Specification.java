package com.epam.task3.repository;

import com.epam.task3.entity.AbstractFigure;

public interface Specification<T extends AbstractFigure> {
	boolean specify(T t);
}
