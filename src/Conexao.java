import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static void main(String[] args) {
        Conexao.conectar();
    }

    private static final String URL = "jdbc:mysql://localhost:3306/loja";
    private static final String USUARIO = "root";
    private static final String SENHA = "Java2026#Crud";

    public static Connection conectar() {
        try {
            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão bem-sucedida!");
            return conexao;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
            
        }
        
    }
    
}
