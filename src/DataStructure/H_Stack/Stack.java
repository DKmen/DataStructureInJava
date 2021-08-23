package DataStructure.H_Stack;

public class Stack {
    private int[] array;
    private int top=-1;

    public Stack(int size){
        array=new int[size];
    }

    public void push(int data){
        if(top<(array.length-1)){
            top++;
            array[top]=data;
        }
    }

    public int pop(){
        if(top>=0){
            int data=array[top];
            array[top]=Integer.MIN_VALUE;
            top--;
            return data;
        }
        return Integer.MIN_VALUE;
    }

    public int peek(){
        if(top!=-1) return array[top];
        return Integer.MIN_VALUE;
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public void display(){
        for (int i=0;i<=top;i++) System.out.print(array[i]+" ");
        System.out.println();
    }

    public static void main(String[] arr){
        Stack stack=new Stack(2);
        stack.push(2);
        stack.push(4);
        stack.push(6);
        stack.display();
        stack.pop();
        stack.display();
    }
}
