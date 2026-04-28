package clonagem_profunda;

/**
 * Prototype abstrato - CLONAGEM PROFUNDA.
 */
public abstract class Violao implements Cloneable {

    protected String nome;
    protected String tipoCorda;
    protected int numeroCordas;
    protected boolean eletrico;
    protected boolean indicadoIniciantes;
    protected String generoMusical;
    protected String descricao;
    protected EspecificacoesTecnicas especificacoes;

    @Override
    public Violao clone() {
        try {
            Violao copia = (Violao) super.clone();
            copia.especificacoes = new EspecificacoesTecnicas(this.especificacoes);
            return copia;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Erro ao clonar violao: " + e.getMessage());
        }
    }

    public void exibirDetalhes() {
        String sep = "+--------------------------------------------------+";
        String mid = "+--- Especificacoes Tecnicas -----------------------+";
        System.out.println("\n" + sep);
        System.out.printf("|  %-48s|%n", ">> " + nome.toUpperCase());
        System.out.println(sep);
        System.out.printf("|  %-14s %-33s|%n", "Cordas      :", numeroCordas + " (" + tipoCorda + ")");
        System.out.printf("|  %-14s %-33s|%n", "Eletrico    :", eletrico ? "Sim" : "Nao");
        System.out.printf("|  %-14s %-33s|%n", "Iniciantes  :", indicadoIniciantes ? "Sim" : "Nao");
        System.out.printf("|  %-14s %-33s|%n", "Genero      :", generoMusical);
        String desc = descricao.length() > 33 ? descricao.substring(0, 30) + "..." : descricao;
        System.out.printf("|  %-14s %-33s|%n", "Descricao   :", desc);
        System.out.println(mid);
        System.out.printf("|  %-14s %-33s|%n", "Peso        :", especificacoes.getPeso());
        System.out.printf("|  %-14s %-33s|%n", "Preco       :", "R$ " + especificacoes.getPreco());
        System.out.printf("|  %-14s %-33s|%n", "Nivel       :", especificacoes.getNivel());
        System.out.println(sep);
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTipoCorda() { return tipoCorda; }
    public void setTipoCorda(String tipoCorda) { this.tipoCorda = tipoCorda; }
    public int getNumeroCordas() { return numeroCordas; }
    public void setNumeroCordas(int numeroCordas) { this.numeroCordas = numeroCordas; }
    public boolean isEletrico() { return eletrico; }
    public void setEletrico(boolean eletrico) { this.eletrico = eletrico; }
    public boolean isIndicadoIniciantes() { return indicadoIniciantes; }
    public void setIndicadoIniciantes(boolean v) { this.indicadoIniciantes = v; }
    public String getGeneroMusical() { return generoMusical; }
    public void setGeneroMusical(String generoMusical) { this.generoMusical = generoMusical; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public EspecificacoesTecnicas getEspecificacoes() { return especificacoes; }
    public void setEspecificacoes(EspecificacoesTecnicas e) { this.especificacoes = e; }
}
