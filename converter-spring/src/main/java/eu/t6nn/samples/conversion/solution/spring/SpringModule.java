package eu.t6nn.samples.conversion.solution.spring;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.multibindings.Multibinder;

import eu.t6nn.samples.conversion.problem.spi.ObjectConverterFactory;
import eu.t6nn.samples.conversion.solution.spring.model.ModelConvertersModule;

public class SpringModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new ModelConvertersModule());

		configureFactory();
	}

	private void configureFactory() {
		Multibinder<ObjectConverterFactory> binder = Multibinder.newSetBinder(binder(), ObjectConverterFactory.class);
		binder.addBinding().to(SpringConverterFactory.class);
	}

	@Provides
	@Inject
	@Singleton
	public ConversionService provideConversionService(@SuppressWarnings("rawtypes") Set<Converter> converters) {
		DefaultConversionService service = new DefaultConversionService();
		converters.forEach(c -> service.addConverter(c));
		return service;
	}

}
