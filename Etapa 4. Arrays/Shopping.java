public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas = null;

    public Shopping(
        String nome,
        Endereco endereco,
        int quantidadeMaximaLojas
    ) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[quantidadeMaximaLojas];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Loja[] getLojas() {
        return lojas;
    }

    private String formatarLojas() {
        boolean existeLojaCadastrada = false;
        for (Loja loja : lojas) {
            if(loja != null){
                existeLojaCadastrada = true;
            }
        }

        if (!existeLojaCadastrada) {
            return "Nenhuma loja cadastrada.";
        }
    
        StringBuilder stringBuilder = new StringBuilder();
        for (Loja loja : lojas) {
            if(loja != null){
                stringBuilder.append(loja.toString());
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
            "Endereço:",
            "- Rua: " + endereco.getNomeDaRua(),
            "- Número: " + endereco.getNumero(),
            "- Complemento: " + endereco.getComplemento(),
            "- CEP: " + endereco.getCep(),
            "- Cidade: " + endereco.getCidade(),
            "- Estado: " + endereco.getEstado(),
            "- Pais: " + endereco.getPais(),
            "Lojas: " + formatarLojas());
    }

    public boolean insereLoja(Loja loja) {
        for(int i = 0; i < this.lojas.length; i++) {
            if(this.lojas[i] == null) {
                this.lojas[i] = loja;
                return true;
            }
        }
        return false;
    }

    public boolean removeLoja(String nomeLoja) {
        for(int i = 0; i < this.lojas.length; i++) {
            if(this.lojas[i] != null){
                if(this.lojas[i].getNome() == nomeLoja) {
                    this.lojas[i] = null;
                    return true;
                }
            } 
        }
        return false;
    }

    public int quantidadeLojasPorTipo(String tipoLoja) {
        int totalLojas = 0;

        if ( 
            !tipoLoja.equalsIgnoreCase("Cosmético") &&
            !tipoLoja.equalsIgnoreCase("Vestuário") &&
            !tipoLoja.equalsIgnoreCase("Bijuteria") &&
            !tipoLoja.equalsIgnoreCase("Alimentação") &&
            !tipoLoja.equalsIgnoreCase("Informática")
        ) {
            return -1;
        }

        for (Loja loja : this.lojas) {
            if (
                (tipoLoja.equalsIgnoreCase("Alimentação") && loja instanceof Alimentacao) ||
                (tipoLoja.equalsIgnoreCase("Bijuteria") && loja instanceof Bijuteria) ||
                (tipoLoja.equalsIgnoreCase("Cosmético") && loja instanceof Cosmetico) ||
                (tipoLoja.equalsIgnoreCase("Informática") && loja instanceof Informatica) ||
                (tipoLoja.equalsIgnoreCase("Vestuário") && loja instanceof Vestuario)
            ) {
                totalLojas++;
            }
        }

        return totalLojas;
    }

    public Informatica lojaSeguroMaisCaro() {
        Informatica lojaComSeguroMaisCaro = null;
        double maiorValorSeguro = 0.0;

        for (Loja loja : this.lojas) {
            if (loja instanceof Informatica) {
                Informatica lojaInformatica = (Informatica) loja;
                double valorSeguroAtual = lojaInformatica.getSeguroEletronicos();

                if(valorSeguroAtual > maiorValorSeguro) {
                    maiorValorSeguro = valorSeguroAtual;
                    lojaComSeguroMaisCaro = lojaInformatica;
                }
            }
        }

        return lojaComSeguroMaisCaro;
    }
}
