public class Usuario {
    protected String nome;
    protected int cpf;
    protected String dataNasc;
    protected int payDay;

    public Usuario() {
        this.nome = "DEFAULT";
        this.cpf = 0;
        this.dataNasc = "XX/XX/XXXX";
    }
    public Usuario (String nome, int cpf, String dataNasc) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
    }

    // Getters e setters
    public String getNome() {
        return this.nome;
    }
    public int getCpf() {
        return this.cpf;
    }
    public String getDataNasc() {
        return this.dataNasc;
    }

    public int getPayDay() {
        return this.payDay;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setPayDay(int payDay) {
        this.payDay = payDay;
    }

}