public class Loja {
    private String nome;
    private int quantidadeFuncionarios;
    private double salarioBaseFuncionario;

    public Loja(
        String nome,
        int quantidadeFuncionarios,
        double salarioBaseFuncionario
    ) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
    }

    public Loja(
        String nome,
        int quantidadeFuncionarios
    ) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = -1;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }

    public double getSalarioBaseFuncionario() {
        return salarioBaseFuncionario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }

    public void setSalarioBaseFuncionario(double salarioBaseFuncionario) {
        this.salarioBaseFuncionario = salarioBaseFuncionario;
    }

    @Override
    public String toString() {
        return String.join(
                System.lineSeparator(),
                "Nome: " + nome,
                "Quantidade de funcionários: " + quantidadeFuncionarios,
                "Salário base do funcionario: " + salarioBaseFuncionario);
    }

    public double gastosComSalario() {
        if (salarioBaseFuncionario < 0) {
            return salarioBaseFuncionario;
        }

        return salarioBaseFuncionario * quantidadeFuncionarios;
    }

    public char tamanhoDaLoja() {
        if (quantidadeFuncionarios < 10) {
            return 'P';
        } else if (quantidadeFuncionarios >= 10 && quantidadeFuncionarios <= 30) {
            return 'M';
        } else {
            return 'G';
        }
    }
}