import java.util.ArrayList;
import java.util.List;

public class Seguradora {
    private String nome ;
    private String telefone ;
    private String email ;
    private String endereco ;
    private List<Sinistro> listaSinistros;
    private List<Cliente> listaClientes;


    // Construtor
    public Seguradora ( String nome , String telefone , String email , String endereco ) {
        this.nome = nome ;
        this.telefone = telefone ;
        this.email = email ;
        this.endereco = endereco ;
        this.listaSinistros = new ArrayList<Sinistro>() ;
        this.listaClientes = new ArrayList<Cliente>() ;
    }
   
    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public void setListaSinistros(List<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public boolean cadastrarCliente(Cliente cliente){
        if (cliente != null)
        {
            getListaClientes().add(cliente);
            atualizaPrecoSeguroCliente(cliente);
            return true;
        }
        return false;
    }

    public boolean removerCliente(String cliente){
        if (cliente != null)
        {
            int numeroClientes = getListaClientes().size();
            for (int i = 0; i < numeroClientes; i++)
            {
                if (getListaClientes().get(i).getNome().equals(cliente))
                {
                    getListaClientes().remove(i);
                    return true;
                }
            }
            /*caso não encontre o cliente */
            return false;
        }
        return false;
    }

    public boolean removerSinistro(int id)
    {
        int numeroSinistros = getListaSinistros().size();
        for (int i = 0; i < numeroSinistros; i++)
        {
            if (getListaSinistros().get(i).getId() == id)
            {
                getListaSinistros().remove(i);
                return true;
            }
        }
        /*caso não encontre o sinistro */
        return false;
    }

    public boolean removerVeiculo(String placa){
        if (placa != null)
        {
            int numeroClientes = getListaClientes().size();
            for (int i = 0; i < numeroClientes; i++)
            {
                for (int j = 0; j < getListaClientes().get(i).getListaVeiculos().size(); j++)
                {
                    if (getListaClientes().get(i).getListaVeiculos().get(j).getPlaca().equals(placa))
                    {
                        getListaClientes().get(i).getListaVeiculos().remove(j);
                        return true;
                    }
                }
            }
            /*caso não encontre a placa */
            return false;
        }
        return false;
    }

    public void listarCliente(String tipoCliente){
        int numeroClientes = getListaClientes().size();
        ClientePF clientePF;
        ClientePJ clientePJ; 
        Cliente clienteAtual;      
        for (int i = 0; i < numeroClientes; i++)
        {
            clienteAtual = getListaClientes().get(i);
            if (tipoCliente == "ClientePJ" && clienteAtual instanceof ClientePJ)
            {
                clientePJ = (ClientePJ) clienteAtual;
                if (clientePJ.getCNPJ() != null)
                {
                    System.out.println(clientePJ.toString());
                }
            }
            else if (tipoCliente == "ClientePF" && clienteAtual instanceof ClientePF)
            {
                clientePF = (ClientePF) clienteAtual;
                if (clientePF.getCpf() != null)
                {
                    System.out.println(clientePF.toString());

                }
            }
        } 
    }

    public void adicionarVeiculoCliente(String nomeCliente, Veiculo veiculo){
        int numeroClientes = getListaClientes().size();
        Cliente clienteAtual;      
        for (int i = 0; i < numeroClientes; i++)
        {
            clienteAtual = getListaClientes().get(i);
            if (clienteAtual.getNome().equals(nomeCliente))
            {
                clienteAtual.adicionarVeiculo(veiculo);
                break;
            }            
        }
        System.out.println("Cliente não possui cadastro!");
    }

    public boolean gerarSinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente){
        Sinistro novoSinistro = null;
        if (cliente instanceof ClientePJ)
        {
            ClientePJ clientePJ = (ClientePJ) cliente;
            novoSinistro = new Sinistro(data, endereco, seguradora, veiculo, clientePJ);
        }
        else if (cliente instanceof ClientePF)
        {
            ClientePF clientePF = (ClientePF) cliente;
            novoSinistro = new Sinistro(data, endereco, seguradora, veiculo, clientePF);
        }
        List<Cliente> listaClientes = getListaClientes();
        if (novoSinistro != null)
        {
            getListaSinistros().add(novoSinistro);
            if (!listaClientes.contains(cliente))
            {
                listaClientes.add(cliente);
            }
            atualizaPrecoSeguroCliente(cliente);            
            return true;
        }
        return false;     
    }

