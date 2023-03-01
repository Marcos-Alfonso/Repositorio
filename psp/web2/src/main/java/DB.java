import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DB {
    public static ArrayList<String> getListaProvincias(Connection c, String query) throws SQLException, SQLException {
        Statement statement = c.createStatement();
        ArrayList<String> list = new ArrayList<String>();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String s = resultSet.getString(1);
            list.add(s);
        }
        return list;
    }
}
