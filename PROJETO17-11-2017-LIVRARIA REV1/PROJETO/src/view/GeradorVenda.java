package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GeradorVenda {
	
	JFrame janela = new JFrame("GERADOR VENDA");
	JPanel painel = new JPanel();
	
	JLabel lbcliente = new JLabel("CLIENTE");
	JLabel lblivro= new JLabel("LIVRO");
	JLabel lbautor= new JLabel("AUTOR");
	JLabel lbpunitario = new JLabel("PREÇO UNITÁRIO");
	JLabel lbqtd= new JLabel("QUANTIDADE");
	JLabel lbvalortotal= new JLabel("VALOR TOTAL");
	JLabel lbvalorpago= new JLabel("VALOR PAGO");
	JLabel lbtroco= new JLabel("TROCO");
	
	JTextField txtcliente = new JTextField();
	JTextField txtautor = new JTextField();
	//JTextField txtautor = new JTextField();
	
	
void criarTela(){
		
		janela.setSize(600, 520);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		painel.setLayout(null);
		
		lbcliente.setBounds(10, 40, 60, 30);
		txtcliente.setBounds(70, 40, 400, 26);
		lbautor.setBounds(10, 100, 60, 20);
		txtautor.setBounds(70, 100, 300, 26);
		

		painel.add(lbcliente);
		painel.add(txtcliente);
		painel.add(lbautor);
		painel.add(txtautor);
		
		janela.getContentPane().add(painel);
		janela.setVisible(true);
		
}

	public static void main(String[] args) {
		GeradorVenda gv = new GeradorVenda();
		gv.criarTela();
	}
}
