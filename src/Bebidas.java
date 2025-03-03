import java.util.ArrayList; //
import java.util.List;      //essa parte são importações de classes da biblioteca java
import java.util.Scanner;   //

public class Bebidas {// classe bebida tera a função de fornecer os tipos de bebidas e seus valores, tbm registra qual foi escolhida e o seu valor

    public static class Bebida {// sub classe para criação do construtor
        private String nome;
        private double valor;

        public Bebida(String nome, double valor) {// construtor para atribuir valores do parametro a variavel
            this.nome = nome;
            this.valor = valor;
        }

        public String getNome() {
            return nome;
        }// metodo que tras o retorno da variavel nome

        public double getValor() {
            return valor;
        }// metodo que tras o retorno da variavel valor
    }

    private static List<Bebida> bebidas = new ArrayList<>();// classe lista foi importada da biblioteca java onde esta criando uma lista com o nome bebidas

    static {
        bebidas.add(new Bebida("Coca-cola", 5.00));       //
        bebidas.add(new Bebida("Guaraná", 4.50));         //
        bebidas.add(new Bebida("Água Mineral", 3.00));    //a lista bebidas esta recebendo esses valores
        bebidas.add(new Bebida("Suco Natural", 6.00));    //
        bebidas.add(new Bebida("Cerveja", 7.00));         //
    }

    // public static void main(String[] args) {


    public static Bebida escolherBebida() {
        Scanner leitura = new Scanner(System.in);// classe importada da biblioteca para a leitura do que o funcionario digitar
        boolean escolhaValida = false;// variavel com tipo booleano para que se o usuario informar um valor errado repita o processo
        int escolha = 0;// variavel para receber a bebida escolhida
        while (!escolhaValida) {// loop para que o usuario consiga escolher a bebida
            System.out.println("=============================================================\n" +
                    "                         Escolha tipo de bebida                            " +
                    "\n=============================================================");
            System.out.println("Escolha uma bebida: ");
            for (int i = 0; i < bebidas.size(); i++) {// loop para que imprima a lista de bebidas
                System.out.printf("%d. %s - R$ %.2f\n", i + 1, bebidas.get(i).getNome(), bebidas.get(i).getValor());
            }
            escolha = Integer.parseInt(leitura.nextLine());// aqui esta lendo a bebida escolhida pelo usuario
            if (escolha < 1 || escolha > bebidas.size()) {// caso o usuario informe uma bebida invalida retorna o loop
                System.out.println("Opção inválida. Escolha uma opção entre 1 e " + bebidas.size() + ".");
            } else {
                escolhaValida = true;// caso a escolha estiver correta cai fora do loop
            }
        }
        return bebidas.get(escolha - 1); // aqui vai retornar qual a bebida escolhida
    }
}