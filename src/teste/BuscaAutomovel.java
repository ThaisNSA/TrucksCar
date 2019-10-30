package teste;

import dados.entidades.Automovel;
import dados.entidades.Servicos;
import javax.persistence.EntityManager;
import util.JPAUtil;

public class BuscaAutomovel {
    public static void main(String[] args) {
        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();
        
        //Buscando um automovel pelo id
        Automovel a = gerenciador.find(Automovel.class, 1);
        
        //Imprimindo o nome do automovel
        System.out.println("Automovel: " + a.getPorteDoAutomovel());
        
        //Imprimindo o nome do tipo de lavagem do automovel
        System.out.println("Serviço: " + a.getServicos().getTiposDeLavagem());
    }
}
