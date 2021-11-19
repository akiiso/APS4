/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Modelo.Clima;
import Modelo.Controle;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author utayk
 */
@ManagedBean
@RequestScoped
public class bgrHistorico
{

    private String id;
    private String temperatura;
    private String umidade;
    private String precipitação;
    private String dataHora;
    private String mensagem;
    private List<Clima> listaClimas;

    /**
     * Creates a new instance of bgrHistorico
     */
    public bgrHistorico()
    {

    }

    public String pesquisarHistorico()
    {
        Controle controle = new Controle();
        listaClimas = controle.PesquisarClimaHistorico();
        this.mensagem = controle.getMensagem();
        if (listaClimas == null || listaClimas.isEmpty())
        {
            this.mensagem = "Não existe registros salvos";
            return null;
        }
        if (listaClimas.size() >= 1)
        {
            return "/paginas/paginaHistorico.xhtml";
        }
        return null;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
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

    public String getPrecipitação()
    {
        return precipitação;
    }

    public void setPrecipitação(String precipitação)
    {
        this.precipitação = precipitação;
    }

    public String getDataHora()
    {
        return dataHora;
    }

    public void setDataHora(String dataHora)
    {
        this.dataHora = dataHora;
    }

    public String getMensagem()
    {
        return mensagem;
    }

    public void setMensagem(String mensagem)
    {
        this.mensagem = mensagem;
    }

    public List<Clima> getListaClimas()
    {
        return listaClimas;
    }

    public void setListaClimas(List<Clima> listaClimas)
    {
        this.listaClimas = listaClimas;
    }

}
