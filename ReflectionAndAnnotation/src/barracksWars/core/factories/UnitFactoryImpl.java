package barracksWars.core.factories;

import barracksWars.data.UnitRepository;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import barracksWars.models.units.AbstractUnit;
import barracksWars.models.units.Archer;
import jdk.jshell.spi.ExecutionControl;

public class UnitFactoryImpl implements UnitFactory {
	UnitRepository repository;
	public UnitFactoryImpl(UnitRepository repository) {
		this.repository=repository;
	}

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
		// TODO: implement for problem 3
		this.repository.addUnit(unitType);
		return null;
	}
}
