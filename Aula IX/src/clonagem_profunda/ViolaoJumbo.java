package clonagem_profunda;

public class ViolaoJumbo extends Violao {
    public ViolaoJumbo() {
        this.nome               = "Violao Jumbo";
        this.tipoCorda          = "Aco";
        this.numeroCordas       = 6;
        this.eletrico           = true;
        this.indicadoIniciantes = false;
        this.generoMusical      = "Country / Rock / Pop";
        this.descricao          = "Corpo largo, base arredondada, som grave";
        this.especificacoes     = new EspecificacoesTecnicas("2.4 kg", 1800, "Intermediario");
    }
}