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
