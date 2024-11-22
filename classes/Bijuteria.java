public class Bijuteria extends Loja{
    private double metaVendas;

    public Bijuteria(
        String nome,
        int quantidadeFuncionarios,
        double salarioBaseFuncionario,
        Endereco endereco,
        Data dataFundacao,
        double metaVendas,
        int quantidadeEstoqueProdutos
    ) {
        super(
            nome,
            quantidadeFuncionarios,
            salarioBaseFuncionario,
            endereco,
            dataFundacao,
            quantidadeEstoqueProdutos
        );
        
        this.metaVendas = metaVendas;
    }

    public double getMetaVendas() {
        return metaVendas;
    }

    public void setMetaVendas(double metaVendas) {
        this.metaVendas = metaVendas;
    }

    @Override
    public String toString() {

        return String.join(
            System.lineSeparator(),
            super.toString(),
            "Meta de vendas: " + metaVendas
        );
    }
}
