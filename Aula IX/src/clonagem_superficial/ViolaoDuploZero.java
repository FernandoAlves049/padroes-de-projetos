package clonagem_superficial;

public class ViolaoDuploZero extends Violao {
    public ViolaoDuploZero() {
        this.nome               = "Violao Duplo Zero (Parlor)";
        this.tipoCorda          = "Aco";
        this.numeroCordas       = 6;
        this.eletrico           = false;
        this.indicadoIniciantes = true;
        this.generoMusical      = "Fingerstyle / Casual";
        this.descricao          = "Boa sonoridade, indicado para fingerstyle";
        this.especificacoes     = new EspecificacoesTecnicas("1.6 kg", 700, "Iniciante");
    }
}