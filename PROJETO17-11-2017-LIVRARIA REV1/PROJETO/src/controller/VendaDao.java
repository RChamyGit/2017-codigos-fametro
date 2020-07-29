package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import controller.CadclienteDao;


import connection.Conexao;
import model.Cliente;
import model.TelaVendaModel;

public class VendaDao {
	
// NAO TA PRONTO MAS FUNCIONA - FALTA ADICIONAR TRATAMENTOS DE ERROS
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql = "";
	//Salvar - OK
	
	
	public void salvar(int edicaocod, Cliente dadoscliente, Double valorvenda) {  //
		conn = Conexao.getConexao();
		
		 //pesquisa de cliente CPF!
		CadclienteDao pesqcliente = new CadclienteDao();

			sql = "insert into venda(vendaclientecod, vendaedicaocod, vendavalor) values (?,?,?)"; //FALTA VENDA 
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, Integer.toString(dadoscliente.getClientecod()));
				ps.setString(2, Integer.toString(edicaocod));  //aqui vai o cpf do cliente
				ps.setDouble(3, valorvenda);
				ps.execute();
				System.out.println("venda realizada!");
			}
			catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		
	
	public List<TelaVendaModel> consultarEdicao(String nomelivro){ //pesquisa de dados necessarios para a tela
		conn = Conexao.getConexao();
		List<TelaVendaModel> listavenda = new ArrayList<>();
		
		
		sql = "select edicao.edicaocod,autor_livro.autorcod, autor.autornome , livro.livrocod, "
				+ "livro.livronome, edicao.edicaovalor from"
				+ "(((autor_livro inner join autor on autor_livro.autorcod = autor.autorcod)"
				+ "inner join livro on autor_livro.livrocod = livro.livrocod)"
				+ "inner join edicao on edicao.edicaolivrocod = livro.livrocod) where livronome like '%"+nomelivro+"%'"; // se o valor for nulo, ele imprime todas as edicoes.
		
		try{
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();		
		
			while(rs.next()){
				TelaVendaModel vendapesq = new TelaVendaModel();
				vendapesq.setEdicaocod(rs.getInt("edicaocod"));
				vendapesq.setLivrocod(rs.getInt("livrocod")); // anotacao - tem que ser o nome da coluna da tabela-resultado, nao a original do select.
				vendapesq.setEdicaopreco(rs.getDouble("edicaovalor"));
				vendapesq.setLivronome(rs.getString("livronome"));
				vendapesq.setAutorcod(rs.getInt("autorcod"));
				vendapesq.setAutornome(rs.getString("autornome"));
				listavenda.add(vendapesq);
			}
			rs.close();
			conn.close();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
		return listavenda;
	}
}






//Um algoritmo só está correto se funcionar para N casos.



