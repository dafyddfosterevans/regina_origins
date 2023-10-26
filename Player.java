// the player class which will store the player position
import java.lang.Math;

public class Player extends Entity{

    public Player(int x_pos, int y_pos, String message){
        super(x_pos, y_pos, message);
    }

    public double distanceToTreasure(Treasure t){
        int t_x_pos = t.getX();
        int t_y_pos = t.getY();

        return Math.sqrt((t_x_pos - x_pos) * (t_x_pos - x_pos) + (t_y_pos - y_pos) * (t_y_pos - y_pos ));
    }

    // function to determine the moves to reach the treasure
    public int movesToTreasure(Treasure t)
    {
        int t_x_pos=t.getX();
        int t_y_pos=t.getY();

        int numOfMoves= Math.abs(x_pos-t_x_pos)+ Math.abs(y_pos-t_y_pos);
        return numOfMoves;
    }

}
