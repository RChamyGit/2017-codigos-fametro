

package view;



import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.CadLivroDao;
import controller.RenderizadorListaVenda;
import controller.VendaDao;

import model.Cliente;
import model.Livro;
import model.TelaVendaModel;
import model.ModeloTabela;
//import Dao;
//import model;

public class TelaVenda extends JFrame implements ActionListener {

	
	
    private final String colunas[]={"Cod. Edicao","Titulo Livro","Autor","Preço"};
    ModeloTabela modelotabela = new ModeloTabela(10, colunas.length);
    private JTable table;
	Cliente cli_importado = new Cliente(); //actionlistener nao usa objetos declarados externamente. 
    
	JFrame janela = new JFrame("VENDA");
	JPanel painel = new JPanel();
	
	JLabel lbpesq = new JLabel("Titulo Livro");
	JTextField txtpesquisa = new JTextField();
	JButton btpesquisaedicao = new JButton("CONSULTAR EDICOES");

	JLabel lbnomecliente = new JLabel("Cliente");
	JLabel lbnomelivro = new JLabel("Livro");
	JLabel lbcodigoedicao = new JLabel("Cod Edicao");
	JLabel lbautorlivro = new JLabel("Autor");
	JLabel lbprecolivro = new JLabel("Preço");
	JLabel lbvalortotal = new JLabel("Valor Total");
	JLabel lbvalor = new JLabel("Valor");
	JLabel lbquantidade = new JLabel("Quantidade");
	JLabel lbvalortroco = new JLabel("Valor Troco");
	JLabel lbvalorinformado = new JLabel("Valor Pago: ");
	
	JTextField txtnomecliente = new JTextField();
	JTextField txtnomelivro = new JTextField();
	JTextField txtcodigoedicao = new JTextField();
	JTextField txtautorlivro = new JTextField();
	JTextField txtprecolivro = new JTextField();
	JTextField txtvalortotal = new JTextField();
	JTextField txtvalor = new JTextField();
	JTextField txtquantidade = new JTextField(); // TROCAR POR UM MENU DROP DOWN NA PROXIMA REVISAO
	JTextField txtvalortroco = new JTextField();
	JTextField txtvalorinformado = new JTextField();
	//LISTA
	
	
	
	//botoes
	JButton btconfirmar = new JButton("Confirmar");
	JButton btvoltar = new JButton("Voltar");
	
	
	

	public void criarTela(Cliente clivenda){
		//lista
		/*JList lista = new JList(modelo_lista);
		lista.setCellRenderer(new RenderizadorListaVenda());
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lista.setLayoutOrientation(JList.VERTICAL);
		lista.setVisibleRowCount(-1); */
		cli_importado = clivenda;
		//tabela!
		modelotabela.setColumnIdentifiers(colunas); //faz as colunas terem os nomes contidos no vetor colunas
		table=new JTable(modelotabela);
        table.setPreferredScrollableViewportSize(new Dimension(520,220));//barra de rolagem
        table.setFillsViewportHeight(true);
        table.addMouseListener(new MouseAdapter() {  //tambem posso usar MouseAdapter no implement.
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int selecao = table.getSelectedRow();
        		txtautorlivro.setText(table.getModel().getValueAt(selecao, 2).toString());
        		double calcvalor = Double.parseDouble(table.getModel().getValueAt(selecao, 3).toString())*Double.parseDouble(txtquantidade.getText());
        		txtvalortotal.setText(Double.toString(calcvalor)); //possivel gambiarra
        		txtnomelivro.setText(table.getModel().getValueAt(selecao, 1).toString());
        		txtvalortroco.setText(Double.toString(Double.parseDouble(txtvalorinformado.getText())-calcvalor));//trocar calctroco pelo campo valor pago
        		//JOptionPane.showMessageDialog(null, "testa evento"); //REMOVER
        	}
        });
         
                //adicionando a tabela em uma barra de rolagem, ficará envolta , pela mesma 
        JScrollPane scrollPane=new JScrollPane(table);
                 
                //adicionando ao JFrame "Formulário" a JTable "Tabela" 
        add(scrollPane);
		
