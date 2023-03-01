import java.util.*;

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
    String ensino;
    String turno; 
    int numeroDeMatricula = NumeroMatricula.numeroCreator();
    String mensalidade; 
    int diaDeVencimento;
    String dataNasc;
    boolean suspenso;


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

    public String getEnsino() {
        return ensino;
    }

    public void setEnsino(String ensino) {
        this.ensino = ensino;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getNumeroDeMatricula() {
        return numeroDeMatricula;
    }

    public void setNumeroDeMatricula(int numeroDeMatricula) {
        this.numeroDeMatricula = numeroDeMatricula;
    }

    public String getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(String mensalidade) {
        this.mensalidade = mensalidade;
    }

    public int getDiaDeVencimento() {
        return diaDeVencimento;
    }

    public void setDiaDeVencimento(int diaDeVencimento) {
        this.diaDeVencimento = diaDeVencimento;
    }

    public String getNomeDoResponsavel() {
        return nomeDoResponsavel1;
    }

    public void setNomeDoResponsavel(String nomeDoResponsavel1) {
        this.nomeDoResponsavel1 = nomeDoResponsavel1;
    }

    public String getTelefoneResponsavel() {
        return telefoneResponsavel1;
    }

    public void setTelefoneResponsavel(String telefoneResponsavel1) {
        this.telefoneResponsavel1 = telefoneResponsavel1;
    }

    public String getDataNasc(){
        return dataNasc;
    }

    public void setDataNasc(String dataNasc){
        this.dataNasc = dataNasc;
    }

    public boolean getSuspenso(){
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


