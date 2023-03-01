import java.util.Scanner;
import java.io.*;

public class Edit{
    public static void opcao10(){
        System.out.print("Digite uma opção:\n1 - Voltar ao menu anterior\n2 - Encerrar\nOpcao:");
        Scanner in = new Scanner(System.in);
        int option = in.nextInt();

        if(option == 1){
            LimpaTela.limpa();
            Menu.menuOperacoes();
        }else if(option == 2){
            LimpaTela.limpa();
            return;
        }else{
            LimpaTela.limpa();
            System.out.println("\n\nOpção inválida!");
            opcao10();
        }
    }

    public static void edit(String matricula){
        System.out.print("Digite uma opção correspondente ao que deseja editar:\n1 - Nome do aluno\n2 - Data de Nascumento\n3 - Nome dos responsaveis\n4 - Numero de telefone dos responsaveis\n5 - Serie\n6 - Tipo de ensino\n7 - Turno\n8 - Valor da mensalidade\n9 - Data de vencimento ddas faturas\n10 - Sair\nOpção: ");
        Scanner input = new Scanner(System.in);
        int opcao = input.nextInt();
        
        String aux = matricula;
        try {
            File arquivo = new File(aux);
            Scanner scanner = new Scanner(arquivo);

            //conta o numero de linhhas do arquivo
            int tamanho = 0;
            while(scanner.hasNextLine()){
                tamanho++;
                scanner.nextLine();
            }scanner.close();

            scanner = new Scanner(arquivo);
            String[] lines = new String[tamanho];

            int i = 0;
            while(scanner.hasNextLine()){
                lines[i] = scanner.nextLine();
                i++;
            }scanner.close();

            
            Scanner entrada = new Scanner(System.in);
            //opcoes
            if(opcao == 1){
                String edicao = AlunoCreator.nome();
                lines[1] = "NOME: " + edicao;

            }else if(opcao == 2){
                String edicao = AlunoCreator.nasc();
                lines[2] = "DATA DE NASCIMENTO: " + edicao;

            }else if(opcao == 3){
                Scanner Input = new Scanner(System.in);
                String aux2, edicao;
                edicao = AlunoCreator.responsavel();

                while(true){
                    System.out.print("Ha um segundo responsavel pelo(a) aluno(a)? 1 - Sim; 2 - Nao\nOpcao: ");
                    int option = Input.nextInt();
                    if(option == 1){
                        aux2 = AlunoCreator.responsavel();
                        if(aux.equals(aux2)){
                            System.out.println("O nome digitado e igual ao anterior!");
                        }else{
                            edicao = edicao + ", " + aux2;
                            break;
                        }
                    }else if(option == 2){
                        break;
                    }else{
                        System.out.println("Opcao invalida!");
                    }
                }

                lines[3] = "NOME DO(S) RESPONSAVEL(IS): " + edicao;

            }else if(opcao == 4){
                Scanner Input = new Scanner(System.in);
                String edicao, aux1;
                edicao = AlunoCreator.numeroresponsavel();

                while(true){
                    System.out.print("Ha um segundo numero? 1 - Sim; 2 - Nao\nOpcao: ");
                    int option = Input.nextInt();
                    if(option == 1){
                        aux1 = AlunoCreator.numeroresponsavel();
                        if(aux1.equals(edicao)){
                            System.out.println("O numero digitado e igual ao anterior!");
                        }else{
                            edicao = edicao + ", " + aux1;
                            break;
                        }
                    }else if(option == 2){
                        break;
                    }else{
                        System.out.println("Opcao invalida!");
                    }
                }

                lines[4] = "TELEFONE DO(S) REPONSAVEL(IS): " + edicao;

            }else if(opcao == 5){
                String serie = lines[6].substring(0, 0) + lines[6].substring(16);
                int edicao = AlunoCreator.serie(serie);
                lines[5] = "SERIE: " + edicao;

            }else if(opcao == 6){
                String edicao = AlunoCreator.ensino();
                lines[6] = "TIPO DE ESNINO: " + edicao;

            }else if(opcao == 7){
                String edicao = AlunoCreator.turno();
                lines[7] = "TURNO: " + edicao;

            }else if(opcao == 8){
                String edicao = AlunoCreator.mensalidade();
                lines[8] = "VALOR DA MENSALIDADE: " + edicao;

            }else if(opcao == 9){
                int edicao = AlunoCreator.vencimento();
                lines[9] = "DATA DE VENCIMENTO DAS FATURAS: " + edicao;

            }else if(opcao == 10){
                LimpaTela.limpa();
                opcao10();
                return;

            }else{
                System.out.println("\n\nOpcao Invalida!");
                edit(matricula);
            }
            
            //limpa o arquivo e escreve o novo
            FileWriter writer = new FileWriter(arquivo);
            i = 0;
            for(String line : lines){
                if(i < tamanho - 1){
                    writer.write(line + System.lineSeparator());
                }else{
                    writer.write(line);
                }
                i++;
            }writer.close();

        }catch(IOException e){
            e.printStackTrace();
        }
        
        return;
    }

    public static boolean exist(String matricula){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("matriculas.txt"));
            StringBuilder sb = new StringBuilder();
            String linha = reader.readLine();

            while(true){
                if(matricula.equals(linha)){
                    reader.close();
                    return true;
                }

                linha = reader.readLine();                
                if(linha == null){
                    reader.close();
                    return false;
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }

        return true;
    }
    
    public static void options(){
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o número de matricula do aluno que irá ter seus dados alterados: ");
        String matricula = input.nextLine();

        boolean teste = exist(matricula);

        if(teste == true){
            int opcao;
            edit(matricula);
            LimpaTela.limpa();
            System.out.println("\tVOCE ESTA EDITANDO AS INFORMACOES DE UM ALUNO NO SISTEMA!");
            System.out.println("-----------------------------------------------------------------------------------------");
            
            while(true){
                System.out.print("Voce deseja continuar editando as informacoes do mesmo aluno?\n1 - Sim\n2- Nao\nOpcao: "); 
                opcao = input.nextInt();
                if(opcao == 1){
                    edit(matricula);
                    LimpaTela.limpa();
                    System.out.println("\tVOCE ESTA EDITANDO AS INFORMACOES DE UM ALUNO NO SISTEMA!");
                    System.out.println("-----------------------------------------------------------------------------------------");
                }else if(opcao == 2){
                    break;
                }else{
                    LimpaTela.limpa();
                    System.out.println("\tVOCE ESTA EDITANDO AS INFORMACOES DE UM ALUNO NO SISTEMA!");
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.println("Opcao invalida!");
                }
            }
        }else{
            System.out.print("\n\nO aluno não está matriculado!\nQuer digitar o número de matricula novamente?\n1 - Sim\n2 - Não\nOpção: ");
            Scanner in = new Scanner(System.in);
            int novamente = in.nextInt();

            if(novamente == 1){
                options();
            }else{
                return;
            }
        }
    }
}