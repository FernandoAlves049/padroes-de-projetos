package clonagem_superficial;

public class Violao7Cordas extends Violao {
    public Violao7Cordas() {
        this.nome               = "Violao 7 Cordas";
        this.tipoCorda          = "Nylon";
        this.numeroCordas       = 7;
        this.eletrico           = false;
        this.indicadoIniciantes = false;
        this.generoMusical      = "Choro / Samba";
        this.descricao          = "7a corda mais grave, exige conhecimento";
        this.especificacoes     = new EspecificacoesTecnicas("2.0 kg", 1500, "Intermediario");
    }
}