/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "LOTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lote.findAll", query = "SELECT l FROM Lote l"),
    @NamedQuery(name = "Lote.findByIdLote", query = "SELECT l FROM Lote l WHERE l.idLote = :idLote"),
    @NamedQuery(name = "Lote.findByQuantidade", query = "SELECT l FROM Lote l WHERE l.quantidade = :quantidade"),
    @NamedQuery(name = "Lote.findByDataChegada", query = "SELECT l FROM Lote l WHERE l.dataChegada = :dataChegada"),
    @NamedQuery(name = "Lote.findByQtdlixo", query = "SELECT l FROM Lote l WHERE l.qtdlixo = :qtdlixo"),
    @NamedQuery(name = "Lote.findByPreco", query = "SELECT l FROM Lote l WHERE l.preco = :preco"),
    @NamedQuery(name = "Lote.findByQtdcompra", query = "SELECT l FROM Lote l WHERE l.qtdcompra = :qtdcompra"),
})
public class Lote implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @SequenceGenerator(
        name="seqLote",
        sequenceName="IN_LOTE", 
        allocationSize=1
    )
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="seqLote")
    @Column(name="ID_LOTE", nullable = false)
    private Integer idLote;
    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private Double quantidade;
    @Basic(optional = false)
    @Column(name = "DATA_CHEGADA")
    @Temporal(TemporalType.DATE)
    private Date dataChegada;
    @Column(name = "QTDLIXO")
    private Double qtdlixo;
    @Column(name = "PRECO")
    private Double preco;
    @Column(name = "QTDCOMPRA")
    private Double qtdcompra;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLote")
    private Collection<Linhaproduto> linhaprodutoCollection;
    @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID_PRODUTO")
    @ManyToOne
    private Produto idProduto;

    public Lote() {
    }

    public Lote(Integer idLote) {
        this.idLote = idLote;
    }

    public Lote(Integer idLote, Double quantidade, Date dataChegada) {
        this.idLote = idLote;
        this.quantidade = quantidade;
        this.dataChegada = dataChegada;
    }

    public Integer getIdLote() {
        return idLote;
    }

    public void setIdLote(Integer idLote) {
        this.idLote = idLote;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    public Double getQtdlixo() {
        return qtdlixo;
    }

    public void setQtdlixo(Double qtdlixo) {
        this.qtdlixo = qtdlixo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getQtdcompra() {
        return qtdcompra;
    }

    public void setQtdcompra(Double qtdcompra) {
        this.qtdcompra = qtdcompra;
    }

    @XmlTransient
    public Collection<Linhaproduto> getLinhaprodutoCollection() {
        return linhaprodutoCollection;
    }

    public void setLinhaprodutoCollection(Collection<Linhaproduto> linhaprodutoCollection) {
        this.linhaprodutoCollection = linhaprodutoCollection;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLote != null ? idLote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lote)) {
            return false;
        }
        Lote other = (Lote) object;
        if ((this.idLote == null && other.idLote != null) || (this.idLote != null && !this.idLote.equals(other.idLote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Lote[ idLote=" + idLote + " ]";
    }
    
}
