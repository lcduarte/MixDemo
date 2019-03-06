import datatypes.IStationSearch;
import datatypes.SearchResponse;
import datatypes.StationsRepository;

import java.util.ArrayList;
import java.util.List;

public class StationSearch implements IStationSearch {

    private final List<String> stations;

    public StationSearch(StationsRepository repository){
        this.stations = repository.getStations();
    }

    public SearchResponse searchStations(final String searchQuery) {
        List<String> searchResult = new ArrayList<>();
        List<Character> nextCharList = new ArrayList<>();
        int searchQueryLength = searchQuery.length();

        for (String station: stations) {
            if (station.startsWith(searchQuery)){
                searchResult.add(station);

                if (searchQueryLength < station.length()){
                    nextCharList.add(station.charAt(searchQueryLength));
                }
            }
        }

        return new SearchResponse(nextCharList, searchResult);
    }

}
