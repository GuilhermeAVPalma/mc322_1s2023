import java.util.List;

class Imposto {
    private int ano;
    private List<String> pagamentos;

    public Imposto(int ano, List<String> pagamentos) {
        this.ano = ano;
        this.pagamentos = pagamentos;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setPagamentos(List<String> pagamentos) {
        this.pagamentos = pagamentos;
    }
        
    public int getAno() {
        return ano;
    }

    public List<String> getPagamentos() {
        return pagamentos;
    }
  
}