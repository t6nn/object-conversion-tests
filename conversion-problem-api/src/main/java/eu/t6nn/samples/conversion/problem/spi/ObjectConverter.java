package eu.t6nn.samples.conversion.problem.spi;

public interface ObjectConverter<TSource, TTarget> {

	TTarget convert(TSource value);

}
