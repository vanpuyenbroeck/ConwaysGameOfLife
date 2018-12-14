package gameOfLife;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static gameOfLife.CellState.ALIVE;
import static gameOfLife.CellState.DEAD;

public class WorldTest {
    @Test
    public void intializeWorldState() {
        List<CellState> testSeed = Arrays.asList(ALIVE, ALIVE, ALIVE, DEAD);
        World world = new World(2, 2);
        world.intializeWorldState(testSeed);

        Assertions.assertThat(world.getWorldState())
                .isEqualTo(new Cell[][]{
                        new Cell[]{new Cell(ALIVE), new Cell(ALIVE)},
                        new Cell[]{new Cell(ALIVE), new Cell(DEAD)}
                });
    }
}
