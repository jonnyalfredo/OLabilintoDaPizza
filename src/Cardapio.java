import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cardapio {// classe que vai fazer o pedido do cliente
    private static Sabores sabores = new Sabores();// aqui esta chamando a classe sabores
    private static String textoCardapio = """
            Escolha o tamanho da pizza: 

            P   |   M   |   G   |   GG

                 Tamanho P = 1 sabor
                Tamanho M = 2 sabores
                Tamanho G = 3 sabores
                Tamanho GG = 4 sabores

            """;// variavel que informa quais são as escolhas do usuario

    public static class PizzaEscolhida {// sub classe que ira receber o construtor

        private List<String> sabores = new ArrayList<>();// lista de sabores para o cliente
        private List<Double> valores = new ArrayList<>();// lista de valores
        private Double total = 0.0;

        public PizzaEscolhida(String[] sabor, double[] valor) {// construtor que recebe os vetores e transforma em lista
            sabores.add(sabor[0]);
            valores.add(valor[0]);
        }

        public PizzaEscolhida(List<String> sabores, List<Double> valores, double total) {// construtor que recebe a lista de sabores e valores e o valor total
            this.sabores = sabores;
            this.valores = valores;
            this.total = total;
        }

        public List<String> getSabores() {
            return sabores;
        }       //

        public List<Double> getValores() {
            return valores;
        }       //metodo para que outras classes tenham acesso

        public Double getTotal() {
            return total;
        }                 //
    }

    public static PizzaEscolhida pedidoSalgado() {// metodo para que os pediodo de sabores salgados
        Scanner leitura = new Scanner(System.in);// classe de leitura
        System.out.println(sabores.getCardapioSalgada());// ta mostrando quais são os sabores salgados
        System.out.println("Informe apenas o número antes do sabor salgado da pizza:");// ta pedindo para que informe qual o numero antes do sabor
        int numero = Integer.parseInt(leitura.nextLine());// classe de leitura
        if (numero < 1 || numero > sabores.getPizzaSalgada().length) {// condição para que o usuario escolhe apenas de 1 a 10
            System.out.println("Número inválido de sabor de pizza salgada. Tente novamente.");// mensagem de resposta invalida
        } else {
            String pizzaEscolha = sabores.getPizzaSalgada()[numero - 1];//as variaveis estão rescebendo os valores ds vetor de acordo com o numero informado
            double valorEscolha = sabores.getValorSalgada()[numero - 1];//pelo cliente  -1 pq o vetor trabalha de 0 a 9
            return new PizzaEscolhida(new String[]{pizzaEscolha}, new double[]{valorEscolha});// retorna os valores escolhidos
        }
        return pedidoSalgado();
    }


    public static PizzaEscolhida pedidoDoce() {// mesmo processo do pedido anterior so que agora com o sabores doce
        Scanner leitura = new Scanner(System.in);
        System.out.println(sabores.getCardapioDoce());
        System.out.println("Informe apenas o número antes do sabor doce da pizza:");
        int numero = Integer.parseInt(leitura.nextLine());
        if (numero < 1 || numero > sabores.getPizzaDoce().length) {
            System.out.println("Número inválido de sabor de pizza doce. Tente novamente.");
        } else {
            String pizzaEscolha = sabores.getPizzaDoce()[numero - 1];
            double valorEscolha = sabores.getValorDoce()[numero - 1];
            return new PizzaEscolhida(new String[]{pizzaEscolha}, new double[]{valorEscolha});
        }
        return pedidoDoce();
    }

    public static PizzaEscolhida pedidoMisto() {// mesmo processo mas com com as duas opções de escolhas juntos
        Scanner leitura = new Scanner(System.in);
        System.out.println("Tipos de sabores:\n      Doce    |   Salgada    ");
        List<String> saboresEscolhidos = new ArrayList<>();
        List<Double> valoresEscolhidos = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            String tipoDeSabor = "";
            while (!tipoDeSabor.equalsIgnoreCase("doce") && !tipoDeSabor.equalsIgnoreCase("salgada")) {// loop para escolher qual tipo de sabor
                System.out.print("Digite o tipo de sabor da pizza: ");
                tipoDeSabor = leitura.nextLine().toLowerCase();// aqui le qual foi o sabor que escolheu
                if (!tipoDeSabor.equalsIgnoreCase("doce") && !tipoDeSabor.equalsIgnoreCase("salgada")) {// condição para que se ele fez uma escolha invalida
                    System.out.println("Tipo de sabor inválido. Tente novamente.");
                }
            }

            if (tipoDeSabor.equalsIgnoreCase("doce")) {// caso o usuario escolha doce entra aqui
                PizzaEscolhida pizzaDoceEscolhida = pedidoDoce();// aqui vai chamar o metodo que faz o pedido do sabor doce
                saboresEscolhidos.addAll(pizzaDoceEscolhida.getSabores());//aqui vai ser guardado os sabores
                valoresEscolhidos.addAll(pizzaDoceEscolhida.getValores());// aqui vai ser guardado os valores
            } else if (tipoDeSabor.equalsIgnoreCase("salgada")) {// caso o usuario escolha salgado entra aqui
                PizzaEscolhida pizzaSalgadaEscolhida = pedidoSalgado();// aqui vai chamar o metodo que faz o pedido do sabor salgado
                saboresEscolhidos.addAll(pizzaSalgadaEscolhida.getSabores());
                valoresEscolhidos.addAll(pizzaSalgadaEscolhida.getValores());
            }
        }

        //aqui Calcula o valor do pedido
        double total = 0.0;
        for (Double valor : valoresEscolhidos) {
            total += valor;
        }
        return new PizzaEscolhida(saboresEscolhidos, valoresEscolhidos, total);
    }

    public static Bebidas.Bebida pedidoBebida() {
        return Bebidas.escolherBebida();
    }// aqui esta chamando a classe bebidas

    public static void fazerPedido() {// nesse metodo vai ser feito o pedido de acordo com o tamanho escolhido P M G GG
        Scanner leitura = new Scanner(System.in);
        String tamanho = "";
        while (!tamanho.equalsIgnoreCase("p") && !tamanho.equalsIgnoreCase("m") && !tamanho.equalsIgnoreCase("g") && !tamanho.equalsIgnoreCase("gg")) {
            System.out.println(textoCardapio);// mostra quais são os tamanhos disponiveis e quanto sabores pode em cada
            tamanho = leitura.nextLine();// esta lendo qual é o tamanho

            if (tamanho.equalsIgnoreCase("p")) {// aqui foi escolhido o tamanho p
                System.out.println("Essa opção possui apenas 1 sabor \nTipos de sabores:\n      Doce    |   Salgada    ");
                String tipoDeSabores = "";
                while (!tipoDeSabores.equalsIgnoreCase("doce") && !tipoDeSabores.equalsIgnoreCase("salgada")) {// esta lendo qual o tipo de sabor
                    tipoDeSabores = leitura.nextLine().toLowerCase();
                    if (!tipoDeSabores.equalsIgnoreCase("doce") && !tipoDeSabores.equalsIgnoreCase("salgada")) {// caso informe o valor errado vai informar
                        System.out.println("Tipo de sabor inválido. Tente novamente.");
                    }
                }
                if (tipoDeSabores.equalsIgnoreCase("doce")) {// se escolher doce cai aqui
                    PizzaEscolhida pizzaDoceEscolhida = pedidoDoce();// ta chamando o metodo que registra o pedido doce
                    String sabor[] = pizzaDoceEscolhida.getSabores().toArray(new String[0]); // aqui salva a escolha do cliente
                    Double valor[] = pizzaDoceEscolhida.getValores().toArray(new Double[0]);// aqui salva o valor do sabor
                    System.out.println("Pizza doce escolhida: " + sabor[0] + ", valor: " + valor[0]);// informe qual o sabor e o valor escolhido
                } else if (tipoDeSabores.equalsIgnoreCase("salgada")) {// caso escolha salgada cai aqui
                    PizzaEscolhida pizzaSalgadaEscolhida = pedidoSalgado();// o processo se repede mas agora chama o metodo que faz o pedido salgado
                    String sabor[] = pizzaSalgadaEscolhida.getSabores().toArray(new String[0]);
                    Double valor[] = pizzaSalgadaEscolhida.getValores().toArray(new Double[0]);
                    System.out.println("Pizza salgada escolhida: " + sabor[0] + ", valor: " + valor[0]);
                }
                Cardapio cardapio = new Cardapio();
                Bebidas.Bebida bebidaEscolhida = cardapio.pedidoBebida();// esta chamando o metodo pedidoBebida que esta na classe bebidas
                System.out.println("Você escolheu: " + bebidaEscolhida.getNome() + " - R$ " + bebidaEscolhida.getValor());// mostra qual foi a bebida escolhida
            } else if (tamanho.equalsIgnoreCase("m")) {// caso o usuario escolher o tamanho m cai aqui
                String tipoDeSabores = "";
                List<String> saborEscolhido = new ArrayList<>();// variaveis do tipo vetor para receber os sabores de pizza e seus valores
                List<Double> valorEscolhido = new ArrayList<>();// esta sendo criado dois vetores para receber mais de um registro
                for (int i = 0; i < 2; i++) {// loop para que faça dois pedidos
                    while (!tipoDeSabores.equalsIgnoreCase("doce") && !tipoDeSabores.equalsIgnoreCase("salgada") && !tipoDeSabores.equalsIgnoreCase("mista")) {
                        System.out.println("Essa opção possui 2 sabores \nTipos de sabores:\n      Doce    |   Salgada   |     mista ");
                        tipoDeSabores = leitura.nextLine().toLowerCase();// ta lendo qual o tipo do sabor
                        if (!tipoDeSabores.equalsIgnoreCase("doce") && !tipoDeSabores.equalsIgnoreCase("salgada") && !tipoDeSabores.equalsIgnoreCase("mista")) {
                            System.out.println("Tipo de sabor inválido. Tente novamente.");
                        }
                    }
                    if (tipoDeSabores.equalsIgnoreCase("doce")) {//caso escolha doce cai aqui
                        PizzaEscolhida pizzaDoceEscolhida = pedidoDoce();// chama o metodo que registra o pedido doce
                        saborEscolhido.addAll(pizzaDoceEscolhida.getSabores());// armazena os sabores escolhidos
                        valorEscolhido.addAll(pizzaDoceEscolhida.getValores());//armazena os valores escolhido
                    } else if (tipoDeSabores.equalsIgnoreCase("salgada")) {//caso escolha salgada cai aqui
                        PizzaEscolhida pizzaSalgadaEscolhida = pedidoSalgado();//chama o metodo que registra o pedido salgado
                        saborEscolhido.addAll(pizzaSalgadaEscolhida.getSabores());// armazena os sabores escolhidos
                        valorEscolhido.addAll(pizzaSalgadaEscolhida.getValores());//armazena os valores escolhido
                    } else if (tipoDeSabores.equalsIgnoreCase("mista")) {//caso escolha mista cai aqui
                        PizzaEscolhida pizzaMistaEscolhida = pedidoMisto();//chama o metodo que registra o pedido misto
                        saborEscolhido.addAll(pizzaMistaEscolhida.getSabores());// armazena os sabores escolhidos
                        valorEscolhido.addAll(pizzaMistaEscolhida.getValores());//armazena os valores escolhido
                    }
                }
                String sabor[] = saborEscolhido.toArray(new String[0]);// recebe os sabores escolhidos
                Double valor[] = valorEscolhido.toArray(new Double[0]);// recebe os valores escolhidos
                double total = 0.0;
                for (int i = 0; i < valor.length; i++) {// faz o calculo de quantos vai dar
                    total += valor[i]; //variavel ta somando todos os valores
                }
                Cardapio cardapio = new Cardapio();
                Bebidas.Bebida bebidaEscolhida = cardapio.pedidoBebida();// esta chamando o metodo pedidoBebida de outra classe
                System.out.println("Você escolheu os seguintes sabores:");
                for (String s : sabor) {// loop que mostra quais os sabores escolhido
                    System.out.println("- " + s);
                }
                System.out.println("Você escolheu: " + bebidaEscolhida.getNome() + " - R$ " + bebidaEscolhida.getValor());// aqui mostra qual bebida foi escolhida
                System.out.println("O valor total da compra é R$ " + (total + bebidaEscolhida.getValor()));// aqui mostra quanto deu tudo
            } else if (tamanho.equalsIgnoreCase("g")) {// caso o usuario escolha o tamanho g cai aqui e o processo anterior se repete
                String tipoDeSabores = "";
                List<String> saborEscolhido = new ArrayList<>();
                List<Double> valorEscolhido = new ArrayList<>();
                while (!tipoDeSabores.equalsIgnoreCase("doce") && !tipoDeSabores.equalsIgnoreCase("salgada") && !tipoDeSabores.equalsIgnoreCase("mista")) {
                    System.out.println("Essa opção possui 3 sabores \nTipos de sabores:\n      Doce    |   Salgada   |     mista ");
                    tipoDeSabores = leitura.nextLine().toLowerCase();// ta lendo qual o tipo do sabor
                    if (!tipoDeSabores.equalsIgnoreCase("doce") && !tipoDeSabores.equalsIgnoreCase("salgada") && !tipoDeSabores.equalsIgnoreCase("mista")) {
                        System.out.println("Tipo de sabor inválido. Tente novamente.");
                    }
                }
                for (int i = 0; i < 3; i++) {// nesse tamanho a pizza é com 3 sabores

                    if (tipoDeSabores.equalsIgnoreCase("doce")) {
                        PizzaEscolhida pizzaDoceEscolhida = pedidoDoce();
                        saborEscolhido.addAll(pizzaDoceEscolhida.getSabores());
                        valorEscolhido.addAll(pizzaDoceEscolhida.getValores());
                    } else if (tipoDeSabores.equalsIgnoreCase("salgada")) {
                        PizzaEscolhida pizzaSalgadaEscolhida = pedidoSalgado();
                        saborEscolhido.addAll(pizzaSalgadaEscolhida.getSabores());
                        valorEscolhido.addAll(pizzaSalgadaEscolhida.getValores());
                    } else if (tipoDeSabores.equalsIgnoreCase("mista")) {
                        PizzaEscolhida pizzaMistaEscolhida = pedidoMisto();
                        saborEscolhido.addAll(pizzaMistaEscolhida.getSabores());
                        valorEscolhido.addAll(pizzaMistaEscolhida.getValores());
                    }
                }
                String sabor[] = saborEscolhido.toArray(new String[0]);
                Double valor[] = valorEscolhido.toArray(new Double[0]);
                double total = 0.0;
                for (int i = 0; i < valor.length; i++) {
                    total += valor[i];
                }
                Cardapio cardapio = new Cardapio();
                Bebidas.Bebida bebidaEscolhida = cardapio.pedidoBebida();
                System.out.println("Você escolheu os seguintes sabores:");
                for (String s : sabor) {
                    System.out.println("- " + s);
                }
                System.out.println("Você escolheu: " + bebidaEscolhida.getNome() + " - R$ " + bebidaEscolhida.getValor());
                System.out.println("O valor total da compra é R$ " + (total + bebidaEscolhida.getValor()));
            } else if (tamanho.equalsIgnoreCase("gg")) {// caso o usuario escolha o tamanho gg cai aqui
                String tipoDeSabores = "";
                List<String> saborEscolhido = new ArrayList<>();
                List<Double> valorEscolhido = new ArrayList<>();
                while (!tipoDeSabores.equalsIgnoreCase("doce") && !tipoDeSabores.equalsIgnoreCase("salgada") && !tipoDeSabores.equalsIgnoreCase("mista")) {
                    System.out.println("Essa opção possui 4 sabores \nTipos de sabores:\n      Doce    |   Salgada   |     mista ");
                    tipoDeSabores = leitura.nextLine().toLowerCase();// ta lendo qual o tipo do sabor
                    if (!tipoDeSabores.equalsIgnoreCase("doce") && !tipoDeSabores.equalsIgnoreCase("salgada") && !tipoDeSabores.equalsIgnoreCase("mista")) {
                        System.out.println("Tipo de sabor inválido. Tente novamente.");
                    }
                }
                for (int i = 0; i < 4; i++) {// nesse tamanho a pizza é com 4 sabores
                    if (tipoDeSabores.equalsIgnoreCase("doce")) {
                        PizzaEscolhida pizzaDoceEscolhida = pedidoDoce();
                        saborEscolhido.addAll(pizzaDoceEscolhida.getSabores());
                        valorEscolhido.addAll(pizzaDoceEscolhida.getValores());
                    } else if (tipoDeSabores.equalsIgnoreCase("salgada")) {
                        PizzaEscolhida pizzaSalgadaEscolhida = pedidoSalgado();
                        saborEscolhido.addAll(pizzaSalgadaEscolhida.getSabores());
                        valorEscolhido.addAll(pizzaSalgadaEscolhida.getValores());
                    } else if (tipoDeSabores.equalsIgnoreCase("mista")) {
                        PizzaEscolhida pizzaMistaEscolhida = pedidoMisto();
                        saborEscolhido.addAll(pizzaMistaEscolhida.getSabores());
                        valorEscolhido.addAll(pizzaMistaEscolhida.getValores());
                    }
                }
                String sabor[] = saborEscolhido.toArray(new String[0]);
                Double valor[] = valorEscolhido.toArray(new Double[0]);
                double total = 0.0;
                for (int i = 0; i < valor.length; i++) {
                    total += valor[i];
                }
                Cardapio cardapio = new Cardapio();
                Bebidas.Bebida bebidaEscolhida = cardapio.pedidoBebida();
                System.out.println("Você escolheu os seguintes sabores:");
                for (String s : sabor) {
                    System.out.println("- " + s);
                }
                System.out.println("Você escolheu: " + bebidaEscolhida.getNome() + " - R$ " + bebidaEscolhida.getValor());
                System.out.println("O valor total da compra é R$ " + (total + bebidaEscolhida.getValor()));
            } else {
                System.out.println("Opção invalida, tente novamente.");
            }


        }
    }
}

