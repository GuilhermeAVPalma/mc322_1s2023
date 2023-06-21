import java.util.List;

class Veiculo {
    
    private String marca;   
    private String modelo;
    private String cor;
	private String placa;
    private int ano;    
    private List<Peca> pecas;
    private List<Imposto> impostos;
    private List<TrocaOleo> trocasOleo;
    private List<Combustivel> registrosCombustivel;
    private List<Pneu> pneus;
    private int quilometragem; 

    public Veiculo(String marca, String modelo, String cor, String placa, int ano, List<Peca> pecas, List<Imposto> impostos,
            List<TrocaOleo> trocasOleo, List<Combustivel> registrosCombustivel, List<Pneu> pneus, int quilometragem) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
        this.ano = ano;
        this.pecas = pecas;
        this.impostos = impostos;
        this.trocasOleo = trocasOleo;
        this.registrosCombustivel = registrosCombustivel;
        this.pneus = pneus;
        this.quilometragem = quilometragem;
    }   

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public List<Peca> getPecas() {
        return pecas;
    }
    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }
    public List<Imposto> getImpostos() {
        return impostos;
    }
    public void setImpostos(List<Imposto> impostos) {
        this.impostos = impostos;
    }
    public List<TrocaOleo> getTrocasOleo() {
        return trocasOleo;
    }
    public void setTrocasOleo(List<TrocaOleo> trocasOleo) {
        this.trocasOleo = trocasOleo;
    }
    public List<Combustivel> getRegistrosCombustivel() {
        return registrosCombustivel;
    }
    public void setRegistrosCombustivel(List<Combustivel> registrosCombustivel) {
        this.registrosCombustivel = registrosCombustivel;
    }
    public List<Pneu> getPneus() {
        return pneus;
    }
    public void setPneus(List<Pneu> pneus) {
        this.pneus = pneus;
    }
    public int getQuilometragem() {
        return quilometragem;
    }
    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }
    
    public void adicionarPeca(Peca peca) {
        pecas.add(peca);
    }

    public void adicionarImposto(Imposto imposto) {
        impostos.add(imposto);
    }

    public void adicionarTrocaOleo(TrocaOleo trocaOleo) {
        trocasOleo.add(trocaOleo);
    }

    public void adicionarRegistroCombustivel(Combustivel combustivel) {
        registrosCombustivel.add(combustivel);
    }

    public void adicionarPneu(Pneu pneu) {
        pneus.add(pneu);
    } 
    
    // public double calcularGastosTotais() {
    //     double totalGasto = 0.0;

    //     // Somar valores das peças trocadas
    //     for (Peca peca : pecas) {
    //         totalGasto += peca.getValor();
    //     }

    //     // Somar valores dos impostos pagos
    //     for (Imposto imposto : impostos) {
    //         totalGasto += imposto.getValorTotal();
    //     }

    //     // Somar valores das trocas de óleo
    //     for (TrocaOleo trocaOleo : trocasOleo) {
    //         totalGasto += trocaOleo.getValor();
    //     }

    //     // Somar valores das trocas de pneus
    //     for (Pneu pneu : pneus) {
    //         totalGasto += pneu.getValor();
    //     }

    //     return totalGasto;
    // }

    @Override
    public String toString() {
        return "Veiculo [marca=" + marca + ", modelo=" + modelo + ", cor=" + cor + ", placa=" + placa + ", ano=" + ano
                + "]";
    }
}