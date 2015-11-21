package eu.t6nn.samples.conversion.problem;

import org.junit.BeforeClass;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ConversionTests {

	@BeforeClass
	public static void setUpInjection() {
		Injector injector = Guice.createInjector(new RootModule());
	}
}
