// monster class, will be used for inheritance, for creating different monsters
import java.util.Random;
public class Monster extends Entity{

    public Random random = new Random();

    private static String[] messages = {
        "Uh Oh, You've met a MONSTER :0 !!!\n",
        "AHHHHHHH, run for your life\n",
        "Yikes, you've distrubed the monster nest\n",
        "Watch out regina is coming to get you!!!!!\n",
        "Oh no, you've disturbed Donalds beauty sleep\n",
    };

    public Monster(int x_pos, int y_pos, String message){
        super(x_pos, y_pos, message);
        int random_message = random.nextInt(messages.length);
        this.message = messages[random_message];
    }

}