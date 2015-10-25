package rule;

import static tool.Print.*;//pln(Object)
import org.junit.runners.model.Statement;

public class MyStatement extends Statement {
	private final Statement base;

	public MyStatement(Statement base) {
		this.base = base;
	}

	@Override
	public void evaluate() throws Throwable {
		pln("before...sth..sth");
		try {
			base.evaluate();
		} finally {
			pln("after...sth..sth");
		}
	}
}