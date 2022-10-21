package Ej4;

import java.util.Scanner;

public class Frecuencia2 {
    public static void main(String[] args) {
        int a = 0, e = 0, i = 0, o = 0, u = 0;
        Scanner sc = new Scanner(System.in);
        String s = "";
        while (sc.hasNext()){
            s+= sc.nextLine();
        }

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
        System.out.println("a = " + a);
        System.out.println("e = " + e);
        System.out.println("i = " + i);
        System.out.println("o = " + o);
        System.out.println("u = " + u);
    }
}
