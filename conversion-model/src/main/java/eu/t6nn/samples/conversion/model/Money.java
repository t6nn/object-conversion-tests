package eu.t6nn.samples.conversion.model;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Money {
	
	private final BigDecimal amount;
	private final Currency currency;
	
	public Money(BigDecimal amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public Currency getCurrency() {
		return currency;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("amt", amount).append("cur", currency).build();
	}
	
}
