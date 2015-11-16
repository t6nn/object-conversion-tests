package eu.t6nn.samples.conversion.solution.spring;

import eu.t6nn.samples.conversion.problem.spi.ObjectConverter;
import eu.t6nn.samples.conversion.problem.spi.ObjectConverterFactory;

public class SpringConverterFactory implements ObjectConverterFactory {

	@Override
	public <TSource, TTarget> ObjectConverter<TSource, TTarget> getConverter(Class<TSource> fromClass,
			Class<TTarget> toClass) {
		return null;
	}

}
