package Ej1;

import com.mysql.cj.MysqlConnection;

import java.sql.*;
import java.util.Scanner;

public class Ej5 {
    static Connection c = null;
    public static void main(String[] args) throws SQLException {

        int i = 3;


        do {
            System.out.println("1-Insertar en Mysql \n2-Insertar en SQLite \n3-Salir ");
            i = (new Scanner(System.in)).nextInt();
            c = null;

            if(i==1){
                c = DriverManager.getConnection("jdbc:mysql://localhost:3306/unidad2", "root", "root");
            } else if (i==2) {
                c = DriverManager.getConnection("jdbc:sqlite:C:/sqlite/db/unidad2.db");
            }
            if (c != null){
                insertaDatos();
                c.close();
            }
        }while (i!=3);
    }

    private static void insertaDatos() throws SQLException {
        insertaClientes();
        insertaProductos();
    }

    private static void insertaClientes() throws SQLException {
        int i = getMaxIDClientes();
        int count = 0;
        PreparedStatement ps = c.prepareStatement("INSERT INTO clientes\n" +
                "\t(ID, NOMBRE, DIRECCION, POBLACION, TELEF, NIF)\n" +
                "\tVALUES (?,?,?,?,?,?)");
        ps.setInt(1,++i);
        ps.setString(2,"Juan Carlos");
        ps.setString(3,"Avenida Puerto Indias");
        ps.setString(4, "Cortesillas");
        ps.setString(5,"897343167");
        ps.setString(6,"42561349T");
        count += ps.executeUpdate();

        ps = c.prepareStatement("INSERT INTO clientes\n" +
                "\t(ID, NOMBRE, DIRECCION, POBLACION, TELEF, NIF)\n" +
                "\tVALUES (?,?,?,?,?,?)");
        ps.setInt(1,++i);
        ps.setString(2,"Pepe");
        ps.setString(3,"Calle Pamplona del Sur");
        ps.setString(4, "El Almendralejo");
        ps.setString(5,"128379876");
        ps.setString(6,"123334587K");
        count += ps.executeUpdate();

        ps = c.prepareStatement("INSERT INTO clientes\n" +
                "\t(ID, NOMBRE, DIRECCION, POBLACION, TELEF, NIF)\n" +
                "\tVALUES (?,?,?,?,?,?)");
        ps.setInt(1,++i);
        ps.setString(2,"Roberto");
        ps.setString(3,"C/ Merequetengue");
        ps.setString(4, "Albufeira");
        ps.setString(5,"3567142143");
        ps.setString(6,"11344678Y");
        count += ps.executeUpdate();
        System.out.println("Filas Afectadas Clientes: "+count);
    }

    private static int getMaxIDClientes() throws SQLException {
        Statement stmt=c.createStatement();
        ResultSet rs=stmt.executeQuery("select MAX(ID) from clientes");
        rs.next();
        int i = rs.getInt("MAX(id)");
        stmt.close();
        rs.close();
        return i;
    }

    private static void insertaProductos() throws SQLException {
        int i = getMaxIDProductos();
        int count = 0;
        PreparedStatement ps = c.prepareStatement("INSERT INTO productos\n" +
                "\t(ID, DESCRIPCION, STOCKACTUAL, STOCKMINIMO, PVP)\n" +
                "\tVALUES (?,?,?,?,?)");
        ps.setInt(1,++i);
        ps.setString(2,"El libro troll del Rubius");
        ps.setInt(3,90);
        ps.setInt(4,2);
        ps.setDouble(5,19.99);
        count += ps.executeUpdate();

        ps = c.prepareStatement("INSERT INTO productos\n" +
                "\t(ID, DESCRIPCION, STOCKACTUAL, STOCKMINIMO, PVP)\n" +
                "\tVALUES (?,?,?,?,?)");
        ps.setInt(1,++i);
        ps.setString(2,"40 horas de cinemáticas, by Hideo Kojima");
        ps.setInt(3,150);
        ps.setInt(4,5);
        ps.setDouble(5,59.99);
        count += ps.executeUpdate();

        ps = c.prepareStatement("INSERT INTO productos\n" +
                "\t(ID, DESCRIPCION, STOCKACTUAL, STOCKMINIMO, PVP)\n" +
                "\tVALUES (?,?,?,?,?)");
        ps.setInt(1,++i);
        ps.setString(2,"Así es la Vida, Jordi Wild");
        ps.setInt(3,45);
        ps.setInt(4,10);
        ps.setDouble(5,34.99);
        count += ps.executeUpdate();
        System.out.println("Filas Actualizadas Productos: "+count);
    }

    private static int getMaxIDProductos() throws SQLException {
        Statement stmt=c.createStatement();
        ResultSet rs=stmt.executeQuery("select MAX(ID) from productos");
        rs.next();
        int i = rs.getInt("MAX(id)");
        stmt.close();
        rs.close();
        return i;
    }
}
