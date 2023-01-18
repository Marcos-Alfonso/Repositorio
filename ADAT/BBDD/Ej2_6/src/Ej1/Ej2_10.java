package Ej1;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;

public class Ej2_10 {
    static Connection c;
    public static void main(String[] args) throws SQLException {
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/unidad2", "root", "root");

        int emp_no = 0, dir= 0,dept_no = 0;
        String apellido = null, oficio = null;
        LocalDate date = null;
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
        if(dirExiste(emp_no)){
            System.err.println("Director no existe");
            System.exit(-1);
        }if(!dateIsToday(date)){
            System.err.println("La fecha no es hoy");
            System.exit(-1);
        }

        // si pasa todas las condiciones procede a insertar en la base de datos
        PreparedStatement ps = c.prepareStatement("INSERT INTO empleados\n" +
                "\t(emp_no, apellido, oficio, dir, fecha_alt, salario, comision, dept_no)\n" +
                "\tVALUES (?,?,?,?,?,?,?,?)");
        ps.setInt(1, emp_no);
        ps.setString(2, apellido);
        ps.setString(3, oficio);
        ps.setInt(4, dir);
        ps.setDate(5,Date.valueOf(date));
        ps.setFloat(6,salario);
        ps.setFloat(7,comision);
        ps.setInt(8,dept_no);

        ps.executeUpdate();
        ps.close();
        c.close();
    }

    private static boolean dateIsToday(LocalDate date) {
        if(date.compareTo(LocalDate.now())==0)
            return true;

        return false;
    }

    private static boolean dirExiste(int emp_no) throws SQLException {
        Statement stmt=c.createStatement();
        ResultSet rs=stmt.executeQuery("select * from empleados where emp_no = '"+emp_no+"'");
        if (!rs.isBeforeFirst() ) {
            return false;
        }

        return true;
    }

    private static boolean empExiste(int emp_no) throws SQLException {
        Statement stmt=c.createStatement();
        ResultSet rs=stmt.executeQuery("select * from empleados where emp_no = '"+emp_no+"'");
        if (!rs.isBeforeFirst() ) {
            return false;
        }

        return true;
    }

    private static boolean depExiste(int dept_no) throws SQLException {
        Statement stmt=c.createStatement();
        ResultSet rs=stmt.executeQuery("select * from empleados where dept_no = '"+dept_no+"'");
        if (!rs.isBeforeFirst() ) {
            return false;
        }
        return true;
    }
}
