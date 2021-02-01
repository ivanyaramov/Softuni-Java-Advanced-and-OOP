package bankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<Integer,BankAccount> map=new HashMap<>();
        while(!line.equals("End")){
            String[] arrString=line.split(" ");
            String command=arrString[0];
            switch(command){
                case "Create":
                    BankAccount bankAccount=new BankAccount();
                    bankAccount.incrementID();
                    map.put(bankAccount.getId(),bankAccount);
                    break;
                case "Deposit":
                    int IDofPerson=Integer.parseInt(arrString[1]);
                    int amount=Integer.parseInt(arrString[2]);
                    if(!map.containsKey(IDofPerson)){
                        System.out.println("Account does not exist");
                    }
                    else{
                        map.get(IDofPerson).deposit(amount);
                        System.out.printf("Deposited %d to ID%d%n",amount,IDofPerson);
                    }
                    break;
                case "SetInterest" :
                    BankAccount.setInterestRate(Double.parseDouble(arrString[1]));
                    break;
                case "GetInterest":
                    int ID=Integer.parseInt(arrString[1]);
                    int period=Integer.parseInt(arrString[2]);
                    if(!map.containsKey(ID)){
                        System.out.println("Account does not exist");
                    }
                    else{
                        double interest=map.get(ID).getInterest(period);
                        System.out.printf("%.2f%n",interest);
                    }
                    break;
            }


            line=scanner.nextLine();
        }
    }
}
