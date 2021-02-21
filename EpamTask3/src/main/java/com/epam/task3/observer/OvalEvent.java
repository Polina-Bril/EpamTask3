package com.epam.task3.observer;

import java.util.EventObject;

import com.epam.task3.entity.Oval;

public class OvalEvent extends EventObject {

	public OvalEvent(Oval inputSource) {
		super(inputSource);
	}
	public Oval getSource() {
		return (Oval) super.getSource();
	}
}