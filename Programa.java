import java.util.Scanner;

public class Programa {
    
    public static void main(String[] args) {
        
        System.out.println("Você deseja:");
        System.out.println("[1] Adicionar aluno");
        System.out.println("[2] Remover aluno");
        System.out.println("[3] Alterar dados do aluno");

        Scanner Input = new Scanner(System.in);
        int escolha = Input.nextInt(); 

        while (escolha < 1 || escolha > 3) {
            System.out.println("Insira um número válido.");
            escolha = Input.nextInt();
        }

        if (escolha == 1) {
            Aluno aluno = new Aluno(); 
    
            AlunoCreator.init(aluno);
            Arquivo.createFileAluno(aluno);
            Arquivo.addNumeroMatriculaAluno(aluno);

        } else if (escolha == 2) {

            System.out.println("Insira o número de matrícula:");
            int numeroDeMatricula = Input.nextInt(); 
            Arquivo.removeNumeroMatricula(numeroDeMatricula, false);

        } else if (escolha == 3) {
            

            
        }




    }

}