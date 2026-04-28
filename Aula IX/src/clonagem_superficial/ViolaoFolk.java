package clonagem_superficial;

public class ViolaoFolk extends Violao {
    public ViolaoFolk() {
        this.nome               = "Violao Folk";
        this.tipoCorda          = "Aco";
        this.numeroCordas       = 6;
        this.eletrico           = true;
        this.indicadoIniciantes = false;
        this.generoMusical      = "Pop / Rock";
        this.descricao          = "Corpo maior, som encorpado";
        this.especificacoes     = new EspecificacoesTecnicas("2.1 kg", 1200, "Intermediario");
    }
}