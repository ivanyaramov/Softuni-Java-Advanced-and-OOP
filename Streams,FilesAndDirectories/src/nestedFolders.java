import java.io.File;
import java.util.ArrayDeque;

public class nestedFolders {
    public static void main(String[] args) {
        String path="D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        File file=new File(path);
        ArrayDeque<File> queue=new ArrayDeque<>();
        int count=0;
        queue.offer(file);
        while(!queue.isEmpty()){
            File cur=queue.poll();
            if(cur.isDirectory()){
                File[] allFiles=cur.listFiles();
                for(File cur2:allFiles){
                    if(cur2.isDirectory()){
                        queue.offer(cur2);
                    }
                }
                System.out.println(cur.getName());
                count++;
            }
        }
        System.out.printf("%d folders",count);
    }
}
