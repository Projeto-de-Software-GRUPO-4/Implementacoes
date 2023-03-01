import java.util.Scanner;
import java.io.*;

public class Menu
{
    //funcao do menu de operacoes de controle
    public static void menuOperacoes() {
        int selection;
        Scanner input = new Scanner(System.in);
        System.out.print("Escolha uma das opções seguintes:\n1 - Adicionar aluno \n2 - Excluir aluno\n3 - Alterar os dados de um aluno\n4 - Mostrar dados de um aluno\n5 - Suspender aluno \n6 - Mostrar alunos da turma\n7 - Expulsar aluno\n8 - Sair do programa\nOpcao: ");
        selection = input.nextInt();
        
        LimpaTela.limpa();

        if(selection == 1) {
            System.out.println("\tVOCE ESTA INSERINDO UM ALUNO NO SISTEMA!");
            System.out.println("-----------------------------------------------------------------------------------------");
            Aluno aluno = new Aluno(); 
            AlunoCreator.init(aluno);
            Arquivo.createFileAluno(aluno);
            Arquivo.addNumeroMatriculaAluno(aluno);
            Turma turma = new Turma();
            turma.setNome(String.valueOf(Integer.toString(aluno.getSerie()).charAt(0)) + String.valueOf(aluno.getEnsino().charAt(0)) + String.valueOf(aluno.getTurno().charAt(0)));
            Arquivo.addAlunoToTurma(turma, aluno);

            LimpaTela.limpa();
            System.out.println("Matricula efetuada com sucesso!");
            menuOperacoes();

        }else if (selection == 2){
            System.out.println("\tVOCE ESTA EXCLUINDO UM ALUNO DO SISTEMA!");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.print("Insira o número de matrícula: ");
            int numeroDeMatricula = input.nextInt();

            if(Edit.exist(Integer.toString(numeroDeMatricula)) == false){
                LimpaTela.limpa();
                System.out.println("O numero de matricula nao existe!");
                System.out.println("-----------------------------------------------------------------------------------------");
                Menu.menuOperacoes();
            }

            String nomeTurma = Arquivo.getAlunoNomeTurmaFromFile(numeroDeMatricula);
            Arquivo.removeNumeroMatricula(numeroDeMatricula, nomeTurma, false);
            
            //LimpaTela.limpa();
            System.out.println("Exclusao efetuada com sucesso!");
            menuOperacoes();

        }else if (selection == 3) {
            System.out.println("\tVOCE ESTA EDITANDO AS INFORMACOES DE UM ALUNO NO SISTEMA!");
            System.out.println("-----------------------------------------------------------------------------------------");
            Edit.options();

            LimpaTela.limpa();
            System.out.println("Edicao efetuada com sucesso!");
            menuOperacoes();

        }else if (selection == 4) {
            System.out.println("\tVOCE ESTA VISUALIZANDO AS INFORMACOES DE UM ALUNO NO SISTEMA!");
            System.out.println("-----------------------------------------------------------------------------------------");
            AlunoCreator.getAlunoInfo();

            LimpaTela.limpa();
            menuOperacoes();
            
        }else if (selection == 5) {
            System.out.println("\tVOCE ESTA SUSPENDENDO UM ALUNO NO SISTEMA!");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Insira o número de matrícula:");
            int numeroDeMatricula = input.nextInt();
            
            LimpaTela.limpa();
            menuOperacoes();
            System.out.println("Aluno expulso com sucesso!");

        }else if (selection == 6) {
            
            System.out.println("Insira o nome da turma:");
            String nome;
            Scanner Input = new Scanner(System.in);
            nome = Input.nextLine();
            Arquivo.mostrarAlunosTurma(nome);
            
        }else if(selection == 7){
            System.out.println("\tVOCE ESTA EXPULSANDO UM ALUNO DO SISTEMA!");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.print("Insira o número de matrícula: ");
            int numeroDeMatricula = input.nextInt();

            if(Edit.exist(Integer.toString(numeroDeMatricula)) == false){
                LimpaTela.limpa();
                System.out.println("O numero de matricula nao existe!");
                System.out.println("-----------------------------------------------------------------------------------------");
                Menu.menuOperacoes();
            }

            String nomeTurma = Arquivo.getAlunoNomeTurmaFromFile(numeroDeMatricula);
            Arquivo.removeNumeroMatricula(numeroDeMatricula, nomeTurma, true);
            
            LimpaTela.limpa();
            System.out.println("Expulsao efetuada com sucesso!");
            menuOperacoes();
        }else if (selection == 8) {
            LimpaTela.limpa();
            return;
            
        }else{
            LimpaTela.limpa();
            System.out.println("Opcao Invalida!");
            menuOperacoes();
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
            System.out.print("Digite sua senha de acesso: ");
            String senhadigitada;
            Scanner input = new Scanner(System.in);
            senhadigitada = input.nextLine();

            String senha;
            BufferedReader leitor = new BufferedReader(new FileReader("senha.txt"));
            StringBuilder b = new StringBuilder();
            senha = leitor.readLine();

            LimpaTela.limpa();

            if (senhadigitada.equals(senha)) {
                System.out.println("Senha válida, logando...");
                System.out.println("-----------------------------------------------------------------------------------------");
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