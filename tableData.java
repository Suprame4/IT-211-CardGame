import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class tableData {
    static int[][] allData;

    public static void loadFile(String fileName){
        Path file = FileSystems.getDefault().getPath("",fileName);

        try {

            List<String> lines = Files.readAllLines(file);

            for(int i = 0; i < lines.size(); i++){
                String line = lines.get(i);
                String[] lineArray = line.split(",");
                
                if(allData==null){
                    allData = new int[lines.size()][lineArray.length];
                }

                for(int j = 0; j < lineArray.length; j++){
                    int parsedInt = Integer.parseInt(lineArray[j]);
                    allData[i][j] = parsedInt;
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}