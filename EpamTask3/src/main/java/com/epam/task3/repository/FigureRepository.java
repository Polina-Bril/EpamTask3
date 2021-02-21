package com.epam.task3.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.epam.task3.entity.AbstractFigure;

public class FigureRepository {
	private List<AbstractFigure> figures;

	public FigureRepository() {
		figures = new ArrayList<>();
	}
	public List<AbstractFigure> findAll() {
		return Collections.unmodifiableList(figures);
	}

	public void saveFigure(AbstractFigure figure) {
		figures.add(figure);
	}
	public void removeFigure(AbstractFigure figure) {
		figures.remove(figure);
	}
	public AbstractFigure findByIndex(int index) {
		return figures.get(index);
	}
	public AbstractFigure saveByIndex(int index, AbstractFigure element) {
		return figures.set(index, element);
	}
	public List<AbstractFigure> query(Specification<AbstractFigure> specification) {
		List<AbstractFigure> list = figures.stream().filter(o -> specification.specify(o)).collect(Collectors.toList());
		return list;
	}
	public List<AbstractFigure> sort(Comparator<AbstractFigure> type) {
		List<AbstractFigure> sortedList = figures.stream().sorted(type).collect(Collectors.toList());
		return sortedList;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("FigureRepository\n");
		sb.append(figures);
		return sb.toString();
	}
}