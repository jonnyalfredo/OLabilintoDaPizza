import java.util.Scanner;

public class Principal {// classe que vai fazer a primeira interação com o cliente
    public static void main(String[] args) {// o metodo main é o que vai executar todo o codigo
        Scanner leitura= new Scanner(System.in);// faz leitura das informações que o cliente insere
       String inicio = """
                -----------------------------------------------------------------
                                        Seja Bem vindo!
                                 Meu nome é Bia, vou atende-lo!
                         
                Por favor inicia informando a forma de atendimento:
                
                          Delivery    |   A la carte  |   retirada no balcão 
                -----------------------------------------------------------------
                """;
        while(true) {// loop caso o usuario erre as informações

            System.out.println(inicio);
            String atendimento = leitura.nextLine();// ta lendo qual a informação que o usuario coloco
            System.out.println("o meio de atendimento ínformado é: " + atendimento);
            if (atendimento.equalsIgnoreCase("delivery")){
                Delivery chamarDelivery = new Delivery();// chama a classe delivery
                chamarDelivery.chatDelivery();// chama o metodo chatdelivery
                break;
            } else if (atendimento.equalsIgnoreCase("a la carte")) {
                RetiradaNoBalcao chamarbalcao = new RetiradaNoBalcao();//chama a classe retiradanobalcao
                chamarbalcao.chatAtendimentoBalcao();// chama o metodo ChatAtendimentoBalcao
                break;
            }else if ( atendimento.equalsIgnoreCase("retirada no balcão") || atendimento.equalsIgnoreCase("retirada no balcao")){
                ALaCarte chamargarcom = new ALaCarte();//chama a classe alacarte
                chamargarcom.atendimentoALaCarte();// chama o metodo atendimentoalacarte
                break;
            }else {
                System.out.println("Desculpe, opção invalida.");
            }

        }
    }
}
