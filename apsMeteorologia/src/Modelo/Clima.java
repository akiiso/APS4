/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author utayk
 */
@Entity
@Table(name = "clima")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Clima.findAll", query = "SELECT c FROM Clima c")
    , @NamedQuery(name = "Clima.findById", query = "SELECT c FROM Clima c WHERE c.id = :id")
    , @NamedQuery(name = "Clima.findByTemperatura", query = "SELECT c FROM Clima c WHERE c.temperatura = :temperatura")
    , @NamedQuery(name = "Clima.findByUmidade", query = "SELECT c FROM Clima c WHERE c.umidade = :umidade")
    , @NamedQuery(name = "Clima.findByPrecipitacao", query = "SELECT c FROM Clima c WHERE c.precipitacao = :precipitacao")
    , @NamedQuery(name = "Clima.findByDataRegistro", query = "SELECT c FROM Clima c WHERE c.dataRegistro = :dataRegistro")
})
public class Clima implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "temperatura")
    private String temperatura;
    @Column(name = "umidade")
    private String umidade;
    @Column(name = "precipitacao")
    private String precipitacao;
    @Column(name = "data_registro")
    private String dataRegistro;

    public Clima()
    {
    }

    public Clima(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getTemperatura()
    {
        return temperatura;
    }

    public void setTemperatura(String temperatura)
    {
        this.temperatura = temperatura;
    }

    public String getUmidade()
    {
        return umidade;
    }

    public void setUmidade(String umidade)
    {
        this.umidade = umidade;
    }

    public String getPrecipitacao()
    {
        return precipitacao;
    }

    public void setPrecipitacao(String precipitacao)
    {
        this.precipitacao = precipitacao;
    }

    public String getDataRegistro()
    {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro)
    {
        this.dataRegistro = dataRegistro;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clima))
        {
            return false;
        }
        Clima other = (Clima) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Modelo.Clima[ id=" + id + " ]";
    }
    
}
