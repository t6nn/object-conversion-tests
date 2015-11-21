package eu.t6nn.samples.conversion.solution.joda;

import javax.inject.Inject;

import org.joda.convert.StringConvert;

import eu.t6nn.samples.conversion.problem.spi.ObjectConverter;
import eu.t6nn.samples.conversion.problem.spi.ObjectConverterFactory;

public class JodaConverterFactory implements ObjectConverterFactory {

	private final StringConvert convert;

	@Inject
	JodaConverterFactory(StringConvert convert) {
		this.convert = convert;
	}

	@Override
	public <TSource, TTarget> ObjectConverter<TSource, TTarget> getConverter(Class<TSource> fromClass,
			Class<TTarget> toClass) {
		return new JodaConverter<>(fromClass, toClass, convert);
	}

	@Override
	public String toString() {
		return "Joda-Converter Factory";
	}

}
