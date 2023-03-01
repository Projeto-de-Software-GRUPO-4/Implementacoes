public class LimpaTela {
    public static void limpa(){
        try {
            String os = System.getProperty("os.name").toLowerCase();
            
            if (os.contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else if (os.contains("mac")) {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception ex) {
            System.out.println("Erro ao limpar o terminal: " + ex.getMessage());
        }
    }
}