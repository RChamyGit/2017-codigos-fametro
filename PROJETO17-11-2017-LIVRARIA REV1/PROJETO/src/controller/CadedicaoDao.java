package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import connection.Conexao;
import model.Edicao;

	public class CadedicaoDao {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		
		//Salvar - OK
		public void salvar(Edicao edicao){
			conn = Conexao.getConexao();//conecta ao banco de dados
			sql = "insert into edicao( edicaolivrocod, edicaovalor) values(?,?)";
			try {
				ps = conn.prepareStatement(sql); //preparando o BD p/ receber um informacao
				//atributos da tabela
		
				ps.setInt(1, edicao.getEdicaonumero());
				ps.setDouble(2, edicao.getEdicaovalor()); //valor agora é da edição, nao do livro.
				ps.execute(); //executa a acao
				JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
				
			} catch (SQLException e) {
				e.getMessage();
			}
		}
		//Delete - OK
		public void deletar(Edicao edicao){
			conn = Conexao.getConexao();//conecta ao banco de dados
			sql = "delete from edicao(edicaonumero) values(?,?)";
			
			try {
				
				ps = conn.prepareStatement(sql);
				
				ps.setInt(1, edicao.getEdicaonumero());
											
				ps.execute(); //executa a acao
				JOptionPane.showMessageDialog(null, "Deletado com Sucesso !");
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "erro no excluir"+e.getMessage());
			}
		}
		//Falta Corrigir erro do Alterar
		public void alterar(Edicao edicao) {
			conn = Conexao.getConexao();//conecta ao banco de dados
			sql = "update edicao set edicaonumero = ?";
			
			try {
				ps = conn.prepareStatement(sql);
				
				ps.setInt(1, edicao.getEdicaonumero());
								
				ps.execute(); //executa a acao
				JOptionPane.showMessageDialog(null, "Alterado com Sucesso !");			
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "erro no alterar"+e.getMessage());
			}
		}
		
		//Consulta - OK
		public Edicao consultar(String string){
			
			conn = Conexao.getConexao();
			Edicao edicao = new Edicao();
			sql = "select * from edicao where edicaonumero ='"+ string +"'";
				
			try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();		
				
				if(rs.next()){
					JOptionPane.showMessageDialog(null, "teste !");
					
					edicao.setEdicaonumero(rs.getInt("edicaonumero"));						
							
				}else{
					JOptionPane.showMessageDialog(null, "Edicao não Encontrado !");
				}
			}catch(SQLException e){
				e.getMessage();
			}
			
			return edicao;
		}
	}
