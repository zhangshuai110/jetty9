package cskgnt.test;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Son extends Father {

	@Test
	public void testCase() {
		System.out.println("TestCase: " + name.getMethodName());
	}
	
	@Before
	public void extendBefore() {
		System.out.println("Son: before");
	}
	
	public void sonAfter() {
		System.out.println("Son: after");
	}
	
	@BeforeClass
	public static void extendBeforeClass() {
		System.out.println("Son: beforeClass");
	}
	
	@AfterClass
	public static void extendAfterClass() {
		System.out.println("Son: afterClass");
	}
}
