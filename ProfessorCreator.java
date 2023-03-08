import java.util.Scanner;

public class ProfessorCreator extends UsuarioCreator {

    /* 
    private double salarioHora;
    private int cargaHoraria; 
    private ArrayList<String> turmas;
    */


    public static double salarioHora(){
        Scanner Input = new Scanner(System.in);
        System.out.print("Digite o valor do salário hora do professor: ");
        double salarioHora = Input.nextInt();
        return salarioHora;
    }

    public static int cargaHoraria() {
        Scanner Input = new Scanner(System.in);
        System.out.print("Digite a carga horário do professor: ");
        int cargaHoraria = Input.nextInt();
        return cargaHoraria;
    }

    public static void init(Professor professor) {
        Scanner Input = new Scanner(System.in);
        
        professor.setDataNasc(nasc());
        professor.setCpf(cpf());
        professor.setNome(nome());
        professor.setPayDay(payDay());
        professor.setSalarioHora(salarioHora());
        professor.setCargaHoraria(cargaHoraria());

    }

    public static int payDay(){
        Scanner Input = new Scanner(System.in);
        System.out.print("Digite a data de pagamento do salário do professor (Datas sao consideradas validas entre os dias 1 e 28) (Ex: 12 [dia 12]): ");
        int data = Input.nextInt();
        if(data >= 1 && data <= 28){
            return data;
        }else{
            System.out.println("Data invalida!");
            return vencimento();
        }
    }

    @Override
    public String getInfoAsString(Usuario usuario) {
        Professor professor = (Professor) usuario;
        String professorInfo;
        professorInfo = "CPF: " + professor.getCpf() + "\n" +
                        "Nome: " + professor.getNome() + "\n" + 
                        "Data de nascimento: " + professor.getDataNasc() + "\n" +
                        "Dia de pagamento: " + professor.getPayDay() + "\n" + 
                        "Salário por hora: " + professor.getSalarioHora() + "\n" +
                        "Carga horária: " + professor.getCargaHoraria(); 

        return professorInfo; 
    }

    @Override
    public String getInfo() { 
        Scanner Input = new Scanner(System.in);
        String numeroDeMatricula; 
        System.out.println("Insira número de matrícula do aluno: ");
        numeroDeMatricula = Input.nextLine();
        System.out.println("\n\n\t\t\tInformacoes");
        System.out.println("-----------------------------------------------------------------------------------------");
        
        new ArquivoProfessor().getInfoFromFile(numeroDeMatricula);
        

        return "A";
    }
}