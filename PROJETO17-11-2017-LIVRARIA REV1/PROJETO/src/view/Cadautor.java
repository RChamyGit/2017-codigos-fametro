package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.CadautorDao;
import model.Autor;

public class Cadautor implements ActionListener {

	Autor autor = new Autor();
	CadautorDao autordao = new CadautorDao();
	
	JFrame janela = new JFrame("CADASTRO DE AUTORES DE LIVROS");
	JPanel painel = new JPanel();

	JLabel lbautornome = new JLabel("Nome");
	JLabel lbautornasc = new JLabel("Ano de Nasc.");
	
	JTextField txtautornome = new JTextField();
	JTextField txtautornasc = new JTextField();
	
	JButton btautorsalvar = new JButton("Salvar");
	JButton btautorconsultar = new JButton("Consultar");
	JButton btautorexcluir = new JButton("Excluir");
	JButton btautoralterar = new JButton("Alterar");
	JButton btautorvoltar = new JButton("Voltar");
		
	void criarTela(){
		//largura x altura
		janela.setSize(600, 520);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		painel.setLayout(null);
		
		lbautornome.setBounds(10, 10, 100, 30);
		txtautornome.setBounds(10, 40, 100, 30);
		lbautornasc.setBounds(10, 70, 100, 30);
		txtautornasc.setBounds(10, 100, 100, 30);
	
		btautorsalvar.setBounds(10, 340, 100, 30);
		btautorsalvar.addActionListener(this);//acao
		btautorconsultar.setBounds(140, 340, 100, 30);
		btautorconsultar.addActionListener(this);//acao
		btautorexcluir.setBounds(10, 400, 100, 30);
		btautorexcluir.addActionListener(this);//acao
		btautoralterar.setBounds(140, 400, 100, 30);
		btautoralterar.addActionListener(this);//acao
		btautorvoltar.setBounds(270, 400, 100, 30);
		btautorvoltar.addActionListener(this);//acao
		
		painel.add(lbautornome);
		painel.add(txtautornome);
		painel.add(lbautornasc);
		painel.add(txtautornasc);
		
		painel.add(btautorsalvar);
		painel.add(btautorconsultar);
		painel.add(btautorexcluir);
		painel.add(btautoralterar);
		painel.add(btautorvoltar);
		janela.getContentPane().add(painel);
		janela.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		Cadautor t = new Cadautor();
		t.criarTela();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btautorsalvar){
			
			autor.setAutornome(txtautornome.getText());
			autor.setAutornasc(Integer.parseInt(txtautornasc.getText()));
			autordao.salvar(autor);
			
			txtautornome.setText("");
			txtautornasc.setText("");
		}
		if(e.getSource() == btautorconsultar){
			
			autor = autordao.consultar(txtautornome.getText());
			txtautornome.setText(autor.getAutornome());
			txtautornasc.setText(Integer.toString(autor.getAutornasc()));
		}

		if(e.getSource() == btautorexcluir){
			
			String del = txtautornome.getText();
			autor = autordao.consultar(del); 
			autordao.deletar(autor);
			
			txtautornome.setText("");
			txtautornasc.setText("");
		}
	
		if(e.getSource() == btautorvoltar){
			Cadlivro t = new Cadlivro();
			t.criarTela();
		}
		
		if(e.getSource() == btautoralterar){
			
			autor.setAutornome(txtautornome.getText());
			autor.setAutornasc((Integer.parseInt(txtautornasc.getText())));
			
			txtautornome.setText("");
			txtautornasc.setText("");
			
		}
		
	}
}
