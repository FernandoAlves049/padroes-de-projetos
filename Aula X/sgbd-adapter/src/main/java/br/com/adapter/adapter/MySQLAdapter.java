package br.com.adapter.adapter;

import br.com.adapter.sgbd.MySQL;

/** Adapter Concreto — Perfil ULTIMATE (multi-user, múltiplas transações). */
public class MySQLAdapter implements SGBDAdapter {
    private final MySQL mysql = new MySQL();
    private static final String URL  = "jdbc:mysql://localhost:3306/app_ultimate";
    private static final String USER = "admin";
    private static final String TAB  = "registros";

    @Override public String conectar()            { return mysql.abrirConexao(URL, USER); }
    @Override public String inserir(String d)     { return mysql.executarInsert("INSERT INTO " + TAB + " (nome) VALUES ('" + d + "')"); }
    @Override public String consultar(String q)   { return mysql.executarSelect("SELECT * FROM " + TAB + " WHERE nome LIKE '%" + q + "%'"); }
    @Override public String atualizar(String d)   { return mysql.executarUpdate("UPDATE " + TAB + " SET nome = '" + d + "' WHERE id = 1"); }
    @Override public String deletar(String d)     { return mysql.executarDelete("DELETE FROM " + TAB + " WHERE nome = '" + d + "'"); }
    @Override public String desconectar()         { return mysql.fecharConexao(); }
    @Override public String getNomeSGBD()         { return "MySQL"; }
    @Override public String getCapacidades()      { return "Multi-user • Múltiplas Transações"; }
}
