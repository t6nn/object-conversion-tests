package eu.t6nn.samples.conversion.solution.spring.model;

import java.math.BigDecimal;

import org.springframework.core.convert.converter.Converter;

import eu.t6nn.samples.conversion.model.Money;

public class MoneyToBigDecimal implements Converter<Money, BigDecimal> {

	@Override
	public BigDecimal convert(Money money) {
		return money.getAmount();
	}

}
