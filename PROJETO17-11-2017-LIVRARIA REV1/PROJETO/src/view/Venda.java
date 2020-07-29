package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.CadclienteDao;
import model.Cliente;

public class Venda implements ActionListener{
	
	Cliente cliente = new Cliente();
	CadclienteDao clientedao = new CadclienteDao();
	
	JFrame janela = new JFrame("VENDA");
	JPanel painel = new JPanel();
	
	JLabel lbcliente = new JLabel("CLIENTE");
	JLabel lbcpf= new JLabel("CPF");
	
	JTextField txtcliente = new JTextField();
	JTextField txtcpf = new JTextField();
	
	JButton btcompra = new JButton("GERAR VENDA");
	JButton btpesquisa = new JButton("PESQUISAR");
	JButton btcliente = new JButton(" NOVO CLIENTE");
	JButton btvoltar = new JButton("VOLTAR"); 
	
	void criarTela(){
		
		janela.setSize(600, 520);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		painel.setLayout(null);
		
		lbcliente.setBounds(10, 10, 100, 30);
		lbcpf.setBounds(10, 100, 100, 30);
		
		txtcliente.setBounds(10, 40, 150, 30);
		txtcpf.setBounds(10, 130, 150, 30);
		
		btcompra.setBounds(390, 240, 130, 30);
		btcompra.addActionListener(this);//acao
		btcliente.setBounds(200, 240, 130, 30);
		btcliente.addActionListener(this);//acao
		btpesquisa.setBounds(20, 240, 130, 30);
		btpesquisa.addActionListener(this);//acao
		btvoltar.addActionListener(this);//acao
		btvoltar.setBounds(20, 300, 130, 30);
		
		painel.add(lbcliente);
		painel.add(txtcliente);
		painel.add(lbcpf);
		painel.add(txtcpf);
		painel.add(btcompra);
		painel.add(btcliente);
		painel.add(btpesquisa);
		painel.add(btvoltar);
		janela.getContentPane().add(painel);
		janela.setVisible(true);
	}
	

	public static void main(String[] args) {
		Venda t = new Venda();
		t.criarTela();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btpesquisa){
			cliente = clientedao.consultar(txtcliente.getText());
			txtcliente.setText(cliente.getClientenome());
			txtcpf.setText(cliente.getClientecpf());	
		}
		
		if(e.getSource()==btvoltar){
			Menu t = new Menu();
			t.criarTela();
			
		}
		if(e.getSource()==btcliente){
			Cliente clipesq = new Cliente(); 
			clipesq.setClientenome(txtcliente.getText());
			clipesq.setClientecpf(txtcpf.getText());
			
			CadclienteNovo t = new CadclienteNovo();
			t.criarTela(); //falta verificar se cliente existe
		
		}
		if(e.getSource() == btcompra) {
			
			Cliente clicompra = new Cliente();
			clicompra = clientedao.consultar(txtcliente.getText()); // primeiro ele consulta se o cliente existe. 
			if(clientedao.consultar(txtcliente.getText()) != null) {
				TelaVenda venda = new TelaVenda();
				venda.criarTela(clicompra);
				
			};
					
					
		}
	}
}
