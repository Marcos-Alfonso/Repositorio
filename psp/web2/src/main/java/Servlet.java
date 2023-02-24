import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "Provincias", value = "/Provincias")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
        PrintWriter pr = response.getWriter();
        pr.println("<p>Hello World</p>");
        String connectionString = "jdbc:mysql://localhost:3306/provincias?user=root&password=root";
        System.out.println();
        try {

            Connection  c= DriverManager.getConnection("jdbc:mysql://localhost:3306/provincias","root","root");
            ArrayList<String> listaProvincias = getListaProvincias(c, "Select provincias from Provincias");
            ArrayList<String> listaId;
            pr.println("<p>"+listaProvincias.size()+"</p>");
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private ArrayList<String> getListaProvincias(Connection c, String query) throws SQLException {
        Statement statement = c.createStatement();
        ArrayList<String> list = new ArrayList<String>();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String s = resultSet.getString(0);
            System.out.println(s);
            list.add(s);
        }
        return list;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
