public class autoScore {

    public static void main(String[] args) {

    }

    public void scoreLogic()
    {
        int xIndex = getXInputFromOperator();
        int yIndex = getYInputFromOperator();
        int[] currentAprilTags = new int[1];
    
        final int[][] redSideAprilTagConfig = new int[][] {{3}, {3}, {3,2}, {3,2}, {2}, {2,1}, {2,1}, {1}, {1}};
        final int[][] blueSideAprilTagConfig = new int[][] {{8}, {8}, {8,7}, {8,7}, {7}, {7,6}, {7,6}, {6}, {6}};
        final int[] aprilTagOffset = new int[] {-4, -3, -2, -1, 0, 1, 2, 3, 4};
    
        boolean isCentered = false;
        boolean translationCompleted = false;
        boolean vAlignCompleted = false;
        boolean centerIsFinalized = false;
        boolean isExtended = false;
        boolean isPlaced = false;

        enum PlacementState {
            NoTask, Center, TranslateAndVerticalAlign, FinalizeLocation, Extend, Place;
        }

        PlacementState currentState = PlacementState.NoTask;
    
        if (seeAprilTags())
            currentState = PlacementState.Center;
        if (isCentered)
            currentState = PlacementState.TranslateAndVerticalAlign;
        if (translationCompleted && vAlignCompleted)
            currentState = PlacementState.FinalizeLocation;
        if (centerIsFinalized)
            currentState = PlacementState.Extend;
        if (isExtended)
            currentState = PlacementState.Place;
        else 
        {
            currentState = PlacementState.NoTask;
        }
        

        switch(currentState) {
            case NoTask:
                //simply give control to the driver
                break;
            case Center:
                //check if the tolerance is good then set bool to true and return
                break;
            case TranslateAndVerticalAlign:
                //check if both the translate and valign are in tolerance, then set bool to true and return
                break;
            case FinalizeLocation:
                //check if the april tag offset is correct then set bool to true and return
                break;
            case Extend:
                //check if tolerance is correct then set bool to true and return
                break;
            case Place:
                //place than give control back to driver (switch to NoTask)
                break;
        }
    }
}
