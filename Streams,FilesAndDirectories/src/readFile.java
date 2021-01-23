import java.io.FileInputStream;

public class readFile {
    public static void main(String[] args) {
      String path="D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        try(FileInputStream inputStream = new FileInputStream(path)) {
            int oneByte=inputStream.read();
            while(oneByte>=0){
                System.out.print(Integer.toBinaryString(oneByte)+" ");

                oneByte=inputStream.read();
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }



    }
}
