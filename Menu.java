import java.util.Scanner;
import java.io.*;

public class Menu
{
    //funcao do menu de operacoes de controle
    public static void menuOperacoes() {
        int selection;
        Scanner input = new Scanner(System.in);
        System.out.println("Escolha uma das opções seguintes:\n1 - Adicionar aluno \n2 - Remover aluno\n3 - Alterar os dados de um aluno\n4 - Consultar dados do aluno \n5 - Sair do programa");
        selection = input.nextInt();
        
        if (selection == 1) {

            Aluno aluno = new Aluno(); 

            AlunoCreator.init(aluno);
            Arquivo.createFileAluno(aluno);
            Arquivo.addNumeroMatriculaAluno(aluno);
            
        }
        if (selection == 2){

            System.out.println("Insira o número de matrícula:");
            int numeroDeMatricula = input.nextInt(); 
            Arquivo.removeNumeroMatricula(numeroDeMatricula);

        }
        if (selection == 3) {
            
            Edit.options();

        }
        if (selection == 4) {

            AlunoCreator.getAlunoInfo();

        }

        if (selection == 5) {
            return;
        }
    
    
    }

    //funcao de menu inicial
    public static int menu() {
        int selection;
        Scanner input = new Scanner(System.in);
        
        System.out.print("Escolha uma das opções seguintes:\n1 - Acessar o sistema\n2 - Sair\nOpção: ");
        selection = input.nextInt();
        
        return selection;
    }

    //funcao do controle de acesso
    public static void controleAcesso(){
        
        try{
            System.out.print("Digite a senha de acesso: ");
            String senhadigitada;
            Scanner input = new Scanner(System.in);
            senhadigitada = input.nextLine();

            String senha;
            BufferedReader leitor = new BufferedReader(new FileReader("senha.txt"));
            StringBuilder b = new StringBuilder();
            senha = leitor.readLine();
            if (senhadigitada.equals(senha)) {
                System.out.println("Senha válida, logando...");
                menuOperacoes();
            }
            else{
                System.out.println("Senha errada, tente novamente.");
                controleAcesso();
            }
        
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return;
    }

}
