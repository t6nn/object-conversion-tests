package eu.t6nn.samples.conversion.problem;

import java.util.Set;

import javax.inject.Inject;

import eu.t6nn.samples.conversion.problem.spi.ObjectConverter;
import eu.t6nn.samples.conversion.problem.spi.ObjectConverterFactory;

public class ProblemTester {

	private final Set<ObjectConverterFactory> converterFactories;

	@Inject
	public ProblemTester(Set<ObjectConverterFactory> converterFactories) {
		this.converterFactories = converterFactories;
	}
	
	public void testSimpleConversion() {
		converterFactories.forEach(this::testSimpleConversion);
	}

	private void testSimpleConversion(ObjectConverterFactory factory) {
		System.out.println("Testing factory: " + factory);
		testConversion(factory.getConverter(Integer.class, Double.class), 23);
	}
	
	private <TSource, TTarget> void testConversion(ObjectConverter<TSource, TTarget> converter, TSource source) {
		System.out.println(String.format("Convert: %s (%s)", source, source.getClass()));
		TTarget result = converter.convert(source);
		System.out.println(String.format("Result : %s (%s)", result, result.getClass()));
	}
	
}
