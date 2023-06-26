import java.time.LocalDate;

interface Imposto {
	public double getValor();
	public void setValor(double valor);
	public LocalDate getData();
	public void setData(LocalDate data);
	public String getNomeImposto();
	public double calculaImposto(double valorVeiculo);

}