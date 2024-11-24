public class Informatica extends Loja {
    private double seguroEletronicos;

    public Informatica(
        String nome,
        int quantidadeFuncionarios,
        double salarioBaseFuncionario,
        Endereco endereco,
        Data dataFundacao,
        double seguroEletronicos,
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
        
        this.seguroEletronicos = seguroEletronicos;
    }

    public double getSeguroEletronicos() {
        return seguroEletronicos;
    }

    public void setSeguroEletronicos(double seguroEletronicos) {
        this.seguroEletronicos = seguroEletronicos;
    }

    @Override
    public String toString() {

        return String.join(
            System.lineSeparator(),
            super.toString(),
            "Seguro de eletrônicos: " + seguroEletronicos
        );
    }
}
