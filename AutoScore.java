public class autoScore
{
    private int xIndex = getXInputFromOperator();
    private int yIndex = getYInputFromOperator();
    private int[] currentAprilTags = new int[1];

    private final int[][] redSideAprilTagConfig = new int[][] {{3}, {3}, {3,2} {3,2}, {2}, {2,1}, {2,1}, {1}, [1]};
    private final int[][] blueSideAprilTagConfig = new int[][] {{8}, {8}, {8,7} {8,7}, {7}, {7,6}, {7,6}, {6}, [6]};
    private final int[] aprilTagOffset = new int[] {-4, -3, -2, -1, 0, 1, 2, 3, 4};

    enum placementState {
        Center, Move, FinalizeLocation, Extend, Place;
    }

    switch(placementState) {
        case Center:
            break;
        case Move:
            break;
        case FinalizeLocation
        
    }
}