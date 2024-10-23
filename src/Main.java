import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder stb = new StringBuilder();
        List<File> folderList = Arrays.asList(
                new File ("C://Games//temp"),
                new File("C://Games//scr"),
                new File("C://Games//res"),
                new File("C://Games//savegames"),
                new File("C://Games//scr//main"),
                new File("C://Games//scr//test"),
                new File("C://Games//res//drawables"),
                new File("C://Games//res//vectors"),
                new File("C://Games//res//icons")
        );

        List<File> fileList = Arrays.asList(
                new File("C://Games//scr//main//Main.java"),
                new File("C://Games//scr//main//Utils.java"),
                new File("C://Games//temp//temp.txt")
        );

        folderList.stream().forEach(folder -> {
            if (folder.mkdir()) stb.append("Каталог " + folder + " создан\n");
            else stb.append("Каталог " + folder + " не создан\n");
        });

        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile()) stb.append("Файл " + file + " создан\n");
                else stb.append("Файл " + file + " не создан\n");
            } catch (IOException ex) {
                stb.append(ex.getMessage() + '\n');
            }
        });

        try (FileWriter log = new FileWriter("C://Games//temp//temp.txt", false)) {
            log.write(stb.toString());
            log.flush();
        } catch (IOException ex) {
            stb.append(ex.getMessage() + '\n');
        }

        try (BufferedReader br = new BufferedReader(new FileReader("C://Games//temp//temp.txt"))) {
            String s;
            while ((s = br.readLine()) != null) System.out.println(s);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


    }
}
