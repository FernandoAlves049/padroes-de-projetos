public final class NotebookTrabalho extends Notebook {
    private NotebookTrabalho(Builder builder) {
        super(builder);
    }

    public static class Builder extends Notebook.Builder<Builder> {
        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public NotebookTrabalho build() {
            validarCamposObrigatorios();
            return new NotebookTrabalho(this);
        }
    }
}