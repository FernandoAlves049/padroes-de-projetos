package clonagem_superficial;

public class ViolaoFlet extends Violao {
    public ViolaoFlet() {
        this.nome               = "Violao Flet";
        this.tipoCorda          = "Nylon";
        this.numeroCordas       = 6;
        this.eletrico           = true;
        this.indicadoIniciantes = false;
        this.generoMusical      = "Bossa Nova / Jazz";
        this.descricao          = "Caixa fina, timbre suave, uso profissional";
        this.especificacoes     = new EspecificacoesTecnicas("1.9 kg", 2500, "Profissional");
    }
}