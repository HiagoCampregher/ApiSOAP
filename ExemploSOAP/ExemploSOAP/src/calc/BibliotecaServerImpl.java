package calc;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;
import javax.xml.soap.SOAPException;

@WebService(endpointInterface = "calc.BibliotecaServer")
public class BibliotecaServerImpl implements BibliotecaServer
{
	private static HashMap<Integer,Autor> autores = new HashMap<Integer,Autor>();
	private static int qtdAutores = 1;
	
	@Override
	public void createAutor(String nome, int idade, String nacionalidade) throws SOAPException
	{
		Autor autor = new Autor(nome, idade, nacionalidade);
		
		autor.setId(qtdAutores);
		autores.put(qtdAutores++, autor);
	}

	@Override
	public void removeAutor(int idAutor) throws SOAPException
	{
		if (!autores.containsKey(idAutor))
			throw new SOAPException("Autor não encontrado.");
				
		autores.remove(idAutor);
	}

	@Override
	public String selectAllAutor()
	{
		String sConteudo = "Lista de autores:\n";

		for (Integer id : autores.keySet())
			sConteudo += autores.get(id).toString();

		return sConteudo;
	}

	@Override
	public void updateAutor(int id, String nome, int idade, String nacionalidade) throws SOAPException
	{
		Autor autor = new Autor(nome, idade, nacionalidade);
		
		if (!autores.containsKey(id))
			throw new SOAPException("Autor não cadastrado.");
		
		autor.setId(id);
		autores.put(id, autor);
	}

	@Override
	public void createLivro(String titulo, int qtdPaginas, String genero, int idAutor) throws SOAPException {

		Livro livro = new Livro(titulo, qtdPaginas, genero);
		
		if (!autores.containsKey(idAutor))
			throw new SOAPException("Autor não cadastrado.");
		
		Autor autor = autores.get(idAutor);
		autor.addLivro(livro);
	}

	@Override
	public void removeLivro(int id, int idAutor) throws SOAPException {
		if (!autores.containsKey(idAutor))
			throw new SOAPException("Autor não encontrado.");
				
		Autor autor = autores.get(idAutor);
		autor.deleteLivro(id);
	}

	@Override
	public String selectAllLivro(int idAutor) throws SOAPException {
		if (!autores.containsKey(idAutor))
			throw new SOAPException("Autor não cadastrado.");
		
		Autor autor = autores.get(idAutor);

		String sConteudo = "Lista de livros do autor " + autor.getNome() + ":\n";

		for (Integer id : autor.getLivros().keySet())
			sConteudo += autor.getLivros().get(id).toString();

		return sConteudo;
	}

	@Override
	public void updateLivro(int id, String titulo, int qtdPaginas, String genero, int idAutor) throws SOAPException {
		if (!autores.containsKey(idAutor))
			throw new SOAPException("Autor não cadastrado.");
		
		Livro livro = new Livro(titulo, qtdPaginas, genero);
		livro.setId(id);
		
		Autor autor = autores.get(idAutor);
		autor.putLivro(livro);
	}
}
