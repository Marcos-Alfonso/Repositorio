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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html");
    
        PrintWriter pr = response.getWriter();
        try {
            Connection  c= DriverManager.getConnection("jdbc:mysql://localhost:3306/provincias","root","root");
            ArrayList<String> listaProvincias = getListaProvincias(c, "Select provincia from provincias order by id_provincia");
            ArrayList<String> listaId = getListaProvincias(c, "Select id_provincia from provincias order by id_provincia");

            pr.println("<html>");
            pr.println("<head>");
            pr.println("<title>Provincias españolas</title>");
            pr.println("<style>" +
                    "table, th, td {\n" +
                    "  border: 1px solid;\n" +
                    "}" +
                    "</style>");
            pr.println("</head>");
            pr.println("<body>");
            pr.println("<h1>Povincias Españolas</h1>");
            pr.println("<p>Marcos Alfonso García</p>");
            pr.println("<table style='border: 1px solid;'>");
            pr.println("<thead><tr><th>Código Provincia</th><th>Provincia</th></tr></thead>");
            pr.println("<tbody>");
            for (int i = 0; i < listaProvincias.size(); i++) {
                System.out.println(listaId.get(i)+""+listaProvincias.get(i));
                pr.println("<tr><td>"+listaId.get(i)+"</td><td>"+listaProvincias.get(i)+"</td></tr>");
            }
            pr.println("</tbody></table>");

            pr.println("</body>");
            pr.println("</html>");
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<String> getListaProvincias(Connection c, String query) throws SQLException {
        Statement statement = c.createStatement();
        ArrayList<String> list = new ArrayList<String>();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String s = resultSet.getString(1);
            list.add(s);
        }
        return list;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
