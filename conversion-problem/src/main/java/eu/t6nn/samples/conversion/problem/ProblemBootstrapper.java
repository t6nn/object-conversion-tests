package eu.t6nn.samples.conversion.problem;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ProblemBootstrapper {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new RootModule());

		ProblemTester tester = injector.getInstance(ProblemTester.class);
		tester.testSimpleConversion();
	}
}
