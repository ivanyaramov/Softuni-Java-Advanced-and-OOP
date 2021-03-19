package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Field[] fields=RichSoilLand.class.getDeclaredFields();
for(int i=0;i<100;i++){
	String line = scanner.nextLine();
	if(line.equals("HARVEST")){
		break;
	}
	if(line.equals("private")){
		for(Field field: fields){
			if(Modifier.isPrivate(field.getModifiers())){
				System.out.printf("%s %s %s%n",Modifier.toString(field.getModifiers()),field.getType().getSimpleName(),field.getName());
			}
		}
	}
	if(line.equals("protected")){
		for(Field field: fields){
			if(Modifier.isProtected(field.getModifiers())){
				System.out.printf("%s %s %s%n",Modifier.toString(field.getModifiers()),field.getType().getSimpleName(),field.getName());
			}
		}
	}
	if(line.equals("public")){
		for(Field field: fields){
			if(Modifier.isPublic(field.getModifiers())){
				System.out.printf("%s %s %s%n",Modifier.toString(field.getModifiers()),field.getType().getSimpleName(),field.getName());
			}
		}
	}
	if(line.equals("all")){
		for(Field field: fields){

				System.out.printf("%s %s %s%n",Modifier.toString(field.getModifiers()),field.getType().getSimpleName(),field.getName());

		}
	}



}
	}
}