    public boolean visualizarSinistro(String cliente){
        for (Sinistro sinistro : listaSinistros)
        {
            if (sinistro.getCliente().getNome().equals(cliente))
            {
                System.out.println("Sinistro do cliente: " + sinistro.getCliente());
                System.out.println( sinistro.toString());
                System.out.println("Data: " + sinistro.getData());
                System.out.println("Endereço: " + sinistro.getEndereco());
                System.out.println("Seguradora: " + sinistro.getSeguradora());
                System.out.println("Veiculo: " + sinistro.getVeiculo().toString());
                System.out.println("--------------------");
                return true;
            }
        }
        System.out.println("Cliente não possui sinistro!");
        return false;
    }

    //Lista todos os veiculos da seguradora
    public void listarVeiculosSeguradora(){
        int numeroClientes = getListaClientes().size();
        for (int i = 0; i < numeroClientes; i++)
        {
            listaClientes.get(i).listarVeiculos();
        }
    }

    //Lista todos os sinistros da seguradora
    public void listarSinistros(){
        int numeroSinistros = getListaSinistros().size();
        for (int i = 0; i < numeroSinistros; i++)
        {
            System.out.println(listaSinistros.get(i).toString());
            System.out.println("Data: " + listaSinistros.get(i).getData());
            System.out.println("Endereço: " + listaSinistros.get(i).getEndereco());
            System.out.println();
        }
    }

    // Lista o total de sinistros de um cliente
    public void listarSinistroCliente(String nomeCliente){
        int numeroSinistros = getListaSinistros().size();
        for (int i = 0; i < numeroSinistros; i++)
        {
            if (listaSinistros.get(i).getCliente().getNome().equals(nomeCliente))
            {
                System.out.println(listaSinistros.get(i).toString());
                System.out.println("Data: " + listaSinistros.get(i).getData());
                System.out.println("Endereço: " + listaSinistros.get(i).getEndereco());
                System.out.println();
            }
        }
    }

    // Lista o total de veiculos de um cliente
    public void listarVeiculoCliente(String nomeCliente){
        int numeroClientes = getListaClientes().size();
        for (int i = 0; i < numeroClientes; i++)
        {
            if (listaClientes.get(i).getNome().equals(nomeCliente))
            {
                listaClientes.get(i).listarVeiculos();
            }
        }
    }

    // Calcula o total de sinistros de um cliente
    public int calcularSinistroCliente(Cliente cliente){
        int numeroSinistros = getListaSinistros().size();
        int numeroSinistroCliente = 0;
        for (int i = 0; i < numeroSinistros; i++)
        {
            if (listaSinistros.get(i).getCliente().equals(cliente))
            {
                numeroSinistroCliente++;
            }
        }
        return numeroSinistroCliente;
    }

    @Override
	public String toString() {
		return getNome();
	}

    public double calcularPrecoSeguroCliente(Cliente cliente){
        double ValorSeguro = cliente.calculaScore() * (1 + calcularSinistroCliente(cliente));
        cliente.setValorSeguro(ValorSeguro);
        return ValorSeguro;
    }

    //Para somente atualizar
    public void atualizaPrecoSeguroCliente(Cliente cliente){
        double ValorSeguro = cliente.calculaScore() * (1 + calcularSinistroCliente(cliente));
        cliente.setValorSeguro(ValorSeguro);
    }

    public double calcularReceita(){
        int numeroClientes = getListaClientes().size();
        double ReceitaSeguradora = 0;
        for (int i = 0; i < numeroClientes; i++)
        {
            ReceitaSeguradora += calcularPrecoSeguroCliente(listaClientes.get(i));
        }
        return ReceitaSeguradora;
    }

    public void transferenciaSeguro (Cliente doador, Cliente recebedor){
        int numeroSinistros = getListaSinistros().size();
        for (int i = 0; i < numeroSinistros; i++)
        {
            if (listaSinistros.get(i).getCliente().equals(doador))
            {
                listaSinistros.get(i).setCliente(recebedor);
            }
        }
        atualizaPrecoSeguroCliente(recebedor);
    }

}
