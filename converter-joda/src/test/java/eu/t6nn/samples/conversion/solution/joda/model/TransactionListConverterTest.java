package eu.t6nn.samples.conversion.solution.joda.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import eu.t6nn.samples.conversion.model.Currency;
import eu.t6nn.samples.conversion.model.Money;
import eu.t6nn.samples.conversion.model.TransactionList;

public class TransactionListConverterTest {

	private TransactionListConverter converter;

	@Before
	public void initConverter() {
		converter = new TransactionListConverter(new MoneyConverter());
	}

	@Test
	public void convertToStringReturnsCorrectValue() {
		TransactionList list = new TransactionList();
		list.add(new Money(BigDecimal.valueOf(2500, 2), Currency.EUR));
		list.add(new Money(BigDecimal.valueOf(-3005, 2), Currency.USD));
		assertEquals("25.00 EUR,-30.05 USD", converter.convertToString(list));
	}

	@Test
	public void convertToListReadsAllItems() {
		TransactionList list = converter.convertFromString(TransactionList.class, "1 USD,5.33 EUR");
		Iterator<Money> it = list.iterator();
		Money first = it.next();
		assertEquals(BigDecimal.valueOf(1), first.getAmount());
		assertEquals(Currency.USD, first.getCurrency());
		Money second = it.next();
		assertEquals(BigDecimal.valueOf(533, 2), second.getAmount());
		assertEquals(Currency.EUR, second.getCurrency());
	}

}
