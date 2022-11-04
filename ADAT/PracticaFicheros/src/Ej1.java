import java.io.*;

public class Ej1 {
    public static void main(String[] args) {


        //recorro todos los argumentos
        for(String s: args){

            try {
                //inicio un File y un BufferedReader de cada argumento, siendo estos los files
                File f = new File(s);
                BufferedReader br = new BufferedReader(new FileReader(f));

                //dos variables string, una que me lea la linea y compruebe si quedan mas, y otra donde se guarde
                // el contenido del fichero. En este caso, dan igual los saltos de linea.
                String total="";
                String line = "";
                while((line = br.readLine())!=null){
                    total+=line;
                }
                //teniendo el contenido del fichero en un String, lo paso al método que me devuelve el número
                // de variables y lo imprimo.
                System.out.println(f.getName()+" tiene "+cuentaVocales(total)+" vocales. ");
            }catch (IOException e){
                //caso de que no exista el file lo indico por salida
                System.err.println("Archivo: '"+s+"' no encontrado.");
            }


        }
    }

    private static int cuentaVocales(String total) {
        int count = 0;
        //recorro el string como si fuera un array de carácteres y si el caracter es vocal sumo a una variable
        for (char c: total.toLowerCase().toCharArray()) {
            if(c == 'a' || c == 'e'||c == 'i'||c == 'o'||c == 'u')count++;

        }
        //devuelvo esa variable que me ha contado el número de vocales.
        return count;
    }
}