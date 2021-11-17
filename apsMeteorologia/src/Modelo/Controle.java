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
        validacao.validarDados(dadosClima);
        
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

//    public void EditarClima(List<String> dadosClima)
//    {
//        this.mensagem = "";
//        Validacao validacao = new Validacao();
//        validacao.validarDadosDispositivo(dadosClima);
//        validacao.validarDados(dadosClima);
//        if (validacao.getMensagem().equals(""))
//        {
//            Clima clima = new Clima();
//            clima.setId(validacao.getId());
//            clima.setTemperatura(dadosClima.get(1));
//            clima.setUmidade(dadosClima.get(2));
//            clima.setPrecipitacao(dadosClima.get(3));
//            clima.setDataRegistro("0");
//            DAO climaDAO = new DAO();
//            climaDAO.Editar(clima);
//            this.mensagem = climaDAO.getMensagem();
//        }
//        else
//        {
//            this.mensagem = validacao.getMensagem();
//        }
//
//    }
    public void ExcluirClima(String numeroId)
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarID(numeroId);
        Clima clima = new Clima();
        if (validacao.getMensagem().equals(""))
        {
            DAO climaDAO = new DAO();
            clima.setId(validacao.getId());
            climaDAO.Excluir(clima);
            this.mensagem = climaDAO.getMensagem();
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
