import com.isep.rpg.Dragon;
import com.isep.rpg.Game;
import com.isep.rpg.Warrior;
import java.io.PrintStream;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        new Game();
    }

    private static void showStatus(Warrior w, Dragon d) {
        PrintStream var10000 = System.out;
        String var10001 = w.getName();
        var10000.println(var10001 + ":" + w.getHealthPoints() + "\n" + d.getName() + ":" + d.getHealthPoints());
    }
}
