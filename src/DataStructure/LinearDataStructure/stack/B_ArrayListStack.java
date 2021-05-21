package DataStructure.LinearDataStructure.stack;

public class B_ArrayListStack {
    private final int[] Array;
    private int currentIndex=-1;
    private final int size;

    public B_ArrayListStack(int data){
        this.Array=new int[data];
        this.size=data;
    }

    //push data into stack
    public void push(int data){
        if(currentIndex==size-1) return;
        currentIndex++;
        Array[currentIndex]=data;
    }

    //delete from stack
    public int pop(){
        if(currentIndex>=0){
            int result=Array[currentIndex];
            currentIndex--;
            return result;
        }
        return Integer.MIN_VALUE;
    }

    //get peek element
    public int peek(){
        if(currentIndex>=0) return Array[currentIndex];
        return Integer.MIN_VALUE;
    }

    //empty or not
    public boolean isEmpty(){
        if(currentIndex==-1) return true;
        return false;
    }

    //print stack
    public void printStack(){
        for (int i=0;i<=currentIndex;i++) System.out.print(Array[i]+"  ");
        System.out.println();
    }
}
