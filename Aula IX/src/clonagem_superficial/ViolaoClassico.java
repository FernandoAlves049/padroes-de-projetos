package clonagem_superficial;

public class ViolaoClassico extends Violao {
    public ViolaoClassico() {
        this.nome               = "Violao Classico";
        this.tipoCorda          = "Nylon";
        this.numeroCordas       = 6;
        this.eletrico           = false;
        this.indicadoIniciantes = true;
        this.generoMusical      = "Classico / MPB";
        this.descricao          = "Acustico, leve, macio e acessivel";
        this.especificacoes     = new EspecificacoesTecnicas("1.8 kg", 650, "Iniciante");
    }
}