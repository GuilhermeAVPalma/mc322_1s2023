import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List <Seguradora> listaSeguradoras = new ArrayList<>(); 
    public static void main(String[] args) 
    {      
        Veiculo Sandero = new Veiculo("ABC-4169", "Renault", "Sandero", "2018");
        Veiculo Palio = new Veiculo("ABC-1234", "Fiat", "Palio", "2000");
        Veiculo C180 = new Veiculo("ABC-0001", "Mercedez", "C180", "2023");
        Veiculo Clio = new Veiculo("XXX-9999", "Renault", "Clio", "2002");
        Veiculo Fusca = new Veiculo("XYZ-0011", "volkswagen", "Fusca", "1984");

        ClientePF Guilherme, Ricardo, Maria;
        Guilherme = new ClientePF("Guilherme", "Rua Atibaia", "39297301894", "Masculino", Date.valueOf("2018-03-04"), "Sim", Date.valueOf("1998-02-02"), "B");
        Ricardo = new ClientePF("Ricardo", "Rua Aleluia" , "05387129884", "Masculino", Date.valueOf("1997-08-03"), "Sim", Date.valueOf("1966-05-23"), "A");
        Maria = new ClientePF("Maria", "Rua Aleluia" , "12052377808", "Feminino", Date.valueOf("1997-12-23"), "Sim", Date.valueOf("1966-04-17"), "C");
        Ricardo.adicionarVeiculo(Palio);
        Maria.adicionarVeiculo(C180);
        Guilherme.adicionarVeiculo(Sandero);
        
        ClientePJ Localiza;
        Localiza = new ClientePJ("Localiza", "Av Brasil", "01.182.362/0002-94", Date.valueOf("2020-05-16"));
        Localiza.adicionarVeiculo(Palio);
        Localiza.adicionarVeiculo(C180);
        Localiza.adicionarVeiculo(Sandero);

        ClientePJ Movida;
        Movida = new ClientePJ("Movida", "Av Joao Erbolato", "05.789.313/0007-80", Date.valueOf("1998-04-22"));
        Movida.adicionarVeiculo(Clio);
        Movida.adicionarVeiculo(Fusca);

        Seguradora azulSeguradora = new Seguradora("AzulSeguradora", "32425112", "Contato@azulseguradora.com", "Av Marechal Rondon");
        azulSeguradora.cadastrarCliente(Localiza);
        azulSeguradora.cadastrarCliente(Guilherme);
        azulSeguradora.cadastrarCliente(Ricardo);
        azulSeguradora.cadastrarCliente(Maria);
        azulSeguradora.removerCliente("Maria");
        listaSeguradoras.add(azulSeguradora);

        azulSeguradora.gerarSinistro("2023-01-02", "Rua Domingos Signorelli", azulSeguradora, C180, Localiza);
        azulSeguradora.gerarSinistro("2022-02-12", "Rua Dr Francisco", azulSeguradora, C180, Localiza);




        Seguradora SeguradoraAtual;
        Scanner scan = new Scanner(System.in);
        int result = -1, result1 = -1, result2 = -1, result3 = -1, idSinistro = -1;
        String opcaoCliente = "", nomeSeguradora = "", nomeCliente = "", placaVeiculo = "";
        while (result != 0) {
            //Menu principal
            System.out.println("Bem vindo, consultor(a), digite uma das opcoes abaixo:");
            System.out.println("1-Cadastros.");
            System.out.println("2-Listar.");
            System.out.println("3-Excluir.");
            System.out.println("4-Gerar Sinistro.");
            System.out.println("5-Transferir Seguro.");
            System.out.println("6-Calcular Receita Seguradora.");
            System.out.println("0-Sair.");
            result = scan.nextInt();
            switch (result) 
            {
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                //Cadastrar    
                case 1:
                    if (result == -1 )
                    {
                        break;
                    }
                    System.out.println("Digite o nome da Seguradora:");
                    nomeSeguradora = scan.next();
                    SeguradoraAtual = EncontraSeguradora(nomeSeguradora);
                    if (SeguradoraAtual == null)
                    {
                        SeguradoraAtual = MenuCadastroSeguradora();
                    }
                    System.out.println("1-Cadastrar Cliente PF/PJ.");
                    System.out.println("2-Cadastrar Veiculo.");
                    System.out.println("3-Voltar.");
                    result1 = scan.nextInt();
                    switch (result1) 
                    {
                        case 1:
                            MenuCadastroCliente(SeguradoraAtual);
                            result = -1;
                            break;
                        case 2:
                            MenuCadastroVeiculo(SeguradoraAtual);
                            result = -1;
                            break;
                        case 3:
                            result = -1;
                            break;
                    }                          
                       
                //Listar                     
                case 2:
                    if (result == -1 )
                    {
                        break;
                    }
                    System.out.println("Digite o nome da Seguradora:");
                    nomeSeguradora = scan.next();
                    SeguradoraAtual = EncontraSeguradora(nomeSeguradora);
                    if (SeguradoraAtual == null)
                    {
                        SeguradoraAtual = MenuCadastroSeguradora();
                    }
                    System.out.println("1-Listar Cliente PF/PJ.");
                    System.out.println("2-Listar Sinistros por Seguradora.");
                    System.out.println("3-Listar Sinistros por Cliente.");
                    System.out.println("4-Listar Veiculo por Cliente.");
                    System.out.println("5-Listar Veiculo por Seguradora.");
                    System.out.println("6-Voltar.");

                    result2 = scan.nextInt();
                    switch (result2) 
                    {
                        case 1:
                            System.out.println("Digite 'PF' para pessoas fisicas ou 'PJ' para Juridicas.");
                            opcaoCliente = scan.next();
                            if (opcaoCliente.equals("PF"))
                            {
                                System.out.println("Visualizando clientes PF cadastrados...");
                                SeguradoraAtual.listarCliente("ClientePF");
                            }
                            else if (opcaoCliente.equals("PJ"))
                            {
                                System.out.println("Visualizando clientes PJ cadastrados...");

                                SeguradoraAtual.listarCliente("ClientePJ");
                            }
                            result = -1;
                            break;
                        case 2:
                            SeguradoraAtual.listarSinistros();
                            result = -1;
                            break;
                        case 3:
                            System.out.println("Digite o nome do Cliente:");
                            nomeCliente = scan.next();
                            SeguradoraAtual.listarSinistroCliente(nomeCliente);
                            result = -1;
                            break;                                
                        case 4:
                            System.out.println("Digite o nome do Cliente:");
                            nomeCliente = scan.next();
                            SeguradoraAtual.listarVeiculoCliente(nomeCliente); 
                            result = -1;
                            break;
                        case 5:
                            SeguradoraAtual.listarVeiculosSeguradora();
                            result = -1;
                            break;
                        case 6:
                            result = -1;
                            break;

                    }                    
                //Excluir        
                case 3:
                    if (result == -1 )
                    {
                        break;
                    }
                    System.out.println("Digite o nome da Seguradora:");
                    nomeSeguradora = scan.next();
                    SeguradoraAtual = EncontraSeguradora(nomeSeguradora);
                    if (SeguradoraAtual == null)
                    {
                        SeguradoraAtual = MenuCadastroSeguradora();
                    }
                    
                    System.out.println("1-Excluir Cliente.");
                    System.out.println("2-Excluir Veiculo.");
                    System.out.println("3-Excluir Sinistro.");
                    System.out.println("4-Voltar.");
                    result3 = scan.nextInt();
                    switch (result3) 
                    {
                        case 1:
                            System.out.println("Digite o nome do Cliente:");
                            nomeCliente = scan.next();
                            if (SeguradoraAtual.removerCliente(nomeCliente))
                            {
                                System.out.println("Cliente removido com sucesso.");
                            }
                            else
                            {
                                System.out.println("Cliente não pode ser removido.");
                            }
                            result = -1;
                            break;
                        case 2:
                            System.out.println("Digite a placa do Veiculo:");
                            placaVeiculo = scan.next();
                            if (SeguradoraAtual.removerVeiculo(placaVeiculo))
                            {
                                System.out.println("Veiculo removido com sucesso.");
                            }
                            else
                            {
                                System.out.println("Veiculo não pode ser removido.");
                            }
                            result = -1;
                            break;
                        case 3:
                            System.out.println("Digite o ID do Sinistro:");
                            idSinistro = scan.nextInt();
                            if (SeguradoraAtual.removerSinistro(idSinistro))
                            {
                                System.out.println("Sinistro removido com sucesso.");
                            }
                            else
                            {
                                System.out.println("Sinistro não pode ser removido.");
                            }
                            result = -1;
                            break;
                        case 4:
                            result = -1;
                            break;
                    }    
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scan.close();
    }


    public static void MenuCadastroCliente (Seguradora SeguradoraAtual)
    {
        Scanner scan1 = new Scanner(System.in);
        String opcaoCliente = "", nomeCliente = "",  enderecoCliente = "",  cpfCliente = "", cnpjCliente = "", 
                generoCliente = "",  anoNascimentoCliente = "",  mesNascimentoCliente = "", diaNascimentoCliente = "";
        System.out.println("Digite 'PF' para pessoas fisicas ou 'PJ' para Juridicas.");
        opcaoCliente = scan1.next();
        if (opcaoCliente.equals("PF"))
        {
            
            System.out.println("Digite seu nome:");
            nomeCliente = scan1.next();
            System.out.println("Digite seu endereco:");
            enderecoCliente = scan1.next();
            System.out.println("Digite seu CPF:");
            cpfCliente = scan1.next();
            System.out.println("Digite seu genero:");
            generoCliente = scan1.next();
            System.out.println("Digite o ano de seu nascimento:");
            anoNascimentoCliente = scan1.next();
            System.out.println("Digite o mes de seu nascimento:");
            mesNascimentoCliente = scan1.next();
            System.out.println("Digite o dia de seu nascimento:");
            diaNascimentoCliente = scan1.next();
            Date dataNascimento =  Date.valueOf(anoNascimentoCliente + "-" + mesNascimentoCliente + "-" + diaNascimentoCliente);
            ClientePF novoClientePF = new ClientePF(nomeCliente, enderecoCliente, cpfCliente, generoCliente, Date.valueOf("2022-09-09"), "Sim", dataNascimento, "A"); 
            SeguradoraAtual.cadastrarCliente(novoClientePF);
                       
        }
        else if (opcaoCliente.equals("PJ"))
        {
            System.out.println("Digite o nome da empresa:");
            nomeCliente = scan1.next();
            System.out.println("Digite o endereco:");
            enderecoCliente = scan1.next();
            System.out.println("Digite o CNPJ:");
            cnpjCliente = scan1.next();
            ClientePJ novoClientePJ = new ClientePJ("Localiza", "Av Brasil", "01.182.362/0002-94", Date.valueOf("2020-05-16"));
            SeguradoraAtual.cadastrarCliente(novoClientePJ);
        }
        scan1.close();
    }

    public static void MenuCadastroVeiculo (Seguradora SeguradoraAtual)
    {        
        Scanner scan2 = new Scanner(System.in);
        String placaVeiculo = "", marcaVeiculo = "", modeloVeiculo = "", anoFabricacaoVeiculo = "", nomeClienteVeiculo = "";
        
        System.out.println("Digite a placa do veiculo no formato XXX-0000:");
        placaVeiculo = scan2.next();
        System.out.println("Digite o a marca do veiculo:");
        marcaVeiculo = scan2.next();
        System.out.println("Digite o modelo do veiculo:");
        modeloVeiculo = scan2.next();
        System.out.println("Digite o ano de fabricacao do veiculo:");
        anoFabricacaoVeiculo = scan2.next();

        Veiculo novoVeiculo = new Veiculo(placaVeiculo, marcaVeiculo, modeloVeiculo, anoFabricacaoVeiculo);

        System.out.println("Digite o nome do cliente que possui o veiculo:");
        nomeClienteVeiculo = scan2.next();

        SeguradoraAtual.adicionarVeiculoCliente(nomeClienteVeiculo, novoVeiculo);
        scan2.close();
    }     
    
    public static Seguradora MenuCadastroSeguradora ()
    {             
        Scanner scan3 = new Scanner(System.in);
        String nomeSeguradora = "", telefoneSeguradora = "", emailSeguradora = "", enderecoSeguradora = "";

        System.out.println("Digite o novo nome da Seguradora:");
        nomeSeguradora = scan3.next();
        System.out.println("Digite o telefone da Seguradora:");
        telefoneSeguradora = scan3.next();
        System.out.println("Digite o email da Seguradora:");
        emailSeguradora = scan3.next();
        System.out.println("Digite o endereco da Seguradora:");
        enderecoSeguradora = scan3.next();

        Seguradora novaSeguradora = new Seguradora(nomeSeguradora, telefoneSeguradora, emailSeguradora, enderecoSeguradora);
        listaSeguradoras.add(novaSeguradora);
        scan3.close();
        return novaSeguradora;
    }  
    
    public static Seguradora EncontraSeguradora(String nomeSeguradora)
    {
        for (int i = 0; i < listaSeguradoras.size(); i++)
        {
            Seguradora SeguradoraAtual = listaSeguradoras.get(i);
            if (SeguradoraAtual.getNome().equals(nomeSeguradora))
            {
                return SeguradoraAtual;
            } 
        }
        System.out.println("Seguradora não cadastrada. Cadastre uma nova seguradora.");
        return null;
    }
}
