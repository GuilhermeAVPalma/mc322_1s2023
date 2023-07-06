public enum CalcSeguro {
    VALOR_BASE (100.0) ,
    FATOR_18_30 (1.2) ,
    FATOR_30_60 (1.0) ,
    FATOR_60_90 (1.5) ;
   
    public final double seguro ;
   
    CalcSeguro(double seguro) {
       this.seguro = seguro;
    }
   
    public double getSeguro() {
       return this.seguro;
    }
}