package DataStructure.LinearDataStructure.stack;

public class tested {
    public static void main(String[] arr){
//        A_LinkListStack stack=new A_LinkListStack();
//
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.printStack();
//        stack.pop();
//        stack.printStack();
//        System.out.println(stack.peek());
//        B_ArrayListStack stackArray=new B_ArrayListStack(10);
//        stackArray.push(2);
//        stackArray.push(5);
//        stackArray.push(10);
//        stackArray.push(20);
//        stackArray.printStack();
//        stackArray.pop();
//        stackArray.pop();
//        stackArray.printStack();

        C_InfixToPostfix exp=new C_InfixToPostfix();
        String result=exp.infixToPostfix("1+2*(3^4-5)^(6+7*8)-9");
        System.out.println(result);
        System.out.println(exp.evolutationPostfix(result));
    }
}
