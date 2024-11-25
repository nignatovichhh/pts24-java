package sk.uniba.fmph.dcs.game_board;

import sk.uniba.fmph.dcs.stone_age.Effect;

import java.util.Collection;
import java.util.OptionalInt;

public class ArbitraryBuilding implements Building {

    public ArbitraryBuilding() {
    }

    @Override
    public OptionalInt build(Collection<Effect> resources) {
        if (resources.size() > 7) {
            return OptionalInt.empty();
        }
        int ret = 0;
        for (Effect resource : resources) {
            ret += resource.points();
        }
        return OptionalInt.of(ret);
    }
}
