import java.util.*;

public class wrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int[][]arr=new int[a][];
        for(int i=0;i<a;i++){
            arr[i]=readArray(scanner.nextLine());
        }
        int[] arrFalse=readArray(scanner.nextLine());
        int element=arr[arrFalse[0]][arrFalse[1]];
        Map<Integer, List<Integer>>map=new LinkedHashMap<>();
        for(int i=0;i<a;i++){
            for(int k=0;k<arr[i].length;k++){
                if(arr[i][k]==element){
                    if(map.get(i)==null){
                        List<Integer> list=new ArrayList<>();
                        list.add(k);
                        map.put(i,list);
                    }
                    else{
                        map.get(i).add(k);
                    }
                }
            }
        }
        for(int i=0;i<a;i++){
            for(int k=0;k<arr[i].length;k++){
                if(arr[i][k]==element){
                    arr[i][k]=replacement(i,k,arr,element,map);
                }
            }
        }
        for(int i=0;i<a;i++){
            for(int k=0;k<arr[i].length;k++){
                System.out.print(arr[i][k]+" ");
            }
            System.out.println();
        }
    }
    public static int[] readArray(String s){

        String[] arrString= s.split(" ");
        int[] arr=new int[arrString.length];
        for(int i=0;i<arrString.length;i++){
            arr[i]=Integer.parseInt(arrString[i]);
        }
        return arr;
    }
    public static int replacement(int i,int k,int[][] arr,int element,Map<Integer,List<Integer>> map){
        int sum=0;
        if(i!=0 && isValid(i-1,k,map)){

                sum+=arr[i-1][k];
        }
        if(i!=arr.length-1 && isValid(i+1,k,map)){

                sum += arr[i + 1][k];
            }

        if(k!=0&& isValid(i,k-1,map)){

            sum+=arr[i][k-1];
        }
        if(k!=arr[i].length-1&&isValid(i,k+1,map)){

                sum += arr[i][k + 1];

        }
        return sum;
    }

public static boolean isValid(int i,int k,Map<Integer,List<Integer>> map){
        if(!map.containsKey(i)){
            return true;
        }
        else{
            if(!map.get(i).contains(k)){
                return true;
            }
        }
        return false;
}
}
