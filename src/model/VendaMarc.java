/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NunoM
 */
@Entity
@Table(name = "VENDA_MARC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VendaMarc.findAll", query = "SELECT v FROM VendaMarc v"),
    @NamedQuery(name = "VendaMarc.findByIdVendamarc", query = "SELECT v FROM VendaMarc v WHERE v.idVendamarc = :idVendamarc")})
public class VendaMarc implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
        @SequenceGenerator(
        name="seqVendaMarc",
        sequenceName="IN_VendaMarc", 
        allocationSize=1
        )
                
    @Id
         @GeneratedValue(strategy=SEQUENCE, generator="seqVendaMarc")
    @Column(name = "ID_VENDAMARC", nullable = false)
    private Integer idVendamarc;
    @JoinColumn(name = "ID_MARCACAO", referencedColumnName = "ID_MARCACAO")
    @ManyToOne
    private Marcacao idMarcacao;
    @JoinColumn(name = "ID_VENDA", referencedColumnName = "ID_VENDA")
    @ManyToOne
    private Venda idVenda;

    public VendaMarc() {
    }

    public VendaMarc(Integer idVendamarc) {
        this.idVendamarc = idVendamarc;
    }

    public Integer getIdVendamarc() {
        return idVendamarc;
    }

    public void setIdVendamarc(Integer idVendamarc) {
        this.idVendamarc = idVendamarc;
    }

    public Marcacao getIdMarcacao() {
        return idMarcacao;
    }

    public void setIdMarcacao(Marcacao idMarcacao) {
        this.idMarcacao = idMarcacao;
    }

    public Venda getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Venda idVenda) {
        this.idVenda = idVenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVendamarc != null ? idVendamarc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VendaMarc)) {
            return false;
        }
        VendaMarc other = (VendaMarc) object;
        if ((this.idVendamarc == null && other.idVendamarc != null) || (this.idVendamarc != null && !this.idVendamarc.equals(other.idVendamarc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.VendaMarc[ idVendamarc=" + idVendamarc + " ]";
    }
    
}
