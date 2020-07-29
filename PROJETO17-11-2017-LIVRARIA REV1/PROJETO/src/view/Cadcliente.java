package view;

	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;

import javax.swing.JPanel;
	import javax.swing.JTextArea;
	import javax.swing.JTextField;
	import controller.CadclienteDao;
	import model.Cliente;

	public class Cadcliente implements ActionListener {

		Cliente cliente = new Cliente();
		CadclienteDao clientedao = new CadclienteDao();
		
		JFrame janela = new JFrame("CADASTRO DE CLIENTES");
		JPanel painel = new JPanel();

		JLabel lbclientenome = new JLabel("NOME");
		JLabel lbclientecpf = new JLabel("CPF");
		
		JTextField txtclientenome = new JTextField();
		JTextField txtclientecpf = new JTextField();
		
		JButton btclientesalvar = new JButton("Salvar");
		JButton btclienteconsultar = new JButton("Consultar");
		JButton btclienteexcluir = new JButton("Excluir");
		JButton btclientealterar = new JButton("Alterar");
		JButton btclientevoltar = new JButton("Voltar");
		JTextArea txtAreaLista = new JTextArea("");
		
		void criarTela(){
			//largura x altura
			janela.setSize(600, 520);
			janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			painel.setLayout(null);
			
			lbclientenome.setBounds(10, 10, 100, 30);
			txtclientenome.setBounds(10, 40, 170, 30);
			lbclientecpf.setBounds(10, 70, 100, 30);
			txtclientecpf.setBounds(10, 100, 170, 30);
		
			btclientesalvar.setBounds(10, 360, 100, 30);
			btclientesalvar.addActionListener(this);//acao
			btclienteconsultar.setBounds(140, 360, 100, 30);
			btclienteconsultar.addActionListener(this);//acao
			btclienteexcluir.setBounds(10, 420, 100, 30);
			btclienteexcluir.addActionListener(this);//acao
			btclientealterar.setBounds(140, 420, 100, 30);
			btclientealterar.addActionListener(this);//acao
			btclientevoltar.setBounds(270, 420, 100, 30);
			btclientevoltar.addActionListener(this);//acao
			
			painel.add(lbclientenome);
			painel.add(txtclientenome);
			painel.add(lbclientecpf);
			painel.add(txtclientecpf);
			
			painel.add(btclientesalvar);
			painel.add(btclienteconsultar);
			painel.add(btclienteexcluir);
			painel.add(btclientealterar);
			painel.add(txtAreaLista);
			painel.add(btclientevoltar);
			janela.getContentPane().add(painel);
			janela.setVisible(true);
			
		}
		
		public static void main(String[] args) {
			Cadcliente t = new Cadcliente();
			t.criarTela();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			//Botão Funcionando
			if(e.getSource() == btclientesalvar){
				
				cliente.setClientenome(txtclientenome.getText());
				cliente.setClientecpf(txtclientecpf.getText());
					
				clientedao.salvar(cliente);
			
				txtclientenome.setText("");
				txtclientecpf.setText("");
						
			}
			//Botão Funcionando
			if(e.getSource() == btclienteconsultar){
				
				cliente = clientedao.consultar(txtclientenome.getText());
				txtclientenome.setText(cliente.getClientenome());
				txtclientecpf.setText(cliente.getClientecpf());
				
				
			}
			//Botão Funcionando
			if(e.getSource() == btclienteexcluir){
				String cli = txtclientenome.getText();
				
				cliente = clientedao.consultar(cli);

				clientedao.deletar(cliente);
				txtclientenome.setText("");
				txtclientecpf.setText("");
				
			}
	
			
			if(e.getSource() == btclientevoltar){
				Menu t = new Menu();
				t.criarTela();
			}
			//Botão Funcionando
			if(e.getSource() == btclientealterar){
				
				cliente.setClientenome(txtclientenome.getText());
				cliente.setClientecpf(txtclientecpf.getText());
						
				clientedao.alterar(cliente);
				
			}
			
		}
	}
