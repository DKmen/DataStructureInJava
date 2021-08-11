package DataStructure.A_BitManipulation;

public class BitManipulation {

    public static int getBit(int number , int position){
        int bitNumber=1<<position;
        return (number&bitNumber)!=0?1:0;
    }

    public static int setBit(int number , int position){
        int bitNumber=1<<position;
        return (number|bitNumber);
    }

    public static int resetBit(int number , int position){
        int bitNumber=~(1<<position);
        return (number&bitNumber);
    }

    public static int updateBit(int number , int position , int value){
        number=resetBit(number,position);
        value=value<<position;
        return number|value;
    }


    public static void main(String[] arr){
        System.out.println(getBit(1,0));
        System.out.println(setBit(2,0));
        System.out.println(resetBit(2,1));
        System.out.println(updateBit(2,0,1));
    }
}
