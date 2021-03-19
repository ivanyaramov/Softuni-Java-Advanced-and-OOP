package barracksWars;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Runnable;
import barracksWars.interfaces.UnitFactory;
import barracksWars.core.Engine;
import barracksWars.core.factories.UnitFactoryImpl;
import barracksWars.data.UnitRepository;
import jdk.jshell.spi.ExecutionControl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ExecutionControl.NotImplementedException {
        Scanner scanner = new Scanner(System.in);
        UnitRepository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl(repository);

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();

    }
}
