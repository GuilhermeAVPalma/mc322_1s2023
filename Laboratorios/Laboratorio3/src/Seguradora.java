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
            this.listaClientes.add(cliente);
            return true;
        }
        return false;
    }

    public boolean removerCliente(String cliente){
        if (cliente != null)
        {
            int numeroClientes = this.listaClientes.size();
            for (int i = 0; i < numeroClientes; i++)
            {
                if (listaClientes.get(i).getNome().equals(cliente))
                {
                    this.listaClientes.remove(i);
                    return true;
                }
            }
            /*caso não encontre o cliente */
            return false;
        }
        return false;
    }

    public void listarCliente(String tipoCliente){
        int numeroClientes = this.listaClientes.size();
        List<Cliente> listaTipoCliente = null; 
        ClientePF clientePF;
        ClientePJ clientePJ; 
        Cliente cliente, clienteAtual;      
        for (int i = 0; i < numeroClientes; i++)
        {
            clienteAtual = this.listaClientes.get(i);
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
        List<Cliente> listaClientes = this.listaClientes;
        if (novoSinistro != null)
        {
            listaSinistros.add(novoSinistro);
            if (!listaClientes.contains(cliente))
            {
                listaClientes.add(cliente);
            }
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

    public void listarSinistros(){
        int numeroSinistros = this.listaSinistros.size();
        for (int i = 0; i < numeroSinistros; i++)
        {
            System.out.println(listaSinistros.get(i).toString());
            System.out.println("Data: " + listaSinistros.get(i).getData());
            System.out.println("Endereço: " + listaSinistros.get(i).getEndereco());
            System.out.println();
        }
    }

    @Override
	public String toString() {
		return getNome();
	}
}
