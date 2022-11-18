public class Main {
    public static void main(String[] args) {
        System.out.println(intToRoman(34));
    }
    public static String intToRoman(int num) {
        String s = "";
        try{
            String i = String.valueOf(num);
            System.out.println(i.charAt(0));

            System.out.println(i);
            if(i=="1")s+="I";
            if(i=="2")s+="II";
            if(i=="3")s+="III";
            if(i=="4")s+="IV";
        }catch(Exception e){

        }

        return s;
    }
}