package DAL;

import Modelo.Clima;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class DAO
{

    private String mensagem;
    Conexao conexao = new Conexao();
    Session session = HibernateUtil.getSessionFactory().openSession();

    public void Cadastrar(Clima clima)
    {
        this.mensagem = "";
        try
        {
            session.beginTransaction();
            session.save(clima);
            session.getTransaction().commit();
            session.close();
            this.mensagem = "Registro cadastrado com sucesso!";
        }
        catch (Exception e)
        {
            this.mensagem = "Erro de gravação no BD";
        }
    }

    public void Editar(Clima clima)
    {
        this.mensagem = "";
        try
        {
            session.beginTransaction();
            session.saveOrUpdate(clima);
            session.getTransaction();
            session.close();
            this.mensagem = "Registro editado com sucesso!";

        }
        catch (Exception e)
        {
            this.mensagem = "Erro de gravação no BD";
        }
    }

    public void Excluir(Clima clima)
    {
        this.mensagem = "";
        try
        {
            session.beginTransaction();
            session.delete(clima);
            session.getTransaction().commit();
            session.close();
            this.mensagem = "Registro excluido com sucesso!";
        }
        catch (Exception e)
        {
            this.mensagem = "Erro de gravação no BD";
        }
    }

//    public Clima PesquisarID(Clima clima)
//    {
//        this.mensagem = "";
//        try
//        {
//            Query q = session.createQuery("From Clima c where c.id = :id");
//            q.setParameter("id", clima.getId());
//            clima = (Clima) q.list().get(0);
//        }
//        catch (Exception e)
//        {
//            this.mensagem = "erro de leitura no BD";
//        }
//        return clima;
//    }

//    public List<Clima> PesquisarClimaTemperatura(Clima clima)
//    {
//        this.mensagem = "";
//        List<Clima> listaClima = new ArrayList<>();
//        try
//        {
//            Query q;
//            q = session.createQuery("from Clima c where c.temperatura like :temperatura");
//            q.setParameter("temperatura", clima.getTemperatura() + "%");
//            listaClima = (List<Clima>) q.list();
//        }
//        catch (Exception e)
//        {
//            this.mensagem = "Erro de leitura no BD";
//        }
//        return listaClima;
//    }

//    public List<Clima> PesquisarClimaUmidade(Clima clima)
//    {
//        this.mensagem = "";
//        List<Clima> listaClima = new ArrayList<>();
//        try
//        {
//            Query q;
//            q = session.createQuery("from Clima c where c.umidade like :umidade");
//            q.setParameter("umidade", clima.getUmidade()+ "%");
//            listaClima = (List<Clima>) q.list();
//        }
//        catch (Exception e)
//        {
//            this.mensagem = "Erro de leitura no BD";
//        }
//        return listaClima;
//    }

//    public List<Clima> PesquisarClimaPrecipitacao(Clima clima)
//    {
//        this.mensagem = "";
//        List<Clima> listaClima = new ArrayList<>();
//        try
//        {
//            Query q = session.createQuery("from Clima c where c.precipitacao like :precipitacao");
//            q.setParameter("precipitacao", clima.getPrecipitacao() + "%");
//            listaClima = (List<Clima>) q.list();
//        }
//        catch (Exception e)
//        {
//            this.mensagem = "Erro de leitura no BD";
//        }
//        return listaClima;
//    }

//    public List<Clima> PesquisarClimaDataHora(Clima clima)
//    {
//        this.mensagem = "";
//        List<Clima> listaClima = new ArrayList<>();
//        try
//        {
//            Query q = session.createQuery("from Clima c where c.data_registro like :data_registro");
//            q.setParameter("data_registro", clima.getDataRegistro()+ "%");
//            listaClima = (List<Clima>) q.list();
//        }
//        catch (Exception e)
//        {
//            this.mensagem = "Erro de leitura no BD";
//        }
//        return listaClima;
//    }

    public List<Clima> Historico(Clima clima)
    {
        this.mensagem = "";
        List<Clima> listaClimas = new ArrayList<>();
        try
        {
            Query q = session.createQuery("from Clima c");
            listaClimas = (List<Clima>) q.list();
        }
        catch (Exception e)
        {
            this.mensagem = "Erro de leitura no BD";
        }
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
