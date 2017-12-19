package sample.testing.config;

import org.junit.After;
import org.junit.Before;

public abstract class TestUnit {

	@Before
	public void setUp() {
		System.out.println("@Before");
	}
	
	@After
	public void shutdown() {
		System.out.println("@After");
	}
}
