public class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private String anoFabricacao;    

    // Construtor    
    public Veiculo(String placa, String marca, String modelo, String anoFabricacao) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
    }

    // Getters e setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(String anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    @Override
	public String toString() {
		return getMarca() + "-" + getModelo() + "-" + getPlaca();
	}  
}
