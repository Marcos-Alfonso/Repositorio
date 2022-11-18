import java.sql.*;


public class Main {
    public static void main(String[] args){
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "root");
            Statement stmt=c.createStatement();
            ResultSet rs=stmt.executeQuery("select * from empleados");
            /*
            rs.last();
            System.out.println("Nº Filas"+rs.getRow());
            rs.beforeFirst();
             */
            while (rs.next()){
                System.out.printf("Fila %d: %s, %s, %f\n",
                        rs.getRow(),
                        rs.getString("apellido"),
                        rs.getString("oficio"),
                        rs.getFloat("salario"));
            }
            rs = stmt.executeQuery("SELECT apellido, salario, dnombre FROM empleados NATURAL JOIN departamentos \n" +
                    "WHERE salario = (SELECT MAX(salario) FROM empleados)");
            rs.next();
            System.out.printf("Empleado con mayor salario:\n %s, %f, %s ",
                    rs.getString("apellido"),
                    rs.getFloat("salario"),
                    rs.getString("dnombre"));
            rs.close();
            stmt.close();
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}