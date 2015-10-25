package com.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestJava {

	public static void main(String[] args) {
		String userDirStr = System.getProperty("user.dir");
		System.out.println(userDirStr);
String name = "/jetty-start-test/src/test/resources/jetty home with spaces/modules/base.mod";
		Pattern pat = Pattern.compile("^.*[/\\\\]{1}modules[/\\\\]{1}(.*).mod$",Pattern.CASE_INSENSITIVE);
        Matcher mat = pat.matcher(name);
        if (!mat.find())
        {
            throw new RuntimeException("Invalid Module location (must be located under /modules/ directory): " + name);
        }
        String fileRef = mat.group(1).replace('\\','/');
        System.out.println(fileRef);
	}
	

}
