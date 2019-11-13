/*package teste;

import dados.entidades.Agendamento;
import javax.persistence.EntityManager;
import util.JPAUtil;

public class BuscaAgendamento {
    public static void main(String[] args) {
        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();
        
        //Buscando um automovel pelo id
        Agendamento a = gerenciador.find(Agendamento.class, 1);
        
        //Imprimindo o nome do automovel
        System.out.println("Automovel: " + a.getPorteDoAutomovel());
        
        //Imprimindo o nome do tipo de lavagem do automovel
        System.out.println("Serviço: " + a.getServicos().getTiposDeLavagem());
    }
}*/
