import java.util.List;

class TrocaOleo {
    private int quilometragem;
    private List<String> filtros;

    public TrocaOleo(int quilometragem, List<String> filtros) {
        this.quilometragem = quilometragem;
        this.filtros = filtros;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public List<String> getFiltros() {
        return filtros;
    }

    public void setFiltros(List<String> filtros) {
        this.filtros = filtros;
    } 
}