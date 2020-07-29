package controller;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.TelaVendaModel;

public class RenderizadorListaVenda extends JLabel implements ListCellRenderer<TelaVendaModel>{ //Nao usar mais. Substituido por JTable
	
	public RenderizadorListaVenda() {
		setOpaque(true);
	}
	@Override
	
	public Component getListCellRendererComponent(JList<? extends TelaVendaModel> lista, TelaVendaModel edicoesvenda, int indice,
			boolean isSelected, boolean cellHasFocus) {
		
		/*setText(edicoesvenda.getAutornome());
		setText(Integer.toString(edicoesvenda.getLivrocod()));
		setText(Double.toString(edicoesvenda.getLivropreco()));
		Nao funciona*/ 
		if (isSelected) {
            setBackground(lista.getSelectionBackground());
            setForeground(lista.getSelectionForeground());
        } else {
            setBackground(lista.getBackground());
            setForeground(lista.getForeground());
        } 
		return this;
	}

}



/*
package net.codejava.swing;
 
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import net.codejava.model.Country;
 
/**
 * Custom renderer to display a country's flag alongside its name
 *
 * @author wwww.codejava.net
 */
/*public class CountryRenderer extends JLabel implements ListCellRenderer<Country> {
 
    @Override
    public Component getListCellRendererComponent(JList<? extends Country> list, Country country, int index,
        boolean isSelected, boolean cellHasFocus) {
          
        String code = country.getCode();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/" + code + ".png"));
         
        setIcon(imageIcon);
        setText(country.getName());
         
        return this;
    }
     
}*/