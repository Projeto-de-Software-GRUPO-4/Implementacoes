import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner; // Import the Scanner class to read text files


abstract public class Arquivo {
    
    abstract public void createFileUsuario(Usuario usuario);

    public static void createFileTurma(Turma turma) {
        String file_name = turma.getNome();
        try {
            FileWriter texto = new FileWriter(file_name + ".txt");
            texto.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    abstract public String getInfoFromFile(String identificador);

    public static void mostrarAlunosTurma(String nomeArquivoTurma) {
        try {
            File alunoFile = new File(nomeArquivoTurma + ".txt");
            BufferedReader reader = new BufferedReader(new FileReader(alunoFile));
            
            String currentLine;

            while((currentLine = reader.readLine()) != null) {

                System.out.println(currentLine);
                
            }


        } catch (IOException e) {
            System.out.println("Não existe turma com esse nome!");
        }



    }

}