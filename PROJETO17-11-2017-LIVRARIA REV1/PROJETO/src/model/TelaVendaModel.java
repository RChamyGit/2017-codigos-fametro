package model;

public class TelaVendaModel {
	public int getLivrocod() {
		return livrocod;
	}
	public void setLivrocod(int livrocod) {
		this.livrocod = livrocod;
	}

	public int getAutorcod() {
		return autorcod;
	}
	public void setAutorcod(int autorcod) {
		this.autorcod = autorcod;
	}
	public String getAutornome() {
		return autornome;
	}
	public void setAutornome(String autornome) {
		this.autornome = autornome;
	}
	public int getEdicaocod() {
		return edicaocod;
	}
	public void setEdicaocod(int edicaocod) {
		this.edicaocod = edicaocod;
	}
	public double getEdicaopreco() {
		return edicaopreco;
	}
	public void setEdicaopreco(double edicaopreco) {
		this.edicaopreco = edicaopreco;
	}
	private int edicaocod;
	private int livrocod;
	private double edicaopreco;
	private int autorcod;
	private String autornome;
	private String livronome;
	public String getLivronome() {
		return livronome;
	}
	public void setLivronome(String livronome) {
		this.livronome = livronome;
	}
	
	
	// model que recebe os dados necessarios para realizar a venda select autor_livro.livrocod, livro.livropreco, autor_livro.autorcod autor.autornome
}
