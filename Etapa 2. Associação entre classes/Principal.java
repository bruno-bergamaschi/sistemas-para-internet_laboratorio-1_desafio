public class Principal {
    public static void main(String[] args){
        String escolhaMenu;
        Loja loja = null;
        Produto produto = null;
        
        while(true) {
            System.out.println("(1) criar uma loja");
            System.out.println("(2) criar um produto");
            System.out.println("(3) sair");

            escolhaMenu = Teclado.leString("");

            if(escolhaMenu.equals("1")) {
                System.out.println("\nCriação de Loja:\n");
                String nome = Teclado.leString("Nome: ");
                String quantidadeFuncionarios = Teclado.leString("Quantidade de funcionários: ");
                String salarioBaseFuncionario = Teclado.leString("Salário base dos funcionários: ");
                
                String temEndereco = Teclado.leString("Deseja inserir endereço? 1 - Sim | 2 - Não");
                Endereco endereco = null;
    
                if(temEndereco.equals("1")) {
                    String nomeDaRua = Teclado.leString("Rua: ");
                    String numero = Teclado.leString("Número: ");
                    String complemento = Teclado.leString("Complemento: ");
                    String cep = Teclado.leString("CEP: ");
                    String cidade = Teclado.leString("Cidade: ");
                    String estado = Teclado.leString("Estado: ");
                    String pais = Teclado.leString("Pais: ");
    
                    endereco = new Endereco(
                        nomeDaRua,
                        cidade,
                        estado,
                        pais,
                        cep,
                        numero,
                        complemento
                    );
                }
    
                String temDataFundacao = Teclado.leString("Deseja inserir data de fundação? 1 - Sim | 2 - Não");
                Data dataFundacao = null;
    
                if(temDataFundacao.equals("1")) {
                    String data = Teclado.leString("Data (dd/mm/ano): ");
                    String[] partes = data.split("/");
                    int dia = Integer.parseInt(partes[0]);
                    int mes = Integer.parseInt(partes[1]);
                    int ano = Integer.parseInt(partes[2]);
      
                    dataFundacao = new Data(dia, mes, ano);
                }
    
                loja = new Loja(
                    nome,
                    Integer.parseInt(quantidadeFuncionarios),
                    Double.parseDouble(salarioBaseFuncionario),
                    endereco,
                    dataFundacao,
                    10
                );
            } else if (escolhaMenu.equals("2")) {
                System.out.println("\nCriação de Loja:\n");

                String nome = Teclado.leString("Nome: ");
                String preco = Teclado.leString("Preço: ");
                String data = Teclado.leString("Data de validade (dd/mm/ano): ");
                String[] partes = data.split("/");
                int dia = Integer.parseInt(partes[0]);
                int mes = Integer.parseInt(partes[1]);
                int ano = Integer.parseInt(partes[2]);
                Data dataValidade = new Data(dia, mes, ano);
  
                produto = new Produto(
                    nome,
                    Double.parseDouble(preco),
                    dataValidade
                );

            } else if (escolhaMenu.equals("3")) {
                break;
            } else {
                System.out.println("\nOpção inválida \n");
            }
            
        }

        if(produto != null) {
            boolean produtoVencido = produto.estaVencido(new Data(20, 10, 2023));
            System.out.println(produtoVencido ? "PRODUTO VENCIDO" : "PRODUTO NÃO VENCIDO");
        }

        if(loja != null) {
            System.out.println(loja.toString());
        }
        
    }
}