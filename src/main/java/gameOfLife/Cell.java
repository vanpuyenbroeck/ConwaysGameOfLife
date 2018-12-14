package gameOfLife;

import java.util.Collection;
import java.util.stream.Collectors;

import static gameOfLife.CellState.ALIVE;
import static gameOfLife.CellState.DEAD;

public class Cell {

    private CellState state;

    public Cell(CellState state) {
        this.state = state;
    }

    public CellState calculateNextState(Collection<Cell> neighbours) {
        int amountOfAliveNeighbours = countAliveNeighbours(neighbours);
        if (amountOfAliveNeighbours == 3) {
            return ALIVE;
        }
        if (amountOfAliveNeighbours == 2) {
            return this.state;
        }
        return DEAD;
    }

    private int countAliveNeighbours(Collection<Cell> neighbours) {
        return neighbours.stream()
                .map(cell -> cell.state)
                .filter(cellState -> (cellState == ALIVE))
                .collect(Collectors.toList())
                .size();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cell) {
            return state == ((Cell) obj).state;
        }
        return super.equals(obj);
    }

}
