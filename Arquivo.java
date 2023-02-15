import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Arquivo {
    public static void createFileTurma(Turma turma) {
        String file_name = turma.getNome();
        try {
            FileWriter texto = new FileWriter(file_name + ".txt");
            texto.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addAlunoToTurma(Turma turma, Aluno aluno) {
        String nomeTurma = turma.getNome();
        try {

            // Checa se já existe um arquivo para turma e cria caso não
            File fileTurma = new File(nomeTurma + ".txt");
            if(!fileTurma.exists() && !fileTurma.isDirectory()) { 
                createFileTurma(turma);
                Files.write(Paths.get(nomeTurma + ".txt"), (Integer.toString(aluno.getNumeroDeMatricula()) + " " + aluno.getNome() + "\n").getBytes(), StandardOpenOption.APPEND);
            } else {
                Files.write(Paths.get(nomeTurma + ".txt"), (Integer.toString(aluno.getNumeroDeMatricula()) + " " + aluno.getNome() + "\n").getBytes(), StandardOpenOption.APPEND);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFileAluno(Aluno aluno) {
        // String file_name = Integer.toString(aluno.numeroDeMatricula) + "_" + aluno.nome;
        String file_name = Integer.toString(aluno.numeroDeMatricula);
        String file_content = AlunoCreator.getAlunoInfoAsString(aluno);

        try {
            FileWriter texto = new FileWriter(file_name);
            texto.write(file_content);
            texto.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void addNumeroMatriculaAluno(Aluno aluno) {
        try {
            Files.write(Paths.get("matriculas.txt"), (Integer.toString(aluno.getNumeroDeMatricula()) + "\n").getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getAlunoNomeTurmaFromFile(int numeroDeMatricula) {

        String numeroDeMatriculaString = Integer.toString(numeroDeMatricula);

        String serie = "", ensino = "", turno = ""; 
        try {
            File alunoFile = new File(numeroDeMatriculaString);
            BufferedReader reader = new BufferedReader(new FileReader(alunoFile));
            
            String currentLine; 

            int counter = 0; 
            
            while((currentLine = reader.readLine()) != null) {
                if (counter == 1) serie = currentLine;
                if (counter == 2) ensino = currentLine;
                if (counter == 3) {turno = currentLine; break;}

                counter++; 
            }


        } catch (IOException e) {
            System.out.println("Não existe aluno com esse número de matrícula!");
        }

        return serie + ensino + turno;
    }

    public static String getAlunoInfoFromFile(String numeroDeMatricula) {
        
        try {
            File alunoFile = new File(numeroDeMatricula);
            BufferedReader reader = new BufferedReader(new FileReader(alunoFile));
            
            String currentLine; 

            int counter = 0; 
            while((currentLine = reader.readLine()) != null) {

                switch (counter) {
                    case 0:
                        System.out.printf("Nome: ");
                        break;
                    case 1:
                        System.out.printf("Serie: ");
                        break;
                    case 2:
                        System.out.printf("Ensino: ");
                        break;
                    case 3:
                        System.out.printf("Turno: ");
                        break;
                    case 4:
                        System.out.printf("Matrícula: ");
                        break;
                    case 5:
                        System.out.printf("Mensalidade: ");
                        break;
                    case 6:
                        System.out.printf("Dia do pagamento: ");
                        break;
                    case 7:
                        System.out.printf("Suspenso: ");
                        break;
                    default:
                        break;
                }
                
                System.out.println(currentLine);
                counter++; 
            }


        } catch (IOException e) {
            System.out.println("Não existe aluno com esse número de matrícula!");
        }


        return "A";
    }

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


    public static void removeNumeroMatricula(int numeroDeMatricula, String nomeDaTurma, boolean expelled) {

        String numeroDeMatriculaString = Integer.toString(numeroDeMatricula);

        File inputFile = new File("matriculas.txt");
        File tempFile = new File("matriculasTemp.txt");
        File matriculaFile = new File(numeroDeMatriculaString);
        // File matriculaFileNew = expelled ? new File(numeroDeMatriculaString + "_expelled") : new File(numeroDeMatriculaString + "_inactive");
        File matriculaFileNew = new File(numeroDeMatriculaString + "_inactive");

        
        matriculaFile.renameTo(matriculaFileNew);
        
        try {

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
    
            String lineToRemove = numeroDeMatriculaString;
            String currentLine;
    
            while((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                if(trimmedLine.equals(lineToRemove)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close(); 
            reader.close(); 

            inputFile.delete();
            boolean successful = tempFile.renameTo(inputFile);



        } catch (IOException e) {
            e.printStackTrace();
        }

        // Removendo do arquivo da turma
        inputFile = new File(nomeDaTurma + ".txt");
        tempFile = new File(nomeDaTurma + "Temp.txt");

        try {

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
    
            String lineToRemove = numeroDeMatriculaString;
            String currentLine;
    
            while((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                if(trimmedLine.startsWith(lineToRemove)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close(); 
            reader.close(); 

            inputFile.delete();
            boolean successful = tempFile.renameTo(inputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }

        
    }

}