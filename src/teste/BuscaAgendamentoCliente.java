/*package teste;

import dados.entidades.Cliente;
import dados.entidades.Automovel;
import javax.persistence.EntityManager;
import util.JPAUtil;

public class BuscaAgendamentoCliente {
    public static void main(String[] args) {
     
        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();
        
        //Bucar o automovel de id 1
        Automovel a = gerenciador.find(Automovel.class, 1);
        
        //Imprimir o nome do automovel
        System.out.println("Automovel: " + a.getPorteDoAutomovel());
        
        //Imprimir o serviço
        System.out.println("Servicos: " + a.getServicos().getTiposDeLavagem());
        
        //Imprimindo o nome do dono do automovel
        for(Cliente c : a.getClientes()){
            System.out.println("Cliente: " + c.getNome());
        }
        
    }
}
*/