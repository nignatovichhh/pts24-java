package sk.uniba.fmph.dcs.game_board;

import org.junit.Test;
import sk.uniba.fmph.dcs.stone_age.Effect;

import java.util.ArrayList;
import java.util.OptionalInt;

import static org.junit.Assert.assertEquals;

public class VariableBuildingTest {

    @Test
    public void test_calculation() {
        ArrayList<Effect> buildingResources = new ArrayList<Effect>();

        VariableBuilding building = new VariableBuilding(4, 2);

        assertEquals(building.build(buildingResources), OptionalInt.empty());
        buildingResources.add(Effect.WOOD);
        assertEquals(building.build(buildingResources), OptionalInt.empty());
        buildingResources.add(Effect.WOOD);
        buildingResources.add(Effect.WOOD);
        buildingResources.add(Effect.GOLD);
        assertEquals(building.build(buildingResources), OptionalInt.of(3 * 3 + 6));
        buildingResources.add(Effect.GOLD);
        assertEquals(building.build(buildingResources), OptionalInt.empty());

        ArrayList<Effect> differentResources = new ArrayList<Effect>();
        differentResources.add(Effect.WOOD);
        differentResources.add(Effect.CLAY);
        differentResources.add(Effect.STONE);
        differentResources.add(Effect.GOLD);
        assertEquals(building.build(differentResources), OptionalInt.empty());
    }

}
