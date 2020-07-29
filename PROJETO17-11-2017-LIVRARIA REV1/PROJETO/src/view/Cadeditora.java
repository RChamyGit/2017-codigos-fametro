package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.CadeditoraDao;
import model.Editora;


public class Cadeditora implements ActionListener {

	Editora editora = new Editora();
	CadeditoraDao editoradao = new CadeditoraDao();
	
	JFrame janela = new JFrame("CADASTRO DE EDITORAS");
	JPanel painel = new JPanel();

	JLabel lbeditoranome = new JLabel("Nome");
	JLabel lbeditorafone = new JLabel("Telefone");
	JLabel lbeditoraendereco = new JLabel("Endereço");
	
	JTextField txteditoranome = new JTextField();
	JTextField txteditorafone = new JTextField();
	JTextField txteditoraendereco = new JTextField();
	
	JButton bteditorasalvar = new JButton("Salvar");
	JButton bteditoraconsultar = new JButton("Consultar");
	JButton bteditoraexcluir = new JButton("Excluir");
	JButton bteditoraalterar = new JButton("Alterar");
	JButton bteditoravoltar = new JButton("Voltar");
	JTextArea txtAreaLista = new JTextArea("");
	
	void criarTela(){
		//largura x altura
		janela.setSize(600, 520);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		painel.setLayout(null);
		
		lbeditoranome.setBounds(10, 10, 100, 30);
		txteditoranome.setBounds(10, 40, 100, 30);
		lbeditorafone.setBounds(10, 70, 100, 30);
		txteditorafone.setBounds(10, 100, 100, 30);
		lbeditoraendereco.setBounds(10, 130, 100, 30);
		txteditoraendereco.setBounds(10, 160, 100, 30);

		bteditorasalvar.setBounds(10, 340, 100, 30);
		bteditorasalvar.addActionListener(this);//acao
		bteditoraconsultar.setBounds(140, 340, 100, 30);
		bteditoraconsultar.addActionListener(this);//acao
		bteditoraexcluir.setBounds(10, 400, 100, 30);
		bteditoraexcluir.addActionListener(this);//acao
		bteditoraalterar.setBounds(140, 400, 100, 30);
		bteditoraalterar.addActionListener(this);//acao
		bteditoravoltar.setBounds(270, 400, 100, 30);
		bteditoravoltar.addActionListener(this);//acao
		
		painel.add(lbeditoranome);
		painel.add(txteditoranome);
		painel.add(lbeditorafone);
		painel.add(txteditorafone);
		painel.add(lbeditoraendereco);
		painel.add(txteditoraendereco);
		
		painel.add(bteditorasalvar);
		painel.add(bteditoraconsultar);
		painel.add(bteditoraexcluir);
		painel.add(bteditoraalterar);
		painel.add(bteditoravoltar);
		janela.getContentPane().add(painel);
		janela.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		Cadeditora t = new Cadeditora();
		t.criarTela();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bteditorasalvar){
			
			editora.setEditoranome(txteditoranome.getText());
			editora.setEditorafone(Integer.parseInt(txteditorafone.getText()));
			editora.setEditoraendereco(txteditoraendereco.getText());
						
			editoradao.salvar(editora);
			
			txteditoranome.setText("");
			txteditorafone.setText("");
			txteditoraendereco.setText("");
				
		}
		if(e.getSource() == bteditoraconsultar){
				
			editora = editoradao.consultar(txteditoranome.getText());
				
			txteditoranome.setText(editora.getEditoranome());
			txteditorafone.setText(Integer.toString(editora.getEditorafone()));
			txteditoraendereco.setText(editora.getEditoraendereco());
			
		}

		if(e.getSource() == bteditoraexcluir){
			
			String cli = txteditoranome.getText();
				
			editora = editoradao.consultar(cli);

			editoradao.deletar(editora);
				
			txteditoranome.setText("");
			txteditorafone.setText("");
			txteditoraendereco.setText("");
				
		}
		
		if(e.getSource() == bteditoravoltar){
			Cadlivro t = new Cadlivro();
			t.criarTela();
		}
		
		if(e.getSource() == bteditoraalterar){
			
			editora.setEditoranome(txteditoranome.getText());
			editora.setEditorafone(Integer.parseInt(txteditorafone.getText()));
			editora.setEditoraendereco(txteditoraendereco.getText());
					
			editoradao.alterar(editora);
			
		}
		
	}
}
