package br.com.adapter.adapter;

/**
 * Target Interface — contrato unificado do Padrão Adapter.
 * A aplicação sempre se comunica por esta interface,
 * nunca diretamente com Paradox, Firebird ou MySQL.
 */
public interface SGBDAdapter {
    String conectar();
    String inserir(String dado);
    String consultar(String query);
    String atualizar(String dado);
    String deletar(String dado);
    String desconectar();
    String getNomeSGBD();
    String getCapacidades();
}
