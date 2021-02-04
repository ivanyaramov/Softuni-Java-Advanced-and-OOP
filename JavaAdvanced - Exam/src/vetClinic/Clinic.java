package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private  List<Pet> data;
    private int capacity;

    public Clinic(int capacity){
        this.capacity=capacity;
        this.data=new ArrayList<>();
    }

    public List<Pet> getData() {
        return data;
    }



    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public  void add(Pet pet){
        this.data.add(pet);
    }
    public  boolean remove(String name){
        for(Pet pet:this.data){
            if(pet.getName().equals(name)){
                this.data.remove(pet);
                return true;
            }
        }
        return false;
    }
    public  Pet getPet(String name,String owner){
        for(Pet pet:this.data){
            if(pet.getName().equals(name)&&pet.getOwner().equals(owner)){
                return pet;
            }
        }
        return null;
    }
    public  Pet getOldestPet(){
        int max=-1;
        Pet finalPet=null;
        for(Pet pet: this.data){
            if(pet.getAge()>max){
                max=pet.getAge();
                finalPet=pet;
            }
        }
        return finalPet;
    }

    public int getCount(){
        return this.data.size();
    }
    public String getStatistics(){
        StringBuilder build=new StringBuilder();
        build.append("The clinic has the following patients:");



        for(Pet pet:this.data){
            build.append(System.lineSeparator());
            build.append(pet.getName());
            build.append(" ");
            build.append(pet.getOwner());



        }
        return build.toString();
    }

}
