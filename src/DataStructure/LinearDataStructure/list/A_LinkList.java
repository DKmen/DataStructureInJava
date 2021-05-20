package DataStructure.LinearDataStructure.list;

//Points of LinkList

/*

A linked list is represented by a pointer to the first node of the linked
list. The first node is called the head. If the linked list is empty, then
the value of the head is NULL.
Each node in a list consists of at least two parts:
1) data
2) Pointer (Or Reference) to the next node

*/
class Node{
    private final int data;
    private Node next=null;

    public Node(int data){
        this.data=data;
    }

    public void setNode(Node next){
        this.next=next;
    }

    public Node getNext(){
        return next;
    }

    public int getData(){
        return data;
    }
}

public class A_LinkList {

    private Node head=null;

    //setAndGet Head
    public Node getHead(){
        return head;
    }
    private void setHead(Node head){
        this.head=head;
    }

    //Add data front of link list
    public void addDataFront(int data){
        Node newNode=new Node(data);
        if(head==null) {
            head=newNode;
            return;
        }
        newNode.setNode(head);
        head=newNode;
    }

    //Add data after given node
    public void addDataAfter(int previousData,int data){
        Node temp=head;
        Node newNode=new Node(data);

        while (temp.getNext()!=null && temp.getData()!=previousData){
            temp=temp.getNext();
        }

        if(temp.getData()!=previousData) return;

        newNode.setNode(temp.getNext());
        temp.setNode(newNode);
    }

    //Add data end of link list
    public void addDataEnd(int data){
        Node newNode=new Node(data);
        Node temp=head;

        if(temp==null){
            head=newNode;
            return;
        }

        while (temp.getNext()!=null) temp=temp.getNext();
        temp.setNode(newNode);
    }

    //delete data from link list
    public void deleteData(int key){
        Node previous=null;
        Node iterable=head;

        if(iterable==null) return;

        if(iterable.getData()==key){
            head=head.getNext();
            return;
        }

        while (iterable!=null && iterable.getData()!=key){
            previous=iterable;
            iterable=iterable.getNext();
        }

        if(iterable==null) return;
        assert previous != null;
        previous.setNode(iterable.getNext());
    }

    //delete data at given position from link list
    //index is 1 base
    public void deleteDataAt(int index){
        int indexCount=1;
        Node iterable=head;
        Node previous=null;

        if(iterable==null) return;

        if(index==1){
            head=head.getNext();
            return;
        }

        while (iterable.getNext()!=null && indexCount<index){
            indexCount++;
            previous=iterable;
            iterable=iterable.getNext();
        }

        if(indexCount!=index) return;
        previous.setNode(iterable.getNext());

    }

    //get length of link list
    public int length(){
        int count=0;
        Node iterable=head;

        while (iterable!=null){
            count++;
            iterable=iterable.getNext();
        }

        return count;
    }

    //swap two node of link list
    public void swap(int x,int y){
        if(x==y) return;
        Node previousX=null;
        Node iterableX=head;
        Node previousY=null;
        Node iterableY=head;

        if(head==null) return;

        while (iterableX!=null && iterableX.getData()!=x){
            previousX=iterableX;
            iterableX=iterableX.getNext();
        }

        if(iterableX==null) return;

        while (iterableY!=null && iterableY.getData()!=y){
            previousY=iterableY;
            iterableY=iterableY.getNext();
        }

        if(iterableY==null) return;

        if(previousX!=null) previousX.setNode(iterableY);
        else head=iterableY;
        if(previousY!=null) previousY.setNode(iterableX);
        else head=iterableX;

        Node temp=iterableX.getNext();
        iterableX.setNode(iterableY.getNext());
        iterableY.setNode(temp);
    }

    //reverse link list by iterative method
    public void reverse(){
        Node current=head;
        Node previous=null;
        Node next;

        while (current!=null){
            next=current.getNext();
            current.setNode(previous);
            previous=current;
            current=next;
        }

        head=previous;
    }

    //reverse link list by recursive method
    private static Node callForReverse(Node head){

        if(head==null || head.getNext()==null) return head;
        Node newHead= callForReverse(head.getNext());

        head.getNext().setNode(head);
        head.setNode(null);

        return newHead;
    }
    public void reverseRecursive(){
        head= callForReverse(head);
    }



    //mergeSort for link list
    private static Node mergeTwoSortedListRecursiveMethod(Node ListA,Node ListB){
        if(ListA==null) return ListB;
        else if(ListB==null) return ListA;
        else if(ListA.getData()>ListB.getData()){
            ListB.setNode(mergeTwoSortedListRecursiveMethod(ListA,ListB.getNext()));
            return ListB;
        }else {
            ListA.setNode(mergeTwoSortedListRecursiveMethod(ListA.getNext(),ListB));
            return ListA;
        }
    }
    private static Node mergeTwoSortedListIterativeMethod(Node ListA,Node ListB){
        Node result=new Node(-1);
        Node iterative=result;
        while (true){
            if(ListA==null){
                iterative.setNode(ListB);
                break;
            }else if(ListB==null){
                iterative.setNode(ListA);
                break;
            }else if(ListA.getData()>ListB.getData()){
                iterative.setNode(new Node(ListB.getData()));
                iterative=iterative.getNext();
                ListB=ListB.getNext();
            }else {
                iterative.setNode(new Node(ListA.getData()));
                iterative=iterative.getNext();
                ListA=ListA.getNext();
            }
        }
        return result.getNext();
    }
    private Node middleNode(Node head){
        Node fastJumpNode=head;
        Node slowJumpNode=head;

        if(head==null) return head;

        while (fastJumpNode.getNext()!=null && fastJumpNode.getNext().getNext()!=null){
            slowJumpNode=slowJumpNode.getNext();
            fastJumpNode=fastJumpNode.getNext().getNext();
        }
        return slowJumpNode;
    }
    private Node mergeSort(Node head){
        Node left=head;
        if(head==null||head.getNext()==null) return head;

        Node middleNode=middleNode(head);
        Node right=middleNode.getNext();
        middleNode.setNode(null);

        left=mergeSort(left);
        right=mergeSort(right);

        return mergeTwoSortedListRecursiveMethod(left,right);
    }
    public void sort(){
        setHead(mergeSort(head));
    }


