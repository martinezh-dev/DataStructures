public class StackClient
{
    public static void main(String[] args)
    {
        Stack<String> myStack = new Stack<String>();

        myStack.push("Stack");
        myStack.push("a");
        myStack.push("is");
        myStack.push("This");

        System.out.println(myStack);
        System.out.println("Popped Value: " + myStack.pop());
        System.out.println(myStack);

        System.out.println("\nCrating copy stack");
        Stack<String> newStack = new Stack<String>(myStack);
        System.out.println("myStack: " + myStack);
        System.out.println("newStack: " + myStack);
        System.out.println("Popping from new stack");
        newStack.pop();
        System.out.println("myStack: " + myStack);
        System.out.println("newStack: " + newStack);

        System.out.println("Unicode value of ( " + "(".compareTo("!"));
        System.out.println("Unicode value of ) " + ")".compareTo("!"));
        System.out.println("Unicode value of { " + "{".compareTo("!"));
        System.out.println("Unicode value of } " + "}".compareTo("!"));
        System.out.println("Unicode value of [ " + "[".compareTo("!"));
        System.out.println("Unicode value of ] " + "]".compareTo("!"));

        String test = "String(test[2])";

        System.out.println("\nc[d]: " + checkValidEnclosures("c[d]"));
        System.out.println("a{b[c]d}e: " + checkValidEnclosures("a{b[c]d}e"));
        System.out.println("a{b(c]d}e: " + checkValidEnclosures("a{b(c]d}e"));
        System.out.println("a[b{c}d]e}: " + checkValidEnclosures(("a[b{c}d]e}")));
        System.out.println("a{b(c): " + checkValidEnclosures("a{b(c)" ));

        System.out.println(checkValidEnclosures(test));

        System.out.println("\nTesting postfix conversion");
        //System.out.println("Converting A+B*C/D-E: " + switchOrder("A+B*C/D-E"));
        //System.out.println("(A+B*(C-D))/E: " + switchOrder("(A+B*(C-D))/E"));
        //System.out.println("2^3: " + switchOrder("2^3"));

        System.out.println("\nTesting postfix evaluation");
        //System.out.println("5 9 3 + 4 2 * * 7 + *: " + evaluate("593+42**7+*"));
        System.out.println("8/2: " + evaluate(switchOrder("8/2")));
    }

    public static boolean checkValidEnclosures(String input)
    {
        Stack<Character> temp = new Stack<Character>();

        for(int i = 0; i < input.length(); i++)
        {
            char cur = input.charAt(i);
            if(cur == '{' || cur == '(' || cur == '[')
            {
                temp.push(cur);
            }
            if(cur == '}' || cur == ']')
            {
                if(temp.isEmpty() || temp.peek().compareTo(cur) != -2)
                {
                    return false;
                }
                temp.pop();
            }
            else if(cur == ')')
            {
                if(temp.isEmpty() || temp.peek().compareTo(cur) != -1)
                {
                    return false;
                }
                temp.pop();
            }
        }
        return(temp.isEmpty());
    }

    public static String switchOrder(String input)
    {
        String ret = "";
        Stack<Character> stack = new Stack<Character>();

        //Iterate through input string
        for(int i = 0; i < input.length(); i++)
        {
            char cur = input.charAt(i);

            //If an operator is scanned
            if(cur == '+' || cur == '-' || cur == '*' || cur == '/' || cur == '^')
            {
                Stack<Character> temp = new Stack<Character>();
                char tChar = (char)0;

                //If it is high precidence, put in all high precidence operators from stack
                //and put the new operator on
                if(cur == '^')
                {
                    tChar = (stack.isEmpty()) ? (char)0: stack.pop();
                    if(tChar == '(')
                    {
                        stack.push(tChar);
                    }
                    //search till end or left parenthesis
                    while(tChar != (char)0 && tChar != '(')
                    {
                        if(tChar == '^')
                        {
                            ret += tChar;
                        }
                        else if(tChar == '+' || tChar == '-' || tChar == '*' || tChar == '/' || tChar == '(')
                        {
                            temp.push(tChar);
                        }
                        tChar = (stack.isEmpty()) ? (char)0: stack.pop();
                    }
                    if(tChar == '(')
                    {
                        stack.push(tChar);
                    }

                    //Place removed, unused elements back in place
                    while(!temp.isEmpty())
                    {
                        stack.push(temp.pop());
                    }
                }
                else if(cur == '*' || cur == '/')
                {
                    //System.out.println(cur);
                    tChar = (stack.isEmpty()) ? (char)0: stack.pop();
                    if(tChar == '(')
                    {
                        stack.push(tChar);
                    }
                    //search till end or left parenthesis
                    while(tChar != (char)0 && tChar != '(')
                    {
                        if(tChar == '*' || tChar == '/' || tChar == '^')
                        {
                            ret += tChar;
                        }
                        else if(tChar == '+' || tChar == '-' || tChar == '(')
                        {
                            temp.push(tChar);
                        }
                        tChar = (stack.isEmpty()) ? (char)0: stack.pop();
                    }
                    if(tChar == '(')
                    {
                        stack.push(tChar);
                    }

                    //Place removed, unused elements back in place
                    while(!temp.isEmpty())
                    {
                        stack.push(temp.pop());
                    }
                }
                //If the operator is low precedence, put everything into ret
                else
                {
                    tChar = (stack.isEmpty()) ? (char)0: stack.pop();
                    if(tChar == '(')
                    {
                        stack.push(tChar);
                    }
                    //go through stack till end or left parenthesis
                    while(tChar != (char)0 && tChar != '(')
                    {
                        ret += tChar;
                        tChar = (stack.isEmpty()) ? (char)0: stack.pop();
                    }
                    if(tChar == '(')
                    {
                        stack.push(tChar);
                    }
                }
                //put current operator on the stack
                stack.push(cur);
            }
            //Automatically push a left parenthesis
            else if (cur == '(') {
                stack.push(cur);
            }
            //Clear out the stack if a close parenthesis is found
            else if(cur == ')')
            {
                char tChar = (stack.isEmpty()) ? (char)0: stack.pop();
                while(!stack.isEmpty() && tChar != '(')
                {
                    ret += tChar;
                    tChar = stack.pop();
                }
                //Take out the last left parenthesis
                stack.pop();
            }
            //Automatically push in remaining operands
            else
            {
                ret += cur;
            }
            System.out.println(stack);
        }
        //put everything else on the stack
        while(!stack.isEmpty())
        {
            ret += stack.pop();
        }
        
        return ret;
    }

    public static double evaluate(String postfix)
    {
        Stack<Double> stack = new Stack<Double>();
        for(int i = 0; i < postfix.length(); i++)
        {
            char cur = postfix.charAt(i);
            if(cur == '+' || cur == '-' || cur == '*' || cur == '/' || cur == '^')
            {
                double a = stack.pop();
                double b = stack.pop();
                if(cur == '+')
                {
                    stack.push(b + a);
                }
                if(cur == '-')
                {
                    stack.push(b - a);
                }
                if(cur == '*')
                {
                    stack.push(b * a);
                }
                if(cur == '/')
                {
                    stack.push(b/a);
                }
                if(cur == '^')
                {
                    stack.push(Math.pow(b, a));
                }
            }
            else
            {
                stack.push((double)cur - 48);
            }
        }
        return stack.pop();
    }
}