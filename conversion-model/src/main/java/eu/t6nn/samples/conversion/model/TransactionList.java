package eu.t6nn.samples.conversion.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


public class TransactionList {
	
	private final List<Money> transactions = new ArrayList<>();
	
	public void add(Money tx) {
		transactions.add(tx);
	}

	public Iterator<Money> iterator() {
		return transactions.iterator();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("tx", transactions).build();
	}

}
