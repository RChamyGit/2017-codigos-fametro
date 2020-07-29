package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu implements ActionListener{

	JFrame janela = new JFrame("CADASTRO");
	JPanel painel = new JPanel();
	
	JButton bttelaum = new JButton("CLIENTE");
	JButton btteladois = new JButton("LIVRO");
	JButton bttelavenda = new JButton("VENDA");
	
	JButton btsair = new JButton("SAIR");
	
	void criarTela(){
		//largura x altura
		janela.setSize(600, 520);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		painel.setLayout(null);
		
		bttelaum.setBounds(10, 340, 100, 30);
		bttelaum.addActionListener(this);//acao
		btteladois.setBounds(140, 340, 100, 30);
		btteladois.addActionListener(this);//acao
		bttelavenda.setBounds(270, 340, 100, 30);
		bttelavenda.addActionListener(this);//acao
		btsair.setBounds(400, 340, 100, 30);
		btsair.addActionListener(this);//acao
		
		painel.add(bttelaum);
		painel.add(btteladois);
		painel.add(bttelavenda);
		painel.add(btsair);
		
		janela.getContentPane().add(painel);
		janela.setVisible(true);
		
	}
	public static void main(String[] args) {
		Menu t = new Menu();
		t.criarTela();

	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bttelaum){
			Cadcliente t = new Cadcliente();
			t.criarTela();
		}
		
		if(e.getSource() == bttelavenda){
			Venda v = new Venda();
				v.criarTela();
			}
		if(e.getSource() == btteladois){
			Cadlivro t = new Cadlivro();
			t.criarTela();
		}

		
		if(e.getSource() == btsair){
			
		}
	}
}
