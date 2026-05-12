package br.com.adapter.service;

import br.com.adapter.adapter.SGBDAdapter;
import br.com.adapter.dto.DemoResponse;
import br.com.adapter.dto.DemoResponse.LogEntry;
import br.com.adapter.dto.OperacaoRequest;
import br.com.adapter.dto.OperacaoResponse;
import br.com.adapter.factory.SGBDAdapterFactory;
import br.com.adapter.perfil.PerfilUsuario;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class SGBDService {

    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("HH:mm:ss");

    public OperacaoResponse executarOperacao(OperacaoRequest req) {
        PerfilUsuario perfil  = PerfilUsuario.valueOf(req.perfil().toUpperCase());
        SGBDAdapter   adapter = SGBDAdapterFactory.criarAdapter(perfil);
        String dado = req.dado() != null ? req.dado() : "exemplo";

        String resultado = switch (req.operacao().toLowerCase()) {
            case "conectar"    -> adapter.conectar();
            case "inserir"     -> adapter.inserir(dado);
            case "consultar"   -> adapter.consultar(dado);
            case "atualizar"   -> adapter.atualizar(dado);
            case "deletar"     -> adapter.deletar(dado);
            case "desconectar" -> adapter.desconectar();
            default            -> "Operação desconhecida: " + req.operacao();
        };

        return new OperacaoResponse(adapter.getNomeSGBD(), req.operacao(), resultado, perfil.getCor());
    }

    public DemoResponse executarDemo(String perfilStr) {
        PerfilUsuario perfil  = PerfilUsuario.valueOf(perfilStr.toUpperCase());
        SGBDAdapter   adapter = SGBDAdapterFactory.criarAdapter(perfil);
        List<LogEntry> logs   = new ArrayList<>();

        logs.add(log("CONECTAR",    adapter.conectar()));
        logs.add(log("INSERIR",     adapter.inserir("Produto Alpha")));
        logs.add(log("CONSULTAR",   adapter.consultar("Produto Alpha")));
        logs.add(log("ATUALIZAR",   adapter.atualizar("Produto Alpha v2")));
        logs.add(log("DELETAR",     adapter.deletar("Produto Alpha v2")));
        logs.add(log("DESCONECTAR", adapter.desconectar()));

        return new DemoResponse(perfil.getNome(), adapter.getNomeSGBD(),
            adapter.getCapacidades(), perfil.getCor(), perfil.getIcone(), logs);
    }

    private LogEntry log(String op, String msg) {
        return new LogEntry(op, msg, LocalTime.now().format(FMT));
    }
}
