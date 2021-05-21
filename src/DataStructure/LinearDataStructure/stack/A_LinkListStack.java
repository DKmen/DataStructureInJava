package DataStructure.LinearDataStructure.stack;

import DataStructure.LinearDataStructure.list.A_LinkList;

public class A_LinkListStack {
    private final A_LinkList stackLinkList=new A_LinkList();
    private int totalElement=0;

    //add element on stack
    public void push(int data){
        stackLinkList.addDataEnd(data);
        totalElement++;
    }

    //delete element on stack
    public void pop(){
        if(totalElement>=1) {
            stackLinkList.deleteDataAt(totalElement);
            totalElement--;
        }
    }

    //get peek element
    public int peek(){
        if(totalElement>=1) return stackLinkList.endElement();
        return Integer.MAX_VALUE;
    }

    //stack is empty or not
    public Boolean isEmpty(){
        if(totalElement==0) return true;
        else return false;
    }

    //print stack
    public void printStack(){
        stackLinkList.printLinkList();
    }
}
