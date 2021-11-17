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

    }

    public void validarDados(List<String> dadosCarro)
    {
        this.Mensagem = "";
        this.validarID(dadosCarro.get(0));
        this.validarTemperatura(dadosCarro.get(1));
        this.validarUmidade(dadosCarro.get(2));
        this.validarPrecipitacao(dadosCarro.get(3));
        this.validarDadosDispositivo(dadosCarro);

    }

    public void validarTemperatura(String temperatura)
    {
        try
        {
            Integer.parseInt(temperatura);
        }
        catch (Exception e)
        {
            this.Mensagem += "Temperatura inválida <br>";
        }

    }

    public void validarUmidade(String umidade)
    {
        try
        {
            Integer.parseInt(umidade);
        }
        catch (Exception e)
        {
            this.Mensagem += "Umidade inválida <br>";
        }

    }

    public void validarPrecipitacao(String precipitacao)
    {
        try
        {
            Integer.parseInt(precipitacao);
        }
        catch (Exception e)
        {
            this.Mensagem += "Precipitação inválida <br>";
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
            this.Mensagem += "Data hora inválida";
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
