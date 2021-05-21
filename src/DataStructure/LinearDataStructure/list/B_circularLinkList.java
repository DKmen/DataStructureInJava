package DataStructure.LinearDataStructure.list;


public class B_circularLinkList {
    private Node head=null;

    //Insert Data Into circular list
    public void insertDataAtFront(int data){
        Node newNode=new Node(data);
        Node iterable=head;

        if(head==null){
            head=newNode;
            newNode.setNode(newNode);
            return;
        }

        while (iterable.getNext()!=head) iterable=iterable.getNext();
        iterable.setNode(newNode);
        newNode.setNode(head);
        head=newNode;
    }

    public void insertDataAtEnd(int data){
        Node newNode=new Node(data);
        Node iterable=head;

        if(head==null){
            head=newNode;
            newNode.setNode(newNode);
            return;
        }

        while (iterable.getNext()!=head) iterable=iterable.getNext();
        iterable.setNode(newNode);
        newNode.setNode(head);
    }

    public void insertDataIntoSortedList(int data){
        Node newNode=new Node(data);
        Node iterable=head;

        if(head==null){
            head=newNode;
            newNode.setNode(newNode);
        }else if(iterable.getData()>data){
            insertDataAtFront(data);
        }else{
            while (iterable.getNext()!=head && iterable.getNext().getData()<data){
                iterable=iterable.getNext();
            }
            newNode.setNode(iterable.getNext());
            iterable.setNode(newNode);
        }
    }
}
