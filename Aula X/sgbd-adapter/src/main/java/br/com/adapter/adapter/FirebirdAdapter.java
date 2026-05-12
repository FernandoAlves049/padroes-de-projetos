package br.com.adapter.adapter;

import br.com.adapter.sgbd.Firebird;

/** Adapter Concreto — Perfil BÁSICO (multi-user, transação única). */
public class FirebirdAdapter implements SGBDAdapter {
    private final Firebird firebird = new Firebird();
    private static final String HOST  = "localhost";
    private static final int    PORTA = 3050;
    private static final String BANCO = "app_basico.fdb";
    private static final String TAB   = "registros";

    @Override public String conectar()            { return firebird.conectarServidor(HOST, PORTA, BANCO); }
    @Override public String inserir(String d)     { return firebird.inserirRegistro(TAB, "'" + d + "'"); }
    @Override public String consultar(String q)   { return firebird.selecionarRegistro(TAB, "nome LIKE '%" + q + "%'"); }
    @Override public String atualizar(String d)   { return firebird.atualizarRegistro(TAB, "nome = '" + d + "'"); }
    @Override public String deletar(String d)     { return firebird.deletarRegistro(TAB, "nome = '" + d + "'"); }
    @Override public String desconectar()         { return firebird.desconectarServidor(); }
    @Override public String getNomeSGBD()         { return "Firebird"; }
    @Override public String getCapacidades()      { return "Multi-user • Transação Única"; }
}
