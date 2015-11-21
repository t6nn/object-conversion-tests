package eu.t6nn.samples.conversion.solution.spring;

import javax.inject.Inject;

import org.springframework.core.convert.ConversionService;

import eu.t6nn.samples.conversion.problem.spi.ObjectConverter;
import eu.t6nn.samples.conversion.problem.spi.ObjectConverterFactory;

public class SpringConverterFactory implements ObjectConverterFactory {

	private final ConversionService conversionService;

	@Inject
	public SpringConverterFactory(ConversionService conversionService) {
		this.conversionService = conversionService;
	}

	@Override
	public <TSource, TTarget> ObjectConverter<TSource, TTarget> getConverter(Class<TSource> fromClass,
			Class<TTarget> toClass) {
		return new SpringConverter<>(fromClass, toClass, conversionService);
	}
	
	@Override
	public String toString() {
		return "Spring-Converter Factory";
	}

}
