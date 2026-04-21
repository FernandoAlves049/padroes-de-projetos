public abstract class Notebook {
    private final String processador;
    private final String memoriaRam;
    private final String armazenamento;
    private final String placaDeVideo;
    private final String sistemaOperacional;

    protected Notebook(Builder<?> builder) {
        this.processador = builder.processador;
        this.memoriaRam = builder.memoriaRam;
        this.armazenamento = builder.armazenamento;
        this.placaDeVideo = builder.placaDeVideo;
        this.sistemaOperacional = builder.sistemaOperacional;
    }

    public String getProcessador() {
        return processador;
    }

    public String getMemoriaRam() {
        return memoriaRam;
    }

    public String getArmazenamento() {
        return armazenamento;
    }

    public String getPlacaDeVideo() {
        return placaDeVideo;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "processador='" + processador + '\'' +
                ", memoriaRam='" + memoriaRam + '\'' +
                ", armazenamento='" + armazenamento + '\'' +
                ", placaDeVideo='" + placaDeVideo + '\'' +
                ", sistemaOperacional='" + sistemaOperacional + '\'' +
                '}';
    }

    public abstract static class Builder<T extends Builder<T>> {
        private String processador;
        private String memoriaRam;
        private String armazenamento;
        private String placaDeVideo;
        private String sistemaOperacional;

        public T comProcessador(String processador) {
            this.processador = processador;
            return self();
        }

        public T comMemoriaRam(String memoriaRam) {
            this.memoriaRam = memoriaRam;
            return self();
        }

        public T comArmazenamento(String armazenamento) {
            this.armazenamento = armazenamento;
            return self();
        }

        public T comPlacaDeVideo(String placaDeVideo) {
            this.placaDeVideo = placaDeVideo;
            return self();
        }

        public T comSistemaOperacional(String sistemaOperacional) {
            this.sistemaOperacional = sistemaOperacional;
            return self();
        }

        public abstract Notebook build();

        protected abstract T self();

        protected void validarCamposObrigatorios() {
            validarTexto(processador, "Processador deve ser informado.");
            validarTexto(memoriaRam, "Memoria RAM deve ser informada.");
            validarTexto(armazenamento, "Armazenamento deve ser informado.");
            validarTexto(placaDeVideo, "Placa de video deve ser informada.");
            validarTexto(sistemaOperacional, "Sistema operacional deve ser informado.");
        }

        private void validarTexto(String valor, String mensagemErro) {
            if (valor == null || valor.isBlank()) {
                throw new IllegalStateException(mensagemErro);
            }
        }
    }
}