import java.io.File;
import java.util.ArrayDeque;

public class getFolderSize {
    public static void main(String[] args) {
        String path="D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File file=new File(path);
        ArrayDeque<File> queue=new ArrayDeque<>();

        int sum=0;
        queue.offer(file);
        while(!queue.isEmpty()){
            File cur=queue.poll();
            if(cur.isFile()){
                sum+=cur.length();
            }
            if(cur.isDirectory()){
                File[] allFiles=cur.listFiles();
                for(File cur2:allFiles){
                    if(cur2.isDirectory()){
                        queue.offer(cur2);
                    }
                    if(cur2.isFile()){
                        sum+=cur2.length();
                    }
                }

            }
        }
        System.out.printf("Folder size: %d",sum);
    }
}
