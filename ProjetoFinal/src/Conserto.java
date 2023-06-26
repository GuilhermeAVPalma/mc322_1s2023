import java.time.LocalDate;
import java.util.ArrayList;

public class Conserto extends Manutencao{
    protected ArrayList<Peca> listaPecas;

    public Conserto(LocalDate dataInicio, LocalDate dataFim) {
        super(dataInicio, dataFim);
        this.listaPecas = new ArrayList<Peca>();
    }

    public void adicionarPeca(Peca peca) {
        listaPecas.add(peca);
    }

    @Override
    public double calculaGasto() {
        double custo = 50.0;
        for(Peca p: listaPecas) {
            custo += p.getValor();
        }
        return custo;
    }
}
