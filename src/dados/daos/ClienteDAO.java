package dados.daos;

import dados.entidades.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.JPAUtil;

public class ClienteDAO {
    
    /**
     * Salvar o cliente no BD
     */
    public void salvar(Cliente c){
        
        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();
        
        //Iniciar a transação
        gerenciador.getTransaction().begin();
        
        //Mandar persistir o cliente
        gerenciador.persist(c);
        
        //Commit
        gerenciador.getTransaction().commit();
        
    }
    public List<Cliente> listar(){
        
      //Pegando o gerenciador de acesso ao BD
      EntityManager gerenciador = JPAUtil.getGerenciador(); 
      
      //Criando a consulta ao BD
      TypedQuery consulta = gerenciador.createQuery(
              "Select a from Cliente a", Cliente.class);
      
      //Retornar a lista de cliente
      return consulta.getResultList();
}
}
