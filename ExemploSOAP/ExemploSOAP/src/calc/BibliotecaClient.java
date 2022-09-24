package calc;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.ws.Service;
import java.net.URL;

class BibliotecaClient {

  public static void main(String args[]) throws Exception {
    URL url = new URL("http://127.0.0.1:9876/calc?wsdl");
    QName qname = new QName("http://calc/","BibliotecaServerImplService");
    Service ws = Service.create(url, qname);
    BibliotecaServer calc = ws.getPort(BibliotecaServer.class);

    try
    {
	    System.out.println("Criando autora:");
	    calc.createAutor("Bruna", 19, "Brasileira");
	    
	    System.out.println("Criando autor:");
	    calc.createAutor("Hiago", 19, "Italiano");
	    
	    System.out.println("Criando autor:");
	    calc.createAutor("Vinicius", 21, "Coreano");
	    
	    System.out.println("Criando autor:");
	    calc.createAutor("Claudio", 19, "Estadunidense");
	    
	    System.out.println(calc.selectAllAutor());
	    
	    System.out.println("Removida a autora Bruna:");
	    calc.removeAutor(1);
	    
	    System.out.println(calc.selectAllAutor());
	    
	    System.out.println("Alterando nacionalidade do Vinicius:");
	    calc.updateAutor(3, "Vinicius", 19, "Japones");
	    
	    System.out.println(calc.selectAllAutor());
    

    	//System.out.println("Tentativa de remover a autora Bruna (já removida):");
    	//calc.removeAutor(1);    
    	
    	//LIVRO
 	    calc.createLivro("Mentirosos", 270, "Surpresa", 3);
 	    calc.createLivro("Senhor dos anéis", 1050, "Aventura", 3);
 	    
 	    calc.createLivro("Biblia", 3000, "História", 2);
 	    
 	    System.out.println(calc.selectAllLivro(3));
 	    System.out.println(calc.selectAllLivro(2));
 	    
 	    System.out.println("Alterado Mentirosos para o gênero Romance.");
 	    calc.updateLivro(1, "Mentirosos", 1000, "Romance", 3);
 	    
 	    System.out.println("Removido o livro Senhor dos Anéis.\n");
 	    calc.removeLivro(2, 3);
 	    
 	    System.out.println(calc.selectAllLivro(3));
 	    System.out.println(calc.selectAllLivro(2));
    }
    catch(SOAPException e)
    {
    	System.out.println(e.getMessage());
    }
  }
}
