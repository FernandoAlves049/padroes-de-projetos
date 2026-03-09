public abstract class Pessoa {
    private String nome;
    private String documento;

    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}