import java.util.Scanner;

public class Clientes {// que vai fazer o cadastro do cliente
    public static class DadosCliente {// sub classe que tem o construtor
        private String nome;
        private String endereco;
        private String telefone;
        private String email;
        private String formaPagamento;

        public  DadosCliente(String nome, String endereco, String telefone, String email, String formaPagamento) {// construtor que inicia as variaveis
            this.nome = nome;
            this.endereco = endereco;
            this.telefone = telefone;
            this.email = email;
            this.formaPagamento = formaPagamento;
        }

        // getters e setters
        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getFormaPagamento() {
            return formaPagamento;
        }

        public void setFormaPagamento(String formaPagamento) {
            this.formaPagamento = formaPagamento;
        }
    }

    public static DadosCliente fazerCadastroDelivery() {// metodo que recebe os dados do cliente para fazer cadastro para o delivery
        Scanner leitura = new Scanner(System.in);
        DadosCliente cliente = new DadosCliente("", "", "", "", "");// essa linha serve para iniciar as variaveis com o tipo string vazio se não colocar ela o obejto cliente vem como nulo e não recebe as iformações

        System.out.println("Para que possamos efetuar seu pedido informe seus dados pessoais para cadastro.");

        System.out.println("Informe seu nome: ");
        String nome = leitura.nextLine();
        cliente.setNome(nome);// .setnome é para que o objeto cliente receba o valor da variavel nome dentro da variavel que ta no objeto

        System.out.println("Informe seu endereço: ");
        String endereco = leitura.nextLine();
        cliente.setEndereco(endereco);// segue o mesmo fluxo

        System.out.println("Informe seu telefone: ");
        String telefone = leitura.nextLine();
        cliente.setTelefone(telefone);

        System.out.println("Informe seu e-mail: ");
        String email = leitura.nextLine();
        cliente.setEmail(email);

        System.out.println("Informe sua forma de pagamento: ");
        String formaPagamento = leitura.nextLine();
        cliente.setFormaPagamento(formaPagamento);

        return cliente;
    }
    public static DadosCliente fazerCadastroParaBalcao() {// metodo que faz o cadastro do cliente para retirada no balcão mas não é utilizado a variavel email e endereço ja que ele vai buscar
        Scanner leitura = new Scanner(System.in);
        DadosCliente cliente = new DadosCliente("", "", "", "", "");// essa linha serve para iniciar as variaveis com o tipo string vazio se não colocar ela o obejto cliente vem como nulo e não recebe as iformações

        System.out.println("Para que possamos efetuar seu pedido informe seus dados pessoais para cadastro.");

        System.out.println("Informe seu nome: ");
        String nome = leitura.nextLine();
        cliente.setNome(nome);

        System.out.println("Informe seu telefone: ");
        String telefone = leitura.nextLine();
        cliente.setTelefone(telefone);

        System.out.println("Informe sua forma de pagamento: ");
        String formaPagamento = leitura.nextLine();
        cliente.setFormaPagamento(formaPagamento);

        return cliente;
    }
}