public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.ano = ano;
        this.dia = dia;
        this.mes = mes;

        boolean anoBissexto = this.verificaAnoBissexto();
        boolean diaValido = this.validaDiaDoMes(anoBissexto);

        if (!diaValido) {
            this.ano = 1;
            this.mes = 1;
            this.ano = 2000;

            System.out.println("A data informada é inválida.");
        }
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

    public boolean verificaAnoBissexto() {
        if (this.ano % 400 == 0) {
            return true;
        } else if (this.ano % 100 == 0) {
            return false;
        } else if (this.ano % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validaDiaDoMes(boolean anoBissexto) {
        switch (this.mes) {
            case 1:
                return this.dia <= 31;
            case 2:
                return anoBissexto ? this.dia <= 29 : this.dia <= 28;
            case 3:
                return this.dia <= 31;
            case 4:
                return this.dia <= 30;
            case 5:
                return this.dia <= 31;
            case 6:
                return this.dia <= 30;
            case 7:
                return this.dia <= 31;
            case 8:
                return this.dia <= 31;
            case 9:
                return this.dia <= 30;
            case 10:
                return this.dia <= 31;
            case 11:
                return this.dia <= 30;
            case 12:
                return this.dia <= 31;
            default:
                return false;
        }
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }
}
