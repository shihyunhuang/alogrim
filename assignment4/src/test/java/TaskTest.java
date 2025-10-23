import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TaskTest {
    static List<City> cities = new ArrayList<>();
    static Map<String, City> map = new HashMap<>();
    static Task t = new Task();

    // Include task2
    @BeforeAll
    static void setup(){
        String popFile  = "city_population.txt";
        String roadFile = "road_network.txt";

        // Read all cities and add to list
        try(BufferedReader br = new BufferedReader(new FileReader(popFile))) {
            String line;
            while((line = br.readLine()) != null){
                line = line.trim();
                String[] cop = line.split(":");
                City city = new City(cop[0].trim(), cop[1].trim());
                cities.add(city);
                map.put(cop[0].trim(), city);
            }
        }catch (IOException e) { System.out.println(e.getMessage());}
        // Read all connections and add into cities
        try(BufferedReader br2 = new BufferedReader(new FileReader(roadFile))) {
            String line;
            while((line = br2.readLine()) != null){
                line = line.trim();
                String[] twoCities = line.split(":");
                City city1 = map.get(twoCities[0].trim());
                City city2 = map.get(twoCities[1].trim());
                city1.addConnection(city2);
                city2.addConnection(city1);
            } 
        } catch (IOException e) { System.out.println(e.getMessage());}

    }
    @Test
    void testTask2(){
        try(PrintWriter pw = new PrintWriter("Graph.txt")){
            for(City c : cities) {pw.println(c);}
        }catch (IOException e) { System.out.println(e.getMessage());}
    }

    @Test
    void testTask3(){
        // Case 1: Connected cities are empty
        List<City> case1 = List.of(cities.get(12), cities.get(14));
        assertEquals(2, t.groupCities(case1));
        // Case 2: Create three islands
        City A = new City("A", "1");
        City B = new City("B", "1");
        City C = new City("C", "1");
        A.addConnection(B); B.addConnection(A);
        B.addConnection(C); C.addConnection(B);
        City D = new City("D", "1");
        City E = new City("E", "1");
        D.addConnection(E); E.addConnection(D);
        City F = new City("F", "1");

        List<City> case2 = List.of(A,B,C,D,E,F);
        assertEquals(3, t.groupCities(case2));
        // Case 3: 
        List<City> case3 = Arrays.asList(cities.get(253), cities.get(252), cities.get(250), cities.get(309), cities.get(251), cities.get(565));
        assertEquals(1, t.groupCities(case3));
    }

    @Test
    void testTask4(){
        // Case 1: Connected cities are empty
        List<City> case1 = Arrays.asList(cities.get(12), cities.get(14));
        List<Integer> populations1 = t.countPopulation(case1);
        System.out.println("Case 1:");
        for(int i = 1; i <= populations1.size(); i++){
            System.out.println("Islande " + i + ": " + populations1.get(i - 1));
        }
        // Case 2: Long list
        List<City> case2 = Arrays.asList(cities.get(253), cities.get(252), cities.get(250), cities.get(309), cities.get(251), cities.get(565));
        List<Integer> populations2 = t.countPopulation(case2);
        System.out.println("Case 2:");
        for(int i = 1; i <= populations2.size(); i++){
            System.out.println("Islande " + i + ": " + populations2.get(i - 1));
        }
    }

    @Test
    void testTask5(){
        // Case 1: Sample test
        City start = cities.get(0);
        City end = cities.get(783);
        assertEquals(2, t.minDistance(start, end));
        // Case 2
        end =  cities.get(312);
        assertEquals(3, t.minDistance(start, end));
        // Case 3: No connection
        end = cities.get(12);
        assertEquals(-1, t.minDistance(start, end));
    }
}
