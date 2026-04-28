package clonagem_superficial;

public class ViolaoZero extends Violao {
    public ViolaoZero() {
        this.nome               = "Violao Zero (Parlor)";
        this.tipoCorda          = "Nylon";
        this.numeroCordas       = 6;
        this.eletrico           = false;
        this.indicadoIniciantes = true;
        this.generoMusical      = "Casual / Recreativo";
        this.descricao          = "Menor dos Parlor, confortavel";
        this.especificacoes     = new EspecificacoesTecnicas("1.5 kg", 550, "Iniciante");
    }
}