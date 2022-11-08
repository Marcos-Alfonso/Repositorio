import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Ej5 {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("trail.json"));
        String nombre = "";
        ArrayList<TrackPoint> lista= new ArrayList<TrackPoint>();
        try {

            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                if(line.contains("name")){
                    sb.append(line.substring(13,29));
                    sb.append(System.lineSeparator());
                    nombre = line;
                }
                if(line.contains("name"))
                line = br.readLine();
            }
            String everything = sb.toString();
            System.out.println(everything);
            br.close();
        }catch (IOException e){

        }
    }
}
