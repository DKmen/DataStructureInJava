package DataStructure.D_Recursion;

// move all X to last of string

public class MovingXtoLast {

    public static String moveAllXtoLast(String str){
        if(str.length()==0) return str;

        String restOfString=moveAllXtoLast(str.substring(1));

        if(str.charAt(0)=='X') return restOfString+str.charAt(0);
        else return str.charAt(0)+restOfString;
    }

    public static void main(String[] arr){
        String str="abcdeXfghiXjkX";
        str=moveAllXtoLast(str);
        System.out.println(str);
    }
}
