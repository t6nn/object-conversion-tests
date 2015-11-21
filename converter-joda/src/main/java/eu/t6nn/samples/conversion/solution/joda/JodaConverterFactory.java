package eu.t6nn.samples.conversion.solution.joda;

import org.joda.convert.StringConvert;
import org.jvnet.hk2.annotations.Service;

import eu.t6nn.samples.conversion.model.Money;
import eu.t6nn.samples.conversion.model.TransactionList;
import eu.t6nn.samples.conversion.problem.spi.ObjectConverter;
import eu.t6nn.samples.conversion.problem.spi.ObjectConverterFactory;
import eu.t6nn.samples.conversion.solution.joda.model.MoneyConverter;
import eu.t6nn.samples.conversion.solution.joda.model.TransactionListConverter;

@Service
public class JodaConverterFactory implements ObjectConverterFactory {

	private final StringConvert convert = new StringConvert();

	public JodaConverterFactory() {
		MoneyConverter moneyConverter = new MoneyConverter();
		convert.register(Money.class, moneyConverter);
		convert.register(TransactionList.class, new TransactionListConverter(moneyConverter));
	}

	@Override
	public <TSource, TTarget> ObjectConverter<TSource, TTarget> getConverter(Class<TSource> fromClass,
			Class<TTarget> toClass) {
		return new JodaConverter<>(fromClass, toClass, convert);
	}

	@Override
	public String toString() {
		return "Joda-Convert";
	}

}
