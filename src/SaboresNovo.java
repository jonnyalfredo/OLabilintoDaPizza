import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//=============================================================//==============================================================="
// Essa classe não faz parte do codigo tentei concertar a classe sabores que estava muito bagunçada mas acabei não tendo tempo
//=============================================================//==============================================================="
public class SaboresNovo {
    public static class MinhaClasse {
        private String pedido;
        private double valorPedido;

        public MinhaClasse(String pedido, double valorPedido) {
            this.pedido = pedido;
            this.valorPedido = valorPedido;
        }

        public MinhaClasse() {
        }

        public void setPedido(String pedido) {
            this.pedido = pedido;
        }

        public void setValorPedido(double valorPedido) {
            this.valorPedido = valorPedido;
        }

        public String getPedido() {
            return pedido;
        }

        public double getValorPedido() {
            return valorPedido;
        }

    }


    public static class DetalhesSaboresSalgada extends MinhaClasse {// sub classe para criação do construtor

        public DetalhesSaboresSalgada(String pizzaSalgada, double valorSalgada) {

            this.pizzaSalgada = pizzaSalgada;
            this.valorSalgada = valorSalgada;
        }

        private String pizzaSalgada;
        private double valorSalgada;

        public String getPizzaSalgada() {
            return pizzaSalgada;
        }//metodo que tras o retorno da vetor pizzaSalgada

        public double getValorSalgada() {
            return valorSalgada;
        }//metodo que tras o retorno da vetor valorSalgada
    }

    private static List<DetalhesSaboresSalgada> salgada = new ArrayList<>();// classe lista foi importada da biblioteca java onde esta criando uma lista com o nome bebidas

    static {
        salgada.add(new DetalhesSaboresSalgada("Calabresa", 10.11));                //
        salgada.add(new DetalhesSaboresSalgada("Portuguesa", 10.20));              //
        salgada.add(new DetalhesSaboresSalgada("Marguerita", 10.09));             //a lista bebidas esta recebendo esses valores
        salgada.add(new DetalhesSaboresSalgada("Frango Com Catupiry", 11.88));   //
        salgada.add(new DetalhesSaboresSalgada("Mussarela", 11.00));            //
        salgada.add(new DetalhesSaboresSalgada("Napolitana", 10.55));          //
        salgada.add(new DetalhesSaboresSalgada("Quatro Queijos", 11.22));     //a lista bebidas esta recebendo esses valores
        salgada.add(new DetalhesSaboresSalgada("Atum Com Cebola", 09.95));   //
        salgada.add(new DetalhesSaboresSalgada("Milho", 10.50));            //
        salgada.add(new DetalhesSaboresSalgada("Baiana", 10.80));          //
    }

    public static class DetalhesSaboresDoce extends MinhaClasse {// sub classe para criação do construtor
        private String pizzaDoce;
        private double valorDoce;

        public DetalhesSaboresDoce(String pizzaDoce, double valorDoce) {// construtor para atribuir valores do parametro a variavel
            this.pizzaDoce = pizzaDoce;
            this.valorDoce = valorDoce;

        }

        public String getPizzaDoce() {
            return pizzaDoce;
        }//metodo que tras o retorno da vetor pizzaDoce

        public double getValorDoce() {
            return valorDoce;
        }//metodo que tras o retorno da vetor valorDoce
    }

    private static List<DetalhesSaboresDoce> doce = new ArrayList<>();// classe lista foi importada da biblioteca java onde esta criando uma lista com o nome bebidas

    static {
        doce.add(new DetalhesSaboresDoce("Brigadeiro", 12.00));                  //
        doce.add(new DetalhesSaboresDoce("Ganache Com Rum", 13.00));                //
        doce.add(new DetalhesSaboresDoce("Chocolate Com Avelã", 12.23));               //a lista bebidas esta recebendo esses valores
        doce.add(new DetalhesSaboresDoce("Chocolate, Sorvete e Frutas", 13.50));     //
        doce.add(new DetalhesSaboresDoce("Ovomaltine", 14.00));              //
        doce.add(new DetalhesSaboresDoce("Brownie", 13.20));            //
        doce.add(new DetalhesSaboresDoce("Banana Nevada", 11.30));       //a lista bebidas esta recebendo esses valores
        doce.add(new DetalhesSaboresDoce("Romeu e Julieta", 12.82));     //
        doce.add(new DetalhesSaboresDoce("Prestígio", 08.00));              //
        doce.add(new DetalhesSaboresDoce("Banofe", 12.87));            //
    }

