package principal;

import principal.crud.ClienteCrud;

public class Cliente extends Pessoa {
    
    private double renda;
    
    ClienteCrud crud = new ClienteCrud();

    public Cliente(String nome, String email, String cpf) {
        super(nome, email, cpf);
        
        try {
            crud.criarCliente(this);
            System.out.println("Cliente inserido com sucesso!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro SQL: " + ex.getMessage());
        }
        
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public ClienteCrud getCrud() {
        return crud;
    }

    public void setCrud(ClienteCrud crud) {
        this.crud = crud;
    }
    
}
