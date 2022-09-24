package calc;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.soap.SOAPException;

@WebService
@SOAPBinding(style = Style.RPC)
public interface BibliotecaServer {
  @WebMethod void createAutor(String nome, int idade, String nacionalidade) throws SOAPException;
  @WebMethod void removeAutor(int id) throws SOAPException;
  @WebMethod String selectAllAutor();
  @WebMethod void updateAutor(int id, String nome, int idade, String nacionalidade) throws SOAPException;

  @WebMethod void createLivro(String titulo, int qtdPaginas, String genero, int idAutor) throws SOAPException;
  @WebMethod void removeLivro(int id, int idAutor) throws SOAPException;
  @WebMethod String selectAllLivro(int idAutor) throws SOAPException;
  @WebMethod void updateLivro(int id, String titulo, int qtdPaginas, String genero, int idAutor) throws SOAPException;
}
