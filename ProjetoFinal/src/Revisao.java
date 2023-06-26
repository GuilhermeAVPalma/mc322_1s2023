import java.time.LocalDate;
import java.util.ArrayList;

public class Revisao extends Manutencao{

    public Revisao(LocalDate dataInicio, LocalDate dataFim) {
        super(dataInicio, dataFim);
    }

    @Override
    public double calculaGasto() {
        return 50.0;
    }
}
