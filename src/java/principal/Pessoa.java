package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import principal.crud.ClienteCrud;

public class Pessoa {
    
    private String nome;
    private String email;
    private String cpf;
    private String dataNascimento;
    private LocalDateTime dataNascimento2;
    
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyy");
    
    public Pessoa(String nome, String email, String cpf, String dataNascimento) throws ParseException {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        
        this.dataNascimento2 = (LocalDateTime) dtf.parse(this.dataNascimento);
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDateTime getDataNascimento2() {
        return dataNascimento2;
    }

    public void setDataNascimento2(LocalDateTime dataNascimento2) {
        this.dataNascimento2 = dataNascimento2;
    }
    
    
    
}
