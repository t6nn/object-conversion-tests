package eu.t6nn.samples.conversion.problem;

import com.google.inject.AbstractModule;

import eu.t6nn.samples.conversion.problem.spi.ProblemApiModule;
import eu.t6nn.samples.conversion.solution.joda.JodaModule;
import eu.t6nn.samples.conversion.solution.spring.SpringModule;

public class RootModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new ProblemApiModule());
		install(new JodaModule());
		install(new SpringModule());
		
		bind(ProblemTester.class);
	}

}
