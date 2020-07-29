package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import connection.Conexao;
import model.Editora;

	public class CadeditoraDao {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";

		public void salvar(Editora editora){
			conn = Conexao.getConexao();//conecta ao banco de dados
			sql = "insert into editora( editoranome, editorafone, editoraend) values(?, ?, ?)";
			try {
				ps = conn.prepareStatement(sql); //preparando o BD p/ receber um informacao
				//atributos da tabela
		
				ps.setString(1, editora.getEditoranome());
				ps.setInt(2, editora.getEditorafone());
				ps.setString(3, editora.getEditoraendereco());
			
				ps.execute(); //executa a acao
				JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Não foi possível realizar o cadastro!"+e.getMessage());
			}
		}

		public void deletar(Editora editora){
			conn = Conexao.getConexao();//conecta ao banco de dados			
			sql = "delete from editora where editoranome = ?";
			
			try {
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, editora.getEditoranome());
				ps.execute(); //executa a acao
				JOptionPane.showMessageDialog(null, "Deletado com Sucesso!");
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro no momento da exclusão!"+e.getMessage());
			}
		}
	
		public void alterar(Editora editora) {
			conn = Conexao.getConexao();//conecta ao banco de dados
			sql = "update editora set editoranome = ?, editorafone = ?, editoraend = ?";
			
			try {
				ps = conn.prepareStatement(sql);
				
				ps.setString(1, editora.getEditoranome());
				ps.setInt(2, editora.getEditorafone());
				ps.setString(3, editora.getEditoraendereco());
								
				ps.execute(); //executa a acao
				JOptionPane.showMessageDialog(null, "Cadastro alterado com Sucesso !");		
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o cadastro!"+e.getMessage());
			}
		}
		
		public Editora consultar(String editoranome){
			conn = Conexao.getConexao();
			Editora editora = new Editora();
			sql = "select * from editora where editoranome ='"+ editoranome +"'";
				
			try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();		
				
				if(rs.next()){
					
					editora.setEditoranome(rs.getString("editoranome"));
					editora.setEditorafone(rs.getInt("editorafone"));
					editora.setEditoraendereco(rs.getString("editoraend"));
							
				}else{
					JOptionPane.showMessageDialog(null, "Editora não cadastrada!");
				}
			}catch(SQLException e){
				e.getMessage();
			}
			
			return editora;
		}
	}

