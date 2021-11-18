package Modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Validacao
{

    private String Mensagem = "";
    private Integer ID;

    public void validarDadosDispositivo(List<String> dadosCarro)
    {
        if (Protocolo.temperatura == null && Protocolo.umidade == null && Protocolo.precipitacao == null)
        {
            this.Mensagem = "Dispositivo desconectado";
        }
        else
        {
            this.Mensagem = "";
        }

    }

    public void validarID(String numeroId)
    {
        try
        {
            this.ID = Integer.parseInt(numeroId);
        }
        catch (Exception e)
        {
            this.Mensagem += "ID inválido <br>";
        }
    }

    public String DataHoraAtual()
    {
        try
        {
            LocalDateTime DataTempo = LocalDateTime.now();
            DateTimeFormatter Formatador = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String DataFormatada = DataTempo.format(Formatador);
            return DataFormatada;
        }
        catch (Exception e)
        {
            return null;
        }

    }

    public String getMensagem()
    {
        return Mensagem;
    }

    public Integer getId()
    {
        return ID;
    }
}
