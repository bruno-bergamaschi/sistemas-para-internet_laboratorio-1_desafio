import java.time.LocalDate;

public class Produto {
    private String nome;
    private double preco;
    private Data dataValidade;

    public Produto(
        String nome,
        double preco,
        Data dataValidade
    ) {
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataValidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Data getDataValidade() {
        return dataValidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setDataValidade(Data dataValidade) {
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString() {
        return String.join(
                System.lineSeparator(),
                "Nome: " + nome,
                "Preço: " + preco);
    }

    public boolean estaVencido(Data data) {
        LocalDate dataValidadeDoProduto = LocalDate.of(
            this.dataValidade.getAno(),
            this.dataValidade.getMes(),
            this.dataValidade.getDia()
        );

        LocalDate dataParaValidacao = LocalDate.of(
            data.getAno(),
            data.getMes(),
            data.getDia()
        );

        if(dataParaValidacao.isAfter(dataValidadeDoProduto)) {
            return true;
        }

        return false;
    }
}