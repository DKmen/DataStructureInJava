package codechef.December2021.codeDrive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumFactorsProblem {
    public static void main(String[] arr){
        try{
            FastReader sc = new FastReader();
            int t=sc.nextInt();
            while (t--!=0){
                int inputNumber=sc.nextInt();
                int maxPowerOfPrimeNumbers = 0;
                int minPf=0;
                for(int i=2;i*i<=inputNumber;i++){
                    if(inputNumber%i==0){
                        int power=0;
                        while (inputNumber%i==0){
                            inputNumber/=i;
                            power++;
                        }
                        if(power>maxPowerOfPrimeNumbers){
                            maxPowerOfPrimeNumbers=power;
                            minPf=i;
                        }
                    }
                }
                if(maxPowerOfPrimeNumbers==0) minPf=inputNumber;
                System.out.println(minPf);
            }
        }catch (Exception ignored){

        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
