import java.util.ArrayList;

public class Veiculo {
    
    private String marca;   
    private String modelo;
    private String cor;
	private String placa;
    private int ano;    
    private ArrayList<Peca> pecas;
    private ArrayList<Imposto> impostos;
    private ArrayList<TrocaOleo> trocasOleo;
    private ArrayList<Combustivel> registrosCombustivel;
    private ArrayList<Pneu> pneus;
    private int quilometragem;
    private double valorVeiculo;

    public Veiculo(String marca, String modelo, String cor, String placa, int ano, ArrayList<Peca> pecas, ArrayList<Imposto> impostos,
            ArrayList<TrocaOleo> trocasOleo, ArrayList<Combustivel> registrosCombustivel, ArrayList<Pneu> pneus, int quilometragem,
                   double valorVeiculo) {
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
        this.valorVeiculo = valorVeiculo;
    }

    public double getValorVeiculo() {
        return valorVeiculo;
    }

    public void setValorVeiculo(double valorVeiculo) {
        this.valorVeiculo = valorVeiculo;
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
    public ArrayList<Peca> getPecas() {
        return pecas;
    }
    public void setPecas(ArrayList<Peca> pecas) {
        this.pecas = pecas;
    }
    public ArrayList<Imposto> getImpostos() {
        return impostos;
    }
    public void setImpostos(ArrayList<Imposto> impostos) {
        this.impostos = impostos;
    }
    public ArrayList<TrocaOleo> getTrocasOleo() {
        return trocasOleo;
    }
    public void setTrocasOleo(ArrayList<TrocaOleo> trocasOleo) {
        this.trocasOleo = trocasOleo;
    }
    public ArrayList<Combustivel> getRegistrosCombustivel() {
        return registrosCombustivel;
    }
    public void setRegistrosCombustivel(ArrayList<Combustivel> registrosCombustivel) {
        this.registrosCombustivel = registrosCombustivel;
    }
    public ArrayList<Pneu> getPneus() {
        return pneus;
    }
    public void setPneus(ArrayList<Pneu> pneus) {
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
    
    public void listarPecas() {
    	for(Peca p: pecas) {
    		System.out.println(p + "\n");
    	}
    }
    
    public double rendimentoCombustivel() {
    	int quilometros = 0;
    	double volume = 0.0;
    	for(Combustivel comb: registrosCombustivel) {
    		quilometros += (comb.getQuilometragemFinal() - comb.getQuilometragemInicial());
    		volume += comb.getVolume();
    	}
    	
    	Double rendimento = 1.0*quilometros / volume;
    	return rendimento;
    }
    
    public void cadastrarTrocaOleo(TrocaOleo t) { 
    	trocasOleo.add(t);
    }
    
    public void cadastrarTrocaPneu(Pneu p) {
    	int posicao = p.getPosicao();
    	for (Pneu pneu: pneus) {
    		if(pneu.getPosicao() == posicao) {
    			pneus.remove(pneu);
    			pneus.add(p);
    			break;
    		}
    	}
    }
    
    public double calcularGastosTotais() {
        double totalGasto = 0.0;

        // Somar valores das peças trocadas
        for (Peca peca : pecas) {
            totalGasto += peca.getValor();
        }

        // Somar valores dos impostos pagos
        for (Imposto imposto : impostos) {
            totalGasto += imposto.getValor();
        }

        // Somar valores das trocas de óleo
        for (TrocaOleo trocaOleo : trocasOleo) {
            totalGasto += trocaOleo.getValor();
        }

        // Somar valores das trocas de pneus
        for (Pneu pneu : pneus) {
            totalGasto += pneu.getValor();
        }

        // Somar volume de combustivel
        double volumeComb = 0.0;
        for(Combustivel comb: registrosCombustivel)
            volumeComb += comb.getVolume();
        totalGasto += volumeComb*5.0;

        return totalGasto;
    }

    @Override
	public String toString() {
		return "Veiculo [marca=" + marca + ", modelo=" + modelo + ", cor=" + cor + ", placa=" + placa + ", ano=" + ano
				+ ", pecas=" + pecas + ", impostos=" + impostos + ", trocasOleo=" + trocasOleo
				+ ", registrosCombustivel=" + registrosCombustivel + ", pneus=" + pneus + ", quilometragem="
				+ quilometragem + "]";
	}
    
    
}