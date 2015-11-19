package eu.t6nn.samples.conversion.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;


public class TransactionList {
	
	private List<Money> transactions = new ArrayList<>();
	
	public void add(Money tx) {
		transactions.add(tx);
	}

	public Iterator<Money> iterator() {
		return transactions.iterator();
	}

}
