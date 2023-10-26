// This class contains all the properties of the donut!
import java.util.Random;

public class Treasure extends Entity{

    public Random random = new Random();

    private static String[] messages = {
        "Congratulations! You found a Donut\n",
        "Congratulations! You found a Deep fried Pizza\n",
        "Congratulations! You found a Deep fried Mars Bar\n",
        "Congratulations! You found fries!\n"
    };

    public Treasure(int x_pos, int y_pos, String message){
        super(x_pos, y_pos, message);
        int random_message = random.nextInt(messages.length);
        this.message = messages[random_message];
    }

}
