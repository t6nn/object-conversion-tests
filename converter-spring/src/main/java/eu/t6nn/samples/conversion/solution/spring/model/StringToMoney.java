package eu.t6nn.samples.conversion.solution.spring.model;

import java.math.BigDecimal;

import org.springframework.core.convert.converter.Converter;

import eu.t6nn.samples.conversion.model.Currency;
import eu.t6nn.samples.conversion.model.Money;

public class StringToMoney implements Converter<String, Money> {

	@Override
	public Money convert(String strValue) {
		String[] components = strValue.split(" ");
		return new Money(new BigDecimal(components[0]), Currency.valueOf(components[1]));
	}

}
