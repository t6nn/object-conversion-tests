package eu.t6nn.samples.conversion.solution.spring.model;

import java.util.Iterator;

import javax.inject.Inject;

import org.springframework.core.convert.converter.Converter;

import eu.t6nn.samples.conversion.model.Money;
import eu.t6nn.samples.conversion.model.TransactionList;

public class TransactionListToString implements Converter<TransactionList, String>{

	private final MoneyToString moneyToString;

	@Inject
	TransactionListToString(MoneyToString moneyToString) {
		this.moneyToString = moneyToString;
	}
	
	@Override
	public String convert(TransactionList transactions) {
		StringBuilder result = new StringBuilder();
		Iterator<Money> it = transactions.iterator();
		while (it.hasNext()) {
			result.append(moneyToString.convert(it.next()));
			if (it.hasNext()) {
				result.append(",");
			}
		}
		return result.toString();
	}

	
}
