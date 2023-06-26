import java.time.LocalDate;
import java.util.ArrayList;

public class Revisao extends Manutencao{
    protected boolean status;

    public Revisao(LocalDate dataInicio, LocalDate dataFim, boolean status) {
        super(dataInicio, dataFim);
        this.status = status;
    }

    @Override
    public double calculaGasto() {
        return 50.0;
    }

    @Override
    public String toString() {
        return "Revisao{" +
                "status=" + status +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                "} " + super.toString();
    }
}
