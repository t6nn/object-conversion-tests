package eu.t6nn.samples.conversion.solution.joda.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import eu.t6nn.samples.conversion.model.Currency;
import eu.t6nn.samples.conversion.model.Money;

public class MoneyConverterTest {
	private MoneyConverter converter;

	@Before
	public void initConverter() {
		converter = new MoneyConverter();
	}

	@Test
	public void convertToStringReturnsCorrectFormat() {
		Money money = new Money(BigDecimal.valueOf(2005, 2), Currency.EUR);
		assertEquals("20.05 EUR", converter.convertToString(money));
	}

	@Test
	public void convertToMoneyReturnsCorrectValue() {
		Money converted = converter.convertFromString(Money.class, "54.35 USD");
		assertEquals(BigDecimal.valueOf(5435, 2), converted.getAmount());
		assertEquals(Currency.USD, converted.getCurrency());
	}
}
