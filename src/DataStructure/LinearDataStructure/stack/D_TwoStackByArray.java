package DataStructure.LinearDataStructure.stack;

public class D_TwoStackByArray {
    private int[] Array;

    public D_TwoStackByArray(int size){
        Array=new int[size];
    }

    int firstPointer=-1;
    int secondPointer=Array.length;

    //space is avable
    private boolean isSpace(){
        if(secondPointer-firstPointer-1!=0) return false;
        return true;
    }
    //add element at first stack
    public void pushFirst(int data){
        if(isSpace()) return;
        firstPointer++;
        Array[firstPointer]=data;
    }
    //add element at second stack
    public void pushSecound(int data){
        if(isSpace()) return;
        secondPointer--;
        Array[secondPointer]=data;
    }
    //remove element at first stack
    public void popFirst(){
        if(firstPointer>=0) firstPointer--;
    }
    //remove element at second stack
    public void popSecond(){
        if(secondPointer<Array.length) secondPointer++;
    }
    //first stack is empty
    public boolean isEmptyFirst(){
        if(firstPointer==-1) return true;
        return false;
    }
    //second stack is empty
    public boolean isEmptySecond(){
        if(secondPointer==Array.length) return true;
        return false;
    }
}
