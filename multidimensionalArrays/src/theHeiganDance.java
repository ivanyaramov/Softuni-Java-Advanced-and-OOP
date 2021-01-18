import java.util.*;

public class theHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double damage = Double.parseDouble(scanner.nextLine());
        double heiganHP=3000000;
        double playerHP=18500;
        double plague=3500;
        double eruption=6000;
        int rowCur=7;
        int colCur=7;
        int rowLast=7;
        int colLast=7;
        String lastSpell="";
        List<Integer> list=new ArrayList<>();
        boolean flag=true;
        while(true){
            if(playerHP>0){
                heiganHP-=damage;}
            if(!flag){
                playerHP-=3500;
                flag=true;
                lastSpell="Plague Cloud";
            }

            if(heiganHP<=0||playerHP<=0){
                if(heiganHP<=0&&playerHP<=0){
                    System.out.println("Heigan: Defeated!");
                    System.out.printf("Player: Killed by %s%n",lastSpell);
                    System.out.println("Final position: "+rowLast+", "+colLast);
                }
                else if(heiganHP<=0){
                    System.out.println("Heigan: Defeated!");
                    System.out.printf("Player: %.0f%n",playerHP);
                    System.out.println("Final position: "+rowLast+", "+colLast);
                }
                else if(playerHP<=0){
                    System.out.printf("Heigan: %.2f%n",heiganHP);
                    System.out.printf("Player: Killed by %s%n",lastSpell);
                    System.out.println("Final position: "+rowLast+", "+colLast);
                }
                break;
            }
            String line = scanner.nextLine();
            String[] arrString=line.split(" ");
            int row=Integer.parseInt(arrString[1]);
            int col=Integer.parseInt(arrString[2]);
            String type=arrString[0];
            if(isValid(row,col,rowCur,colCur)){
                rowCur--;
                if(isValid(row,col,rowCur,colCur)){
                    rowCur=rowLast;
                    colCur++;
                    if(isValid(row,col,rowCur,colCur)){
                        rowCur++;
                        colCur=colLast;
                        if(isValid(row,col,rowCur,colCur)){
                            rowCur=rowLast;
                            colCur--;
                            if(isValid(row,col,rowCur,colCur)){
                                colCur=colLast;
                                if(type.equals("Cloud")){
                                    lastSpell="Plague Cloud";
                                playerHP-=3500;
                                flag=false;
                                }
                                if(type.equals("Eruption")){
                                    lastSpell="Eruption";
                                    playerHP-=6000;
                                }
                            }
                        }
                    }
                }


            }
            rowLast=rowCur;
            colLast=colCur;
        }
    }
    public static Map<Integer, List<Integer>> DamageZone(int row, int col){
        Map<Integer,List<Integer>> map=new LinkedHashMap<>();
        for(int i=-1;i<=1;i++){
            List<Integer> list=new ArrayList<>();
            for(int k=-1;k<=1;k++){
                list.add(col+k);
            }
            map.put(row+i,list);
        }
        return map;
    }

    public static boolean isValid(int row,int col,int rowCur,int colCur){
        if(DamageZone(row,col).containsKey(rowCur)) {
            if (DamageZone(row, col).get(rowCur).contains(colCur)) {
                return true;
            }
        }
        if(rowCur > 14 || rowCur < 0 || colCur > 14 || colCur < 0){
            return true;
        }
        return false;

    }
}
