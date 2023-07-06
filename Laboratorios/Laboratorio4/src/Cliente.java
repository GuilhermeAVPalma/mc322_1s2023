import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
    private String nome ;
    private String endereco ;    
    private List<Veiculo> listaVeiculos;
    private double valorSeguro;    

    // Construtor
    public Cliente(String nome, String endereco) {
    if (verificarSomenteLetras(nome)) {
        this.nome = nome;
        this.endereco = endereco;
        this.listaVeiculos = new ArrayList<>();
        setValorSeguro(0);;
    } else {
        throw new IllegalArgumentException("O nome deve conter somente letras.");
    }
}

    // Getters e setters
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

    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    } 

    public double getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }
    
    public void adicionarVeiculo(Veiculo veiculo){
        if (!this.listaVeiculos.contains(veiculo))
        {
            this.listaVeiculos.add(veiculo);
        }
    }

    public int calcularQuantidadeCarros(){
        return getListaVeiculos().size();
    }
    
    @Override
	public String toString() {
		return getNome();
	}  

    public void listarVeiculos ()
    {
        for (int i = 0; i < listaVeiculos.size(); i++)
        {
            System.out.println("Veiculo" + (i+1) + " - " + listaVeiculos.get(i).toString());
        }
    }
    
    //Função para verificar se o nome contém somente letras
    private boolean verificarSomenteLetras(String nome) {
        return nome.matches("[a-zA-Z]+");
    }

    public abstract double calculaScore();
}
