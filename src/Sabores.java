import java.util.ArrayList; //
import java.util.List;      //essa parte são importações de classes da biblioteca java
import java.util.Scanner;   //
public class Sabores {// classe onde vai exibir os sabores e receber o pedido
    // vetor criado para receber quais são os sabores de pizzas
    public static String pizzaSalgada[] = {"Calabresa", "Portuguesa", "Marguerita", "Frango Com Catupiry", "Mussarela", "Napolitana", "Quatro Queijos", "Atum Com Cebola", "Milho", "Baiana"};
   // vetor para receber os valores de cada pizza
    public static double valorSalgada[] = {10.11, 10.20, 10.09, 11.88, 11.00, 10.55, 11.22, 09.95, 10.50, 10.80};
    private static String cardapioSalgada = """
             
             ---------------------------------------------- Pizza Salgada -------------------------------------------------
               
                1. Calabresa.............................................................................RS 10,11
                2. Portuguesa............................................................................RS 10,20
                3. Marguerita............................................................................RS 10,09
                4. Frango com Caturipy...................................................................RS 11,88
                5. Mussarela.............................................................................RS 11,00
                6. Napolitana............................................................................RS 10,55
                7. Quatro Queijos........................................................................RS 11,22
                8. Atum Com Cebola.......................................................................RS 09,95
                9. Milho.................................................................................RS 10,50
                10. Baiana...............................................................................RS 10,80              
            """;// variavel para apresentar um cardapio

    public String[] getPizzaSalgada() {
        return pizzaSalgada;
    }//metodo que tras o retorno da vetor pizzaSalgada

    public double[] getValorSalgada() {
        return valorSalgada;
    }//metodo que tras o retorno da vetor valorSalgada
    String getCardapioSalgada() {
        return cardapioSalgada;
    }//metodo que tras o retorno do cardapioSalgada
    // vetor criado para receber quais são os sabores de pizzas
    public static String pizzaDoce[] = {"Brigadeiro", "Ganache Com Rum", "Chocolate Com Avelã", "Chocolate, Sorvete e Frutas", "Ovomaltine", "Brownie", "Banana Nevada", "Romeu e Julieta", "Prestígio", "Banofe"};
    // vetor para receber os valores de cada pizza
    public static double valorDoce[] = {12.00, 13.00, 12.23, 13.50, 14.00, 13.20, 11.30, 12.82, 08.00, 12.87};
    private static String cardapioDoce = """
            ----------------------------------------------- Pizza Doces --------------------------------------------------
                
                1. Brigadeiro............................................................................RS 12,00
                2. Ganache com rum.......................................................................RS 13,00
                3. Chocolate Com Avelã...................................................................RS 12,23
                4. Chocolate, Sorvete e Frutas...........................................................RS 13,50
                5. Ovomaltine............................................................................RS 14,00
                6. Brownie...............................................................................RS 13,20
                7. Banana nevada.........................................................................RS 11,30
                8. Romeu e Julieta.......................................................................RS 12,82
                9. Prestígio.............................................................................RS 08,00
                10. Banofe...............................................................................RS 12,87
                            
            """;// variavel para apresentar um cardapio

    public String[] getPizzaDoce() {
        return pizzaDoce;
    }//metodo que tras o retorno da vetor pizzaDoce

    public double[] getValorDoce() {
        return valorDoce;
    }//metodo que tras o retorno da vetor valorDoce

    String getCardapioDoce() {
        return cardapioDoce;
    }//metodo que tras o retorno do cardapioSalgada
}