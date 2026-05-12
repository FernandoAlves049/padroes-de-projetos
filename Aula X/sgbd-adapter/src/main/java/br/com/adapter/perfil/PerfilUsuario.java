package br.com.adapter.perfil;

public enum PerfilUsuario {

    GRATUITO("Gratuito", "Sem custo", "Paradox", "Single-user • Transação Única", "🆓", "#00d4ff",
             "Acesso limitado a um único usuário e transações simples."),
    BASICO("Básico", "R$ 29,90/mês", "Firebird", "Multi-user • Transação Única", "⭐", "#7c3aed",
           "Suporte a múltiplos usuários, porém com controle de uma transação por vez."),
    ULTIMATE("Ultimate", "R$ 99,90/mês", "MySQL", "Multi-user • Múltiplas Transações", "👑", "#f59e0b",
             "Acesso completo: múltiplos usuários e transações simultâneas ilimitadas.");

    private final String nome, preco, sgbd, capacidades, icone, cor, descricao;

    PerfilUsuario(String nome, String preco, String sgbd, String capacidades,
                  String icone, String cor, String descricao) {
        this.nome = nome; this.preco = preco; this.sgbd = sgbd;
        this.capacidades = capacidades; this.icone = icone;
        this.cor = cor; this.descricao = descricao;
    }

    public String getNome()        { return nome; }
    public String getPreco()       { return preco; }
    public String getSgbd()        { return sgbd; }
    public String getCapacidades() { return capacidades; }
    public String getIcone()       { return icone; }
    public String getCor()         { return cor; }
    public String getDescricao()   { return descricao; }
}
