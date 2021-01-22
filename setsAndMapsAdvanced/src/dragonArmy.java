import java.util.*;

public class dragonArmy {
    public static class Dragon{
        String name;
        int damage;
        int health;
        int armor;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Dragon>> map =new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for(int i=0;i<n;i++){
            String line = scanner.nextLine();
            String[]arrString=line.split(" ");
            String type=arrString[0];
            String name=arrString[1];
            int damage=0;
            if(arrString[2].equals("null")){
                damage=45;
            }
            else{
                damage=Integer.parseInt(arrString[2]);
            }
            int health=0;
            if(arrString[3].equals("null")){
                health=250;
            }
            else{
                health=Integer.parseInt(arrString[3]);
            }
            int armor=0;
            if(arrString[4].equals("null")){
                armor=10;
            }
            else{
                armor=Integer.parseInt(arrString[4]);
            }
            Dragon dragon=new Dragon();
            dragon.name=name;
            dragon.damage=damage;
            dragon.health=health;
            dragon.armor=armor;
            if(!map.containsKey(type)){
                List<Dragon> list=new ArrayList<>();
                list.add(dragon);
                map.put(type,list);
            }
            else{
                boolean bool=false;
                int index=-1;
                for(int k=0;k<map.get(type).size();k++){
                    Dragon cur=map.get(type).get(k);
                    if(name.equals(cur.name)){
                        bool=true;
                        index=k;
                        break;
                    }
                }
                if(!bool){
                    map.get(type).add(dragon);
                }
                else{
                    map.get(type).get(index).health=health;
                    map.get(type).get(index).armor=armor;
                    map.get(type).get(index).damage=damage;
                }
            }


        }


        for (Map.Entry<String, List<Dragon>> str : map.entrySet()) {
            double damageSum=0;
            double healthSum=0;
            double armorSum=0;
            for(Dragon cur:str.getValue()){
                damageSum+=cur.damage;
                healthSum+=cur.health;
                armorSum+=cur.armor;
            }
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n",str.getKey(),damageSum/str.getValue().size(),healthSum/str.getValue().size(),armorSum/str.getValue().size());
        str.getValue().stream().sorted((p1,p2)->p1.name.compareTo(p2.name))
                .forEach(p-> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",p.name,p.damage,p.health,p.armor));

        }


    }
}
