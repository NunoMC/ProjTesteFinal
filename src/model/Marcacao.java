/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NunoM
 */
@Entity
@Table(name = "MARCACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marcacao.findAll", query = "SELECT m FROM Marcacao m"),
    @NamedQuery(name = "Marcacao.findByIdMarcacao", query = "SELECT m FROM Marcacao m WHERE m.idMarcacao = :idMarcacao"),
    @NamedQuery(name = "Marcacao.findByDescricao", query = "SELECT m FROM Marcacao m WHERE m.descricao = :descricao"),
    @NamedQuery(name = "Marcacao.findByDataMarcacao", query = "SELECT m FROM Marcacao m WHERE m.dataMarcacao = :dataMarcacao"),
    @NamedQuery(name = "Marcacao.findByDataServico", query = "SELECT m FROM Marcacao m WHERE m.dataServico = :dataServico"),
    @NamedQuery(name = "Marcacao.findByLocal", query = "SELECT m FROM Marcacao m WHERE m.local = :local")})
public class Marcacao implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
   @SequenceGenerator(
        name="seqMarcacao",
        sequenceName="IN_MARCACAO", 
        allocationSize=1
    )
       
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="seqMarcacao")
    @Column(name="ID_MARCACAO", nullable = false)
    private Integer idMarcacao;
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "DATA_MARCACAO")
    @Temporal(TemporalType.DATE)
    private Date dataMarcacao;
    @Basic(optional = false)
    @Column(name = "DATA_SERVICO")
    @Temporal(TemporalType.DATE)
    private Date dataServico;
    @Basic(optional = false)
    @Column(name = "LOCAL")
    private String local;
    @OneToMany(mappedBy = "idMarcacao")
    private Collection<VendaMarc> vendaMarcCollection;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne
    private Cliente idCliente;
    @JoinColumn(name = "ID_FUNCIONARIO", referencedColumnName = "ID_FUNCIONARIO")
    @ManyToOne
    private Funcionario idFuncionario;

    public Marcacao() {
    }

    public Marcacao(Integer idMarcacao) {
        this.idMarcacao = idMarcacao;
    }

    public Marcacao(Integer idMarcacao, String descricao, Date dataServico, String local) {
        this.idMarcacao = idMarcacao;
        this.descricao = descricao;
        this.dataServico = dataServico;
        this.local = local;
    }

    public Integer getIdMarcacao() {
        return idMarcacao;
    }

    public void setIdMarcacao(Integer idMarcacao) {
        this.idMarcacao = idMarcacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataMarcacao() {
        return dataMarcacao;
    }

    public void setDataMarcacao(Date dataMarcacao) {
        this.dataMarcacao = dataMarcacao;
    }

    public Date getDataServico() {
        return dataServico;
    }

    public void setDataServico(Date dataServico) {
        this.dataServico = dataServico;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @XmlTransient
    public Collection<VendaMarc> getVendaMarcCollection() {
        return vendaMarcCollection;
    }

    public void setVendaMarcCollection(Collection<VendaMarc> vendaMarcCollection) {
        this.vendaMarcCollection = vendaMarcCollection;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMarcacao != null ? idMarcacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marcacao)) {
            return false;
        }
        Marcacao other = (Marcacao) object;
        if ((this.idMarcacao == null && other.idMarcacao != null) || (this.idMarcacao != null && !this.idMarcacao.equals(other.idMarcacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Marcacao[ idMarcacao=" + idMarcacao + " ]";
    }
    
}
