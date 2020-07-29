package controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import connection.Conexao;
import model.Cliente;

	public class CadclienteDao {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		//Salvar - OK
		public void salvar(Cliente cliente){
			conn = Conexao.getConexao();//conecta ao banco de dados
			sql = "insert into cliente(clientenome, clientecpf) values(?,?)";
			try {
				ps = conn.prepareStatement(sql); //preparando o BD p/ receber um informacao
				//atributos da tabela
		
				ps.setString(1, cliente.getClientenome());
				ps.setString(2, cliente.getClientecpf());
				
			
				ps.execute(); //executa a acao
				JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
				
			} catch (SQLException e) {
				e.getMessage();
			}
		}
		//Delete - OK
		public void deletar(Cliente cliente){
			conn = Conexao.getConexao();//conecta ao banco de dados
			
			sql = "delete from cliente where clientenome = ?";
			try {
				
				ps = conn.prepareStatement(sql);
				
				ps.setString(1, cliente.getClientenome());
				
				ps.execute(); //executa a acao
				JOptionPane.showMessageDialog(null, "Deletado com Sucesso !");
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "erro no excluir"+e.getMessage());
			}
		}
	
		public void alterar(Cliente cliente) {
			conn = Conexao.getConexao();//conecta ao banco de dados
			sql = "update cliente set clientenome = ?, clientecpf = ?";
			
			try {
				ps = conn.prepareStatement(sql);
				
				ps.setString(1,cliente.getClientenome());
				ps.setString(2,cliente.getClientecpf());
								
				ps.execute(); //executa a acao
				JOptionPane.showMessageDialog(null, "Alterado com Sucesso !");
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "erro no alterar"+e.getMessage());
			}
		}
		
		//Consulta - OK
		public Cliente consultar(String clientenome){
			
			conn = Conexao.getConexao();
			Cliente cliente = new Cliente();
			sql = "select * from cliente where clientenome ='"+clientenome+"'";
				
			try{
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();		
				
				if(rs.next()){
					cliente.setClientecod(rs.getInt("clientecod"));
					cliente.setClientecpf(rs.getString("clientecpf"));	
					cliente.setClientenome(rs.getString("clientenome"));
							
				}else{
					JOptionPane.showMessageDialog(null, "Cliente não Encontrado!");
				}
			}catch(SQLException e){
				e.getMessage();
			}
			
			return cliente;
		}
		

	}

