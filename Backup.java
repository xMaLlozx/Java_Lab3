package Lab_3;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Backup {
    Scanner in = new Scanner(System.in);
    public void BackupFunction(){
        String pathFile = in.nextLine().trim();
        Path rPath = Paths.get(pathFile);
        if(!Files.exists(rPath) || Files.isDirectory(rPath)){
            System.out.println("Файл не существует");
            return;
        }
        Path pathNewFile = Paths.get(rPath.toString() + ".bak");
        try{
            Files.copy(rPath, pathNewFile, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Копирование прошло успешно:");
            System.out.println(pathNewFile.toAbsolutePath());
        }
        catch(IOException e){
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
