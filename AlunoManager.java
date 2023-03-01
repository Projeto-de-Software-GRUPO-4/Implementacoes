import java.util.Scanner;

public class AlunoManager {
    public static void init(Aluno aluno) {
        
        Scanner Input = new Scanner(System.in);

        System.out.println("Insira número de matrícula do aluno:");
        int numeroDeMatricula = Input.nextInt();

        System.out.println("Insira nome do aluno:");
        String nomeDoAluno = Input.nextLine();

    }
}