public enum NivelCliente {
    BRONZE(3),
    PRATA(5),
    OURO(7),
    PLATINA(10);

    private int quantidadeItens;

    NivelCliente(int quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }
}
