package Ej1;

import java.sql.*;

public class Ej2_8_SQLite {
    public static void main(String[] args) {
        try {
            Connection c = DriverManager.getConnection("jdbc:sqlite:C:/sqlite/db/unidad2.db");
            DatabaseMetaData dbmd = c.getMetaData();
            System.out.println("Información Base de Datos\n" +
                    "------------------------------------");
            System.out.printf("Nombre: %s %n", dbmd.getDatabaseProductName());
            System.out.printf("Driver: %s %n", dbmd.getDriverName());
            System.out.printf("URL: %s %n", dbmd.getURL());
            System.out.printf("Usuario: %s %n", dbmd.getUserName());
            ResultSet rs = dbmd.getTables("unidad2", null, null, null);
            while (rs.next()){
                System.out.printf("Tabla %s %n", rs.getString("TABLE_NAME").toUpperCase());
                System.out.printf("\tCatalogo: %s %n",rs.getString("TABLE_CAT"));
                System.out.printf("\tEsquema: %s %n", rs.getString("TABLE_SCHEM"));
                System.out.printf("\tTipo: %s %n", rs.getString("TABLE_TYPE"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
