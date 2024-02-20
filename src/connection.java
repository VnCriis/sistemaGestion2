import java.sql.*;
public class connection {
    private static final String dbhost = "jdbc:mysql://uic8zenzexubon9b:CyeTIbbEElhaiZn8YeyJ@bgvdfopd1a0a1djyhyxs-mysql.services.clever-cloud.com:3306/bgvdfopd1a0a1djyhyxs";
    private static final String dbuser = "uic8zenzexubon9b";
    private static final String dbpassword = "CyeTIbbEElhaiZn8YeyJ";

    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            // Registro del driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer conexión
            conexion = DriverManager.getConnection(dbhost, dbuser, dbpassword);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver JDBC.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error en la conexión a la base de datos.");
            e.printStackTrace();
        }
        return conexion;
    }
    public static void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión.");
                e.printStackTrace();
            }
        }
    }
}
