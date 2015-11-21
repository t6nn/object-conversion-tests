package eu.t6nn.samples.conversion.solution.joda.model;

import org.joda.convert.StringConverter;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

import eu.t6nn.samples.conversion.model.Money;
import eu.t6nn.samples.conversion.model.TransactionList;

public class ModelConvertersModule extends AbstractModule {

	@Override
	protected void configure() {
		configureConverters();
	}
	
	@SuppressWarnings("rawtypes")
	private void configureConverters() {
		MapBinder<Class, StringConverter> binder = MapBinder.newMapBinder(binder(), Class.class, StringConverter.class);
		
		binder.addBinding(Money.class).to(MoneyConverter.class);
		binder.addBinding(TransactionList.class).to(TransactionListConverter.class);
	}

}
