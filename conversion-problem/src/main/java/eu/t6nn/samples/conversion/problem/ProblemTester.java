package eu.t6nn.samples.conversion.problem;

import java.math.BigDecimal;
import java.util.Set;

import javax.inject.Inject;

import eu.t6nn.samples.conversion.model.Currency;
import eu.t6nn.samples.conversion.model.Money;
import eu.t6nn.samples.conversion.model.TransactionList;
import eu.t6nn.samples.conversion.problem.spi.ObjectConverterFactory;

public class ProblemTester {

	private final Set<ObjectConverterFactory> converterFactories;

	@Inject
	public ProblemTester(Set<ObjectConverterFactory> converterFactories) {
		this.converterFactories = converterFactories;
	}

	public void testSimpleConversion() {
		converterFactories.forEach(this::testSimpleConversion);
	}

	private void testSimpleConversion(ObjectConverterFactory factory) {
		TestSuite suite = new TestSuite(factory);
		
		suite.addTestCase("Integer->Double", 20, Integer.class, Double.class);
		suite.addTestCase("Double->Integer", 21.53D, Double.class, Integer.class);
		
		suite.addTestCase("Double->BigDecimal", 15.23D, Double.class, BigDecimal.class);
		suite.addTestCase("BigDecimal->Double", BigDecimal.valueOf(152255, 4), BigDecimal.class, Double.class);
		
		suite.addTestCase("Boolean->String", false, Boolean.class, String.class);
		suite.addTestCase("String->Boolean", "true", String.class, Boolean.class);
		
		suite.addTestCase("Currency->String", Currency.EUR, Currency.class, String.class);
		suite.addTestCase("String->Currency", "USD", String.class, Currency.class);
		
		suite.addTestCase("Money->String", new Money(BigDecimal.valueOf(1000, 2), Currency.EUR), Money.class, String.class);
		suite.addTestCase("String->Money", "12 EUR", String.class, Money.class);
		
		TransactionList list = new TransactionList();
		list.add(new Money(BigDecimal.valueOf(1000, 2), Currency.EUR));
		list.add(new Money(BigDecimal.valueOf(-20, 2), Currency.USD));
		suite.addTestCase("TransactionList->String", list, TransactionList.class, String.class);
		suite.addTestCase("String->TransactionList", "5 EUR,10 USD", String.class, TransactionList.class);
		
		suite.addTestCase("Money->TransactionList", new Money(BigDecimal.valueOf(1000, 2), Currency.EUR), Money.class, TransactionList.class);
		suite.addTestCase("Money->BigDecimal", new Money(BigDecimal.valueOf(1000, 2), Currency.EUR), Money.class, BigDecimal.class);
		suite.addTestCase("Money->Double", new Money(BigDecimal.valueOf(1000, 2), Currency.EUR), Money.class, Double.class);
		
		//suite.addTestCase("BigDecimal->Money", BigDecimal.valueOf(1522, 2), BigDecimal.class, Money.class);
		//suite.addTestCase("Double->Money", 22.14D, Double.class, Money.class);
		
		suite.runAndReport();
		System.out.println();
	}

}
