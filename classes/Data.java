// o Método Construtor: crie 1 construtor que um recebe parâmetros para
// inicializar todos os atributos. Neste construtor, você deve validar a data
// informada nos parâmetros. Ou seja, o método construtor deve verificar se o
// dia é condizente com o mês, levando em conta, também, o fato de o ano
// poder ser bissexto. Por exemplo, o dia 29 para o mês 2 só pode ser atribuído
// em anos bissextos. Caso a data seja inválida, o método construtor deve
// imprimir uma mensagem de erro e alterar a data para a seguinte data padrão:
// 1/1/2000.

// o Métodos de acesso: crie os métodos de acesso (getters e setters)
// para todos os atributos da classe.
// o Método toString: se necessário, pesquise sobre o método toString e
// implemente-o nesta classe, retornando uma String que representa a data
// no formato dia/mês/ano.

// o Método verificaAnoBissexto: este método não recebe parâmetros e
// retorna verdadeiro caso o ano seja bissexto e falso caso contrário. 

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        boolean anoBissexto = this.validaAnoBissexto(ano);
        boolean diaValido = this.validaDiaDoMes(dia, mes, anoBissexto);

        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    private boolean validaAnoBissexto(int ano) {
        if (ano % 400 == 0) {
            return true;
        } else if (ano % 100 == 0) {
            return false;
        } else if (ano % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validaDiaDoMes(int dia, int mes, boolean anoBissexto) {
        switch (mes) {
            case 1:
                return dia <= 31;
            case 2:
                if (anoBissexto) {
                    return dia <= 29;
                }
                return dia <= 28;
            case 3:
                return dia <= 31;
            case 4:
                return dia <= 30;
            case 5:
                return dia <= 31;
            case 6:
                return dia <= 30;
            case 7:
                return dia <= 31;
            case 8:
                return dia <= 31;
            case 9:
                return dia <= 30;
            case 10:
                return dia <= 31;
            case 11:
                return dia <= 30;
            case 12:
                return dia <= 31;
            default:
                return false;
        }
    }
}
