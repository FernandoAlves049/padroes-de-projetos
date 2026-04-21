public final class NotebookGamer extends Notebook {
    private NotebookGamer(Builder builder) {
        super(builder);
    }

    public static class Builder extends Notebook.Builder<Builder> {
        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public NotebookGamer build() {
            validarCamposObrigatorios();
            return new NotebookGamer(this);
        }
    }
}