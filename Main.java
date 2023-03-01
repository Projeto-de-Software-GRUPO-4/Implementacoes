public class Main{

    public static void main(String[] args) {
        LimpaTela.limpa();
        int escolha = Menu.menu();

        if(escolha == 1){
            LimpaTela.limpa();
            System.out.println("\t\tCONTROLE DE ACESSO");
            System.out.println("-----------------------------------------------------------------------------------------");
            Menu.controleAcesso();
        }

        else if(escolha == 2){
            LimpaTela.limpa();
            return;
        }

        else{
            LimpaTela.limpa();
            System.out.print("Você digitou uma opção inválida.\n");
            main(args);
        }    
    }
}


