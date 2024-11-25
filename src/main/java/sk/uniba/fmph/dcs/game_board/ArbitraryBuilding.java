package sk.uniba.fmph.dcs.game_board;

import sk.uniba.fmph.dcs.stone_age.Effect;

import java.util.Collection;
import java.util.OptionalInt;

public class ArbitraryBuilding implements Building {

    private final int maxNumberOfResources;

    public ArbitraryBuilding(int maxNumberOfResources) {
        this.maxNumberOfResources = maxNumberOfResources;
    }

    @Override
    public OptionalInt build(Collection<Effect> resources) {
        if (resources.size() > maxNumberOfResources) {
            return OptionalInt.empty();
        }
        int ret = 0;
        for (Effect resource : resources) {
            ret += resource.points();
        }
        return OptionalInt.of(ret);
    }
}
