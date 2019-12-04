package dados.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author THAIS & SAMUEL
 */
@Entity
public class Agendamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Agendamento;
    
    private LocalDate dataAgendamento;
    private LocalTime horaAgendamento;
    private String porteDoAutomovel;
    private String tipoDeLavagem;
    private BigDecimal valor;

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    @ManyToOne (optional = false)
    private Cliente cliente;

    @ManyToOne
    private Set<Cliente> clientes = new HashSet<Cliente>();
    
     //Construtor vazio da JPA (OBRIGATÓRIO)
    public Agendamento(){}
    
    //Construtor
    public Agendamento(Cliente c){
        this.setCliente(c);
    }

    public Agendamento(String text, LocalDate value, LocalTime value0, BigDecimal bigDecimal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String getPorteDoAutomovel() {
        return porteDoAutomovel;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public LocalTime getHoraAgendamento() {
        return horaAgendamento;
    }

    public void setHoraAgendamento(LocalTime horaAgendamento) {
        this.horaAgendamento = horaAgendamento;
    }

    public void setPorteDoAutomovel(String PorteDoAltomovel) {
        this.porteDoAutomovel = PorteDoAltomovel;
    }

    public String getTipoDeLavagem() {
        return tipoDeLavagem;
    }

    public void setTipoDeLavagem(String tipoDeLavagem) {
        this.tipoDeLavagem = tipoDeLavagem;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
   
    

    public Integer getId_Agendamento() {
        return id_Agendamento;
    }

    public void setId_Agendamento(Integer id_Agendamento) {
        this.id_Agendamento = id_Agendamento;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id_Agendamento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Agendamento other = (Agendamento) obj;
        if (!Objects.equals(this.id_Agendamento, other.id_Agendamento)) {
            return false;
        }
        return true;
    }
    
}