package dados.daos;

import dados.entidades.Cliente;
import javax.persistence.EntityManager;
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
    
}