		//largura x altura
		janela.setSize(1024, 600);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		painel.setLayout(null);
		
		
		lbpesq.setBounds(10, 10, 100, 30);
		txtpesquisa.setBounds(80, 10, 300, 30);
		lbnomecliente.setBounds(10, 90, 100, 30);
		txtnomecliente.setBounds(80, 90, 300, 30);
		lbnomelivro.setBounds(10, 160, 100, 30);
		txtnomelivro.setBounds(80, 160, 300, 30);
		lbautorlivro.setBounds(10, 220, 100, 30);
		txtautorlivro.setBounds(80, 220, 300, 30);
		lbprecolivro.setBounds(10, 350, 100, 30);
		txtprecolivro.setBounds(10, 380, 100, 30);
		lbvalortotal.setBounds(250, 350, 100, 30);
		txtvalortotal.setBounds(250, 380, 100, 30);
		lbvalorinformado.setBounds(380, 350, 100, 30);
		txtvalorinformado.setBounds(380,380, 100, 30);
		lbvalortroco.setBounds(500, 350, 100, 30);
		txtvalortroco.setBounds(500, 380, 100, 30);
		lbquantidade.setBounds(10, 280, 100, 30);
		txtquantidade.setBounds(80, 280, 100, 30);
		lbcodigoedicao.setBounds(10,240, 100, 30);
		scrollPane.setBounds(480, 90, 480, 240);
		
		//config de alguns textfields.
		txtnomecliente.setText(cli_importado.getClientenome());
		txtnomecliente.setEditable(false);
		txtvalortroco.setEditable(false);
		txtvalortotal.setEditable(false);
		txtquantidade.setText("1");
		txtvalortroco.setText("0.00");
		
		btpesquisaedicao.setBounds(400, 10, 150, 30);
		btpesquisaedicao.addActionListener(this);//acao

		btconfirmar.setBounds(340, 500, 100, 30);
		btconfirmar.addActionListener(this);//acao
		
		//criar botao de pesquisa de cliente
		painel.add(txtpesquisa);
		painel.add(lbpesq);
		painel.add(lbnomecliente);
		painel.add(txtnomecliente);
		painel.add(lbnomelivro);
		painel.add(txtnomelivro);
		painel.add(lbautorlivro);
		painel.add(txtautorlivro);
		//painel.add(lbprecolivro);
		//painel.add(txtprecolivro);
		painel.add(lbvalortotal);
		painel.add(txtvalortotal);
		painel.add(lbvalortroco); //add troco
		painel.add(txtvalortroco);
		painel.add(lbquantidade);
		painel.add(txtquantidade);
		painel.add(lbcodigoedicao);
		painel.add(txtcodigoedicao);
		painel.add(lbvalorinformado);
		painel.add(txtvalorinformado);
		painel.add(btpesquisaedicao);
		painel.add(btconfirmar);
		painel.add(btvoltar);
		
		txtnomecliente.setText(clivenda.getClientenome()); 
		
		//painel.add(lista); removido, lista só suporta um valor, cenário pede JTable
		painel.add(scrollPane);
		
		janela.getContentPane().add(painel);
		janela.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		TelaVenda t = new TelaVenda();
		t.criarTela(new Cliente());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btconfirmar){ //confirmar venda
			if(txtvalortroco.getText() != null && Double.parseDouble(txtvalortroco.getText()) >= 0){
			VendaDao vendadao = new VendaDao();
			int selecao = table.getSelectedRow();
			vendadao.salvar(Integer.parseInt(table.getModel().getValueAt(selecao, 0).toString()), cli_importado, Double.parseDouble(txtvalortotal.getText()));
			// Verificar se preciso mesmo converter pro tipo que será enviado pro SQL.
			//falta linkar nome cliente com a tal janela
			}else
				System.out.println("Valor informado invalido!!!");
			}
		
		
		
		
		if(e.getSource() == btvoltar){ //tela anterior
	
		}
		
		
		
		if(e.getSource() == btpesquisaedicao) {
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			VendaDao vendadao = new VendaDao();
			TelaVendaModel dadosvenda = new TelaVendaModel();
			//teste
			txtprecolivro.setText(Double.toString(dadosvenda.getEdicaopreco()));
			//teste
			System.out.println(dadosvenda.getAutornome());
			int cont=0;
			
			for (TelaVendaModel i : vendadao.consultarEdicao(txtpesquisa.getText())) { //i é um elemento do arraylist
				model.setValueAt(i.getEdicaocod(), cont, 0); //(new Object[]{i.getEdicaocod(),i.getAutornome(),i.getEdicaopreco()});
				model.setValueAt(i.getLivronome(), cont, 1);
				model.setValueAt(i.getAutornome(), cont, 2);
				model.setValueAt(i.getEdicaopreco(), cont, 3);
				cont++;
				
				/*USAR JTABLE -> 21//11/2017 - JTable funcionando, falta arrumar pesquisa aparecendo no fim
								 23/11/2017 - Consertado - add trocado por setvalueat(valor, contador_linha, coluna)
						*///modelo_lista.addElement(i); //preciso criar um renderizador personalizado. 
	               System.out.println(i.getAutornome());
			}
		}

	}

}