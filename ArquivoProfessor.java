import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner; // Import the Scanner class to read text files

public class ArquivoProfessor extends Arquivo {
    
    @Override
    public String getInfoFromFile(String identificador) {
        
        try {
            File alunoFile = new File(identificador);
            BufferedReader reader = new BufferedReader(new FileReader(alunoFile));
            
            String currentLine; 

            int counter = 0; 
            String aux = "";
            while((currentLine = reader.readLine()) != null) {

                if(counter > 10){
                    break;
                }
                
                System.out.println(currentLine);
                counter++; 
            }


        } catch (IOException e) {
            System.out.println("Não existe professor com esse cpf!");
        }


        return "A";
    }

    @Override
    public void createFileUsuario(Usuario usuario) {
        Professor professor = (Professor) usuario;
        // String file_name = Integer.toString(aluno.numeroDeMatricula) + "_" + aluno.nome;
        String file_name = Integer.toString(professor.getCpf());
        String file_content = new ProfessorCreator().getInfo();

        try {
            FileWriter texto = new FileWriter(file_name);
            texto.write(file_content);
            texto.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}