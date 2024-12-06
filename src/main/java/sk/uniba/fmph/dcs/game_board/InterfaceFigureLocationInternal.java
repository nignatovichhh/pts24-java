package sk.uniba.fmph.dcs.game_board;

import sk.uniba.fmph.dcs.stone_age.ActionResult;
import sk.uniba.fmph.dcs.stone_age.Effect;
import sk.uniba.fmph.dcs.stone_age.HasAction;

import java.util.Collection;

public interface InterfaceFigureLocationInternal {
    boolean placeFigures(Player player, int figureCount);
    HasAction tryToPlaceFigures(Player player, int count);
    ActionResult makeAction(Player player, Collection<Effect> inputResources,
                            Collection<Effect> outputResources);
    boolean skipAction(Player player); // returns true if player had his figures
                                        // on location which method withdrew
    HasAction tryToMakeAction(Player player);
    boolean newTurn(); //returns true if end of game is implied by
                        //given location
    String state();
}
