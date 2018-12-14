package gameOfLife;

import java.util.List;
 
public class World {
    private final int xSize;
    private final int ySize;
    private Cell[][] worldState;

    public World(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.worldState = new Cell[xSize][ySize];
    }

    public void intializeWorldState(List<CellState> seed) {
        for(int i = 0; i < xSize; i++){
            for(int j = 0; j < ySize; j++){
                worldState[i][j] = new Cell(seed.get((i*xSize)+j));
            }
        }
    }

    public Cell[][] getWorldState(){
        return worldState;
    }
}
