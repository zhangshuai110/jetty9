package rule;

import org.junit.Rule;
import org.junit.Test;

public class MyTest {
	@Rule
	public MyRule myRule = new MyRule();

	@Test()
	public void xx() {
		System.out.println("xx()...");
	}
}