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
@Table(name = "VENDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venda.findAll", query = "SELECT v FROM Venda v"),
    @NamedQuery(name = "Venda.findByIdVenda", query = "SELECT v FROM Venda v WHERE v.idVenda = :idVenda"),
    @NamedQuery(name = "Venda.findByValorServico", query = "SELECT v FROM Venda v WHERE v.valorServico = :valorServico"),
    @NamedQuery(name = "Venda.findByDataVenda", query = "SELECT v FROM Venda v WHERE v.dataVenda = :dataVenda"),
    @NamedQuery(name = "Venda.findByPrecoTotal", query = "SELECT v FROM Venda v WHERE v.precoTotal = :precoTotal"),
    @NamedQuery(name = "Venda.findByPrcramo", query = "SELECT v FROM Venda v WHERE v.prcramo = :prcramo")})
public class Venda implements Serializable {
    private static final long serialVersionUID = 1L;
    @SequenceGenerator(
        name="seqVenda",
        sequenceName="IN_VENDA", 
        allocationSize=1
    )
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="seqVenda")
    @Column(name="ID_Venda", nullable = false)
    private Integer idVenda;
    @Basic(optional = false)
    @Column(name = "VALOR_SERVICO")
    private Double valorServico;
    @Basic(optional = false)
    @Column(name = "DATA_VENDA")
    @Temporal(TemporalType.DATE)
    private Date dataVenda;
    @Basic(optional = false)
    @Column(name = "PRECO_TOTAL")
    private Double precoTotal;
    @Column(name = "PRCRAMO")
    private Double prcramo;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne
    private Cliente idCliente;
    @JoinColumn(name = "ID_FUNCIONARIO", referencedColumnName = "ID_FUNCIONARIO")
    @ManyToOne
    private Funcionario idFuncionario;
    @OneToMany(mappedBy = "idVenda")
    private Collection<VendaMarc> vendaMarcCollection;
    @OneToMany(mappedBy = "idVenda")
    private Collection<Linhaproduto> linhaprodutoCollection;

    public Venda() {
    }

    public Venda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public Venda(Integer idVenda, Double valorServico, Date dataVenda, Double precoTotal) {
        this.idVenda = idVenda;
        this.valorServico = valorServico;
        this.dataVenda = dataVenda;
        this.precoTotal = precoTotal;
    }

    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public Double getValorServico() {
        return valorServico;
    }

    public void setValorServico(Double valorServico) {
        this.valorServico = valorServico;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Double getPrcramo() {
        return prcramo;
    }

    public void setPrcramo(Double prcramo) {
        this.prcramo = prcramo;
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

    @XmlTransient
    public Collection<VendaMarc> getVendaMarcCollection() {
        return vendaMarcCollection;
    }

    public void setVendaMarcCollection(Collection<VendaMarc> vendaMarcCollection) {
        this.vendaMarcCollection = vendaMarcCollection;
    }

    @XmlTransient
    public Collection<Linhaproduto> getLinhaprodutoCollection() {
        return linhaprodutoCollection;
    }

    public void setLinhaprodutoCollection(Collection<Linhaproduto> linhaprodutoCollection) {
        this.linhaprodutoCollection = linhaprodutoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenda != null ? idVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.idVenda == null && other.idVenda != null) || (this.idVenda != null && !this.idVenda.equals(other.idVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Venda[ idVenda=" + idVenda + " ]";
    }
    
}
