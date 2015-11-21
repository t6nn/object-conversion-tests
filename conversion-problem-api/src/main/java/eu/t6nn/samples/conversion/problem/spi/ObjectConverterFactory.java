package eu.t6nn.samples.conversion.problem.spi;

public interface ObjectConverterFactory {

	<TSource, TTarget> ObjectConverter<TSource, TTarget> getConverter(Class<TSource> fromClass, Class<TTarget> toClass);

}
