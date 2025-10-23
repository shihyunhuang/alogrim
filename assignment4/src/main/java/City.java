import java.util.ArrayList;
import java.util.List;

public class City {
    String name;
    String population;
    List<City> connectedCities;
    City(String n, String num){
        this.name = n;
        this.population = num;
        this.connectedCities = new ArrayList<>();
    }

    public void addConnection(City c){
        if(!connectedCities.contains(c)) connectedCities.add(c);
    }

    public String toString(){
        List<String> neighborNames = new ArrayList<>();
        for (City c : connectedCities) neighborNames.add(c.name); 
        return name + " (" + population + ") -> " + neighborNames;
    }
}
