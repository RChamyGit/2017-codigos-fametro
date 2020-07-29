package view;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.CadclienteDao;
import model.Cliente;
 
public class Tabela extends JFrame{ //classe teste, nao usar.
	Cliente cliente = new Cliente();
	CadclienteDao clientedao = new CadclienteDao();
	//Classe de teste - Nao usar.

	
     
        //variaveis para uso da JTable 
    private JTable table;
    private final String colunas[]={"NOME CLIENTE","CPF CLIENTE"};
    private final String dados[][]= {};
            
     
        /*Construtor da classe ,
          antes de executar o metodo main(),
          ir� construir o JFrame e a JTable*/
    
   
    public Tabela() {
        setLayout(new FlowLayout());//tipo de layout
        setSize(new Dimension(600, 200));//tamanho do Formulario
        setLocationRelativeTo(null);//centralizado
        setTitle("Exemplo JTable");//titulo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//setando a a��o padr�o de fechamento do Formul�rio,
                                                               // neste caso  ir� fechar o programa
         
                //instanciando a JTable
        table=new JTable(dados,colunas);
        table.setPreferredScrollableViewportSize(new Dimension(500,100));//barra de rolagem
        table.setFillsViewportHeight(true);
         
                //adicionando a tabela em uma barra de rolagem, ficar� envolta , pela mesma 
        JScrollPane scrollPane=new JScrollPane(table);
                 
                //adicionando ao JFrame "Formul�rio" a JTable "Tabela" 
        add(scrollPane);
    }
    
  //este � o m�todo onde � executado nosso programa
    public static void main(String[] args) {
        new Tabela().setVisible(true);
    }
}