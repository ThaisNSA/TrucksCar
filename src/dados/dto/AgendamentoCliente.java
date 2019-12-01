/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados.dto;

import dados.entidades.Agendamento;
import dados.entidades.Cliente;

/**
 *
 * @author Pandora(SSQ)
 */
public class AgendamentoCliente {
    
      
    private Agendamento agendamento;
    private Cliente cliente;
    
    public AgendamentoCliente(Agendamento a, Cliente c){
        setCliente(c);
        setAgendamento(a);
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this. agendamento =  agendamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    public String getNomeCliente(){
        return cliente.getNome();
    }
    
    
}


