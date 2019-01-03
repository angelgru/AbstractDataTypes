public class ExpressionValidator {

    static class Stack {

        Node first;

        class Node {
            String value;
            Node next;

            Node(String value) {
                this.value = value;
                next = null;
            }
        }

        boolean isEmpty() {
            return first == null;
        }

        void push(String val) {
            Node newNode = new Node(val);
            newNode.next = first;
            first = newNode;
        }

        String pop() {
            String s = first.value;
            first = first.next;
            return s;
        }
    }

    static boolean validate(String expression) {
        String[] splitted = expression.split("");
        Stack stack = new Stack();
        String tmp;
        for(String s: splitted) {
            switch (s) {
                case "{":
                    stack.push(s);
                    break;
                case "[":
                    stack.push(s);
                    break;
                case "(":
                    stack.push(s);
                    break;
                case ")":
                    tmp = stack.pop();
                    if(!tmp.equals("("))
                        return false;
                    break;
                case "]":
                    tmp = stack.pop();
                    if(!tmp.equals("["))
                        return false;
                    break;
                case "}":
                    tmp = stack.pop();
                    if(!tmp.equals("{"))
                        return false;
                    break;
            }
        }

        if(!stack.isEmpty())
            return false;


        return true;
    }

    public static void main(String[] args) {

        String expression = "{a+[c-d] + (a+4)";
        if(validate(expression)) {
            System.out.println("Expression is valid !");
        } else
            System.out.println("Expression invalid !");

    }

}
