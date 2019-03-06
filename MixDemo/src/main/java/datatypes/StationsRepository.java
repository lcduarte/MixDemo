package datatypes;

import java.util.List;

public class StationsRepository {

    private List<String> stations;

    public StationsRepository(List<String> stations){
        this.stations = stations;
    }

    public List<String> getStations(){
        return stations;
    }
    
}
