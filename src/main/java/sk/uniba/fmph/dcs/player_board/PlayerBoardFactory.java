package sk.uniba.fmph.dcs.player_board;

import java.util.Map;

public final class PlayerBoardFactory {
    private PlayerBoardFactory() {
    }

    public static Map.Entry<PlayerBoard, PlayerBoardFacade> createPlayerBoard() {
        PlayerResourcesAndFood playerRF = new PlayerResourcesAndFood();
        PlayerFigures playerFig = new PlayerFigures();
        PlayerTools playerT = new PlayerTools();
        PlayerCivilisationCards playerCC = new PlayerCivilisationCards();
        TribeFedStatus tribeFedStatus = new TribeFedStatus(playerRF,playerFig);

        PlayerBoard board = new PlayerBoard(playerCC,playerT,tribeFedStatus,playerFig,playerRF);
        return Map.entry(board, new PlayerBoardFacade(board));
    }

}
