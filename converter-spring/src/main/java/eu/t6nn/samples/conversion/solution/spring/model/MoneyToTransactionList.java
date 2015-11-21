package eu.t6nn.samples.conversion.solution.spring.model;

import org.springframework.core.convert.converter.Converter;

import eu.t6nn.samples.conversion.model.Money;
import eu.t6nn.samples.conversion.model.TransactionList;

public class MoneyToTransactionList implements Converter<Money, TransactionList> {

	@Override
	public TransactionList convert(Money money) {
		TransactionList list = new TransactionList();
		list.add(money);
		return list;
	}

}
