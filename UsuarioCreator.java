import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

abstract public class UsuarioCreator {

    public abstract String getInfo();
    public abstract String getInfoAsString(Usuario usuario);
    
    public static String nome(){
        Scanner Input = new Scanner(System.in);
        System.out.print("Digite o nome do(a) aluno(a): ");
        String nome = Input.nextLine();
        nome = nome.toUpperCase();
        return nome;
    }

    public static int cpf() {
        Scanner Input = new Scanner(System.in);
        System.out.print("Digite o CPF do usuário: ");
        int cpf = Input.nextInt();
        return cpf;
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

    public static void init(Usuario usuario) {}

}