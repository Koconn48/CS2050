//Name: Kevin O'Connell
//Assignment: Program #5: The Easy Way

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class Program5 {
    public static String InfixToPostfix(String s) {
        //initialize StringBuilder for postfix expressions
        StringBuilder postfix = new StringBuilder();
        //stack for operators during conversion
        Stack<Character> operatorStack = new Stack<>();

        //loop over each character of the infix expression
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) || c == '.') {
                postfix.append(c);
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop());
                }
                if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                    operatorStack.pop();
                } else {
                    return "unmatched parens";
                }
            } else if (isOperator(c)) {
                while (!operatorStack.isEmpty() && getPrecedence(c) <= getPrecedence(operatorStack.peek())) {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.push(c);
            } else {
                return "invalid character";
            }
        }
        //pop remaining operators from stack and append to postfix expression
        while (!operatorStack.isEmpty()) {
            if (operatorStack.peek() == '(') {
                return "unmatched parens";
            }
            postfix.append(operatorStack.pop());
        }
        return postfix.toString(); //return the postfix expression
    }

    //utility method to check if a character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';}
    //precedence of an operator
    private static int getPrecedence(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/', '%' -> 2;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        try {
            //open a file for reading (Program3.txt) and another for writing (Program5.out)
            BufferedReader br = new BufferedReader(new FileReader("Program3.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("Program5.out"));

            String line;
            while ((line = br.readLine()) != null) {
                String infixExpression = line.trim();

                //check for invalid characters in the infix expression
                if (!isValidExpression(infixExpression)) {
                    bw.write(infixExpression + " ---> invalid character");
                    bw.newLine();
                    continue;
                    //skip processing this and go to the next one
                }
                //convert it to postfix using the InfixToPostfix method
                String postfixExpression = InfixToPostfix(infixExpression);

                if (postfixExpression.equals("unmatched parens")) {
                    bw.write(infixExpression + " ---> unmatched parens");
                    bw.newLine();
                } else {
                    //if successful -> write both expressions side by side
                    bw.write(infixExpression + " ---> " + postfixExpression);
                    bw.newLine();
                }
            }
            //close files
            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //utility method for finding invalid characters in expression
    private static boolean isValidExpression(String expression) {
        String allowedCharacters = "0123456789.()+-*/%";
        for (char c : expression.toCharArray()) {
            if (allowedCharacters.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }
}
