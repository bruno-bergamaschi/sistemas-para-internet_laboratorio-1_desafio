public class Cosmetico extends Loja {

    private double taxaComercializacao;

    public Cosmetico(
        String nome,
        int quantidadeFuncionarios,
        double salarioBaseFuncionario,
        Endereco endereco,
        Data dataFundacao,
        double taxaComercializacao,
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
        
        this.taxaComercializacao = taxaComercializacao;
    }

    public double getTaxaComercializacao() {
        return taxaComercializacao;
    }

    public void setTaxaComercializacao(double taxaComercializacao) {
        this.taxaComercializacao = taxaComercializacao;
    }

    @Override
    public String toString() {

        return String.join(
            System.lineSeparator(),
            super.toString(),
            "Taxa de comercialização: " + taxaComercializacao
        );
    }
    
}
