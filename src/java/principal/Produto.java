package principal;


import principal.crud.ProdutoCrud;

public class Produto {
    
    private String nome;
    private String descricao;
    
    ProdutoCrud crud = new ProdutoCrud();

    public Produto() {
    }

    public Produto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        
        System.out.println("Classe Produto: " + this.nome);
        System.out.println("Classe Produto: " + this.descricao);
        
        try {
            crud.criarProduto(this);
        } catch (ClassNotFoundException ex) {
            System.out.println("Classe de conexão não encontrada: " + ex.getMessage());
        }
    }
    
    public void editarProduto(int id){
        crud.atualizarProduto(id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}
