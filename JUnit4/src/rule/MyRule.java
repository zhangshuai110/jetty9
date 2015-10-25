package rule;

import org.junit.rules.TestRule;
import org.junit.runners.model.Statement;
import org.junit.runner.Description;

public class MyRule implements TestRule {
	@Override
	public Statement apply(Statement base, Description description) {
		return new MyStatement(base);
	}
}