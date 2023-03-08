import java.util.ArrayList;

public class Professor extends Usuario {
    private double salarioHora;
    private int cargaHoraria; 
    private ArrayList<String> turmas;

    // String nome, int cpf, String dataNasc
    public Professor() {
        // super(nome, cpf, dataNasc);
        super();
    }

    public double getSalario() {
        return this.salarioHora * this.cargaHoraria;
    }
    
    public double getSalarioHora() {
        return this.salarioHora; 
    }

    public int getCargaHoraria() {
        return this.cargaHoraria;
    }

    public ArrayList<String> getTurmas() {
        return this.turmas;
    }

    public void setSalarioHora(double salarioHora) {
        this.salarioHora = salarioHora; 
    }


    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria; 
    }
    // Set turmas ...? 

}