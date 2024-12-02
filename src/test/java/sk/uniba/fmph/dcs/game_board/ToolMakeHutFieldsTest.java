package sk.uniba.fmph.dcs.game_board;

import org.junit.Before;
import org.junit.Test;
import sk.uniba.fmph.dcs.stone_age.PlayerOrder;
import sk.uniba.fmph.dcs.player_board.PlayerBoardFacade;
import sk.uniba.fmph.dcs.stone_age.InterfacePlayerBoardGameBoard;

import static org.junit.Assert.*;

public class ToolMakeHutFieldsTest {
    private ToolMakerHutFields toolMakerHutFields;
    private Player mockPlayer1;
    private Player mockPlayer2;
    private InterfacePlayerBoardGameBoard mockPlayerBoard1;
    private InterfacePlayerBoardGameBoard mockPlayerBoard2;

    @Before
    public void setUp() {
        toolMakerHutFields = new ToolMakerHutFields(2);

        mockPlayerBoard1 = new PlayerBoardFacade();
        mockPlayer1 = new Player(new PlayerOrder(0, 2), mockPlayerBoard1);

        mockPlayerBoard2 = new PlayerBoardFacade();
        mockPlayer2 = new Player(new PlayerOrder(1, 2), mockPlayerBoard2);
    }

    @Test
    public void testCanPlaceOnToolMaker() {
        assertTrue(toolMakerHutFields.canPlaceOnToolMaker(mockPlayer1));
        assertTrue(toolMakerHutFields.canPlaceOnToolMaker(mockPlayer2));
    }

    @Test
    public void testPlaceOnToolMaker() {
        assertTrue(toolMakerHutFields.placeOnToolMaker(mockPlayer1));
        assertTrue(toolMakerHutFields.state().contains("Player on Tool Maker: 0"));
        assertFalse(mockPlayerBoard1.hasFigures(5));
    }

    @Test
    public void testCanActionToolMaker() {
        assertTrue(toolMakerHutFields.placeOnToolMaker(mockPlayer1));
        assertTrue(toolMakerHutFields.canActionOnToolMaker(mockPlayer1));
        assertFalse(mockPlayerBoard1.hasSufficientTools(1));
    }

    @Test
    public void testActionToolMaker() {
        toolMakerHutFields.placeOnToolMaker(mockPlayer1);
        assertTrue(toolMakerHutFields.actionToolMaker(mockPlayer1));
        assertTrue(mockPlayerBoard1.hasSufficientTools(1));
        assertFalse(mockPlayerBoard1.hasSufficientTools(2));
    }

    @Test
    public void testSkipActionToolMaker() {
        toolMakerHutFields.placeOnToolMaker(mockPlayer1);
        assertTrue(toolMakerHutFields.skipActionOnToolMaker(mockPlayer1));
        assertFalse(mockPlayerBoard1.hasSufficientTools(1));
    }

    @Test
    public void testCanPlaceOnHut() {
        assertTrue(toolMakerHutFields.canPlaceOnHut(mockPlayer1));
        assertTrue(toolMakerHutFields.canPlaceOnHut(mockPlayer2));
    }

    @Test
    public void testPlaceOnHut() {
        assertTrue(toolMakerHutFields.placeOnHut(mockPlayer1));
        assertTrue(toolMakerHutFields.state().contains("Player on Hut: 0"));
        assertFalse(mockPlayerBoard1.hasFigures(5));
    }

    @Test
    public void testCanActionHut() {
        assertTrue(toolMakerHutFields.placeOnHut(mockPlayer1));
        assertTrue(toolMakerHutFields.canActionOnHut(mockPlayer1));
    }

    @Test
    public void testActionHut() {
        toolMakerHutFields.placeOnHut(mockPlayer1);
        assertTrue(toolMakerHutFields.actionHut(mockPlayer1));
    }

    @Test
    public void testSkipActionHut() {
        toolMakerHutFields.placeOnHut(mockPlayer1);
        assertTrue(toolMakerHutFields.skipActionOnHut(mockPlayer1));
    }

    @Test
    public void testCanPlaceOnFields() {
        assertTrue(toolMakerHutFields.canPlaceOnFields(mockPlayer1));
        assertTrue(toolMakerHutFields.canPlaceOnFields(mockPlayer2));
    }

    @Test
    public void testPlaceOnFields() {
        assertTrue(toolMakerHutFields.placeOnFields(mockPlayer1));
        assertTrue(toolMakerHutFields.state().contains("Player on Fields: 0"));
        assertFalse(mockPlayerBoard1.hasFigures(5));
    }

    @Test
    public void testCanActionFields() {
        assertTrue(toolMakerHutFields.placeOnFields(mockPlayer1));
        assertTrue(toolMakerHutFields.canActionOnFields(mockPlayer1));

    }

    @Test
    public void testActionFields() {
        toolMakerHutFields.placeOnFields(mockPlayer1);
        assertTrue(toolMakerHutFields.actionFields(mockPlayer1));
    }

    @Test
    public void testSkipActionFields() {
        toolMakerHutFields.placeOnFields(mockPlayer1);
        assertTrue(toolMakerHutFields.skipActionOnFields(mockPlayer1));

    }

    @Test
    public void testRestrictions() {
        assertTrue(toolMakerHutFields.placeOnToolMaker(mockPlayer1));
        assertTrue(toolMakerHutFields.placeOnHut(mockPlayer1));

        assertFalse(toolMakerHutFields.canPlaceOnFields(mockPlayer2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidNumberOfPlayers() {
        new ToolMakerHutFields(5);
    }

}
