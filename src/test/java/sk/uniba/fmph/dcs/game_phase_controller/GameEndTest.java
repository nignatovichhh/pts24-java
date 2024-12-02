package test.java.sk.uniba.fmph.dcs.game_phase_controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sk.uniba.fmph.dcs.game_phase_controller.GameEnd;
import sk.uniba.fmph.dcs.stone_age.*;

public class GameEndTest {

    private GameEnd gameEnd;

    @BeforeEach
    void setUp() {
        gameEnd = new GameEnd();
    }

    @Test
    void testNoActionPossibleInGameEnd() {
        // Test that no action is possible in GameEnd state
        PlayerOrder mockPlayerOrder = mock(PlayerOrder.class);

        HasAction result = gameEnd.tryToMakeAutomaticAction(mockPlayerOrder);

        assertEquals(HasAction.NO_ACTION_POSSIBLE, result);
    }

    @Test
    void testAllMethodsReturnFailure() {
        // Test all methods in GameEnd return FAILURE
        PlayerOrder mockPlayerOrder = mock(PlayerOrder.class);
        assertEquals(ActionResult.FAILURE, gameEnd.placeFigures(mockPlayerOrder, Location.FOREST, 1));
        assertEquals(ActionResult.FAILURE, gameEnd.makeAction(mockPlayerOrder, Location.FOREST, null, null));
        assertEquals(ActionResult.FAILURE, gameEnd.skipAction(mockPlayerOrder, Location.FOREST));
        assertEquals(ActionResult.FAILURE, gameEnd.useTools(mockPlayerOrder, 0));
        assertEquals(ActionResult.FAILURE, gameEnd.noMoreToolsThisThrow(mockPlayerOrder));
        assertEquals(ActionResult.FAILURE, gameEnd.feedTribe(mockPlayerOrder, null));
        assertEquals(ActionResult.FAILURE, gameEnd.doNotFeedThisTurn(mockPlayerOrder));
        assertEquals(ActionResult.FAILURE, gameEnd.makeAllPlayersTakeARewardChoice(mockPlayerOrder, Effect.WOOD));
    }
}
