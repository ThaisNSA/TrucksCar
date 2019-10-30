package servicos;

import dados.daos.ClienteDAO;
import dados.entidades.Cliente;

public class ClienteServico {
    
    //Atributo para representar a camada de dados
    private ClienteDAO dao = new ClienteDAO();
    
    public void salvar(Cliente c){
        //Fazer qualquer regra de negócio
        
        //Mandar o cliente para a camada de dados
        //para ser salvo no banco de dados
        dao.salvar(c);
    }    
    
}
