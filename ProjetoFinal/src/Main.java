import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Frota EmpresaGenerica = new Frota("Azul");

        Scanner scan = new Scanner(System.in);
        int result = -1;
        String opcaoCliente = "";
        System.out.println("Digite o nome de sua empresa:");
        opcaoCliente = scan.next();

        System.out.println("Bem vindo a empresa " + opcaoCliente + " consutor.");

        System.out.println("Deseja analisar as informacoes de qual veiculo?");

        for(int i = 0; i < EmpresaGenerica.getListaVeiculo().size(); i++)
        {
            System.out.println("Veiculo " + (i + 1) + " : " + EmpresaGenerica.getListaVeiculo().get(i).toString());
        } 
        System.out.println("0 - Encerrar.");

        result = scan.nextInt();
        if (result == 0)
        {
            System.out.println("Encerrando o programa.");
        }
        else 
        {
            Veiculo veiculoAtual = EmpresaGenerica.getListaVeiculo().get(result - 1);

            // System.out.println("1-Visualizar clientes cadastrados.");
            // System.out.println("2-Listar sinistros.");
            // System.out.println("3-Visualizar sinistro de um cliente.");

        }

        // while (result != 0) {
        //     System.out.println("1-Visualizar clientes cadastrados.");
        //     System.out.println("2-Listar sinistros.");
        //     System.out.println("3-Visualizar sinistro de um cliente.");
        //     System.out.println("0-Sair.");
            
        //     switch (result) {
        //         case 0:
        //             System.out.println("Encerrando o programa.");
        //             break;
        //         case 1:
        //             //lógica para visualizar clientes cadastrados
        //             System.out.println("Digite 'PF' para pessoas fisicas ou 'PJ' para Juridicas.");
        //             opcaoCliente = scan.next();
        //             if (opcaoCliente.toString().equals("PF"))
        //             {
        //                 System.out.println(opcaoCliente);
        //                 System.out.println(opcaoCliente.toString());

        //                 System.out.println("Visualizando clientes PF cadastrados...");
        //                 // azulSeguradora.listarCliente("ClientePF");
        //             }
        //             else if (opcaoCliente.toString().equals("PJ"))
        //             {
        //                 System.out.println("Visualizando clientes PJ cadastrados...");

        //                 // azulSeguradora.listarCliente("ClientePJ");
        //             }
        //             break;
        //         case 2:
        //             //lógica para listar sinistros
        //             System.out.println("Listando sinistros...");
        //             // azulSeguradora.listarSinistros();
        //             break;

        //         case 3:
        //             //lógica para visualizar sinistro de cliente
        //             System.out.println("Qual nome do cliente que deseja visualizar?");
        //             opcaoCliente = scan.next();
        //             // azulSeguradora.visualizarSinistro(opcaoCliente);
        //             break;
        //         default:
        //             System.out.println("Opção inválida. Tente novamente.");
        //             break;
        //     }
        // }
        scan.close();
    }
    
}
