package cskgnt.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public abstract class Father {

	protected String caseIdentifier = "";
	protected abstract void sonAfter();
	
	@Rule
	public TestName name = new TestName();
	
	@BeforeClass
	public static void fatherBeforeClass() {
		System.out.println("Father: beforeClass");
	}
	
	@AfterClass
	public static void fatherAfterClass() {
		System.out.println("Father: afterClass");
	}
	
	@Before
	public void fatherBefore() {
		System.out.println("Father: before");
	}
	
	@After
	public void fatherAfter() {
		System.out.println("Father: after");
	}

	@Rule
	public TestWatcher watchman = new TestWatcher() {

		protected void starting(Description d) {
			caseIdentifier = d.getClassName() + "." + d.getMethodName();
			System.out.println("starting: " + caseIdentifier);
		}

		protected void succeeded(Description d) {
			caseIdentifier = d.getClassName() + " " + d.getMethodName();
			System.out.println("succeeded: " + caseIdentifier);
		}

		protected void failed(Throwable e, Description d) {
			caseIdentifier = d.getClassName() + " " + d.getMethodName();
			System.out.println("failed: " + caseIdentifier);
		}

		protected void finished(Description d) {
			sonAfter();
			caseIdentifier = d.getClassName() + " " + d.getMethodName();
			System.out.println("finished: " + caseIdentifier);
		}

	};
}
