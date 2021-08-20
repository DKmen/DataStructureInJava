package DataStructure.D_Recursion;

//print all substring of given string

public class GenerateSubString {

    public static void printAllSubString(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }

        printAllSubString(str.substring(1),ans);
        printAllSubString(str.substring(1),ans+str.charAt(0));
    }

    public static void main(String[] arr){
        String str="abcd";
        printAllSubString(str,"");
    }
}
