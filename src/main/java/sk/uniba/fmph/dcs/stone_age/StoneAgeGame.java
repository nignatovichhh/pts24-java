package sk.uniba.fmph.dcs.stone_age;

import sk.uniba.fmph.dcs.game_phase_controller.GamePhaseController;

import java.util.Map;
import java.util.Collection;

public class StoneAgeGame implements InterfaceStoneAgeGame, InterfaceGetState {
    private final Map<PlayerOrder, Integer> players;
    private final GamePhaseController gamePhaseController;

    public StoneAgeGame(Map<PlayerOrder, Integer> players, GamePhaseController gamePhaseController) {
        this.players = players;
        this.gamePhaseController = gamePhaseController;
    }

    @Override
    public boolean placeFigures(int playerId, Location location, int figuresCount) {
        return gamePhaseController.placeFigures(getPlayerOrder(playerId), location, figuresCount);
    }

    @Override
    public boolean makeAction(int playerId, Location location, Collection<Effect> usedResources, Collection<Effect> desiredResources) {
        return gamePhaseController.makeAction(getPlayerOrder(playerId), location, usedResources, desiredResources);
    }

    @Override
    public boolean skipAction(int playerId, Location location) {
        return gamePhaseController.skipAction(getPlayerOrder(playerId), location);
    }

    @Override
    public boolean useTools(int playerId, int toolIndex) {
        return gamePhaseController.useTools(getPlayerOrder(playerId), toolIndex);
    }

    @Override
    public boolean noMoreToolsThisThrow(int playerId) {
        return gamePhaseController.noMoreToolsThisThrow(getPlayerOrder(playerId));
    }

    @Override
    public boolean feedTribe(int playerId, Collection<Effect> resources) {
        return gamePhaseController.feedTribe(getPlayerOrder(playerId), resources);
    }

    @Override
    public boolean doNotFeedThisTurn(int playerId) {
        return gamePhaseController.doNotFeedThisTurn(getPlayerOrder(playerId));
    }

    @Override
    public boolean makeAllPlayersTakeARewardChoice(int playerId, Effect reward) {
        return gamePhaseController.makeAllPlayersTakeARewardChoice(getPlayerOrder(playerId), reward);
    }

    @Override
    public String state() {
        return gamePhaseController.state();
    }

    private PlayerOrder getPlayerOrder(int playerId) {
        for (PlayerOrder order : players.keySet()) {
            if (players.get(order) == playerId) {
                return order;
            }
        }
        throw new IllegalArgumentException("Invalid player ID: " + playerId);
    }
}
