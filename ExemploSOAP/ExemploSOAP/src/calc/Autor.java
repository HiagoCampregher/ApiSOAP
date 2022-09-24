package calc;

import java.io.Serializable;
import java.util.HashMap;

import javax.xml.soap.SOAPException;

public class Autor implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private int idade;
	private String nacionalidade;
	
	private HashMap<Integer,Livro> livros = new HashMap<Integer,Livro>();
	private int qtdLivros = 1;
	
	Autor(String nome, int idade, String nacionalidade) throws SOAPException
	{
		this.setId(0);
		this.setNome(nome);
		this.setIdade(idade);
		this.setNacionalidade(nacionalidade);
	}
	
	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) throws SOAPException
	{
		if (nacionalidade == null || nacionalidade.isEmpty())
			throw new SOAPException("Nacionalidade deve ser informada.");
		
		this.nacionalidade = nacionalidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws SOAPException {
		
		if (nome == null || nome.isEmpty())
			throw new SOAPException("Nome deve ser informado.");
		
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) throws SOAPException {
		
		if (idade <= 0)
			throw new SOAPException("Idade deve ser maior que zero.");
		
		this.idade = idade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString(){
		return id + "- " + getNome() + " - " + getIdade() + " - " + getNacionalidade() + "\n";
	}

	public HashMap<Integer,Livro> getLivros() {
		return livros;
	}

	public void addLivro(Livro livro) {
		livro.setId(qtdLivros);
		livros.put(qtdLivros++, livro);
	}
	
	public void deleteLivro(int idLivro) throws SOAPException {
		if (!getLivros().containsKey(idLivro))
			throw new SOAPException("Livro não encontrado.");
		
		livros.remove(idLivro);
	}
	
	public void putLivro(Livro livro) throws SOAPException {
		if (!getLivros().containsKey(livro.getId()))
			throw new SOAPException("Livro não encontrado.");
		
		livros.put(livro.getId(), livro);
	}
}