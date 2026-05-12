package br.com.adapter.controller;

import br.com.adapter.dto.DemoResponse;
import br.com.adapter.dto.OperacaoRequest;
import br.com.adapter.dto.OperacaoResponse;
import br.com.adapter.perfil.PerfilUsuario;
import br.com.adapter.service.SGBDService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/sgbd")
@CrossOrigin(origins = "*")
public class SGBDController {

    private final SGBDService service;

    public SGBDController(SGBDService service) {
        this.service = service;
    }

    /** Lista todos os perfis com seus metadados. */
    @GetMapping("/perfis")
    public ResponseEntity<List<Map<String, String>>> listarPerfis() {
        List<Map<String, String>> perfis = Arrays.stream(PerfilUsuario.values())
            .map(p -> Map.of(
                "id",          p.name(),
                "nome",        p.getNome(),
                "preco",       p.getPreco(),
                "sgbd",        p.getSgbd(),
                "capacidades", p.getCapacidades(),
                "icone",       p.getIcone(),
                "cor",         p.getCor(),
                "descricao",   p.getDescricao()
            ))
            .collect(Collectors.toList());
        return ResponseEntity.ok(perfis);
    }

    /** Executa uma operação CRUD pontual. */
    @PostMapping("/operacao")
    public ResponseEntity<OperacaoResponse> executarOperacao(@RequestBody OperacaoRequest req) {
        return ResponseEntity.ok(service.executarOperacao(req));
    }

    /** Demo completo: conectar → inserir → consultar → atualizar → deletar → desconectar. */
    @GetMapping("/demo/{perfil}")
    public ResponseEntity<DemoResponse> executarDemo(@PathVariable String perfil) {
        return ResponseEntity.ok(service.executarDemo(perfil));
    }
}
