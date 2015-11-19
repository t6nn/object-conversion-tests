package eu.t6nn.samples.conversion.solution.joda.model;

import java.math.BigDecimal;

import org.joda.convert.StringConverter;

import eu.t6nn.samples.conversion.model.Currency;
import eu.t6nn.samples.conversion.model.Money;

public class MoneyConverter implements StringConverter<Money> {

	@Override
	public String convertToString(Money money) {
		return money.getAmount().toPlainString() + " " + money.getCurrency().name();
	}

	@Override
	public Money convertFromString(Class<? extends Money> moneyClass, String strValue) {
		String[] components = strValue.split(" ");
		return new Money(new BigDecimal(components[0]), Currency.valueOf(components[1]));
	}

}
