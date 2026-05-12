package br.com.adapter.adapter;

import br.com.adapter.sgbd.Paradox;

/** Adapter Concreto — Perfil GRATUITO (single-user, transação única). */
public class ParadoxAdapter implements SGBDAdapter {
    private final Paradox paradox = new Paradox();
    private static final String PATH = "C:/dados/gratuito.db";

    @Override public String conectar()            { return paradox.abrirArquivoDb(PATH); }
    @Override public String inserir(String d)     { return paradox.gravarRegistro(d); }
    @Override public String consultar(String q)   { return paradox.lerRegistro(q); }
    @Override public String atualizar(String d)   { return paradox.editarRegistro(d); }
    @Override public String deletar(String d)     { return paradox.excluirRegistro(d); }
    @Override public String desconectar()         { return paradox.fecharArquivoDb(); }
    @Override public String getNomeSGBD()         { return "Paradox"; }
    @Override public String getCapacidades()      { return "Single-user • Transação Única"; }
}
