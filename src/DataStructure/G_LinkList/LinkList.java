package DataStructure.G_LinkList;

class node{
    int data;
    node next;
    public node(int data){
        this.data=data;
        next=null;
    }
}

public class LinkList {
    private node head = null;

    public void insertAtTail(int data){
        node newNode = new node(data);
        node travelingNode = head;

        if(head==null){
            head=newNode;
            return;
        }

        while (travelingNode.next!=null) travelingNode=travelingNode.next;
        travelingNode.next=newNode;

    }

    public void insertAtFront(int data){
        node newNode=new node(data);

        if(head==null){
            head=newNode;
            return;
        }

        newNode.next=head;
        head=newNode;
    }

    public void reverseListUsingIterativeMethod(){
        if(head==null || head.next==null) return;

        node previous=null;
        node current=head;
        node next=head.next;

        while (next!=null){
            current.next=previous;
            previous=current;
            current=next;
            next=next.next;
        }
        current.next=previous;

        head=current;
    }

    private node reverseList(node head){
        if(head==null || head.next==null) return head;

        node newHead=reverseList(head.next);
        head.next.next=head;
        head.next=null;

        return newHead;
    }

    public void reverseListUsingRecursiveMethod(){
        head=reverseList(head);
    }

    private node reverseInode(node head, int k){

        if(head==null || head.next == null) return head;

        int count=0;
        node previous=null;
        node current=head;
        node next;

        while (current!=null && count<k){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
            count++;
        }

        head.next= reverseInode(current,k);

        return previous;
    }

    public void reverseNodeInGroup(int groupSize){
        head= reverseInode(head,groupSize);
    }

    public boolean decatedCycle(){

        if(head==null || head.next==null) return false;

        node fast=head.next.next;
        node slow=head.next;

        while (fast!=null && fast.next!=null){
            if(slow==fast) return true;

            fast=fast.next.next;
            slow=slow.next;
        }

        return false;
    }

    public void makeCycle(int position){
        node cycleOccurNode=head;
        node tailNode=head;
        int index=1;

        while (tailNode.next!=null){
            tailNode=tailNode.next;
            if(index<position) {
                index++;
                cycleOccurNode=cycleOccurNode.next;
            }
        }

        tailNode.next=cycleOccurNode;
    }

    public void removeCycle(){
        if(decatedCycle()){
            node fast=head.next.next;
            node slow=head.next;

            while (fast!=slow){
                fast=fast.next.next;
                slow=slow.next;
            }

            slow=head;
            while (slow.next!=fast.next){
                slow=slow.next;
                fast=fast.next;
            }
            fast.next=null;
        }
    }

    public int length(){
        node temp=head;
        int length=0;

        while (temp!=null){
            temp=temp.next;
            length++;
        }

        return length;
    }

    public void appendLastKnode(int k,LinkList list){
        int listLength = list.length();
        k=k%listLength;
        int counter=listLength-k;

        node iterable=head;
        node newHead=null;
        while (iterable.next!=null){
            if(counter==1){
                node current=iterable;
                iterable=iterable.next;
                current.next=null;
                newHead=iterable;
            }
            iterable=iterable.next;
            counter--;

        }

        iterable.next=head;
        head=newHead;
    }

    public static void makeInterSection(LinkList list1,LinkList list2,int position){
        position=position%list1.length();

        node intersectPoint=list1.head;

        while (intersectPoint!=null && position!=0){
            intersectPoint=intersectPoint.next;
            position--;
        }

        node iterable2=list2.head;
        while (iterable2.next!=null) iterable2=iterable2.next;
        iterable2.next=intersectPoint;
    }

    public static boolean interSectionPointIsOccur(LinkList list1, LinkList list2){
        int firstListLength=list1.length();
        int secondListLength=list2.length();

        node bigList,smallList;
        int iterativeCount;

        if(firstListLength<secondListLength){
            bigList=list2.head;
            smallList=list1.head;
            iterativeCount=secondListLength-firstListLength;
        }else {
            bigList=list1.head;
            smallList=list2.head;
            iterativeCount=firstListLength-secondListLength;
        }

        while (bigList!=null && iterativeCount!=0){
            bigList=bigList.next;
            iterativeCount--;
        }

        while (bigList!=null && smallList!=null){
            if(bigList==smallList) return true;
            bigList=bigList.next;
            smallList=smallList.next;
        }

        return false;
    }

    public void changeEvenToOdd(){
        node odd=head;
        node even=head.next;
        node evenStart=head.next;

        while (true)
        {
            // If there are no more nodes,
            // then connect first node of even
            // list to the last node of odd list
            if (even == null || even.next == null)
            {
                odd.next = evenStart;
                break;
            }

            // Connecting odd nodes
            odd.next = even.next;
            odd = even.next;

            // If there are NO more even nodes
            // after current odd.
            if (odd.next == null)
            {
                even.next = null;
                odd.next = evenStart;
                break;
            }

            // Connecting even nodes
            even.next = odd.next;
            even = odd.next;
        }
    }

    public void display(){
        node travelingNode = head;
        while (travelingNode!=null){
            System.out.print(travelingNode.data+" -> ");
            travelingNode=travelingNode.next;
        }
        System.out.println("null");
    }

    public static void main(String[] arr){
        LinkList list=new LinkList();
        list.insertAtFront(1);
        list.insertAtFront(2);
        list.insertAtFront(3);
        list.insertAtTail(5);
        list.insertAtTail(9);
        list.display();
        list.reverseListUsingIterativeMethod();
        list.display();
        list.reverseListUsingRecursiveMethod();
        list.display();
        list.reverseNodeInGroup(2);
        list.display();
        System.out.println(list.decatedCycle());
        list.makeCycle(3);
        System.out.println(list.decatedCycle());
        list.removeCycle();
        System.out.println(list.decatedCycle());
        list.appendLastKnode(3,list);
        list.display();

        LinkList list1=new LinkList();
        list1.insertAtTail(1);
        list1.insertAtTail(2);
        list1.insertAtTail(5);
        list1.insertAtTail(6);
        list1.insertAtTail(7);
        list1.insertAtTail(8);

        LinkList list2=new LinkList();
        list2.insertAtTail(2);
        list2.insertAtTail(8);

        System.out.println(interSectionPointIsOccur(list1,list2));
        makeInterSection(list1,list2,3);
        System.out.println(interSectionPointIsOccur(list1,list2));

        list.changeEvenToOdd();
        list.display();
    }
}
