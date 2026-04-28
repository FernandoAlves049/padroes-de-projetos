package clonagem_superficial;

public class Violao12Cordas extends Violao {
    public Violao12Cordas() {
        this.nome               = "Violao 12 Cordas";
        this.tipoCorda          = "Aco";
        this.numeroCordas       = 12;
        this.eletrico           = false;
        this.indicadoIniciantes = false;
        this.generoMusical      = "Folk / Rock";
        this.descricao          = "Cordas em duplas, ressonancia plena";
        this.especificacoes     = new EspecificacoesTecnicas("2.3 kg", 1700, "Profissional");
    }
}