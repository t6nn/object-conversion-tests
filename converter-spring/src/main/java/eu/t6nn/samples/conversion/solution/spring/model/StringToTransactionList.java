package eu.t6nn.samples.conversion.solution.spring.model;

import java.util.Arrays;

import javax.inject.Inject;

import org.springframework.core.convert.converter.Converter;

import eu.t6nn.samples.conversion.model.TransactionList;

public class StringToTransactionList implements Converter<String, TransactionList> {

	private final StringToMoney stringToMoney;

	@Inject
	StringToTransactionList(StringToMoney stringToMoney) {
		this.stringToMoney = stringToMoney;
	}

	@Override
	public TransactionList convert(String listAsString) {
		TransactionList list = new TransactionList();
		Arrays.stream(listAsString.split(",")).map(s -> stringToMoney.convert(s)).forEach(list::add);
		return list;
	}

}
