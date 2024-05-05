package com.fatec.zl.amos.aula_mobile_06_exe1;

public class ProfessorTitular extends Professor{
    private int anoInsituicao;
    private double salario;

    public ProfessorTitular(){
        super();
    }
    public int getAnoInsituicao() {
        return anoInsituicao;
    }

    public void setAnoInsituicao(int anoInsituicao) {
        this.anoInsituicao = anoInsituicao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

@Override
    public double calcSalario() {

        int anos = (int) Math.floor(getAnoInsituicao() / 5.0);
        double calc = anos * 0.05;
        return getSalario() * (1 + calc);

    }

}
