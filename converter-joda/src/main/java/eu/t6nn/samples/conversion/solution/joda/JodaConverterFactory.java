package eu.t6nn.samples.conversion.solution.joda;

import org.jvnet.hk2.annotations.Service;

import eu.t6nn.samples.conversion.problem.spi.ObjectConverter;
import eu.t6nn.samples.conversion.problem.spi.ObjectConverterFactory;

@Service
public class JodaConverterFactory implements ObjectConverterFactory{

	@Override
	public <TSource, TTarget> ObjectConverter<TSource, TTarget> getConverter(Class<TSource> fromClass,
			Class<TTarget> toClass) {
		return new JodaConverter<>(fromClass, toClass);
	}
	
	@Override
	public String toString() {
		return "Joda-Convert";
	}

}
