package principal;

import java.sql.SQLException;
import principal.crud.LivroCrud;

public class Livro {
    
    private String titulo;
    private String autor;
    private String genero;
    
    LivroCrud crud = new LivroCrud();

    public Livro(String titulo, String autor, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        
        try {
            crud.criarLivro(this);
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Classe de conexão não encontrada: " + ex.getMessage());
            
        } catch (SQLException ex) {
            System.out.println("Erro de SQL: " + ex.getMessage());
            
        }
        
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
    
}
