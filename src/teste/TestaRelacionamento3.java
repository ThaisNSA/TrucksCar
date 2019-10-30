package teste;

import dados.entidades.Cliente;
import dados.entidades.Automovel;
import javax.persistence.EntityManager;
import util.JPAUtil;

public class TestaRelacionamento3 {
    public static void main(String[] args) {
     
        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();
        
        //Buscar 2 clientes (tem que estar cadastrados no BD)
        Cliente c1 = gerenciador.find(Cliente.class, 1);
        Cliente c2 = gerenciador.find(Cliente.class, 2);
        
        //Buscar um automovel no BD
        Automovel a = gerenciador.find(Automovel.class, 1);
        
        //Associando cliente ao automovel
        a.getClientes().add(c1);
        a.getClientes().add(c2);
        
        //Iniciar a transação, commit e fechar
        gerenciador.getTransaction().begin();
        gerenciador.getTransaction().commit();
        gerenciador.close();
        
    }
}
