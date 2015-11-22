package eu.t6nn.samples.conversion.solution.spring.model;

import org.springframework.core.convert.converter.Converter;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

public class ModelConvertersModule extends AbstractModule {

	@Override
	protected void configure() {
		configureConverters();
	}
	
	@SuppressWarnings("rawtypes")
	private void configureConverters() {
		Multibinder<Converter> binder = Multibinder.newSetBinder(binder(), Converter.class);
		
		binder.addBinding().to(MoneyToString.class);
		binder.addBinding().to(StringToMoney.class);
		binder.addBinding().to(MoneyToTransactionList.class);
		binder.addBinding().to(StringToTransactionList.class);
		binder.addBinding().to(TransactionListToString.class);
		binder.addBinding().to(MoneyToBigDecimal.class);
	}

}
