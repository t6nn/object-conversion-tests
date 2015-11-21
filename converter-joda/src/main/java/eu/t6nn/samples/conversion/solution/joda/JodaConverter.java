package eu.t6nn.samples.conversion.solution.joda;

import org.joda.convert.StringConvert;

import eu.t6nn.samples.conversion.problem.spi.ObjectConverter;

public class JodaConverter<TSource, TTarget> implements ObjectConverter<TSource, TTarget> {

	private final Class<TSource> sourceClass;
	private final Class<TTarget> targetClass;
	private final StringConvert convert;

	JodaConverter(Class<TSource> sourceClass, Class<TTarget> targetClass, StringConvert convert) {
		this.sourceClass = sourceClass;
		this.targetClass = targetClass;
		this.convert = convert;
	}

	@Override
	public TTarget convert(TSource value) {
		System.out.println("Converting from " + sourceClass + " to " + targetClass);

		String stringFormat = convert.convertToString(value);
		return convert.convertFromString(targetClass, stringFormat);
	}

}
