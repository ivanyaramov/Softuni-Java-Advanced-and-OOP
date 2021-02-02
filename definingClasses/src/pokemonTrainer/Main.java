package pokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Trainer> list = new ArrayList<>();
        String line = scanner.nextLine();
        while(!line.equals("Tournament")){
            String[] arr = line.split(" ");
            String trainerName=arr[0];
            String pokemonName=arr[1];
            String pokemonElement=arr[2];
            int pokemonHealth=Integer.parseInt(arr[3]);
            Pokemon pokemon =new Pokemon(pokemonName,pokemonElement,pokemonHealth);
            boolean hasTrainer=false;
            int index=-1;
            for(int i=0;i<list.size();i++){
                Trainer cur=list.get(i);
                if(cur.getName().equals(trainerName)){
                    hasTrainer=true;
                    index=i;
                    break;
                }
            }
            if(!hasTrainer){
                List<Pokemon> listofPokemons=new ArrayList<>();
                listofPokemons.add(pokemon);
                Trainer trainer=new Trainer(trainerName,0,listofPokemons);
                list.add(trainer);
            }
            else{
                list.get(index).getLisOfPokemons().add(pokemon);
            }
            line=scanner.nextLine();
        }

        line=scanner.nextLine();
        while(!line.equals("End")){
            for(Trainer trainer:list){
                boolean hasElement=false;
                for(Pokemon pokemon : trainer.getLisOfPokemons()){
                    if(pokemon.getElement().equals(line)){
                        hasElement=true;
                        break;
                    }
                }
                if(hasElement){
                    trainer.setNumberOfBadges(trainer.getNumberOfBadges()+1);
                }
                else{
                    for(int i=0;i<trainer.getLisOfPokemons().size();i++){

                        trainer.getLisOfPokemons().get(i).setHealth(trainer.getLisOfPokemons().get(i).getHealth()-10);
                        if(trainer.getLisOfPokemons().get(i).getHealth()<=0){
                            trainer.getLisOfPokemons().remove(i);
                            i--;
                        }
                    }
                }
            }


            line=scanner.nextLine();
        }

        list.stream()
                .sorted((p2,p1)->Integer.compare(p1.getNumberOfBadges(),p2.getNumberOfBadges()))
                .forEach(p->System.out.printf("%s %d %d%n",p.getName(),p.getNumberOfBadges(),p.getLisOfPokemons().size()));
    }
}
