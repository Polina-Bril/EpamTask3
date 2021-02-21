package com.epam.task3.repository.impl;

import com.epam.task3.entity.Oval;
import com.epam.task3.entity.OvalParameters;
import com.epam.task3.entity.OvalWarehouse;
import com.epam.task3.repository.Specification;

public class SquareBetweenOvalSpecification implements Specification<Oval> {
    private double from;
    private double to;

    public SquareBetweenOvalSpecification(double from, double to) {
        this.from = from;
        this.to = to;
    }
    @Override
    public boolean specify(Oval oval) {
    	OvalWarehouse warehouse = OvalWarehouse.getInstance();
        OvalParameters ellipseRecorder = warehouse.getData(oval.getId());
        double square = ellipseRecorder.getSquare();
        boolean result = square >= from && square <= to;
        return result;
    }
}