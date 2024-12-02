package sk.uniba.fmph.dcs.game_board;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.OptionalInt;
import org.junit.Test;

import sk.uniba.fmph.dcs.stone_age.Effect;

public class ArbitraryBuildingTest {
    @Test
    public void test_calculation() {
        ArrayList<Effect> buildingResources = new ArrayList<Effect>();

        ArbitraryBuilding building = new ArbitraryBuilding(7);

        assertEquals(building.build(buildingResources), OptionalInt.of(0));
        buildingResources.add(Effect.WOOD);
        assertEquals(building.build(buildingResources), OptionalInt.of(3));
        buildingResources.add(Effect.GOLD);
        assertEquals(building.build(buildingResources), OptionalInt.of(3 + 6));

        ArrayList<Effect> sevenResources = new ArrayList<Effect>();
        for (int i = 0; i < 7; i++) {
            sevenResources.add(Effect.STONE);
        }
        assertEquals(building.build(sevenResources), OptionalInt.of(7 * 5));
        sevenResources.add(Effect.STONE);
        assertEquals(building.build(sevenResources), OptionalInt.empty());
    }
}
