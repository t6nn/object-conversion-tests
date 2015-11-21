package eu.t6nn.samples.conversion.solution.joda;

import org.joda.convert.StringConvert;

import eu.t6nn.samples.conversion.problem.spi.ObjectConverter;

public class JodaConverter<TSource, TTarget> implements ObjectConverter<TSource, TTarget> {

	private final Class<TSource> fromClass;
	private final Class<TTarget> toClass;
	private final StringConvert convert;

	JodaConverter(Class<TSource> fromClass, Class<TTarget> toClass, StringConvert convert) {
		this.fromClass = fromClass;
		this.toClass = toClass;
		this.convert = convert;
	}

	@Override
	public TTarget convert(TSource value) {
		System.out.println("Converting from " + fromClass + " to " + toClass);

		String stringFormat = convert.convertToString(value);
		return convert.convertFromString(toClass, stringFormat);
	}

	@Override
	public String toString() {
		return "Joda-Converter from " + fromClass + " to " + toClass;
	}

}