    //public static void main(String[] args) {

    public static DetalhesSaboresSalgada pedidoSalgado() {// metodo para que os pediodo de sabores salgados
        Scanner leitura = new Scanner(System.in);
        boolean escolhaValida = false;
        int escolhaSalgada = 0;
        double valorPedido = 0.0;
        String pedido = "";
        while (!escolhaValida) {
            System.out.println("=============================================================\n" +
                    "                         Escolha um sabor Salgado                             " +
                    "\n=============================================================");
            for (int i = 0; i < salgada.size(); i++) {
                System.out.println(i + 1 + " - " + salgada.get(i).getPizzaSalgada() + " (R$ " + salgada.get(i).getValorSalgada() + ")");
            }
            escolhaSalgada = leitura.nextInt();
            if (escolhaSalgada >= 1 && escolhaSalgada <= salgada.size()) {
                escolhaValida = true;
            } else {
                System.out.println("Opção inválida. Escolha um sabor doce válido.");
            }
        }
        return salgada.get(escolhaSalgada - 1);
    }


    // public static void main(String[] args) {


    public static DetalhesSaboresDoce pedidoDoce() {// metodo para que os pediodo de sabores salgados
        Scanner leitura = new Scanner(System.in);
        boolean escolhaValida = false;
        int escolhaDoce = 0;
        double valorPedido = 0.0;
        String pedido = "";
        while (!escolhaValida) {
            System.out.println("=============================================================\n" +
                    "                         Escolha um sabor Doce                             " +
                    "\n=============================================================");
            for (int i = 0; i < doce.size(); i++) {
                System.out.println(i + 1 + " - " + doce.get(i).getPizzaDoce() + " (R$ " + doce.get(i).getValorDoce() + ")");
            }
            escolhaDoce = leitura.nextInt();
            if (escolhaDoce >= 1 && escolhaDoce <= doce.size()) {
                escolhaValida = true;
            } else {
                System.out.println("Opção inválida. Escolha um sabor doce válido.");
            }
        }
        return doce.get(escolhaDoce - 1);
    }

    // public static void main(String[] args) {


    public static MinhaClasse pedidoMisto() {//metodo para que os pedidos de sabores mistos
        Scanner leitura = new Scanner(System.in);
        boolean escolhaValida = false;
        // boolean escolhaValida2 = false;
        int escolha = 0;
        //int escolha = 0;
        double valorPedido = 0.0;
        String pedido = "";
        while (!escolhaValida) {
            System.out.println("    Escolha entre os tipos de pizza:\n  Doce    |   Salgada\n");
            String tipoDeSabor = leitura.nextLine();
            if (tipoDeSabor.equalsIgnoreCase("salgada")) {
                System.out.println("=============================================================\n" +
                        "                         Escolha um sabor Salgado                       " +
                        "\n=============================================================");
                for (int i = 0; i < salgada.size(); i++) {
                    System.out.println((i + 1) + " - " + salgada.get(i).getPizzaSalgada() + " (R$ " + salgada.get(i).getValorSalgada() + ")");
                }
                escolha = leitura.nextInt();
                if (escolha >= 1 && escolha <= salgada.size()) {
                    escolhaValida = true;
                } else {
                    System.out.println("Opção inválida. Escolha um sabor salgado válido.");
                }
                return salgada.get(escolha - 1);
            } else if (tipoDeSabor.equalsIgnoreCase("doce")) {

                while (!escolhaValida) {
                    System.out.println("=============================================================\n" +
                            "                         Escolha um sabor Doce                             " +
                            "\n=============================================================");
                    for (int i = 0; i < doce.size(); i++) {
                        System.out.println((i + 1) + " - " + doce.get(i).getPizzaDoce() + " (R$ " + doce.get(i).getValorDoce() + ")");
                    }
                    escolha = leitura.nextInt();
                    if (escolha >= 1 && escolha <= doce.size()) {
                        escolhaValida = true;
                    } else {
                        System.out.println("Opção inválida. Escolha um sabor doce válido.");
                    }
                }
                return doce.get(escolha - 1);
            }
        }
        return null;
    }
}

