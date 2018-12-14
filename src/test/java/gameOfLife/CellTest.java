package gameOfLife;

import org.junit.Test;

import static gameOfLife.CellState.ALIVE;
import static gameOfLife.CellState.DEAD;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class CellTest {

    @Test
    public void calculateNextState_fourAliveNeighbours_dies() {
        Cell cell = new Cell(ALIVE);

        assertThat(
                cell.calculateNextState(asList(
                        new Cell(ALIVE),
                        new Cell(ALIVE),
                        new Cell(ALIVE),
                        new Cell(ALIVE)
                ))
        ).isEqualTo(DEAD);
    }

    @Test
    public void calculateNextState_threeAlive_deadToAlive() {
        Cell cell = new Cell(DEAD);

        assertThat(
                cell.calculateNextState(asList(
                        new Cell(ALIVE),
                        new Cell(ALIVE),
                        new Cell(ALIVE)
                ))
        ).isEqualTo(ALIVE);
    }

    @Test
    public void calculateNextState_twoAlive_deadDoesNotChange() {
        Cell cell = new Cell(DEAD);

        assertThat(
                cell.calculateNextState(asList(
                        new Cell(ALIVE),
                        new Cell(ALIVE)
                ))
        ).isEqualTo(DEAD);
    }

    @Test
    public void calculateNextState_twoAlive_aliveDoesNotChange() {
        Cell cell = new Cell(ALIVE);

        assertThat(
                cell.calculateNextState(asList(
                        new Cell(ALIVE),
                        new Cell(ALIVE)
                ))
        ).isEqualTo(ALIVE);
    }

    @Test
    public void calculateNextState_lessThanTwoAlive_dead() {
        Cell cell = new Cell(ALIVE);

        assertThat(
                cell.calculateNextState(asList(
                        new Cell(ALIVE),
                        new Cell(DEAD),
                        new Cell(DEAD),
                        new Cell(DEAD),
                        new Cell(DEAD)
                ))
        ).isEqualTo(DEAD);
    }

}
