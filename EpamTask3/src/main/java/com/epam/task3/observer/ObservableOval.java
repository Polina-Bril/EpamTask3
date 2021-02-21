package com.epam.task3.observer;

public interface ObservableOval {
	boolean attach(ObserverOval observer);

	boolean detach(ObserverOval observer);

	void notifyObservers();
}
