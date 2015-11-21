package eu.t6nn.samples.conversion.solution.spring;

import javax.inject.Inject;

import org.springframework.core.convert.ConversionService;

import eu.t6nn.samples.conversion.problem.spi.ObjectConverter;

public class SpringConverter<TSource, TTarget> implements ObjectConverter<TSource, TTarget> {

	private final ConversionService conversionService;
	private final Class<TSource> fromClass;
	private final Class<TTarget> toClass;

	@Inject
	SpringConverter(Class<TSource> fromClass, Class<TTarget> toClass, ConversionService conversionService) {
		this.fromClass = fromClass;
		this.toClass = toClass;
		this.conversionService = conversionService;
	}

	@Override
	public TTarget convert(TSource value) {
		return conversionService.convert(value, toClass);
	}

	@Override
	public String toString() {
		return "Spring-Converter from " + fromClass + " to " + toClass;
	}

}
