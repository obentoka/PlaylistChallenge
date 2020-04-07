package io.zipcoder;

import java.util.Arrays;
import java.util.List;

public class Music {

    private List<String> playList;

    public Music(String[] playList){
        this.playList = Arrays.asList(playList);
    }

    public Integer selection(Integer startIndex, String selection){
        int distFirstFound = playList.indexOf(selection) - startIndex;
        int distLastFound = startIndex + playList.size() - playList.lastIndexOf(selection) % playList.size();
        return Math.min(distFirstFound, distLastFound);
    }
}
