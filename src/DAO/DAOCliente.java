package DAO;

import Controle.Cliente;
import javax.swing.JOptionPane;
import org.hibernate.Session;

public class DAOCliente {
    Session s;
    
    public DAOCliente(){
        s = DAOHibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public Cliente buscar(int id){
        try {
            s.beginTransaction(); // abre uma transação
            String consulta = "from Cliente where codigo = " + id;
            Cliente c = (Cliente) s.createQuery(consulta).uniqueResult();
            s.getTransaction().commit();
            return c;
        } catch(Exception e) {
            s.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Não foi possível buscar os dados no banco de dados");
            return null;
        }
    }
    
    public void excluir (Cliente c){
        try {
            s.beginTransaction();
            s.delete(c);
            s.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
        } catch (Exception ex){
            s.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o cliente.");
        }
    }
    
    public void armazenar (Cliente c){
         try{   
            s.beginTransaction();
            s.save(c);
            s.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
         }
         catch(Exception e){
            s.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o cliente."); 
         }
    }
    
    public void alterar (Cliente c){
         try{   
            s.beginTransaction();
            s.merge(c);
            s.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
         }
         catch(Exception e){
            s.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o cliente."); 
         }
    }
    
}
