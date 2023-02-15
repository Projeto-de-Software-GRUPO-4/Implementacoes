import java.util.Scanner;

public class AlunoCreator {
    
    public static void init(Aluno aluno) {

        Scanner Input = new Scanner(System.in);
        System.out.print("Digite o nome do aluno: ");
        aluno.setNome(Input.nextLine());

        int ano, mes, dia;
        while(true){
            System.out.println("Digite a data de nascimento do(a) aluno(a) (Digite o dia e pressione enter, mes e pressione enter, ano e pressione enter):");
            dia = Input.nextInt();
            mes = Input.nextInt();
            ano = Input.nextInt();
            if(dia <= 31 && mes <= 12){
                break;
            }else{
                System.out.print("\n\nData invalida!");
            }
        }
        String nasc = Integer.toString(dia) + "/" + Integer.toString(mes) + "/" + Integer.toString(ano);
        aluno.setDataNasc(nasc);

        
        String aux;
        while(true){
            System.out.print("Digite o ensino do aluno (I[infantil], F [fundamental], M [médio]): ");
            aux = Input.next();

            if(aux.equals("I") || aux.equals("i") || aux.equals("F") || aux.equals("f") || aux.equals("M") || aux.equals("m")){
                aux = aux.toUpperCase();
                aluno.setEnsino(aux.charAt(0));
                break;
            }else{
                System.out.print("\n\nEnsino invalido!\nDigite o ensino do aluno: ");
            }
        }

        if(aux.equals("I")){
            aluno.setSerie(0);

        }else if(aux.equals("F")){
            int serie;
            System.out.println("Digite a série do aluno:");
            while(true){
                serie = Input.nextInt();
                if(serie >= 1 && serie <= 9){
                    aluno.setSerie(serie);
                    break;
                }else{
                    System.out.print("\n\nSerie Invalida!");
                    System.out.print("Digite a série do aluno: ");
                }
            }

        }else{
            int serie;
            System.out.print("Digite a série do aluno: ");
            while(true){
                serie = Input.nextInt();
                if(serie >= 1 && serie <= 4){
                    aluno.setSerie(serie);
                    break;
                }else{
                    System.out.print("\n\nSerie Invalida!");
                    System.out.print("Digite a série do aluno: ");
                }
            }
        }


        String turno;
        while(true){
            System.out.print("Digite o turno do aluno (M[Matutino], V[Vespertino], N[Noturno]): ");
            turno = Input.next();
            turno = turno.toUpperCase();

            if(turno.equals("M") || turno.equals("V") || turno.equals("N")){
                aluno.setTurno(turno.charAt(0));
                break;
            }else{
                System.out.print("\n\nTurno invalido!");
            }
        }

        System.out.print("Digite a mensalidade do aluno:");
        double mensalidade = Input.nextDouble();
        String mensality = "R$ " + Double.toString(mensalidade);
        aluno.setMensalidade(mensality);

        int venc;
        while(true){
            System.out.print("Digite a data de vencimento da mensalidade do aluno (Ex: 12 [dia 12]) (Datas de vencimento são consideradas válidas somente entre os dias 1 e 28):");
            venc = Input.nextInt();
            if(venc >= 1 && venc <= 28){
                aluno.setDiaDeVencimento(venc);
                break;
            }else{
                System.out.println("A data de vencimento é inválida!");
            }
        }

        System.out.print("\n\nAluno(a) matriculado com sucesso!");


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