package eu.t6nn.samples.conversion.problem;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import eu.t6nn.samples.conversion.problem.spi.ObjectConverter;
import eu.t6nn.samples.conversion.problem.spi.ObjectConverterFactory;

@Service
public class ProblemTester {

	@Inject
	private ObjectConverterFactory converterFactory;
	
	public void testSimpleConversion() {
		ObjectConverter<Integer, Double> converter = converterFactory.getConverter(Integer.class, Double.class);
		testConversion(converter, 23);
	}
	
	private <TSource, TTarget> void testConversion(ObjectConverter<TSource, TTarget> converter, TSource source) {
		System.out.println(String.format("Converting from %s (%s)", source, source.getClass()));
		TTarget result = converter.convert(source);
		System.out.println(String.format("Got value %s (%s)", result, result.getClass()));
	}
	
}
