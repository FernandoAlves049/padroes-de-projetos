package br.com.adapter.sgbd;

/** Adaptee — API do MySQL (SGBD relacional completo, multi-user, múltiplas transações). */
public class MySQL {
    public String abrirConexao(String url, String usuario) {
        return "[MySQL] Conexão JDBC estabelecida: " + url + " | Usuário: " + usuario;
    }
    public String executarInsert(String sql) {
        return "[MySQL] Executando INSERT — Query: " + sql + " | Rows affected: 1";
    }
    public String executarSelect(String sql) {
        return "[MySQL] Executando SELECT — Query: " + sql + " | Resultados encontrados";
    }
    public String executarUpdate(String sql) {
        return "[MySQL] Executando UPDATE — Query: " + sql + " | Rows affected: 1";
    }
    public String executarDelete(String sql) {
        return "[MySQL] Executando DELETE — Query: " + sql + " | Rows affected: 1";
    }
    public String fecharConexao() {
        return "[MySQL] Conexão JDBC fechada — todas as transações confirmadas (COMMIT).";
    }
}
