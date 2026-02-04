public class Cliente extends Pessoa implements Autenticavel, Fornecedor {
    
    // Implementação de Autenticavel
    @Override
    public boolean login() {
        System.out.println("Cliente autenticado com sucesso.");
        return true;
    }

    // Implementação de Fornecedor
    @Override
    public void fornecerProdutos() {
        System.out.println("Cliente está fornecendo produtos/serviços para a empresa.");
    }

    @Override
    public void emitirNotaFiscal() {
        System.out.println("NF emitida pelo cliente-fornecedor.");
    }
}