package calculator;

import java.util.Arrays;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Operator {

	PLUS("+", (a, b) -> a.doubleValue() + b.doubleValue()),
	MINUS("-", (a, b) -> a.doubleValue() - b.doubleValue()),
	MULTIPLE("*", (a, b) -> a.doubleValue() * b.doubleValue()),
	DIVIDE("/", (a, b) -> a.doubleValue() / b.doubleValue());

	private static Map<String, Operator> operatorMap = Arrays.stream(values())
			.collect(Collectors.toMap(instance -> instance.operator, Function.identity()));

	private String operator;
	private BiFunction<Number, Number, Number> operation;

	Operator(String operator, BiFunction<Number, Number, Number> operation) {
		this.operator = operator;
		this.operation = operation;
	}

	public static Operator getOperator(String operator) {
		if(isNotExistedOperator(operator)){
			throw new IllegalArgumentException(
					String.format("check operation failed, (operation = %s)", operator));
		}
		return operatorMap.get(operator);
	}

	private static boolean isNotExistedOperator(String operator){
		return !operatorMap.containsKey(operator);
	}

	public Number calculate(Number a, Number b) {
		return operation.apply(a, b);
	}
}
