//By Yure Pablo

package Controle;
// Generated 16/02/2017 13:57:17 by Hibernate Tools 3.6.0

import DAO.DAOCliente;

public class Cliente  implements java.io.Serializable {

     private int codigo;
     private String nome;
     private String cpf;
     private String endereco;

    public Cliente() {
    }
    
    public Cliente(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    
    public Cliente(int codigo, String nome, String cpf, String endereco) {
       this.codigo = codigo;
       this.nome = nome;
       this.cpf = cpf;
       this.endereco = endereco;
    }
   
    public int getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf() {
        return this.cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getEndereco() {
        return this.endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public Cliente buscar(int id){
        DAOCliente daoC = new DAOCliente();
        return daoC.buscar(id);
    }
    public void excluir(){
        DAOCliente daoC = new DAOCliente();
        daoC.excluir(this);
    }
    
    public void armazenar(){
        DAOCliente daoCliente = new DAOCliente();
        daoCliente.armazenar(this);
    }
    
    public void alterar(){
        DAOCliente daoCliente = new DAOCliente();
        daoCliente.alterar(this);
    }
}


