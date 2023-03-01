import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class AlunoCreator {

    public static String nome(){
        Scanner Input = new Scanner(System.in);
        System.out.print("Digite o nome do(a) aluno(a): ");
        String nome = Input.nextLine();
        nome = nome.toUpperCase();
        return nome;
    }

    public static String responsavel(){
        Scanner Input = new Scanner(System.in);
        System.out.print("Digite o nome do(a) responsavel pelo(a) aluno(a): ");
        String nome = Input.nextLine();
        nome = nome.toUpperCase();
        return nome;
    }

    public static String numeroresponsavel(){
        Scanner Input = new Scanner(System.in);
        System.out.print("Digite o numero do(a) responsavel pelo(a) aluno(a) no com 12 diigitos, sendo os 3 primeiros o DDDD: ");
        String numero = Input.next();

        try {
            Long.parseLong(numero);
            String[] numeroAlterado = new String[numero.length() + 3];

            if(numero.length() == 12){
                for (int i = 0, j = 0; i < numero.length(); i++, j++) {
                    if (i == 0) {
                        numeroAlterado[j] = "(";
                        j++;
                    } else if (i == 3) {
                        numeroAlterado[j] = ")";
                        j++;
                    }else if(i == 8){
                        numeroAlterado[j] = "-";
                        j++;
                    }
                    numeroAlterado[j] = String.valueOf(numero.charAt(i));
                }

                return String.join("", numeroAlterado);
                
            }else{
                System.out.println("Número inválido!");
                return numeroresponsavel();
            }
        } catch (NumberFormatException e) {
            System.out.println("Número inválido!");
            return numeroresponsavel();
        }
    }

    public static String nasc(){
        Scanner Input = new Scanner(System.in);
        while(true){
            System.out.print("Digite a data de nascimento do aluno(a) no formato dd/mm/aaaa: ");
            String data_nasc = Input.next();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);

            try {
                sdf.parse(data_nasc);
                return data_nasc;
            } catch (ParseException e) {
                System.out.println("Data inválida!");
                return nasc();
            }
        }
    }

    public static String ensino(){
        Scanner Input = new Scanner(System.in);
        String ensino;
        while(true){
            System.out.print("Digite o ensino do aluno (I [infantil], F [fundamental], M [médio]): ");
            ensino = Input.next();
            ensino = ensino.toUpperCase();
            if(ensino.equals("I")){
                return "INFANTIL";
            }else if(ensino.equals("F")){
                return "FUNDAMENTAL";
            }else if (ensino.equals("M")){
                return "MEDIO";
            }else{
                System.out.println("Tipo de esiino invalido!");
                return ensino();
            }
        }
    }

    public static int serie(String ensino){
        
        Scanner Input = new Scanner(System.in);
        String ens = String.valueOf(ensino);
        int serie = 0;
        if(ens.equals("INFANTIL")){
            return serie;
        }else{
            System.out.print("Digite a série do(a) aluno(a):");
            serie = Input.nextInt();
            if(ens.equals("FUNDAMENTAL")){
                if(serie >= 1 && serie <= 9){
                    return serie;
                }else{
                    System.out.println("Serie invalida!");
                    return serie(ensino);
                }
            }else{
                if(serie >= 1 && serie <= 4){
                    return serie;
                }else{
                    System.out.println("Serie invalida!");
                    return serie(ensino);
                }
            }
        }
    }

    public static String turno(){
        Scanner Input = new Scanner(System.in);
        while(true){
            System.out.print("Digite o turno do(a) aluno(a) (M [Matutino], V [Vespertino], N [Noturno]): ");
            String turno = Input.next();
            turno = turno.toUpperCase();
            if(turno.equals("M")){
                return "MATUTINO";
            }else if(turno.equals("V")){
                return "VESPERTINO";
            }else if(turno.equals("N")){
                return "NOTURNO";
            }else{
                System.out.print("Turno invaliido!");
                return turno();
            }
        }
    }

    public static String mensalidade(){
        Scanner Input = new Scanner(System.in);
        System.out.print("Digite a mensalidade do(a) aluno(a): ");
        Double mensalidade = Input.nextDouble();
        String men = "R$" + Double.toString(mensalidade);
        return men;
    }

    public static int vencimento(){
        Scanner Input = new Scanner(System.in);
        System.out.print("Digite a data de vencimento da mensalidade do(a) aluno(a) (Datas sao consideradas validas entre os dias 1 e 28) (Ex: 12 [dia 12]): ");
        int data = Input.nextInt();
        if(data >= 1 && data <= 28){
            return data;
        }else{
            System.out.println("Data invalida!");
            return vencimento();
        }
    }

    public static void init(Aluno aluno) {
        Scanner Input = new Scanner(System.in);
        String aux, aux2;

        //dados do aluno
        aluno.setNome(nome());
        aux = responsavel();
        while(true){
            System.out.print("Ha um segundo responsavel pelo(a) aluno(a)? 1 - Sim; 2 - Nao\nOpcao: ");
            int option = Input.nextInt();
            if(option == 1){
                aux2 = responsavel();
                if(aux.equals(aux2)){
                    System.out.println("O nome digitado e igual ao anterior!");
                }else{
                    aux = aux + ", " + aux2;
                    break;
                }
            }else if(option == 2){
                break;
            }else{
                System.out.println("Opcao invalida!");
            }
        }
        aluno.setNomeDoResponsavel(aux);

        aux = numeroresponsavel();
        while(true){
            System.out.print("Ha um segundo numero? 1 - Sim; 2 - Nao\nOpcao: ");
            int option = Input.nextInt();
            if(option == 1){
                aux2 = numeroresponsavel();
                if(aux2.equals(aux)){
                    System.out.println("O numero digitado e igual ao anterior!");
                }else{
                    aux = aux + ", " + aux2;
                    break;
                }
            }else if(option == 2){
                break;
            }else{
                System.out.println("Opcao invalida!");
            }
        }
        
        aluno.setTelefoneResponsavel(aux);

        aluno.setDataNasc(nasc());
        String ensino = ensino();
        aluno.setEnsino(ensino);
        aluno.setSerie(serie(ensino));
        aluno.setTurno(turno());
        aluno.setMensalidade(mensalidade());
        aluno.setDiaDeVencimento(vencimento());
        aluno.setSuspenso(false);

    }

    public static String getAlunoInfoAsString(Aluno aluno) {
        String alunoInfo;
        alunoInfo = "NUMERO DE MATRICULA: " + aluno.getNumeroDeMatricula() + "\n"  + "NOME: " + aluno.getNome() + "\n" + 
                    "DATA DE NASCIMENTO: " + aluno.getDataNasc() + "\n" + "NOME DO(S) RESPONSAVEL(IS): " + aluno.getNomeDoResponsavel() + "\n" + 
                    "TELEFONE DO(S) REPONSAVEL(IS): " + aluno.getTelefoneResponsavel() + "\n" + "SERIE: " + aluno.getSerie() + "\n" + 
                    "TIPO DE ESNINO: " + aluno.getEnsino() + "\n" + "TURNO: " + aluno.getTurno() + "\n" + "VALOR DA MENSALIDADE: " + 
                    aluno.getMensalidade() + "\n" + "DATA DE VENCIMENTO DAS FATURAS: " + aluno.getDiaDeVencimento() + "\n" + "ALUNO SUSPENSO? " + 
                    aluno.getSuspenso();

        return alunoInfo; 
    }

    public static String getAlunoInfo() { 
        Scanner Input = new Scanner(System.in);
        String numeroDeMatricula; 
        System.out.println("Insira número de matrícula do aluno: ");
        numeroDeMatricula = Input.nextLine();
        System.out.println("\n\n\t\t\tInformacoes");
        System.out.println("-----------------------------------------------------------------------------------------");
        
        Arquivo.getAlunoInfoFromFile(numeroDeMatricula);
        

        return "A";
    }

}