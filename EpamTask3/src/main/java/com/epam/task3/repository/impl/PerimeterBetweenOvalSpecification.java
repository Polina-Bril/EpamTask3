package com.epam.task3.repository.impl;

import com.epam.task3.entity.Oval;
import com.epam.task3.entity.OvalParameters;
import com.epam.task3.entity.OvalWarehouse;
import com.epam.task3.repository.Specification;

public class PerimeterBetweenOvalSpecification implements Specification<Oval> {
    private double from;
    private double to;

    public PerimeterBetweenOvalSpecification(double from, double to) {
        this.from = from;
        this.to = to;
    }
    @Override
    public boolean specify(Oval oval) {
        OvalWarehouse warehouse = OvalWarehouse.getInstance();
        OvalParameters ovalRecorder = warehouse.getData(oval.getId());
        double perimeter = ovalRecorder.getPerimeter();
        boolean result = perimeter >= from && perimeter <= to;
        return result;
    }
}
