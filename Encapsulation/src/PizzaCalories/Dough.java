package PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;
    public Dough(String flourType,String bakingTechnique,double weight){
setFlourType(flourType);
setBakingTechnique(bakingTechnique);
setWeight(weight);
    }
    private void setWeight(double weight){
if(weight<1 || weight>200){
    throw new IllegalArgumentException("Dough weight should be in range [1..200]");
}
this.weight=weight;
    }
    private void setFlourType(String type){
        if(!type.equals("White")&&!type.equals("Wholegrain")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType=type;


    }
    private void setBakingTechnique(String tech){
        if(!tech.equals("Crispy")&&!tech.equals("Chewy")&&!tech.equals("Homemade")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique=tech;

    }
    public double calculateCalories(){
        double sum=2*this.weight;
        switch(this.flourType){
            case "White":sum*=1.5;break;
            case "Wholegrain":sum*=1;break;
        }
        switch(this.bakingTechnique){
            case "Crispy": sum*=0.9;break;
            case "Chewy": sum*=1.1;break;
        }

        return sum;
    }

}
