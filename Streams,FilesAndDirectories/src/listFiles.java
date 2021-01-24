import java.io.File;

public class listFiles {
    public static void main(String[] args) {
        String path="D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
    File file = new File(path);
    File[] allFiles=file.listFiles();
    for(File cur:allFiles){
        if(cur.isFile()){
            System.out.println(cur.getName()+": ["+cur.length()+"]");

        }
    }
    }
}
