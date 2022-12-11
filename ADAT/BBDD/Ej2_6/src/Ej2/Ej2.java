package Ej2;
import java.sql.*;
import java.util.ArrayList;

public class Ej2 {
    private static Connection c;
    public static void main(String[] args) {
        //a) Conectar a la base de datos (carga del driver y establecimiento de conexión).
        if(estableceConexion()) System.out.println("Conexión establecida");
        else{
            System.err.println("No se pudo establecer la conexión");
            System.exit(-1);
        }
        //b)	Insertar un departamento. El método recibirá los argumentos: número, nombre ylocalidad.
        insertaDep(50,"ADMINISTRACIÓN", "MURCIA");
        //c)	Lo mismo que b) pero recibiendo un solo argumento que será un objeto de la clase departamento.
        insertaDep(new Departamento(60,"DESARROLLO", "ZAMORA"));
        //d)	Método que devuelve un ArrayList de objetos departamento ante la consulta de todas las columnas de todos los departamentos de la tabla departamento.
        ArrayList<Departamento> deptos = getDepartamentos();
        for (Departamento d :deptos) {
            System.out.println(d.toString());
        }
        //e)	Método que reciba un número de departamento y devuelva una lista de los empleados.
        ArrayList<Empleado> emple = getEmpleados(20);
        for (Empleado e :emple) {
            System.out.println(e.toString());
        }
        //f)	Método que recibe el número de un departamento y un nuevo nombre y devuelve elnúmero de filas afectadas.
        System.out.println(modificaDeptNombre(50,"ANÁLISIS")+" filas modificadas.");
        /*
        g)	Método que reciba objeto departamento y actualice su localidad (segundo argumento delmétodo).Utilizar el siguiente procedemientoMySQL:
        delimiter $$
        CREATE PROCEDURE `actualizaDept`(cod INT(2), localidad
        VARCHAR(13))
        BEGIN
        UPDATE Dept SET loc=localidad WHERE deptno = cod;
        END$$*/
        System.out.println(modificaDeptLocalidad(deptos.get(4),"ASTURIAS")+" filas modificadas.");
        //h)	Método que reciba una cantidad y un número de departamento e incremente el sueldo detodos los empleados de ese departamento en esa cantidad.
        System.out.println(aumentaSueldo(100,20)+" filas modificadas.");
        //i)	Método que imprima todas las tablas y vistas del esquema actual, indicando además, sitrata de una tabla o una vista.
        printDBinfo();
        try {
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printDBinfo() {
        try {
            DatabaseMetaData m = c.getMetaData();
            ResultSet rs = m.getTables("unidad2", null, null, null);
            while (rs.next()){
                System.out.printf("Tabla %s %n", rs.getString("TABLE_NAME").toUpperCase());
                System.out.printf("\tTipo: %s %n", rs.getString("TABLE_TYPE"));
                DBTablePrinter.printTable(c, rs.getString("TABLE_NAME"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static int aumentaSueldo(int aumento, int dept_no) {
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE empleados SET salario = salario + "+aumento + " WHERE dept_no = "+dept_no);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static int modificaDeptLocalidad(Departamento d, String localidad) {
        try {
            d.setLoc(localidad);
            PreparedStatement ps = c.prepareStatement("UPDATE departamentos" +
                    " SET loc = '"+localidad+"'" +
                    " WHERE dept_no = "+d.getDept_no());
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //solo podrá devolver 0 o 1 filas, ya que el n de departamento es primary key
    private static int modificaDeptNombre(int dept_no, String dnombre) {
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE departamentos " +
                                                        "SET dnombre = '"+dnombre+"'" +
                                                        "WHERE dept_no = "+dept_no);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static ArrayList<Empleado> getEmpleados(int dept_no) {
        ArrayList<Empleado> empleados = new ArrayList<>();
        try {
            Statement stmt = c.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM empleados WHERE dept_no = 20");

            while (rs.next()){
                Empleado e = new Empleado(rs.getInt("emp_no"));
                e.setApellido(rs.getString("apellido"));
                e.setOficio(rs.getString("oficio"));
                e.setDir(rs.getInt("dir"));
                e.setFecha_alt(rs.getDate("fecha_alt"));
                e.setSalario(rs.getFloat("salario"));
                e.setComision(rs.getFloat("comision"));
                e.setDept_no(rs.getInt("dept_no"));

                empleados.add(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return empleados;
    }

    private static ArrayList<Departamento> getDepartamentos() {
        ArrayList<Departamento> deptos = new ArrayList<>();
        try {
            Statement stmt = c.createStatement();
            ResultSet rs=stmt.executeQuery("select * from departamentos");

            while (rs.next()){
                Departamento d = new Departamento(rs.getInt("dept_no"), rs.getString("dnombre"), rs.getString("loc"));
                deptos.add(d);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deptos;
    }

    private static void insertaDep(int dept_no, String dnombre, String loc) {
        try {
            PreparedStatement ps = c.prepareStatement("INSERT INTO departamentos VALUES('"+dept_no+"', '"+dnombre+"', '"+loc+"')");
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Error al insertar departamento: "+dept_no);
        }
    }
    private static void insertaDep(Departamento d) {
        try {
            PreparedStatement ps = c.prepareStatement("INSERT INTO departamentos VALUES('"+d.getDept_no()+"', '"+d.getDnombre()+"', '"+d.getLoc()+"')");
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Error al insertar departamento: "+d.getDept_no());
        }
    }
    private static boolean estableceConexion() {
        try {
             c= DriverManager.getConnection("jdbc:mysql://localhost:3306/unidad2", "root", "root");
             return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
