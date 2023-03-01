import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner; // Import the Scanner class to read text files


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
                if (counter == 5){
                    serie = String.valueOf((currentLine.substring(0, 0) + currentLine.substring(7)).charAt(0));
                }
                if (counter == 6){
                    ensino = String.valueOf((currentLine.substring(0, 0) + currentLine.substring(16)).charAt(0));
                }
                if (counter == 7) {
                    turno = String.valueOf((currentLine.substring(0, 0) + currentLine.substring(7)).charAt(0));
                    break;
                }
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
            String aux = "";
            while((currentLine = reader.readLine()) != null) {

                if(counter > 10){
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
        Scanner Input = new Scanner(System.in);
        

        File inputFile = new File("matriculas.txt");
        File tempFile = new File("matriculasTemp.txt");
        // File matriculaFileNew = expelled ? new File(numeroDeMatriculaString + "_expelled") : new File(numeroDeMatriculaString + "_inactive");
        if(expelled == true){
            File matriculaFile = new File(numeroDeMatriculaString);
            sucesso = matriculaFile.renameTo(new File(numeroDeMatriculaString + "_expelled"));
        }else{
            File matriculaFile = new File(numeroDeMatriculaString);
            matriculaFile.renameTo(new File(numeroDeMatriculaString + "_inactive"));
        }

        
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