package sk.uniba.fmph.dcs.game_board;

import sk.uniba.fmph.dcs.stone_age.InterfaceGetState;
import sk.uniba.fmph.dcs.stone_age.Location;

import java.util.Map;

public class GameBoard implements InterfaceGetState {

    private ToolMakerHutFields toolMakerHutFields;
    private Map<Location, ResourceSource> resourceSources;
    private CivilizationCardPlace cardPlace;
    private CivilizationCardDeck cardDeck;
    private RewardMenu rewardMenu;

    public GameBoard(ToolMakerHutFields toolMakerHutFields, Map<Location, ResourceSource> resourceSources,
                     CivilizationCardPlace cardPlace, CivilizationCardDeck cardDeck, RewardMenu rewardMenu) {
        this.toolMakerHutFields = toolMakerHutFields;
        this.resourceSources = resourceSources;
        this.cardPlace = cardPlace;
        this.cardDeck = cardDeck;
        this.rewardMenu = rewardMenu;
    }

    public String state() {
        StringBuilder boardState = new StringBuilder();
        boardState.append(toolMakerHutFields.state()).append("\n");
        for(ResourceSource resourceSource : resourceSources.values()) {
            boardState.append(resourceSource.state()).append("\n");
        }
        boardState.append(cardPlace.state()).append("\n");
        boardState.append(cardDeck.state()).append("\n");
        boardState.append(rewardMenu.state()).append("\n");
        
        return boardState.toString();
    }
}
