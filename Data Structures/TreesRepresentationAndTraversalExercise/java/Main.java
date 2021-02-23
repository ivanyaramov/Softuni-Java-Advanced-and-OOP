public class Main {
    public static void main(String[] args) {
        int sum=0;
for(int i=0;i<=50;i++){
    int br=0;
    for(int k=0;k<=30;k++){
        for(int j=0;j<=20;j++){
            if(j+k==i){
                br++;
            }
        }
    }
    int cur=br*(121-i);
    sum+=cur;
}
        System.out.println(sum);
    }
}
