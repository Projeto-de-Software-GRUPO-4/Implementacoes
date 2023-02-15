import java.util.Scanner;

public class AlunoCreator {
    
    public static void init(Aluno aluno) {

        Scanner Input = new Scanner(System.in);
        System.out.println("Digite o nome do aluno:");
        aluno.setNome(Input.nextLine());

        System.out.println("Digite o ensino do aluno (I[infantil], F [fundamental], M [médio]):");
        aluno.setEnsino(Input.next().charAt(0));;

        System.out.println("Digite a série do aluno:");
        aluno.setSerie(Input.nextInt());

        System.out.println("Digite o turno do aluno:");
        aluno.setTurno(Input.next().charAt(0));

        System.out.println("Digite a mensalidade do aluno:");
        aluno.setMensalidade(Input.nextDouble());

        System.out.println("Digite a data de vencimento da mensalidade do aluno (Ex: 12 [dia 12]):");
        aluno.setDiaDeVencimento(Input.nextInt());
    
        System.out.println("Digite o número de telefone do responsável (1):");
        aluno.setTelefoneResponsavel1(Input.nextLine());
      
        System.out.println("Digite o número de telefone do responsável (2):");
        aluno.setTelefoneResponsavel2(Input.nextLine());

    

    }

    public static String getAlunoInfoAsString(Aluno aluno) {
        String alunoInfo;
        alunoInfo = aluno.getNome() + "\n" + aluno.getSerie() + "\n" +
                    aluno.getEnsino() + "\n" + aluno.getTurno() + "\n" + 
                    aluno.getNumeroDeMatricula() + "\n" + aluno.getMensalidade() +
                    "\n" + aluno.getDiaDeVencimento() + "\n" + aluno.isSuspenso();

        return alunoInfo; 
    }

    public static String getAlunoInfo() { 
        Scanner Input = new Scanner(System.in);
        String numeroDeMatricula; 
        System.out.println("Insira número de matrícula do aluno: ");
        numeroDeMatricula = Input.nextLine(); 
        
        Arquivo.getAlunoInfoFromFile(numeroDeMatricula);
        

        return "A";
    }
    
    

}