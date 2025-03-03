public class Delivery {
        public static void chatDelivery() {// criei para ter uma interação com a classe principal é aqui que ta chamando as outras classes
            Clientes controller = new Clientes();// aqui ta chamando a classe clientes
            Clientes.DadosCliente cliente = controller.fazerCadastroDelivery(); // aqui ta chamando o metodo que faz o cadastro que fica na classe Clientes
            Cardapio pedido = new Cardapio();// aqui ta chamando a classe cardapio
            System.out.println("Pronto cadastro concluido \n agora: ");
             pedido.fazerPedido();// chama o metodo que faz pedido da classe cardapio
             System.out.println("Tempo para entrega: 30 minutos");
          System.out.println("dados do cliente para o recebimento:");// as linhas seguintes so mostra as informações do cliente
          System.out.println("Nome: " + cliente.getNome());
          System.out.println("Endereço: " + cliente.getEndereco());
          System.out.println("Telefone: " + cliente.getTelefone());
          System.out.println("E-mail: " + cliente.getEmail());
          System.out.println("Forma de pagamento: " + cliente.getFormaPagamento());
          System.out.println("\nBom apetite!!");
          }
        }


