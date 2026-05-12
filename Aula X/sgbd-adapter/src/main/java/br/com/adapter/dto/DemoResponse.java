package br.com.adapter.dto;

import java.util.List;

public record DemoResponse(
    String perfil,
    String sgbd,
    String capacidades,
    String cor,
    String icone,
    List<LogEntry> logs
) {
    public record LogEntry(String operacao, String mensagem, String timestamp) {}
}
