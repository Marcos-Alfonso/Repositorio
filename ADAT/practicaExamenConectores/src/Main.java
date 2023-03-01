import java.sql.*;
import java.util.ArrayList;

public class Main {
    static Connection c;
    public static void main(String[] args) {
        if(estableceConexion()) System.out.println("Conexión establecida");
        else{
            System.err.println("No se pudo establecer la conexión");
            System.exit(-1);
        }

        //metodo recibe numero de centro y obtenga nombre de asignaturas
        ArrayList<String> listaAsignaturas = getListaAsignaturas(1000);
        for (String s:listaAsignaturas) {
            System.out.println(s);
        }

        //elimina especialidad
        int i = eliminaEspecialidad("INFORMATICA");
        System.out.println("Total eliminado: "+i);

        //recibe consulta e imprime datos de la BBDD
        imprimeDatosQuery("SELECT * FROM profesor");

        try {
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void imprimeDatosQuery(String s) {
        try {
            Statement stmt  = c.createStatement();
            ResultSet rs=stmt.executeQuery(s);
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("Columnas recibidas: "+rsmd.getColumnCount());
            for (int i = 1; i < rsmd.getColumnCount()+1; i++) {
                System.out.println("Columna: "+rsmd.getColumnName(i));
                System.out.println("\tTipo: "+rsmd.getColumnType(i)+" - "+rsmd.getColumnTypeName(i));
                System.out.println("\tTamaño: "+rsmd.getColumnDisplaySize(i));
                System.out.println("\tAdmite null: "+((rsmd.isNullable(i)==1)?("SI"):("NO")));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static int eliminaEspecialidad(String especialidad) {
        try {
            PreparedStatement psPre = c.prepareStatement("Delete from asignatura where COD_PROF in (select COD_PROF FROM profesor where ESPE_PRO = '"+especialidad+"')");
            int i = psPre.executeUpdate();
            System.out.println("Eliminadas asignaturas: "+i);
            PreparedStatement ps = c.prepareStatement("DELETE  FROM profesor " +
                    "WHERE ESPE_PRO = '"+especialidad+"'" );
            int e = ps.executeUpdate();
            System.out.println("Eliminados Profesores: "+e);
            return e+i;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static ArrayList<String> getListaAsignaturas(int codCentro) {
        ArrayList<String> lista = new ArrayList<>();


        try {
            Statement stmt  = c.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT NOMBRE_ASI FROM asignatura NATURAL JOIN profesor WHERE cod_centro = "+codCentro);

            while (rs.next()){
                lista.add(rs.getString("NOMBRE_ASI"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    private static boolean estableceConexion() {
        try {
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "root");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}