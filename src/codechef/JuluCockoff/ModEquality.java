package codechef.JuluCockoff;

import java.util.Scanner;

public class ModEquality {
    public static void main(String[] arr){
        Scanner sc = new Scanner(System.in);
        int testCase=sc.nextInt();
        while(testCase-->0){

            int totalElementCount= sc.nextInt();
            long minElement=Long.MAX_VALUE;
            long[] elementArray=new long[totalElementCount];

            for(int i=0;i<totalElementCount;i++){
                long input=sc.nextLong();
                minElement = Math.min(input,minElement);
                elementArray[i]=input;
            }

            long totalStep=0;
            boolean flag=false;
            for(int i=0;i<totalElementCount;i++){
                if(elementArray[i]==minElement) continue;
                long processElement=(elementArray[i])%(elementArray[i]-minElement);

                if(processElement==minElement){
                    totalStep++;
                }else {
                    flag=true;
                    break;
                }
            }

            if(flag) System.out.println(totalElementCount);
            else System.out.println(totalStep);
        }
    }
}
