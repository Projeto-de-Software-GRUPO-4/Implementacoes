import java.util.Scanner;

public class AlunoManager {
    public static void init(Aluno aluno) {
        
        Scanner Input = new Scanner(System.in);

        System.out.println("Insira número de matrícula do(a) aluno(a):");
        int numeroDeMatricula = Input.nextInt();

        System.out.println("Insira nome do(a) aluno(a):");
        String nomeDoAluno = Input.nextLine();

    }
}