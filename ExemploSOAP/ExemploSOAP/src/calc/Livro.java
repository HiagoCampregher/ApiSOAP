package calc;

import java.io.Serializable;

import javax.xml.soap.SOAPException;

public class Livro implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String titulo;
	private int qtdPaginas;
	private String genero;
	
	Livro(String titulo, int qtdPaginas, String genero) throws SOAPException
	{
		this.setId(0);
		this.setTitulo(titulo);
		this.setQtdPaginas(qtdPaginas);
		this.setGenero(genero);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) throws SOAPException {
		
		if (titulo == null || titulo.isEmpty())
			throw new SOAPException("Título deve ser informado.");
		
		this.titulo = titulo;
	}
	
	public int getQtdPaginas() {
		return qtdPaginas;
	}
	
	public void setQtdPaginas(int qtdPaginas) throws SOAPException {
		if (qtdPaginas <= 0)
			throw new SOAPException("Quantidade de páginas deve ser maior que zero.");
		
		this.qtdPaginas = qtdPaginas;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) throws SOAPException
	{
		if (genero == null || genero.isEmpty())
			throw new SOAPException("Gênero deve ser informado.");
		
		this.genero = genero;
	}
	
	@Override
	public String toString(){
		return id + "- " + getTitulo() + " - " + getGenero() + " - " + getQtdPaginas() + "\n";
	}
}
