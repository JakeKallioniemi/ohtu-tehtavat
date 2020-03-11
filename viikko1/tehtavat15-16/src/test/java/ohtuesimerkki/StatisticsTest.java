package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void playerIsFound() {
        Player player = stats.search("Kurri");
        assertEquals("Kurri", player.getName());
    }
    
    @Test
    public void playerIsNotFound() {
        assertNull(stats.search("Aho"));
    }
    
    @Test
    public void allPlayersFromTeamFound() {       
        List<Player> players = stats.team("EDM");
        assertEquals("Semenko", players.get(0).getName());
        assertEquals("Kurri", players.get(1).getName());
        assertEquals("Gretzky", players.get(2).getName());
    }
    
    @Test
    public void correctAmountOfScorers() {
        assertEquals(3, stats.topScorers(3).size());
    }
    
    @Test
    public void topScorerIsFirts() {
        assertEquals("Gretzky", stats.topScorers(1).get(0).getName());
    }
}
