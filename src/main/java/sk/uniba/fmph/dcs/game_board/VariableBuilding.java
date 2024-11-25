package sk.uniba.fmph.dcs.game_board;

import sk.uniba.fmph.dcs.stone_age.Effect;

import java.util.Collection;
import java.util.HashSet;
import java.util.OptionalInt;
import java.util.Set;

public class VariableBuilding implements Building {

    private final int numberOfResources;
    private final int numberOfResourceTypes;

    public VariableBuilding(int numberOfResources, int numberOfResourceTypes) {
        this.numberOfResources = numberOfResources;
        this.numberOfResourceTypes = numberOfResourceTypes;
    }

    private int numberOfUniqueResources(Collection<Effect> resources) {
        return new HashSet<Effect>(resources).size();
    }

    @Override
    public OptionalInt build(Collection<Effect> resources) {
        if (resources.size() != numberOfResources || numberOfUniqueResources(resources) != numberOfResourceTypes) {
            return OptionalInt.empty();
        }
        int ret = 0;
        for (Effect resource : resources) {
            ret += resource.points();
        }
        return OptionalInt.of(ret);
    }
}
