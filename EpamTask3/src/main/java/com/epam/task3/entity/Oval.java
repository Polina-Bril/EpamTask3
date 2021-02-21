package com.epam.task3.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.epam.task3.exception.OvalException;
import com.epam.task3.observer.ObservableOval;
import com.epam.task3.observer.ObserverOval;
import com.epam.task3.observer.OvalEvent;
import com.epam.task3.observer.impl.OvalObserverImpl;
import com.epam.task3.validator.OvalValidator;

public class Oval extends AbstractFigure implements ObservableOval{
	private SemiAxis a;
	private SemiAxis b;
    private List<ObserverOval> observers;
	
	public Oval(SemiAxis a, SemiAxis b) {
		this.a = a;
		this.b = b;
		observers = new ArrayList<>();
        this.attach(new OvalObserverImpl());
	}
	public Oval(Oval o) {
		this.a = o.getA();
		this.b = o.getB();
		observers = new ArrayList<>();
        this.attach(new OvalObserverImpl());
	}
	public Oval(SemiAxis[] semiAxises) throws OvalException {
		if (semiAxises == null || semiAxises.length != 2
				|| !(OvalValidator.semiAxisesFormOval(semiAxises[0], semiAxises[1]))) {
			throw new OvalException(Arrays.toString(semiAxises) + " don't form oval");
		}
		this.a = semiAxises[0];
		this.b = semiAxises[1];
		observers = new ArrayList<>();
        this.attach(new OvalObserverImpl());
	}
	public SemiAxis getA() {
		return a;
	}
	public void setA(SemiAxis a) {
		this.a = a;
        notifyObservers();
	}
	public SemiAxis getB() {
		return b;
	}
	public void setB(SemiAxis b) {
		this.b = b;
        notifyObservers();

	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + ((b == null) ? 0 : b.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Oval other = (Oval) obj;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		if (b == null) {
			if (other.b != null)
				return false;
		} else if (!b.equals(other.b))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Oval [a=");
		builder.append(a);
		builder.append(", b=");
		builder.append(b);
		builder.append("]");
		return builder.toString();
	}
	@Override
	public void notifyObservers() {
		OvalEvent event = new OvalEvent(this);
        observers.forEach(observer -> observer.parameterChanged(event));		
	}
	@Override
	public boolean attach(ObserverOval observer) {
		if(observer != null) {
            observers.add(observer);
            return true;
        }				
		return false;
	}
	@Override
	public boolean detach(ObserverOval observer) {
		observers.remove(observer);	
		return true;
		}
}