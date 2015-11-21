package eu.t6nn.samples.conversion.solution.joda;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.joda.convert.StringConvert;
import org.joda.convert.StringConverter;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.multibindings.Multibinder;

import eu.t6nn.samples.conversion.problem.spi.ObjectConverterFactory;
import eu.t6nn.samples.conversion.solution.joda.model.ModelConvertersModule;

public class JodaModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new ModelConvertersModule());

		configureFactory();
	}

	@Provides
	@Inject
	@Singleton
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public StringConvert provideStringConvert(Map<Class, StringConverter> converters) {
		StringConvert convert = new StringConvert();
		converters.forEach((k, v) -> convert.register(k, v));
		return convert;
	}

	private void configureFactory() {
		Multibinder<ObjectConverterFactory> binder = Multibinder.newSetBinder(binder(), ObjectConverterFactory.class);
		binder.addBinding().to(JodaConverterFactory.class);
	}

}
