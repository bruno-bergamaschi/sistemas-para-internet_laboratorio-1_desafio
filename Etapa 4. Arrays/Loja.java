public class Loja {
    private String nome;
    private int quantidadeFuncionarios;
    private double salarioBaseFuncionario;
    private Endereco endereco;
    private Data dataFundacao;
    private Produto[] estoqueProdutos;

    public Loja(
        String nome,
        int quantidadeFuncionarios,
        double salarioBaseFuncionario,
        Endereco endereco,
        Data dataFundacao,
        int quantidadeEstoqueProdutos
    ) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.estoqueProdutos = new Produto[quantidadeEstoqueProdutos];
    }

    public Loja(
        String nome,
        int quantidadeFuncionarios,
        Endereco endereco,
        Data dataFundacao,
        int quantidadeEstoqueProdutos
    ) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = -1;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.estoqueProdutos = new Produto[quantidadeEstoqueProdutos];
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

    public Endereco getEndereco() {
        return endereco;
    }

    public Data getDataFundacao() {
        return dataFundacao;
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
    
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public void setDataFundacao(Data dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public Produto[] getEstoqueProdutos() {
        return this.estoqueProdutos;
    }

    private String formatarEndereco() {
        if(this.endereco != null) {
            return String.join(
                System.lineSeparator(),
                "Endereço:",
                "- Rua: " + endereco.getNomeDaRua(),
                "- Número: " + endereco.getNumero(),
                "- Complemento: " + endereco.getComplemento(),
                "- CEP: " + endereco.getCep(),
                "- Cidade: " + endereco.getCidade(),
                "- Estado: " + endereco.getEstado(),
                "- Pais: " + endereco.getPais());
        }

        return "Endereço: Não cadastrado.";
    }
    
    private String formatarDataFundacao() {
        if(this.dataFundacao != null) {
            return "Data da fundação" + dataFundacao.toString();
        }

        return "Data da fundação: Não informado.";
    }

    private String formatarEstoqueProdutos() {
        boolean existeProdutoCadastrado = false;
        for (Produto produto : estoqueProdutos) {
            if(produto != null){
                existeProdutoCadastrado = true;
            }
        }

        if (!existeProdutoCadastrado) {
            return "Nenhuma produto cadastrado.";
        }
    
        StringBuilder stringBuilder = new StringBuilder();
        for (Produto produto : estoqueProdutos) {
            if(produto != null){
                stringBuilder.append(produto.toString());
                stringBuilder.append(System.lineSeparator());
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return String.join(
                System.lineSeparator(),
                "Nome: " + nome,
                "Quantidade de funcionários: " + quantidadeFuncionarios,
                "Salário base do funcionario: " + salarioBaseFuncionario,
                formatarEndereco(),
                formatarDataFundacao(),
                "Estoque de produtos: " + formatarEstoqueProdutos());
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

    public void imprimeProdutos() {
        boolean existeProdutoCadastrada = false;
        for (Produto produto : estoqueProdutos) {
            if(produto != null) {
                existeProdutoCadastrada = true;
            }
        }

        if(existeProdutoCadastrada) {
            for(Produto produto : estoqueProdutos) {
                System.out.println(produto.getNome());
                System.out.println(produto.getPreco());
                System.out.println(produto.getDataValidade());
                System.out.println("-------------------------------------------");
            }
        }
    }

    public boolean insereProduto(Produto produto) {
        for(int i = 0; i < this.estoqueProdutos.length; i++) {
            if(this.estoqueProdutos[i] == null) {
                this.estoqueProdutos[i] = produto;
                return true;
            }
        }
        return false;
    }

    public boolean removeProduto(String nomeProduto) {
        for(int i = 0; i < this.estoqueProdutos.length; i++) {
            if(this.estoqueProdutos[i] != null) {
                if(this.estoqueProdutos[i].getNome() == nomeProduto) {
                    this.estoqueProdutos[i] = null;
                    return true;
                }
            }
        }
        return false;
    }
}