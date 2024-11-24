public class Alimentacao extends Loja {
    private Data dataAlvara;

    public Alimentacao(
        String nome,
        int quantidadeFuncionarios,
        double salarioBaseFuncionario,
        Endereco endereco,
        Data dataFundacao,
        Data dataAlvara,
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
        
        this.dataAlvara = dataAlvara;
    }

    public Data getDataAlvara() {
        return dataAlvara;
    }

    public void setDataAlvara(Data dataAlvara) {
        this.dataAlvara = dataAlvara;
    }

    @Override
    public String toString() {

        return String.join(
            System.lineSeparator(),
            super.toString(),
            "Data do alvará: " + dataAlvara
        );
    }
}
