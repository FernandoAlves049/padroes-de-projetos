package br.com.adapter.sgbd;

/** Adaptee — API do Firebird (SGBD cliente-servidor, multi-user, transação única). */
public class Firebird {
    public String conectarServidor(String host, int porta, String banco) {
        return "[Firebird] Conectando ao servidor " + host + ":" + porta + " | Banco: " + banco;
    }
    public String inserirRegistro(String tabela, String dados) {
        return "[Firebird] INSERT INTO " + tabela + " VALUES (" + dados + ")";
    }
    public String selecionarRegistro(String tabela, String condicao) {
        return "[Firebird] SELECT * FROM " + tabela + " WHERE " + condicao;
    }
    public String atualizarRegistro(String tabela, String dados) {
        return "[Firebird] UPDATE " + tabela + " SET " + dados;
    }
    public String deletarRegistro(String tabela, String condicao) {
        return "[Firebird] DELETE FROM " + tabela + " WHERE " + condicao;
    }
    public String desconectarServidor() {
        return "[Firebird] Conexão encerrada — transação finalizada.";
    }
}
