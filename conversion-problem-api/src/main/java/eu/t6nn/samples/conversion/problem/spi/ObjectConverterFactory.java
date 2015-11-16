package eu.t6nn.samples.conversion.problem.spi;

import org.jvnet.hk2.annotations.Contract;

@Contract
public interface ObjectConverterFactory {
	
	<TSource, TTarget> ObjectConverter<TSource, TTarget> getConverter(Class<TSource> fromClass, Class<TTarget> toClass);
	
}
