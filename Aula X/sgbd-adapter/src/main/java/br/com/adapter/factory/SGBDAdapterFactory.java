package br.com.adapter.factory;

import br.com.adapter.adapter.*;
import br.com.adapter.perfil.PerfilUsuario;

/**
 * Factory — cria o Adapter correto para cada perfil.
 *
 * GRATUITO  → ParadoxAdapter   (single-user, transação única)
 * BASICO    → FirebirdAdapter  (multi-user, transação única)
 * ULTIMATE  → MySQLAdapter     (multi-user, múltiplas transações)
 */
public class SGBDAdapterFactory {
    private SGBDAdapterFactory() {}

    public static SGBDAdapter criarAdapter(PerfilUsuario perfil) {
        return switch (perfil) {
            case GRATUITO -> new ParadoxAdapter();
            case BASICO   -> new FirebirdAdapter();
            case ULTIMATE -> new MySQLAdapter();
        };
    }
}
