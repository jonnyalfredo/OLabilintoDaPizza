import java.util.Scanner;

//=============================================================//==============================================================="
// Essa classe não faz parte do codigo tentei concertar a classe cardapio que estava muito bagunçada mas acabei não tendo tempo
//=============================================================//==============================================================="

public class CardapioNovo extends SaboresNovo {
    private static String textoCardapio = """
            Escolha o tamanho da pizza: 

            P   |   M   |   G   |   GG

                Tamanho P = 1 sabor
                Tamanho M = 2 sabores
                Tamanho G = 3 sabores
                Tamanho GG = 4 sabores

            """;// variavel que informa quais são as escolhas do usuario

    //public static void fazerPedido() {// nesse metodo vai ser feito o pedido de acordo com o tamanho escolhido P M G GG
    public static void main(String[] args) {
        String pedido = "";
        double valorPedido = 0.0;
        boolean escolhaValida = false;
        Scanner leitura = new Scanner(System.in);
        System.out.println(textoCardapio);// mostra quais são os tamanhos disponiveis e quanto sabores pode em cada
        String tamanho = leitura.nextLine();// esta lendo qual é o tamanho

        if (tamanho.equalsIgnoreCase("p")) {// aqui foi escolhido o tamanho p


            while (!escolhaValida) {

                System.out.println("  Essa opção possui 1 sabor \n Escolha entre os tipos de pizza:\n  Doce    |   Salgada\n");
                String tipoDeSabor = leitura.nextLine();

                if (tipoDeSabor.equalsIgnoreCase("salgada")) {
                    DetalhesSaboresSalgada detalhes = SaboresNovo.pedidoSalgado();
                    pedido = detalhes.getPizzaSalgada();
                    valorPedido = detalhes.getValorSalgada();
                    escolhaValida = true;
                } else if (tipoDeSabor.equalsIgnoreCase("doce")) {
                    DetalhesSaboresDoce detalhes = SaboresNovo.pedidoDoce();
                    pedido = detalhes.getPizzaDoce();
                    valorPedido = detalhes.getValorDoce();
                    escolhaValida = true;
                } else {
                    System.out.println("Opção inválida. Escolha um tipo de sabor novamente.");
                }
                Bebidas.Bebida escolherBebida = Bebidas.escolherBebida();

                System.out.println("=============================================================\n" +
                        "                         Pedido Escolhido:                      " +
                        "\n=============================================================");
                System.out.println("Você escolheu: \n" + pedido + (" - R$ ") + valorPedido + ("\n") + escolherBebida.getNome() + " - R$ " + escolherBebida.getValor());// aqui mostra qual bebida foi escolhida
                System.out.println("O valor total da compra é R$ " + (valorPedido + (escolherBebida.getValor())));
            }
        } else if (tamanho.equalsIgnoreCase("m")) {// aqui foi escolhido o tamanho p

            System.out.println("  Essa opção possui 2 sabores \n Escolha entre os tipos de pizza:\n  Doce    |   Salgada    |   mista\n");
            String tipoDeSabor = leitura.nextLine();
            for (int i = 0; i < 2; i++) {
                if (tipoDeSabor.equalsIgnoreCase("salgada")) {
                    DetalhesSaboresSalgada detalhes = SaboresNovo.pedidoSalgado();
                    pedido = detalhes.getPizzaSalgada();
                    valorPedido = detalhes.getValorSalgada();
                    escolhaValida = true;
                } else if (tipoDeSabor.equalsIgnoreCase("doce")) {
                    DetalhesSaboresDoce detalhes = SaboresNovo.pedidoDoce();
                    pedido = detalhes.getPizzaDoce();
                    valorPedido = detalhes.getValorDoce();
                    escolhaValida = true;
                } else if (tipoDeSabor.equalsIgnoreCase("mista")) {
                    MinhaClasse detalhes = SaboresNovo.pedidoMisto();
                    pedido = detalhes.getPedido();
                    valorPedido = detalhes.getValorPedido();
                    escolhaValida = true;
                } else {
                    System.out.println("Opção inválida. Escolha um tipo de sabor novamente.");
                }
            }
            Bebidas.Bebida escolherBebida = Bebidas.escolherBebida();
            System.out.println("=============================================================\n" +
                    "                         Pedido Escolhido:                      " +
                    "\n=============================================================");
            System.out.println("Você escolheu: \n" + pedido + (" - R$ ") + valorPedido + ("\n") + escolherBebida.getNome() + " - R$ " + escolherBebida.getValor());// aqui mostra qual bebida foi escolhida
            System.out.println("O valor total da compra é R$ " + (valorPedido + (escolherBebida.getValor())));

        } else if (tamanho.equalsIgnoreCase("g")) {// aqui foi escolhido o tamanho p
            System.out.println("  Essa opção possui 3 sabores \n Escolha entre os tipos de pizza:\n  Doce    |   Salgada    |   mista\n");
            String tipoDeSabor = leitura.nextLine();
            for (int i = 0; i < 3; i++) {
                if (tipoDeSabor.equalsIgnoreCase("salgada")) {
                    DetalhesSaboresSalgada detalhes = SaboresNovo.pedidoSalgado();
                    pedido = detalhes.getPizzaSalgada();
                    valorPedido = detalhes.getValorSalgada();
                    escolhaValida = true;
                } else if (tipoDeSabor.equalsIgnoreCase("doce")) {
                    DetalhesSaboresDoce detalhes = SaboresNovo.pedidoDoce();
                    pedido = detalhes.getPizzaDoce();
                    valorPedido = detalhes.getValorDoce();
                    escolhaValida = true;
                } else if (tipoDeSabor.equalsIgnoreCase("mista")) {
                    MinhaClasse detalhes = SaboresNovo.pedidoMisto();
                    pedido = detalhes.getPedido();
                    valorPedido = detalhes.getValorPedido();
                    escolhaValida = true;
                } else {
                    System.out.println("Opção inválida. Escolha um tipo de sabor novamente.");
                }
            }
            Bebidas.Bebida escolherBebida = Bebidas.escolherBebida();
            System.out.println("=============================================================\n" +
                    "                         Pedido Escolhido:                      " +
                    "\n=============================================================");
            System.out.println("Você escolheu: \n" + pedido + (" - R$ ") + valorPedido + ("\n") + escolherBebida.getNome() + " - R$ " + escolherBebida.getValor());// aqui mostra qual bebida foi escolhida
            System.out.println("O valor total da compra é R$ " + (valorPedido + (escolherBebida.getValor())));

        } else if (tamanho.equalsIgnoreCase("gg")) {// aqui foi escolhido o tamanho p
            System.out.println("  Essa opção possui 4 sabores \n Escolha entre os tipos de pizza:\n  Doce    |   Salgada    |   mista\n");
            String tipoDeSabor = leitura.nextLine();
            for (int i = 0; i < 4; i++) {
                if (tipoDeSabor.equalsIgnoreCase("salgada")) {
                    DetalhesSaboresSalgada detalhes = SaboresNovo.pedidoSalgado();
                    pedido = detalhes.getPizzaSalgada();
                    valorPedido = detalhes.getValorSalgada();
                    escolhaValida = true;
                } else if (tipoDeSabor.equalsIgnoreCase("doce")) {
                    DetalhesSaboresDoce detalhes = SaboresNovo.pedidoDoce();
                    pedido = detalhes.getPizzaDoce();
                    valorPedido = detalhes.getValorDoce();
                    escolhaValida = true;
                } else if (tipoDeSabor.equalsIgnoreCase("mista")) {
                    MinhaClasse detalhes = SaboresNovo.pedidoMisto();
                    pedido = detalhes.getPedido();
                    valorPedido = detalhes.getValorPedido();
                    escolhaValida = true;
                } else {
                    System.out.println("Opção inválida. Escolha um tipo de sabor novamente.");
                }
            }
            Bebidas.Bebida escolherBebida = Bebidas.escolherBebida();
            System.out.println("=============================================================\n" +
                    "                         Pedido Escolhido:                      " +
                    "\n=============================================================");
            System.out.println("Você escolheu: \n" + pedido + (" - R$ ") + valorPedido + ("\n") + escolherBebida.getNome() + " - R$ " + escolherBebida.getValor());// aqui mostra qual bebida foi escolhida
            System.out.println("O valor total da compra é R$ " + (valorPedido + (escolherBebida.getValor())));
        }
    }
}


