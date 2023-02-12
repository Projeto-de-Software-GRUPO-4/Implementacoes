import java.util.Scanner;
import java.io.*;

public class Edit{
    public static void opcao7(){
        System.out.print("\n\nDigite uma opção:\n1 - Voltar ao menu anterior\n2 - Encerrar\nOpcao:");
        Scanner in = new Scanner(System.in);
        int option = in.nextInt();

        if(option == 1){
            Menu.menuOperacoes();
        }else if(option == 2){
            return;
        }else{
            System.out.println("\n\nOpção inválida!");
            opcao7();
        }
    }

    public static void edit(String matricula){
        System.out.print("Digite uma opção:\n1 - Editar o nome do aluno\n2 - Editar o tipo de ensino\n3 - Editar a serie\n4 - Editar o turno\n5 - Editar o valor da mensalidade\n6 - Editar a data de pagamento\n7 - Sair\nOpção: ");
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
                System.out.print("Digite o novo nome a ser inserido no sistema: ");
                String edicao = entrada.nextLine();
                lines[0] = edicao;

            }else if(opcao == 2){
                System.out.print("Digite o novo tipo de ensino do(a) aluno(a): ");
                String edicao = entrada.nextLine();
                if(edicao.equals("I") || edicao.equals("i") || edicao.equals("f") || edicao.equals("F") || edicao.equals("M") || edicao.equals("m")){
                    lines[1] = edicao.toUpperCase();
                }else{
                    System.out.println("\n\nTipo de ensino Invalido!");
                    edit(matricula);
                }

            }else if(opcao == 3){
                System.out.print("Digite a nova serie do(a) aluno(a): ");
                String edicao = entrada.nextLine();
                if(Integer.parseInt(edicao) >= 1 && Integer.parseInt(edicao) <= 9){
                    lines[2] = edicao;
                }else{
                    System.out.println("\n\nSerie Invalida!");
                    edit(matricula);
                }

            }else if(opcao == 4){
                System.out.print("Digite o novo turno do(a) aluno(a): ");
                String edicao = entrada.nextLine();
                if(edicao.equals("M") || edicao.equals("V") || edicao.equals("N") || edicao.equals("n") || edicao.equals("m") || edicao.equals("v")) {
                    lines[3] = edicao.toUpperCase();
                }else{
                    System.out.println("\n\nTurno Invalido!");
                    edit(matricula);
                }

            }else if(opcao == 5){
                System.out.print("Digite o novo valor da mensalidade: ");
                String edicao = entrada.nextLine();
                lines[4] = "R$ " + edicao;

            }else if(opcao == 6){
                System.out.print("Digite a nova data de pagamento (as datas sao consideradas validas somente ate o dia 28): ");
                String edicao = entrada.nextLine();
                if(Integer.parseInt(edicao) >= 1 && Integer.parseInt(edicao) <= 28){
                    lines[5] = edicao;
                }else{
                    System.out.println("\n\nData Invalida (as datas sao consideradas validas somente ate o dia 28)!");
                    edit(matricula);
                }

            }else if(opcao == 7){
                opcao7();
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
            System.out.println("\n\nOs dados foram editados com sucesso!");
            edit(matricula);

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
            edit(matricula);
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