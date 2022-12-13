
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;

public class Ej2_10 {
    public static void main(String[] args) {
        int emp_no = 0, dir= 0,dept_no = 0;
        String apellido = null, oficio = null;
        LocalDate date;
        Float salario = 0f, comision = 0f;
        try{
            emp_no = Integer.parseInt(args[0]);
            dir = Integer.parseInt(args[3]);
            dept_no = Integer.parseInt(args[7]);

            apellido = args[1];
            oficio = args[2];
            date = LocalDate.parse(args[4]);
            salario = Float.parseFloat(args[5]);
            comision = Float.parseFloat(args[6]);

        }catch(InputMismatchException | IndexOutOfBoundsException es){
            System.err.println("Error en la introducción de datos.");
            System.exit(-1);
        }
        if(!depExiste(dept_no)){
            System.err.println("Departamento no existe");
            System.exit(-1);
        }
        if(empExiste(emp_no)){
            System.err.println("Empleado ya existe");
            System.exit(-1);
        }
        if(salario <=0 ){
            System.err.println("Salario es menor o igual a 0");
            System.exit(-1);
        }
        if(!dirExiste(emp_no)){
            System.err.println("Director no existe");
            System.exit(-1);
        }
        if(!dirExiste(emp_no)){
            System.err.println("Director no existe");
            System.exit(-1);
        }

    }

    private static boolean dirExiste(int emp_no) {
        return false;
    }

    private static boolean empExiste(int emp_no) {
        return false;
    }

    private static boolean depExiste(int dept_no) {

        return false;
    }
}
