import java.util.*;

public class robotics {
    public static class Robot{
        String name;
        int time;
        boolean available;
        int timeLeft;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String robots = scanner.nextLine();
        String curTime = scanner.nextLine();
        String[] arrRobots = robots.split(";");
        List<Robot> list = new ArrayList<>();
        for (int i = 0; i < arrRobots.length; i++) {
            String[] arr = arrRobots[i].split("-");
            Robot robot = new Robot();
            robot.name = arr[0];
            robot.time = Integer.parseInt(arr[1]);
            robot.available = true;
            robot.timeLeft = 0;
            list.add(robot);


        }
        String[] arrTime = curTime.split(":");
        int[] arrTimeNum = new int[3];
        for (int i = 0; i < 3; i++) {
            if (arrTime[i].charAt(0) == '0') {
                arrTimeNum[i] = Character.getNumericValue(arrTime[i].charAt(1));
            } else {
                arrTimeNum[i] = Integer.parseInt(arrTime[i]);
            }
        }
        ArrayDeque<String> queue = new ArrayDeque<>();
        while (true) {

            String a = scanner.nextLine();
            if (a.equals("End")) {
                break;
            }
            queue.offer(a);
        }
        int time = 0;
        boolean bool = true;
        while (true) {
            if (queue.isEmpty()) {
                break;
            }
            int min = Integer.MAX_VALUE;
            for (Robot cur : list) {
if (cur.timeLeft<min){
    min=cur.timeLeft;
}
            }
            if(min==0){
                bool=true;
            }
            else{
                bool=false;
            }
            if (bool) {
                arrTimeNum[2]++;
                for (int i = 0; i < list.size(); i++) {
                    Robot current = list.get(i);

                    if (current.timeLeft == 0) {
                        current.available = true;
                    } else {
                        current.timeLeft--;
                        if (current.timeLeft == 0) {
                            current.available = true;
                        }
                    }
                }
            }
           else{
               arrTimeNum[2]+=min;
                for (Robot cur : list) {
                    cur.timeLeft-=min;
                    if(cur.timeLeft<=0){
                        cur.timeLeft=0;
                        cur.available=true;
                    }
                }
                for(int i=0;i<min-1;i++){
                    queue.offer(queue.poll());
                }
               min=0;
            }



            boolean flag = false;
            for (int i = 0; i < list.size(); i++) {
                Robot current = list.get(i);
                if (current.available) {
                    current.timeLeft = current.time;
                    flag = true;
                    current.available = false;
                    vreme(arrTimeNum);
                    System.out.print(current.name + " - " + queue.poll() + " [");
                    if (arrTimeNum[0] < 10) {
                        System.out.print("0" + arrTimeNum[0] + ":");
                    } else {
                        System.out.print(arrTimeNum[0] + ":");
                    }
                    if (arrTimeNum[1] < 10) {
                        System.out.print("0" + arrTimeNum[1] + ":");
                    } else {
                        System.out.print(arrTimeNum[1] + ":");
                    }
                    if (arrTimeNum[2] < 10) {
                        System.out.print("0" + arrTimeNum[2] + "]");
                    } else {
                        System.out.print(arrTimeNum[2] + "]");
                    }
                    System.out.println();
                    break;
                }
            }

        }
    }
public static void vreme(int[] arrTimeNum){
            if (arrTimeNum[2] > 59) {
                arrTimeNum[1]+=arrTimeNum[2]/60;
                arrTimeNum[2] = arrTimeNum[2]%60;
            }
            if (arrTimeNum[1] > 59) {
                arrTimeNum[0]+=arrTimeNum[1]/60;
                arrTimeNum[1] = arrTimeNum[1]%60;
            }
            if (arrTimeNum[0] > 23) {
                while(arrTimeNum[0]>23){
                    arrTimeNum[0]=arrTimeNum[0]%24;
                }
            }
        }

}
