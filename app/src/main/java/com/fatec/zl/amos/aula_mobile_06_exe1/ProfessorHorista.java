package com.fatec.zl.amos.aula_mobile_06_exe1;

public class ProfessorHorista extends Professor{
    private int horasAula;
    private double valorHoraAula;


    public ProfessorHorista(){
        super();
    }
    public int getHorasAula() {
        return horasAula;
    }

    public void setHorasAula(int horasAula) {
        this.horasAula = horasAula;
    }

    public double getValorHoraAula() {
        return valorHoraAula;
    }

    public void setValorHoraAula(double valorHoraAula) {
        this.valorHoraAula = valorHoraAula;
    }

@Override
    public double calcSalario() {
       return getHorasAula() * getValorHoraAula();

    }
}
