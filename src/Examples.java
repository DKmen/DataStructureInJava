import java.util.Scanner;

public class Examples {
    public static void ipV4Header(){
        Scanner sc= new Scanner(System.in);
        String input = sc.nextLine();
        input=input.trim();
        System.out.println("version"+input.substring(0,4)+"   hexa code  "+  Integer.toHexString(Integer.parseInt(input.substring(0,4),2)));
        System.out.println("IHL"+input.substring(4,8)+"   hexa code  "+  Integer.toHexString(Integer.parseInt(input.substring(4,8),2)));
        System.out.println("DSCP"+input.substring(8,14)+"   hexa code  "+  Integer.toHexString(Integer.parseInt(input.substring(8,14),2)));
        System.out.println("ECN"+input.substring(14,16)+"   hexa code  "+  Integer.toHexString(Integer.parseInt(input.substring(14,16),2)));
        System.out.println("Total length"+input.substring(16,32)+"   hexa code  "+  Integer.toHexString(Integer.parseInt(input.substring(16,32),2)));
        System.out.println("Identification"+input.substring(32,48)+"   hexa code  "+  Integer.toHexString(Integer.parseInt(input.substring(32,48),2)));
        System.out.println("Flag"+input.substring(48,51)+"   hexa code  "+  Integer.toHexString(Integer.parseInt(input.substring(48,51),2)));
        System.out.println("Fragment offset"+input.substring(51,64)+"   hexa code  "+  Integer.toHexString(Integer.parseInt(input.substring(51,64),2)));
        System.out.println("Time To Live"+input.substring(64,72)+"   hexa code  "+  Integer.toHexString(Integer.parseInt(input.substring(64,72),2)));
        System.out.println("Protocol"+input.substring(72,80)+"   hexa code  "+  Integer.toHexString(Integer.parseInt(input.substring(72,80),2)));
        System.out.println("Header Check Sum"+input.substring(80,96)+"   hexa code  "+  Integer.toHexString(Integer.parseInt(input.substring(80,96),2)));
        System.out.println("Source address"+input.substring(96,128));
        System.out.println("Destination address"+input.substring(128,160));
    }
    public static void tcpLayer(){
        Scanner sc= new Scanner(System.in);
        String input = sc.nextLine();
        input=input.trim();
        System.out.println("Source Port"+input.substring(0,16));
        System.out.println("Destination Port"+input.substring(16,32));
        System.out.println("Sequence Number"+input.substring(32,64));
        System.out.println("Acknowlegement Number"+input.substring(64,96));
        System.out.println("Header length"+input.substring(96,100));
        System.out.println("Reserved Bit"+input.substring(100,106));
        System.out.println("URG"+input.substring(106,107));
        System.out.println("ACK"+input.substring(107,108));
        System.out.println("PSH"+input.substring(108,109));
        System.out.println("RST"+input.substring(109,110));
        System.out.println("SYN"+input.substring(110,111));
        System.out.println("FIN"+input.substring(111,112));
        System.out.println("Window Size"+input.substring(112,128));
        System.out.println("Check Sum"+input.substring(128,144));
        System.out.println("Urgent Point"+input.substring(144,160));
    }
    public static void main(String[] arr){
        tcpLayer();
    }
}
