package test.java.sk.uniba.fmph.dcs.game_phase_controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sk.uniba.fmph.dcs.game_phase_controller.MakeActionState;
import sk.uniba.fmph.dcs.stone_age.*;
import java.util.ArrayList;

public class MakeActionStateTest {

    private MakeActionState makeActionState;
    private InterfaceFigureLocation mockLocationHandler;
    private PlayerOrder mockPlayerOrder;

    @BeforeEach
    void setUp() {
        mockLocationHandler = mock(InterfaceFigureLocation.class);
        mockPlayerOrder = mock(PlayerOrder.class);
        makeActionState = new MakeActionState(mockLocationHandler);
    }

    @Test
    void testSuccessfulMakeAction() {
        // Test successful execution of an action in MakeActionState
        when(mockLocationHandler.makeAction(mockPlayerOrder, new ArrayList<>(), new ArrayList<>()))
                .thenReturn(ActionResult.ACTION_DONE);

        ActionResult result = makeActionState.makeAction(mockPlayerOrder, Location.FOREST, new ArrayList<>(), new ArrayList<>());

        assertEquals(ActionResult.ACTION_DONE, result);
        verify(mockLocationHandler, times(1)).makeAction(mockPlayerOrder, new ArrayList<>(), new ArrayList<>());
    }

    @Test
    void testUnsuccessfulMakeAction() {
        // Test failed execution of an action in MakeActionState
        when(mockLocationHandler.makeAction(mockPlayerOrder, new ArrayList<>(), new ArrayList<>()))
                .thenReturn(ActionResult.FAILURE);

        ActionResult result = makeActionState.makeAction(mockPlayerOrder, Location.FOREST, new ArrayList<>(), new ArrayList<>());
        assertEquals(ActionResult.FAILURE, result);
    }

    @Test
    void testTryToMakeAutomaticAction() {
        // Test automatic action execution in MakeActionState
        when(mockLocationHandler.tryToMakeAction(mockPlayerOrder)).thenReturn(HasAction.AUTOMATIC_ACTION_DONE);

        HasAction result = makeActionState.tryToMakeAutomaticAction(mockPlayerOrder);

        assertEquals(HasAction.AUTOMATIC_ACTION_DONE, result);
        verify(mockLocationHandler, times(1)).tryToMakeAction(mockPlayerOrder);
    }

    @Test
    void testTryToMakeNoAutomaticAction() {
        // Test no automatic action possible in MakeActionState
        when(mockLocationHandler.tryToMakeAction(mockPlayerOrder)).thenReturn(HasAction.NO_ACTION_POSSIBLE);

        HasAction result = makeActionState.tryToMakeAutomaticAction(mockPlayerOrder);

        assertEquals(HasAction.NO_ACTION_POSSIBLE, result);
    }
}
