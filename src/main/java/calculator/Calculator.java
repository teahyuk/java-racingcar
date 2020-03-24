package calculator;

public class Calculator {
	private static final int FIRST_NUMBER_IDX = 0;
	private static final int FIRST_OPERATOR_IDX = 1;
	private static final int NEXT_NUMBER_IDX_INTERVAL = 2;

	public Number calculate(String expression) {
		checkValidate(expression);
		String[] expressions = parseExpression(expression);

		int lastOperatorIdx = expressions.length - 1;

		Number answer = Double.parseDouble(expressions[FIRST_NUMBER_IDX]);
		for (int i = FIRST_OPERATOR_IDX; i < lastOperatorIdx; i += NEXT_NUMBER_IDX_INTERVAL) {
			int operatorIdx = i + 1;
			answer = calculate(expressions[i], answer, Double.parseDouble(expressions[operatorIdx]));
		}
		return answer;
	}

	private String[] parseExpression(String expression) {
		String[] expressions = expression.split(" ");
		if (expressions.length < 3) {
			throwValidation(expression);
		}
		return expressions;
	}

	private void checkValidate(String expression) {
		if (expression == null || expression.isEmpty()) {
			throwValidation(expression);
		}
	}

	private void throwValidation(String expression) {
		throw new IllegalArgumentException(
				String.format("validation check failed, (expression = %s)", expression));
	}

	private Number calculate(String operation, Number left, Number right) {
		return Operator.getOperator(operation).calculate(left,right);
	}
}