    //reverse link list by group size
    private static Node reverseListUsingGroupSizeFunction(int groupSize,Node head){
        Node previous=null;
        Node current=head;
        Node next=null;

        if(head==null || head.getNext()==null) return head;

        int countIndex=0;

        while (current!=null && countIndex<groupSize){
            next=current.getNext();
            current.setNode(previous);
            previous=current;
            current=next;
            countIndex++;
        }

        if(next!=null) head.setNode(reverseListUsingGroupSizeFunction(groupSize,next));
        return previous;
    }
    public void reverseListGroup(int GroupSize){
        head=reverseListUsingGroupSizeFunction(GroupSize,head);
    }

    //Detection and Remove loop in link list
    public Boolean detectedLoopInList(){
        Node slowJumpNode=head;
        Node fastJumpNode=head;

        while (fastJumpNode!=null && fastJumpNode.getNext()!=null){
            fastJumpNode=fastJumpNode.getNext().getNext();
            slowJumpNode=slowJumpNode.getNext();

            if(fastJumpNode==slowJumpNode) return true;
        }
        return false;
    }
    public void makeLoopInList(int position){
        int countIndex=1;
        Node iterative=head;
        Node loopNode=null;

        while (iterative.getNext()!=null){
            if(countIndex==position){
                loopNode=iterative;
            }
            countIndex++;
            iterative=iterative.getNext();
        }
        iterative.setNode(loopNode);
    }
    public void deleteLoopInList(){
        if(detectedLoopInList()){
            Node slowJumpNode=head;
            Node fastJumpNode=head;

            while (fastJumpNode!=null && fastJumpNode.getNext()!=null){
                fastJumpNode=fastJumpNode.getNext().getNext();
                slowJumpNode=slowJumpNode.getNext();

                if(fastJumpNode==slowJumpNode) break;
            }

            fastJumpNode=head;

            while (fastJumpNode.getNext()!=slowJumpNode.getNext()){
                fastJumpNode=fastJumpNode.getNext();
                slowJumpNode=slowJumpNode.getNext();
            }
            slowJumpNode.setNode(null);
        }
    }

    //rotated a link list
    public void rotatedLinkList(int kthNodeIndex){
        int countIndex=1;
        Node iterative=head;
        Node kthNode=head;

        while (iterative.getNext()!=null){
            if(countIndex==kthNodeIndex){
                kthNode=iterative;
            }
            countIndex++;
            iterative=iterative.getNext();
        }

        if(kthNode.getNext()!=null){
            Node newHead=kthNode.getNext();
            kthNode.setNode(null);
            iterative.setNode(head);
            head=newHead;
        }
    }

    //print element of link list
    public void printLinkList(){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.getData()+" -> ");
            temp=temp.getNext();
        }
        System.out.print("NULL");
        System.out.println();
    }
}


class tested {
    public static void main(String[] arr){
//        A_LinkList LinkList=new A_LinkList();
//        LinkList.addDataFront(1);
//        LinkList.addDataFront(2);
//        LinkList.addDataFront(3);
//        LinkList.printLinkList();
//        LinkList.addDataEnd(4);
//        LinkList.addDataAfter(1,55);
//        LinkList.printLinkList();
//        LinkList.deleteData(3);
//        LinkList.printLinkList();
//        LinkList.deleteDataAt(1);
//        LinkList.printLinkList();
//        System.out.println(LinkList.length());
//        LinkList.swap(55,1);
//        LinkList.printLinkList();
//        LinkList.reverse();
//        LinkList.printLinkList();
//        LinkList.reverseRecursive();
//        LinkList.printLinkList();
        A_LinkList ListA=new A_LinkList();
        ListA.addDataEnd(10);
        ListA.addDataEnd(1);
        ListA.addDataEnd(3);
        ListA.addDataEnd(2);
        ListA.addDataEnd(40);
        ListA.addDataEnd(20);
        ListA.addDataEnd(11);
        ListA.printLinkList();
        ListA.sort();
        ListA.printLinkList();
        ListA.reverseListGroup(3);
        ListA.printLinkList();
        ListA.makeLoopInList(2);
        System.out.println(ListA.detectedLoopInList());
        ListA.deleteLoopInList();
        ListA.printLinkList();
        ListA.rotatedLinkList(4);
        ListA.printLinkList();
    }
}