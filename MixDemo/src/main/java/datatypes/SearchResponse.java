package datatypes;

import java.util.List;

public class SearchResponse {

    private List<Character> suggestionChars;
    private List<String> matchingStations;

    public SearchResponse(List<Character> suggestionChars, List<String> matchingStations){
        this.suggestionChars = suggestionChars;
        this.matchingStations = matchingStations;
    }

    public List<Character> getSuggestionChars() {
        return suggestionChars;
    }

    public List<String> getMatchingStations() {
        return matchingStations;
    }

}
