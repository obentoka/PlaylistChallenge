package io.zipcoder;

public class Music {

    private String[] playList;

    public Music(String[] playList){
        this.playList = playList;
    }

    public Integer selection(Integer startIndex, String selection){
        int leastButtonPressed = 0;
        int firstSelectionIndex = 0;
        int secondSelectionIndex = 0;
        int distanceFromFristIndex = 0;
        int distanceFromSencondIndex = 0;
        boolean isFirstTimeSelection = true;

        for (int i = 0; i < playList.length; i++) {
            if(playList[i].equals(selection) && isFirstTimeSelection){
                isFirstTimeSelection = false;
                firstSelectionIndex = i;
            } else if(playList[i].equals(selection) && !isFirstTimeSelection){
                secondSelectionIndex = i;
            }
        }
        System.out.println(isFirstTimeSelection + " " +secondSelectionIndex);
        if(!isFirstTimeSelection && secondSelectionIndex != 0){
            firstSelectionIndex = firstSelectionIndex % (playList.length -1);
            secondSelectionIndex = secondSelectionIndex % (playList.length -1);
            distanceFromFristIndex = firstSelectionIndex - startIndex;

            if(secondSelectionIndex == 0){
                distanceFromSencondIndex = startIndex - secondSelectionIndex + 1;
            }else {
                distanceFromSencondIndex = secondSelectionIndex - startIndex;
            }

            if(distanceFromFristIndex < distanceFromSencondIndex){
                leastButtonPressed = distanceFromFristIndex;
            }else {
                leastButtonPressed = distanceFromSencondIndex;
            }
        }else {
            leastButtonPressed = firstSelectionIndex - startIndex;
            if(firstSelectionIndex == 0 && (startIndex - firstSelectionIndex) < leastButtonPressed){
                leastButtonPressed = startIndex - firstSelectionIndex;
            }
        }
        return leastButtonPressed;
    }
}
