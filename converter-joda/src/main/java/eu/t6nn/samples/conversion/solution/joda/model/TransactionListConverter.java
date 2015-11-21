package eu.t6nn.samples.conversion.solution.joda.model;

import java.util.Arrays;
import java.util.Iterator;

import javax.inject.Inject;

import org.joda.convert.StringConverter;

import eu.t6nn.samples.conversion.model.Money;
import eu.t6nn.samples.conversion.model.TransactionList;

public class TransactionListConverter implements StringConverter<TransactionList> {

	private final MoneyConverter moneyConverter;

	@Inject
	public TransactionListConverter(MoneyConverter moneyConverter) {
		this.moneyConverter = moneyConverter;
	}

	@Override
	public String convertToString(TransactionList transactions) {
		StringBuilder result = new StringBuilder();
		Iterator<Money> it = transactions.iterator();
		while (it.hasNext()) {
			result.append(moneyConverter.convertToString(it.next()));
			if (it.hasNext()) {
				result.append(",");
			}
		}
		return result.toString();
	}

	@Override
	public TransactionList convertFromString(Class<? extends TransactionList> paramClass, String paramString) {
		TransactionList list = new TransactionList();
		Arrays.stream(paramString.split(",")).map(s -> moneyConverter.convertFromString(Money.class, s))
				.forEach(list::add);
		return list;
	}

}
