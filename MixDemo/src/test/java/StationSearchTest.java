import datatypes.SearchResponse;
import datatypes.StationsRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StationSearchTest {

    @Test
    public void testScenario1(){
        List<String> stations = new ArrayList<>();
        stations.add("DARTFORD");
        stations.add("DARTMOUTH");
        stations.add("TOWER HILL");
        stations.add("DERBY");

        StationSearch stationSearch = new StationSearch(new StationsRepository(stations));

        SearchResponse response = stationSearch.searchStations("DART");

        List<Character> suggestionChars = response.getSuggestionChars();
        List<String> responseStations = response.getMatchingStations();

        Assert.assertEquals(2, suggestionChars.size());
        Assert.assertEquals(2, responseStations.size());

        Assert.assertEquals('F', suggestionChars.get(0).charValue());
        Assert.assertEquals( 'M', suggestionChars.get(1).charValue());

        Assert.assertEquals("DARTFORD", responseStations.get(0));
        Assert.assertEquals("DARTMOUTH", responseStations.get(1));
    }

    @Test
    public void testScenario2(){
        List<String> stations = new ArrayList<>();
        stations.add("LIVERPOOL");
        stations.add("LIVERPOOL LIME STREET");
        stations.add("PADDINGTON");

        StationSearch stationSearch = new StationSearch(new StationsRepository(stations));

        SearchResponse response = stationSearch.searchStations("LIVERPOOL");

        List<Character> suggestionChars = response.getSuggestionChars();
        List<String> responseStations = response.getMatchingStations();

        Assert.assertEquals(1, suggestionChars.size());
        Assert.assertEquals(2, responseStations.size());

        Assert.assertEquals(' ', suggestionChars.get(0).charValue());

        Assert.assertEquals("LIVERPOOL", responseStations.get(0));
        Assert.assertEquals("LIVERPOOL LIME STREET", responseStations.get(1));
    }

    @Test
    public void testScenario3(){
        List<String> stations = new ArrayList<>();
        stations.add("EUSTON");
        stations.add("LONDON BRIDGE");
        stations.add("VICTORIA");

        StationSearch stationSearch = new StationSearch(new StationsRepository(stations));

        SearchResponse response = stationSearch.searchStations("KINGS CROSS");

        List<Character> suggestionChars = response.getSuggestionChars();
        List<String> responseStations = response.getMatchingStations();

        Assert.assertEquals(0, suggestionChars.size());
        Assert.assertEquals(0, responseStations.size());
    }

}
