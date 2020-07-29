package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.CadedicaoDao;
import model.Edicao;
import model.Livro;

public class Cadedicao implements ActionListener {

	Edicao edicao = new Edicao();
	CadedicaoDao edicaodao = new CadedicaoDao();
	
	JFrame janela = new JFrame("CADASTRO DA EDIÇÃO DOS LIVROS");
	JPanel painel = new JPanel();

	JLabel lbedicaonumero = new JLabel("Código");
	
	JTextField txtedicaonumero= new JTextField();

	JButton btedicaosalvar = new JButton("Salvar");
	JButton btedicaoconsultar = new JButton("Consultar");
	JButton btedicaoexcluir = new JButton("Excluir");
	JButton btedicaoalterar = new JButton("Alterar");
	JButton btedicaovoltar = new JButton("Voltar");
	JTextArea txtAreaLista = new JTextArea("");
	
	void criarTela(Livro livro){ 
		//largura x altura
		janela.setSize(600, 520);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		painel.setLayout(null);
		
		lbedicaonumero.setBounds(10, 10, 100, 30);
		txtedicaonumero.setBounds(10, 40, 100, 30);

		btedicaosalvar.setBounds(10, 340, 100, 30);
		btedicaosalvar.addActionListener(this);//acao
		btedicaoconsultar.setBounds(140, 340, 100, 30);
		btedicaoconsultar.addActionListener(this);//acao
		btedicaoexcluir.setBounds(10, 400, 100, 30);
		btedicaoexcluir.addActionListener(this);//acao
		btedicaoalterar.setBounds(140, 400, 100, 30);
		btedicaoalterar.addActionListener(this);//acao
		btedicaovoltar.setBounds(270, 400, 100, 30);
		btedicaovoltar.addActionListener(this);//acao
		
		painel.add(lbedicaonumero);
		painel.add(txtedicaonumero);
		
		painel.add(btedicaosalvar);
		painel.add(btedicaoconsultar);
		painel.add(btedicaoexcluir);
		painel.add(btedicaoalterar);
		painel.add(txtAreaLista);
		painel.add(btedicaovoltar);
		janela.getContentPane().add(painel);
		janela.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		Cadedicao t = new Cadedicao();
		t.criarTela(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btedicaosalvar){
		
			edicao.setEdicaonumero(Integer.parseInt(txtedicaonumero.getText()));
			edicaodao.salvar(edicao);
			
			txtedicaonumero.setText("");
		}
		if(e.getSource() == btedicaoconsultar){
			
			edicao = edicaodao.consultar(txtedicaonumero.getText());
			
			txtedicaonumero.setText(Integer.toString(edicao.getEdicaonumero()));
		}

		if(e.getSource() == btedicaoexcluir){
			String cli = txtedicaonumero.getText();
			
			edicao = edicaodao.consultar(cli);

			edicaodao.deletar(edicao);
				
			txtedicaonumero.setText("");
		}
		
		if(e.getSource() == btedicaovoltar){
			Cadlivro t = new Cadlivro();
			t.criarTela();
		}
		
		if(e.getSource() == btedicaoalterar){
			
			edicao.setEdicaonumero(Integer.parseInt(txtedicaonumero.getText()));
			edicaodao.alterar(edicao);
		}
	}	
}