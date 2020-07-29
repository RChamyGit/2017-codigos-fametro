package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import connection.Conexao;
import model.Autor;

	public class CadautorDao {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		
		//Salvar - OK
		public void salvar(Autor autor){
			conn = Conexao.getConexao();//conecta ao banco de dados
			sql = "insert into autor(autornome,autornasc) values(?,?)";
			try {
				ps = conn.prepareStatement(sql); //preparando o BD p/ receber um informacao
				//atributos da tabela
		
				ps.setString(1, autor.getAutornome());
				ps.setInt(2, autor.getAutornasc());
				
				ps.execute(); //executa a acao
				JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
				
			} catch (SQLException e) {
				e.getMessage();
			}
		}
		//Delete - OK
		public void deletar(Autor autor){
			conn = Conexao.getConexao();//conecta ao banco de dados		
			sql = "delete from autor(autornome,autornasc) values(?,?)";
			
			try {
				
				ps = conn.prepareStatement(sql);
				
				ps.setString(1, autor.getAutornome());
				ps.setInt(2, autor.getAutornasc());
				
				ps.execute(); //executa a acao
				JOptionPane.showMessageDialog(null, "Deletado com Sucesso !");
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "erro no excluir"+e.getMessage());
			}
		}
		
		// Alterar ok
		public void alterar(Autor autor) {
			conn = Conexao.getConexao();//conecta ao banco de dados
			sql = "update autor set autornome = ?, autornasc = ?";
			
			try {
				ps = conn.prepareStatement(sql);
				
				ps.setString(1, autor.getAutornome());
				ps.setInt(2,autor.getAutornasc());
								
				ps.execute(); //executa a acao
				JOptionPane.showMessageDialog(null, "Alterado com Sucesso !");
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao tentar alterar!"+e.getMessage());
			}
		}
		
		//Consulta - OK
		public Autor consultar(String autornome){
			
			conn = Conexao.getConexao();
			Autor autor = new Autor();
			sql = "select * from autor where autornome ='"+ autornome +"'";
				
			try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();		
				
				if(rs.next()){
					JOptionPane.showMessageDialog(null, "teste !");
					
					autor.setAutornome(rs.getString("autornome"));	
					autor.setAutornasc(rs.getInt("autornasc"));
							
				}else{
					JOptionPane.showMessageDialog(null, "Autor não Encontrado!");
				}
			}catch(SQLException e){
				e.getMessage();
			}
			
			return autor;
		}
	}