package eu.t6nn.samples.conversion.solution.spring.model;

import org.springframework.core.convert.converter.Converter;

import eu.t6nn.samples.conversion.model.Money;

public class MoneyToString implements Converter<Money, String> {

	@Override
	public String convert(Money money) {
		return money.getAmount().toPlainString() + " " + money.getCurrency().name();
	}

}
