package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaLogin implements ActionListener{
	
	JFrame janela = new JFrame("SEJA BEM-VINDO | Desenvolvido P/ #AK#LC#LO#RC|2017| Manaus-AM-Brasil");
	JPanel painel = new JPanel();
	
	
	JLabel lblogin = new JLabel("Login");
	JLabel lbsenha = new JLabel("Password");
	
	JTextField txtlogin = new JTextField();
	JPasswordField  txtsenha= new JPasswordField ();
	
	JButton btacessar = new JButton("Acessar");
	JButton btcancelar = new JButton("Cancelar");
	
	void CriatTela() {
		janela.setSize(600,520);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		painel.setLayout(null);
		
		lblogin.setBounds(270, 130, 100, 30);
		txtlogin.setBounds(215, 160, 150, 30);
		lbsenha.setBounds(260, 190, 100, 30);
		txtsenha.setBounds(215, 220, 150, 30);
		
		btacessar.setBounds(180, 360, 100, 30);
		btacessar.addActionListener(this);//acao
		btcancelar.setBounds(300, 360, 100, 30);
		btcancelar.addActionListener(this);//acao
		
		painel.add(lblogin);
		painel.add(txtlogin);
		painel.add(lbsenha);
		painel.add(txtsenha);
		
		painel.add(btacessar);
		painel.add(btcancelar);

		janela.getContentPane().add(painel);
		janela.setVisible(true);
	}
	
	public static void main(String[] args) {
		TelaLogin t = new TelaLogin();
		t.CriatTela();
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btacessar){
			String Loginadm = (txtlogin.getText());
			@SuppressWarnings("deprecation")
			int Senhaadm=Integer.parseInt(txtsenha.getText());
	        if(Loginadm.equals("Administrador")&& Senhaadm==1234) {
				JOptionPane.showMessageDialog(null, "INICIALIZANDO...");
				Menu menu = new Menu(); //instanciando a classe que tem seu JFrame de cadastro
				menu.criarTela();
		        
	        }else if(e.getSource()==btacessar) {
	        	String Loginvend = (txtlogin.getText());
				@SuppressWarnings("deprecation")
				int Senhavend=Integer.parseInt(txtsenha.getText());
		        if(Loginvend.equals("Vendedor")&& Senhavend==12345) {
					JOptionPane.showMessageDialog(null, "Acesso Permitido");
					//MenuVend menuvend = new Menuvend();
					//menuvend
		        }else {
	        	JOptionPane.showMessageDialog(null,"Usuário não cadastrado! Entre em contato com o Administrador!");
	        	txtlogin.setText("");
				txtsenha.setText("");
		        }
				
	        }

		}
	}
}