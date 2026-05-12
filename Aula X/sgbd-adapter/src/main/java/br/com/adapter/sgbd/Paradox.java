package br.com.adapter.sgbd;

/** Adaptee — API legada do Paradox (SGBD de arquivo local, single-user). */
public class Paradox {
    public String abrirArquivoDb(String caminho) {
        return "[Paradox] Abrindo arquivo de banco de dados: " + caminho;
    }
    public String gravarRegistro(String registro) {
        return "[Paradox] Gravando registro no arquivo: \"" + registro + "\"";
    }
    public String lerRegistro(String filtro) {
        return "[Paradox] Lendo registro com filtro: \"" + filtro + "\"";
    }
    public String editarRegistro(String registro) {
        return "[Paradox] Editando registro existente: \"" + registro + "\"";
    }
    public String excluirRegistro(String registro) {
        return "[Paradox] Excluindo registro: \"" + registro + "\"";
    }
    public String fecharArquivoDb() {
        return "[Paradox] Arquivo de banco de dados fechado com sucesso.";
    }
}
