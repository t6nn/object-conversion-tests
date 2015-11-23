package eu.t6nn.samples.conversion.problem;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import eu.t6nn.samples.conversion.problem.spi.ObjectConverterFactory;

class TestSuite {
	
	private final ObjectConverterFactory factory;
	private final List<TestCase<?>> testCases = new ArrayList<>();
	
	public TestSuite(ObjectConverterFactory factory) {
		this.factory = factory;
	}
	
	public void runAndReport() {
		System.out.println("Factory: " + factory.toString());
		System.out.println(StringUtils.repeat('-', 9 + factory.toString().length()));
		
		testCases.forEach(TestCase::run);
	}
	
	public <TSource> void addTestCase(String name, TSource fromValue, Class<? super TSource> fromClass, Class<?> toClass) {
		testCases.add(new TestCase<>(name, fromValue, fromClass, toClass));
	}
	
	private class TestCase<TSource> {
		
		private final String name;
		private final TSource fromValue;
		private final Class<? super TSource> fromClass;
		private final Class<?> toClass;
		
		public TestCase(String name, TSource fromValue, Class<? super TSource> fromClass, Class<?> toClass) {
			this.name = name;
			this.fromValue = fromValue;
			this.fromClass = fromClass;
			this.toClass = toClass;
		}
		
		void run() {
			try {
				Object result = factory.getConverter(fromClass, toClass).convert(fromValue);
				printResult(System.out, "[SUCCESS] (" + result + ")");
			} catch (RuntimeException e) {
				printResult(System.err, "[FAILURE] (" + e.getMessage() + ")");
			}
		}
		
		private void printResult(PrintStream stream, String result) {
			stream.print(name + ": ");
			stream.print(result);
			stream.println();
		}

	}
}