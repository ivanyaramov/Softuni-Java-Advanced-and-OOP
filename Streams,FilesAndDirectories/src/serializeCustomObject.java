import java.io.*;

public class serializeCustomObject {
    public static class Cube implements Serializable{
        String color;
        double width;
        double height;
        double depth;
    }
    public static void main(String[] args)throws Exception {
        String path="D:\\failove_softuni\\obekt.txt";
        Cube cube=new Cube();
        cube.color="green";
        cube.width=15.3;
        cube.height=12.4;
        cube.depth=3;
        ObjectOutputStream ou=new ObjectOutputStream(new FileOutputStream(path));
        ou.writeObject(cube);
        ou.close();
        ObjectInputStream oi=new ObjectInputStream(new FileInputStream(path));
        Cube cubeNew=(Cube)oi.readObject();
        System.out.println(cubeNew.height);
    }
}
