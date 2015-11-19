package eu.t6nn.samples.conversion.solution.joda;

import org.junit.Before;

import eu.t6nn.samples.conversion.problem.spi.ObjectConverterFactory;

public class JodaConverterFactoryTest {

	private ObjectConverterFactory factory;

	@Before
	public void setUpTest() {
		factory = new JodaConverterFactory();
	}

}
