public class ALaCarte {
    public static void atendimentoALaCarte() {// criei para ter uma interação com a classe principal é aqui que ta chamando as outras classes
        Cardapio pedido = new Cardapio();// aqui ta chamando a classe cardapio
        pedido.fazerPedido();// chama o metodo que faz pedido da classe cardapio
        System.out.println("O seu pedido esta sendo preparado...\n iremos trazer.");
        System.out.println("\n\n\n aqui esta o seu pedido.");
        System.out.println("\nBom apetite!!");
    }
}
