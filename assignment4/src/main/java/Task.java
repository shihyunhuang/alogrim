import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Task {
    // Task 3
    // Group cities into islands
    public int groupCities(List<City> cities){
        Set<City> visited = new HashSet<>();
        int count = 0;
        for(City c: cities){
            if(!visited.contains(c)){
                count++;
                defineIsland(visited, c);
            }
        }
        return count;
    }
    // Recursive method: Add connectedCities into islands untilit's empty
    private void defineIsland(Set<City> set, City c){
        if(!set.contains(c)){
            set.add(c);
            if (c.connectedCities == null) return;
            for(City connected : c.connectedCities){
                defineIsland(set, connected);
            }
        }
    }

    // Task 4
    // Function to count populations
    public List<Integer> countPopulation(List<City> cities){
        Set<City> visited = new HashSet<>();
        List<Integer> pop = new ArrayList<>();
        for(City c: cities){
            if(!visited.contains(c)){
                int sum = islandPeople(visited, c);
                pop.add(sum);
            }
        }
        return pop;
    }
    // Add population in connected cities
    private int islandPeople(Set<City> set, City c){
        if (!set.add(c)) return 0;
        int sum = Integer.parseInt(c.population);
        if (c.connectedCities != null){
            for(City connected : c.connectedCities){
                sum += islandPeople(set, connected);
            }
        }        
        return sum;
    }

    // Task 5
    // Function to find minimum distance by BFS way 
    public int minDistance(City start, City goal){
        Queue<City> q = new LinkedList<>();
        Map<City, Integer> dist = new HashMap<>();
        q.add(start);
        dist.put(start, 0);

        while(!q.isEmpty()){
            City current = q.poll();
            int d = dist.get(current);
            for(City next : current.connectedCities){
                if (dist.containsKey(next)) continue;
                dist.put(next, d + 1);    
                if (next.equals(goal)) return d + 1; 
                q.add(next);  
            }
        }
        return -1;
    }
}
