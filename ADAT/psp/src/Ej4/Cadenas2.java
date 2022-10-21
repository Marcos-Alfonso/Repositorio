package Ej4;

import java.util.Random;

public class Cadenas2 {
    public static void main(String[] args) {
        try{
            long id = ProcessHandle.current().pid();

            for(int i = 0; i < Integer.parseInt(args[0]); i++){
                int numRand = (int) (Math.random()*19) + 1;
                System.out.println(id+ ": "+ generarCadena(numRand));
            }
        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
    }
    public static StringBuffer generarCadena(int longitud){
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < (new Random().nextInt(1,20)); i++) {
            s.append(rndChar()) ;
        }
        return s;
    }
    private static char rndChar () {
        int rnd = (int) (Math.random() * 52);
        //determino si el carácter va a ser mayúscula o minúscula
        char base = (rnd < 26) ? 'A' : 'a';
        return (char) (base + rnd % 26);

    }
}
