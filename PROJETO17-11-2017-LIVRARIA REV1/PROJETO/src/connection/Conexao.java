package connection;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexao {

	
	public static Connection getConexao() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/projetolivraria17112017?&useSSL=false";// &useSSL para remover aviso de SSL do mysql.
		String user = "root";
		String senha = "";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, senha);
			JOptionPane.showMessageDialog(null, "Conexão ok!" );
		}catch(Exception e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Nao Conectou !" );
		}
		return conn;
	}
	public static void main(String[] args) {
		Conexao.getConexao();
		
	}
}
