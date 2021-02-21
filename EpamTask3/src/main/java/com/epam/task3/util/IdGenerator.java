package com.epam.task3.util;

public class IdGenerator {
	private static int id;

	private IdGenerator() {
	}

	public static int generateId(){
        return ++id;
    }
}
