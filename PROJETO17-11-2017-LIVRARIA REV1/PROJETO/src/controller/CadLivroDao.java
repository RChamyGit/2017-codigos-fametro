package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import connection.Conexao;
import model.Livro;


	public class CadLivroDao {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		
		public void salvar(Livro livro){
			conn = Conexao.getConexao();//conecta ao banco de dados
			sql = "insert into livro( livronome, livroidioma, livroano) values(?, ?, ?)";
			try {
				ps = conn.prepareStatement(sql); //preparando o BD p/ receber um informacao
				//atributos da tabela
		
				ps.setString(1,livro.getLivronome());
				ps.setString(2,livro.getLivroidioma());
				ps.setInt(3,livro.getLivroano());
			
				ps.execute(); //executa a acao
				JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
				
			} catch (SQLException e) {
				e.getMessage();
			}
		}
		
		public void deletar(Livro livro){
			conn = Conexao.getConexao();//conecta ao banco de dados
			sql = "delete from livro where livronome = ?";
			
			try {
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, livro.getLivronome());

				ps.execute(); //executa a acao3
				JOptionPane.showMessageDialog(null, "Deletado com Sucesso !");
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "erro no excluir"+e.getMessage());
			}
		}
		
		public void alterar(Livro livro) {
			conn = Conexao.getConexao();//conecta ao banco de dados
			sql = "update livro set livronome = ?, livroidioma = ?, livroano = ?, livropreco=?";
			
			try {
				ps = conn.prepareStatement(sql);
				
				ps.setString(1, livro.getLivronome());
				ps.setString(2, livro.getLivroidioma());
				ps.setInt(3, livro.getLivroano());
				
				ps.execute(); //executa a acao
				JOptionPane.showMessageDialog(null, "Alterado com Sucesso !");
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "erro no alterar"+e.getMessage());
			}
		}
		public Livro consultar(String livronome){
			
			conn = Conexao.getConexao();
			Livro livro = new Livro();
			sql = "select * from livro where livronome ='"+ livronome +"'";
				
			try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();		
				
				if(rs.next()){
					
					livro.setLivronome(rs.getString("livronome"));
					livro.setLivroidioma(rs.getString("livroidioma"));
					livro.setLivroano(rs.getInt("livroano"));
							
				}else{
					JOptionPane.showMessageDialog(null, "Livro não cadastrado!");
				}
			}catch(SQLException e){
				e.getMessage();
			}
			
			return livro;
		}
	
	}
