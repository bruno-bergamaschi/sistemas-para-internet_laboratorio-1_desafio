public class ArquivoDeTeste {
    public static void main(String[] args){
        Endereco shopping1endereco = new Endereco(
            "Rua 1", 
            "Porto Alegre", 
            "RS", 
            "Brasil", 
            "91000000", 
            "30", 
            "Sem complemento"
            );
        Shopping shopping1 = new Shopping("Pria de Belas Shopping", shopping1endereco, 20);

        System.out.println(shopping1.toString());
    }
}