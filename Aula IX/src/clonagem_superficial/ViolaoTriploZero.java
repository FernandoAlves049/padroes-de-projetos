package clonagem_superficial;

public class ViolaoTriploZero extends Violao {
    public ViolaoTriploZero() {
        this.nome               = "Violao Triplo Zero (Parlor)";
        this.tipoCorda          = "Nylon";
        this.numeroCordas       = 6;
        this.eletrico           = false;
        this.indicadoIniciantes = true;
        this.generoMusical      = "Casual / MPB";
        this.descricao          = "Tamanho intermediario, timbre peculiar";
        this.especificacoes     = new EspecificacoesTecnicas("1.7 kg", 800, "Iniciante");
    }
}