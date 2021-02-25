package RhombusOfStarts;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        System.out.println(TriangleUp(a));
        System.out.println(TriangleDown(a));
    }
    public static String TriangleUp(int size){
      int brStarts=1;
      int brSpaces=size-1;
      StringBuilder build=new StringBuilder();
      for(int i=0;i<size;i++){
        spaceAdder(brSpaces,build);
          starAdder(brStarts,build);
          brStarts++;
          brSpaces--;
          if(i!=size-1){
              build.append(System.lineSeparator());
          }
      }
        return build.toString();
    }
    public static String TriangleDown(int size){
        int brStarts=size-1;
        int brSpaces=1;
        StringBuilder build=new StringBuilder();
        for(int i=0;i<size-1;i++){
            spaceAdder(brSpaces,build);
            starAdder(brStarts,build);
            brStarts--;
            brSpaces++;
            if(i!=size-1){
                build.append(System.lineSeparator());
            }

        }
        return build.toString();
    }
    public static StringBuilder spaceAdder(int brSpaces,StringBuilder build){
        for(int k=0;k<brSpaces;k++){
            build.append(" ");
        }
        return build;
    }
    public static StringBuilder starAdder(int brStars,StringBuilder build){
        for(int k=0;k<brStars;k++){
            build.append("*");
            if(k!=brStars-1){
                build.append(" ");
            }
        }
        return build;
    }
}
