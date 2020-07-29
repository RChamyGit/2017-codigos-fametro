package view;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.CadLivroDao;
import model.Livro;

public class Cadlivro implements ActionListener {

	Livro livro = new Livro();
	CadLivroDao livrodao = new CadLivroDao();
	
	JFrame janela = new JFrame("CADASTRO DE LIVROS");
	JPanel painel = new JPanel();

	JLabel lblivronome = new JLabel("Nome");
	JLabel lblivroidioma = new JLabel("Idioma");
	JLabel lblivroano = new JLabel("Ano");
	 //JLabel lblivropreco = new JLabel("Preço");
	
	JTextField txtlivronome = new JTextField();
	JTextField txtlivroidioma = new JTextField();
	JTextField txtlivroano= new JTextField();
	//JTextField txtlivropreco= new JTextField();
	
	JButton btlivrosalvar = new JButton("Salvar");
	JButton btlivroconsultar = new JButton("Consultar");
	JButton btlivroexcluir = new JButton("Excluir");
	JButton btlivroalterar = new JButton("Alterar");
	JButton btlivrovoltar = new JButton("Voltar");
	JButton btlivroeditora = new JButton("Editora");
	JButton btlivroedicao = new JButton("Edição");
	
	void criarTela(){
		//largura x altura
		janela.setSize(600, 520);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		painel.setLayout(null);
		
		lblivronome.setBounds(10, 10, 100, 30);
		txtlivronome.setBounds(10, 40, 100, 30);
		lblivroidioma.setBounds(10, 70, 100, 30);
		txtlivroidioma.setBounds(10, 100, 100, 30);
		lblivroano.setBounds(10, 130, 100, 30);
		txtlivroano.setBounds(10, 160, 100, 30);
		//lblivropreco.setBounds(10, 200, 100, 30);
		//txtlivropreco.setBounds(10, 230, 100, 30);

		btlivrosalvar.setBounds(10, 340, 100, 30);
		btlivrosalvar.addActionListener(this);//acao
		btlivroconsultar.setBounds(140, 340, 100, 30);
		btlivroconsultar.addActionListener(this);//acao
		btlivroexcluir.setBounds(10, 400, 100, 30);
		btlivroexcluir.addActionListener(this);//acao
		btlivroalterar.setBounds(140, 400, 100, 30);
		btlivroalterar.addActionListener(this);//acao
		btlivrovoltar.setBounds(270, 400, 100, 30);
		btlivrovoltar.addActionListener(this);//acao
		btlivroeditora.setBounds(270, 340, 100, 30);
		btlivroeditora.addActionListener(this);//acao
		btlivroedicao.setBounds(400, 400, 100, 30);
		btlivroedicao.addActionListener(this);//acao
		
		painel.add(lblivronome);
		painel.add(txtlivronome);
		//painel.add(lblivropreco);
		//painel.add(txtlivropreco);
		painel.add(lblivroidioma);
		painel.add(txtlivroidioma);
		painel.add(lblivroano);
		painel.add(txtlivroano);
		
		painel.add(btlivrosalvar);
		painel.add(btlivroconsultar);
		painel.add(btlivroexcluir);
		painel.add(btlivroalterar);
		painel.add(btlivrovoltar);
		painel.add(btlivroeditora);
		painel.add(btlivroedicao);
		
		janela.getContentPane().add(painel);
		janela.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		Cadlivro t = new Cadlivro();
		t.criarTela();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btlivrosalvar){
			
			livro.setLivronome(txtlivronome.getText());
			livro.setLivroidioma(txtlivroidioma.getText());
			livro.setLivroano(Integer.parseInt(txtlivroano.getText()));
			//livro.setLivropreco(Double.parseDouble(txtlivropreco.getText()));
					
			livrodao.salvar(livro);
			
			txtlivronome.setText("");
			txtlivroidioma.setText("");
			txtlivroano.setText("");
			//txtlivropreco.setText("");
			
		}
		if(e.getSource() == btlivroconsultar){
				
			livro = livrodao.consultar(txtlivronome.getText());
			
			txtlivronome.setText(livro.getLivronome());
			txtlivroidioma.setText(livro.getLivroidioma());
			txtlivroano.setText(Integer.toString(livro.getLivroano()));
		//	txtlivropreco.setText(Double.toString(livro.getLivropreco()));
			
		}

		if(e.getSource() == btlivroexcluir){
			
			String livr = txtlivronome.getText();	
			
			livro = livrodao.consultar(livr);
			
			livrodao.deletar(livro);
			
			txtlivronome.setText("");
			txtlivroidioma.setText("");
			txtlivroano.setText("");
			//txtlivropreco.setText("");				
		}
		
		if(e.getSource() == btlivrovoltar){
			Menu t = new Menu();
			t.criarTela();
		}
		
		if(e.getSource() == btlivroalterar){
			
			livro.setLivronome(txtlivronome.getText());
			livro.setLivroidioma(txtlivroidioma.getText());
			livro.setLivroano(Integer.parseInt(txtlivroano.getText()));
			//livro.setLivropreco(Double.parseDouble(txtlivropreco.getText()));
					
			livrodao.alterar(livro);
			
		}
		
		if(e.getSource() == btlivroeditora){
			Cadeditora t = new Cadeditora();
			t.criarTela();
		}
		if(e.getSource() == btlivroedicao){
			Cadedicao t = new Cadedicao();
			t.criarTela(livro);
		}
	}
}
