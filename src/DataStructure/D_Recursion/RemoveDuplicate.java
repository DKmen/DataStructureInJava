package DataStructure.D_Recursion;

// remove all duplicate from sorted string

public class RemoveDuplicate {

    public static String removeDuplicateFromString(String str){
        if(str.length()==1) return str;
        String restOfRemovingDuplicateString=removeDuplicateFromString(str.substring(1));
        if(restOfRemovingDuplicateString.charAt(0)==str.charAt(0)){
            return restOfRemovingDuplicateString;
        }
        return String.valueOf(str.charAt(0)).concat(restOfRemovingDuplicateString);
    }

    public static void main(String[] arr){
        String str="aaaaabbbbdddee";
        str=removeDuplicateFromString(str);
        System.out.println(str);
    }
}
