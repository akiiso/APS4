package Modelo;

import DAL.DAO;
import java.util.ArrayList;
import java.util.List;

public class Controle
{

    public String mensagem;

    public void CadastrarClima(List<String> dadosClima)
    {
        this.mensagem = "";
        
        Validacao validacao = new Validacao();
        validacao.validarDadosDispositivo(dadosClima);
        
        if (validacao.getMensagem().equals(""))
        {
            Clima clima = new Clima();
            clima.setId(validacao.getId());
            clima.setTemperatura(dadosClima.get(1));
            clima.setUmidade(dadosClima.get(2));
            clima.setPrecipitacao(dadosClima.get(3));
            clima.setDataRegistro(validacao.DataHoraAtual());
            DAO dao = new DAO();
            dao.Cadastrar(clima);
            this.mensagem = dao.getMensagem();
        }

        else
        {
            this.mensagem = validacao.getMensagem();
        }

    }


    public List<Clima> PesquisarClimaHistorico()
    {
        this.mensagem = "";
        Clima clima = new Clima();
        List<Clima> listaClimas = new ArrayList<>();
        DAO climaDAO = new DAO();
        listaClimas = climaDAO.Historico(clima);
        this.mensagem = climaDAO.getMensagem();
        return listaClimas;
    }

    public String getMensagem()
    {
        return mensagem;
    }

    public void setMensagem(String mensagem)
    {
        this.mensagem = mensagem;
    }
}
