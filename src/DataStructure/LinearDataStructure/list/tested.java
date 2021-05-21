package DataStructure.LinearDataStructure.list;

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
//        A_LinkList ListA=new A_LinkList();
//        ListA.addDataEnd(10);
//        ListA.addDataEnd(1);
//        ListA.addDataEnd(3);
//        ListA.addDataEnd(2);
//        ListA.addDataEnd(40);
//        ListA.addDataEnd(20);
//        ListA.addDataEnd(11);
//        ListA.printLinkList();
//        ListA.sort();
//        ListA.printLinkList();
//        ListA.reverseListGroup(3);
//        ListA.printLinkList();
//        ListA.makeLoopInList(2);
//        System.out.println(ListA.detectedLoopInList());
//        ListA.deleteLoopInList();
//        ListA.printLinkList();
//        ListA.rotatedLinkList(4);
//        ListA.printLinkList();

//        B_circularLinkList Ac=new B_circularLinkList();
//        B_circularLinkList Bc=new B_circularLinkList();
//        B_circularLinkList Cc=new B_circularLinkList();
//
//        Ac.insertDataAtEnd(1);
//        Ac.insertDataAtEnd(2);
//        Ac.insertDataAtEnd(3);
//        Ac.insertDataAtEnd(5);
//        Ac.insertDataAtEnd(7);
//        Ac.insertDataAtEnd(11);
//        Ac.insertDataAtEnd(20);
//        Ac.insertDataAtEnd(21);
//        Ac.printList();
//
//        Ac.splitCircularList(Bc,Cc);
//        Bc.printList();
//        Cc.printList();

        C_DoublyLinkList Ad=new C_DoublyLinkList();
        Ad.insertDataAtEnd(1);
        Ad.insertDataAtEnd(20);
        Ad.insertDataAtEnd(4);
        Ad.insertDataAtEnd(50);
        Ad.insertDataAtEnd(6);
        Ad.insertDataAtEnd(7);
        Ad.printList();
        Ad.insertDataAtPosition(3,1);
        Ad.printList();
        Ad.deleteNode(1);
        Ad.printList();
        Ad.deleteNode(6);
        Ad.printList();
//        Ad.reverseList();
//        Ad.printList();
        Ad.sort();
        Ad.printList();
    }
}