import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    static Connection c;
    public static void main(String[] args) throws ParseException {
        if(estableceConexion()) System.out.println("Conexión establecida");
        else{
            System.err.println("No se pudo establecer la conexión");
            System.exit(-1);
        }

        //b. metodo que recie objeto y lo inserta en la BBDD
        String str = "26-09-1989";
        SimpleDateFormat obj = new SimpleDateFormat("dd-MM-yyyy");
        long e = obj.parse(str).getTime();
        Date fechaNac = new Date(e);
        insertaArtista(new Artista(109, "Cristiano Ronaldo", fechaNac, null));

        //c. metodo recibe numero de estudio y muestra los titulos y actores
        muestraDatosEstudio(2);

        //d. metodo recibe un estudio y elimina peliculas de ese estudio devuelve las filas afectadas
        System.out.println("Columnas Totales Modificadas: "+eliminaPeliculasByEstudio(2));

        //e. Metodo recibe consulta e imprime el numero de columnas y por cada una el nombre el tipo el tamaño y si admite nulos o no
        imprimeDatosQuery("Select * from artistas");

        desconecta();
    }

    private static void muestraDatosEstudio(int i) {
        try {
            Statement stmt  = c.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * from peliculas where estudio_id = "+i);
            while (rs.next()){
                System.out.println("Pelicula: "+rs.getString("titulo"));
                muestraActoresPelicula(rs.getInt("pelicula_id"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void muestraActoresPelicula(int pelicula_id) {
        try {
            Statement stmt  = c.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT DISTINCT(nombre) FROM peliculas natural JOIN pel_art NATURAL JOIN artistas WHERE peliculas.pelicula_id = "+pelicula_id);
            while (rs.next()){
                System.out.println("\t-"+rs.getString(1));
            }

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

    private static int eliminaPeliculasByEstudio(int i) {
        int nColumnas= 0;
        try {
            //como tiene una foreing key QUE NO TIENE UN CASCADE, primero borro en la tabla pel_art y despues en la de peliculas
            PreparedStatement psPre = c.prepareStatement("DELETE from pel_art where pelicula_id in (select pelicula_id from peliculas where estudio_id = ?)");
            psPre.setInt(1, i);
            int columnasRelaciones = psPre.executeUpdate();
            System.out.println("Eliminadas Relaciones: "+columnasRelaciones);

            PreparedStatement ps = c.prepareStatement("DELETE FROM peliculas where estudio_id = ?");
            ps.setInt(1,i);
            int columnasPeliculas = ps.executeUpdate();
            System.out.println("Peliculas eliminadas: "+columnasPeliculas);
            nColumnas = columnasPeliculas+columnasRelaciones;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("No se pudo eliminar peliculas");;
        }
        return nColumnas;

    }

    private static void insertaArtista(Artista artista) {
        try{
            PreparedStatement ps = c.prepareStatement("INSERT INTO artistas\t(artista_id, nombre, fecha_nac, fecha_def)VALUES (?, ?, ?, ?)");
            ps.setInt(1, artista.getId());
            ps.setString(2, artista.getNombre());
            ps.setDate(3, artista.getFechaNac());
            ps.setDate(4, artista.getFechaDef());
            ps.executeUpdate();

        }catch (SQLException e) {
            if(e instanceof SQLIntegrityConstraintViolationException){
                System.err.println("Id Duplicado. Artista no introducido");
            }else{
                System.err.println("Error al introducir artista");
            }
        }
    }

    private static void desconecta() {
        try {
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean estableceConexion() {
        try {
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/peliculas", "root", "root");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}