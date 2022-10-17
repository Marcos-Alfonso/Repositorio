package Ej3;

import java.util.Scanner;

public class Frecuencia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int a = 0, e = 0, i = 0, o = 0, u = 0;
        for (int j = 0; j<s.length(); j++){
            switch (s.charAt(j)){
                case 'a': a++;break;
                case 'e': e++;break;
                case 'i': i++;break;
                case 'o': o++;break;
                case 'u': u++;break;
                default:
            }
        }
        System.out.println("a="+a+"\n" +
                "e="+e+"\n" +
                "i="+i+"\n" +
                "o="+o+"\n" +
                "u="+u+"\n" );
    }
}
