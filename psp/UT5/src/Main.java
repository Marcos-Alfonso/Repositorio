import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String  cancion = "";
        try {
            // Abrir el archivo de texto para lectura
            BufferedReader reader = new BufferedReader(new FileReader("cancion.txt"));

            // Leer cada línea del archivo
            String line;
            while ((line = reader.readLine()) != null) {

                cancion += line+"\n";
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(cancion);

        try {

            // Crear una instancia de la clase Robot
            Robot robot = new Robot();

            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_Z);
            robot.keyRelease(KeyEvent.VK_Z);

            Thread.sleep(1000);

            // Iterar sobre cada carácter del mensaje
            for (String s : cancion.split("\n")) {
                if (s.contains("--")){
                    continue;
                }
                for (char c : s.toCharArray()) {
                    int keyCode = (int) c;

                    robot.keyPress(keyCode);
                    robot.keyRelease(keyCode);
                }

                Thread.sleep(400);
            }
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
/*
        try {
            // Crear una instancia de la clase Robot
            Robot robot = new Robot();

            Thread.sleep(5000);
            // Simular la pulsación de la tecla 's'

            robot.keyPress(KeyEvent.VK_N);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyPress(KeyEvent.VK_X);

            robot.keyRelease(KeyEvent.VK_S);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_X);
            // Esperar 5 segundos (5000 milisegundos)
            Thread.sleep(353);
            Thread.sleep(353);
            Thread.sleep(353);
            robot.keyPress(KeyEvent.VK_M);
            robot.keyRelease(KeyEvent.VK_M);

            Thread.sleep(353);

            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_A);

            Thread.sleep(353);

            robot.keyPress(KeyEvent.VK_N);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyPress(KeyEvent.VK_X);

            robot.keyRelease(KeyEvent.VK_S);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_X);

            Thread.sleep(353);
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}