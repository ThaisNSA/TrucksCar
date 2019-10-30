package teste;

import dados.entidades.Cliente;
import javax.persistence.EntityManager;
import util.JPAUtil;

public class BuscaCliente {
   
    public static void main(String[] args) {
        
        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();
        
        //Buscando um cliente pelo id 
        Cliente c = gerenciador.find(Cliente.class, 1);
        
        //Imprimindo o nome do cliente
        System.out.println("Nome: " + c.getNome());
        
        //Fechar o gerenciador
        gerenciador.close();
        
    }
    
}
