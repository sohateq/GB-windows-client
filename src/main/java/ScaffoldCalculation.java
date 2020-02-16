import java.util.HashMap;
import java.util.Map;

public class ScaffoldCalculation {

    public void calculate (int height, int length, double squareMeterCost) {
        if (height%2 == 1) height++;
        if (length%3 == 2) length++;
        if (length%3 == 1) length--;
        int levelCount = height/2;
        int sectionCount = length/3;
        int liftCount = 1 + (length/30);
        int deckLevelCount = 1;
        if (levelCount - 1 > 0) deckLevelCount = levelCount - 1;
        int stairsFrameCount = (levelCount-1) * liftCount;

        int passFrameCount = levelCount * ((sectionCount + 1) - deckLevelCount) + deckLevelCount;

        int diagonalConnectionCount = ((height/3) * (length/2))/2;

        int horizontalConnectionCount = diagonalConnectionCount * 3;

        int crossbarCount = deckLevelCount * sectionCount * 2;

        int deckCount = sectionCount * deckLevelCount * 3;

        int supportsCount = (sectionCount + 1) * 2;

        double costPerDay = height * length * squareMeterCost;

    }

}
