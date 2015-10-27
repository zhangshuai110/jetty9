package com.java;

import java.util.Enumeration;

public class TestSystemGetProperties {

	public static void main(String[] args) {
		Enumeration<?> ensysprop = System.getProperties().propertyNames();
		while (ensysprop.hasMoreElements()) {
			String name = (String) ensysprop.nextElement();
			System.out.println(name + "=" + System.getProperty(name));
		}
	}

}
