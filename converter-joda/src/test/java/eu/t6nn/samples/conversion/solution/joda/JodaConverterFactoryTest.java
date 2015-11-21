package eu.t6nn.samples.conversion.solution.joda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.joda.convert.StringConvert;
import org.junit.Before;
import org.junit.Test;

import eu.t6nn.samples.conversion.model.Currency;
import eu.t6nn.samples.conversion.model.Money;
import eu.t6nn.samples.conversion.problem.spi.ObjectConverter;
import eu.t6nn.samples.conversion.problem.spi.ObjectConverterFactory;
import eu.t6nn.samples.conversion.solution.joda.model.MoneyConverter;

public class JodaConverterFactoryTest {

	private StringConvert convert;
	private ObjectConverterFactory factory;

	@Before
	public void setUpTest() {
		convert = new StringConvert();
		convert.register(Money.class, new MoneyConverter());
		factory = new JodaConverterFactory(convert);
	}
	
	@Test
	public void moneyConverterIsCreated() {
		ObjectConverter<Money, String> toStringConverter = factory.getConverter(Money.class, String.class);
		ObjectConverter<String, Money> toMoneyConverter = factory.getConverter(String.class, Money.class);
		assertNotNull(toStringConverter);
		assertNotNull(toMoneyConverter);
		Money before = new Money(BigDecimal.valueOf(10), Currency.EUR);
		Money after = toMoneyConverter.convert(toStringConverter.convert(before));
		assertEquals(before.getAmount(), after.getAmount());
		assertEquals(before.getCurrency(), after.getCurrency());
	}
	
}
