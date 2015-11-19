package eu.t6nn.samples.conversion.problem;

import java.util.List;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.junit.BeforeClass;

import eu.t6nn.samples.conversion.problem.spi.ObjectConverterFactory;

public class ConversionTests {

	private static List<ObjectConverterFactory> factories;

	@BeforeClass
	public static void setUpInjection() {
		ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();
		factories = locator.getAllServices(ObjectConverterFactory.class);
	}
}
