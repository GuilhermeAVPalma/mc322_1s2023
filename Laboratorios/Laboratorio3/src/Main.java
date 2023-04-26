import java.lang.reflect.Array;
import java.sql.Date;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) 
    {
        Veiculo Sandero = new Veiculo("ABC-4169", "Renault", "Sandero");
        Veiculo Palio = new Veiculo("ABC-1234", "Fiat", "Palio");
        Veiculo C180 = new Veiculo("ABC-0001", "Mercedez", "C180");

        ClientePF Guilherme, Ricardo, Maria;
        Guilherme = new ClientePF("Guilherme", "Rua Atibaia", Arrays.asList(Sandero), "39297301894", "Masculino", Date.valueOf("2018-03-04"), "Sim", Date.valueOf("1998-02-02"), "B");
        Ricardo = new ClientePF("Ricardo", "Rua Aleluia", Arrays.asList(Palio) , "05387129884", "Masculino", Date.valueOf("1997-08-03"), "Sim", Date.valueOf("1966-05-23"), "A");
        Maria = new ClientePF("Maria", "Rua Aleluia", Arrays.asList(C180) , "12052377808", "Feminino", Date.valueOf("1997-12-23"), "Sim", Date.valueOf("1966-04-17"), "C");
        
        ClientePJ Localiza;
        Localiza = new ClientePJ("Localiza", "Av Brasil",  Arrays.asList(Sandero, Palio, C180), "01.182.362/0002-94", Date.valueOf("2020-05-16"));
        Localiza.adicionarVeiculo(Sandero);
        Localiza.adicionarVeiculo(Palio);

        Seguradora azulSeguradora = new Seguradora("AzulSeguradora", "32425112", "Contato@azulseguradora.com", "Av Marechal Rondon");
        azulSeguradora.cadastrarCliente(Localiza);
        azulSeguradora.cadastrarCliente(Guilherme);
        azulSeguradora.cadastrarCliente(Ricardo);
        azulSeguradora.cadastrarCliente(Maria);
        azulSeguradora.removerCliente("Maria");

        azulSeguradora.gerarSinistro("2023-01-02", "Rua Domingos Signorelli", azulSeguradora, C180, Localiza);




        Scanner scan = new Scanner(System.in);
        int result = -1;
        String opcaoCliente = "";
        while (result != 0) {
            System.out.println("Bem vindo, consultor da Azul Seguradora, digite uma das opcoes abaixo:");
            System.out.println("1-Visualizar clientes cadastrados.");
            System.out.println("2-Listar sinistros.");
            System.out.println("3-Visualizar sinistro de um cliente.");
            System.out.println("0-Sair.");
            result = scan.nextInt();
            switch (result) {
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                case 1:
                    //lógica para visualizar clientes cadastrados
                    System.out.println("Digite 'PF' para pessoas fisicas ou 'PJ' para Juridicas.");
                    opcaoCliente = scan.next();
                    if (opcaoCliente == "PF")
                    {
                        System.out.println("Visualizando clientes PF cadastrados...");
                        azulSeguradora.listarCliente("ClientePF");
                    }
                    else if (opcaoCliente == "PJ")
                    {
                        System.out.println("Visualizando clientes PJ cadastrados...");

                        azulSeguradora.listarCliente("ClientePJ");
                    }
                    break;
                case 2:
                    //lógica para listar sinistros
                    System.out.println("Listando sinistros...");
                    azulSeguradora.listarSinistros();
                    break;

                case 3:
                    //lógica para visualizar sinistro de cliente
                    System.out.println("Qual nome do cliente que deseja visualizar?");
                    opcaoCliente = scan.next();
                    azulSeguradora.visualizarSinistro(opcaoCliente);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scan.close();

    }
}
