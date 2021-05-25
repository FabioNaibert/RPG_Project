import java.io.*;
import java.lang.Thread;

public class Principal {
    public static void main(String[] args) {
        Tela tela = new Tela(Ler());
        tela.Home();

        ThreadSave sv = new ThreadSave(tela);
        Thread save = new Thread(sv);
        save.start();
    }

    public static String Ler(){
        FileReader reader;
        BufferedReader ler;
        File arquivo;
        String save = null;

        try{
            arquivo = new File("C:\\Windows\\Temp\\Save.txt");
            if(!arquivo.exists()){
                return "null";
            }
            reader = new FileReader(arquivo);
            ler = new BufferedReader(reader);

            save = ler.readLine();

            ler.close();
            reader.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
        return save;
    }
}