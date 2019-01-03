import java.util.Stack;

public class ExpressionEvaluation {

    static int evaluateExpression(String expression) {
        String[] splitted = expression.split("");
        Stack<String> operatorStack = new Stack<>();
        Stack<Integer> operandStack = new Stack<>();


        for(String s: splitted) {
            switch (s) {
                case "+":
                case "-":
                case "*":
                    operatorStack.push(s);
                    break;
                case ")":
                    String operator = operatorStack.pop();
                    Integer operand1 = operandStack.pop();
                    Integer operand2 = operandStack.pop();
                    switch (operator){
                        case "+":
                            operandStack.push(operand1 + operand2);
                            break;
                        case "-":
                            operandStack.push(operand1 - operand2);
                            break;
                        case "*":
                            operandStack.push(operand1 * operand2);
                            break;
                    }
                    break;
                case " ":
                case "(":
                    break;
                default:
                    operandStack.push(Integer.valueOf(s));
            }
        }

        return operandStack.pop();
    }

    public static void main(String[] args) {
        String s = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        System.out.println(evaluateExpression(s));
    }
}
