package eu.t6nn.samples.conversion.problem;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

public class ProblemBootstrapper {

	public static void main(String[] args) {
		ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();

		ProblemTester tester = locator.getService(ProblemTester.class);
		tester.testSimpleConversion();
	}
}
