package model;

import javax.swing.table.DefaultTableModel;

public class ModeloTabela extends DefaultTableModel{
	private boolean[][] editable_cells;
	
	public ModeloTabela(int rows,int cols){
		super(rows,cols);
		this.editable_cells = new boolean[rows][cols];
	}
	
	@Override
	public boolean isCellEditable(int row , int column){
		return this.editable_cells[row][column];
	}
	public void setCellEditable(int row,int col, boolean value){
		this.editable_cells[row][col] = value;
		this.fireTableCellUpdated(row, col);
	}
}
