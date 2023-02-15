import java.util.UUID;
import java.util.Scanner;

public class Aluno {
    
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    String nome;  
    String nomeDoResponsavel1;
    String nomeDoResponsavel2;
    String telefoneResponsavel1;
    String telefoneResponsavel2;
    int serie; 
    char ensino;
    char turno; 
    int numeroDeMatricula = NumeroMatricula.numeroCreator();
    double mensalidade; 
    int diaDeVencimento;
    boolean suspenso = false;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public char getEnsino() {
        return ensino;
    }

    public void setEnsino(char ensino) {
        this.ensino = ensino;
    }

    public char getTurno() {
        return turno;
    }

    public void setTurno(char turno) {
        this.turno = turno;
    }

    public int getNumeroDeMatricula() {
        return numeroDeMatricula;
    }

    public void setNumeroDeMatricula(int numeroDeMatricula) {
        this.numeroDeMatricula = numeroDeMatricula;
    }

    public double getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(double mensalidade) {
        this.mensalidade = mensalidade;
    }

    public int getDiaDeVencimento() {
        return diaDeVencimento;
    }

    public void setDiaDeVencimento(int diaDeVencimento) {
        this.diaDeVencimento = diaDeVencimento;
    }

    public String getNomeDoResponsavel1() {
        return nomeDoResponsavel1;
    }

    public void setNomeDoResponsavel1(String nomeDoResponsavel1) {
        this.nomeDoResponsavel1 = nomeDoResponsavel1;
    }

    public String getNomeDoResponsavel2() {
        return nomeDoResponsavel2;
    }

    public void setNomeDoResponsavel2(String nomeDoResponsavel2) {
        this.nomeDoResponsavel2 = nomeDoResponsavel2;
    }

    public String getTelefoneResponsavel1() {
        return telefoneResponsavel1;
    }

    public void setTelefoneResponsavel1(String telefoneResponsavel1) {
        this.telefoneResponsavel1 = telefoneResponsavel1;
    }

    public String getTelefoneResponsavel2() {
        return telefoneResponsavel2;
    }

    public void setTelefoneResponsavel2(String telefoneResponsavel2) {
        this.telefoneResponsavel2 = telefoneResponsavel2;
    }

    public boolean isSuspenso() {
        return suspenso;
    }

    public void setSuspenso(boolean suspenso) {
        this.suspenso = suspenso;
    }

    public String getAlunoInfo() { 
        Scanner Input = new Scanner(System.in);
        String numeroDeMatricula; 
        System.out.println("Insira número de matrícula do aluno: ");
        numeroDeMatricula = Input.nextLine(); 
        
        Arquivo.getAlunoInfoFromFile(numeroDeMatricula);
        

        return "A";
    }


}


