package DataStructure.A_BitManipulation;

//Check given number is power of 2 or not

import java.util.Scanner;

public class NumberIsPowerTwo {
    public static void main(String[] arr){
        Scanner sc= new Scanner(System.in);
        int number=sc.nextInt();
        if(((number&(number-1))==0)&&(number!=0)){
            System.out.println("Number is power of 2");
        }else{
            System.out.println("Number is not power of 2");
        }
    }
}
