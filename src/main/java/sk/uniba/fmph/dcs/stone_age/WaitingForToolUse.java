package sk.uniba.fmph.dcs.game_phase_controller;

import sk.uniba.fmph.dcs.stone_age.*;
import java.util.Collection;
public class WaitingForToolUse implements InterfaceGamePhaseState {
    private final InterfaceToolUse toolUseHandler;

    public WaitingForToolUse(InterfaceToolUse toolUseHandler) {
        this.toolUseHandler = toolUseHandler;
    }

    @Override
    public ActionResult useTools(PlayerOrder player, int toolIndex) {
        if (toolUseHandler.useTool(toolIndex)) {
            return ActionResult.ACTION_DONE;
        }
        return ActionResult.FAILURE;
    }

    @Override
    public HasAction tryToMakeAutomaticAction(PlayerOrder player) {
        if (toolUseHandler.canUseTools()) {
            return HasAction.WAITING_FOR_PLAYER_ACTION;
        }
        toolUseHandler.finishUsingTools();
        return HasAction.NO_ACTION_POSSIBLE;
    }

    // Остальные методы — FAILURE:
    @Override
    public ActionResult placeFigures(PlayerOrder player, Location location, int figuresCount) {
        return ActionResult.FAILURE;
    }

    @Override
    public ActionResult makeAction(PlayerOrder player, Location location, Collection<Effect> inputResources, Collection<Effect> outputResources) {
        return ActionResult.FAILURE;
    }

    @Override
    public ActionResult skipAction(PlayerOrder player, Location location) {
        return ActionResult.FAILURE;
    }

    @Override
    public ActionResult noMoreToolsThisThrow(PlayerOrder player) {
        return ActionResult.FAILURE;
    }

    @Override
    public ActionResult feedTribe(PlayerOrder player, Collection<Effect> resources) {
        return ActionResult.FAILURE;
    }

    @Override
    public ActionResult doNotFeedThisTurn(PlayerOrder player) {
        return ActionResult.FAILURE;
    }

    @Override
    public ActionResult makeAllPlayersTakeARewardChoice(PlayerOrder player, Effect reward) {
        return ActionResult.FAILURE;
    }
}
