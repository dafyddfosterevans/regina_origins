/*
Entity class is defining the blueprint for the player, monsters and treasure. So anything which is 
present in the grid.
The class has the class variables x_pos and y_pos which defines the coordinates of the entity, i.e, (x,y)
For the class variable message is used to display the message according the the entity. For different monsters 
we will have different messages. When the treasure is found we will have different message.
We have created getX and getY functions which are the getter functions to get the coordinates accordingly.
printMessage() is used when the player faces the monsters or when player finds the treasure.
move() is used to update the coordinates.
*/
public abstract class Entity {

    protected int x_pos, y_pos;
    protected String message;

    public Entity(int x_pos, int y_pos, String message){
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        this.message = message;
    }
    
    public int getX(){
        return x_pos;
    }

    public int getY(){
        return y_pos;
    }

    public void printMessage(){
        System.out.println(message);
    }

    public void move(int new_x, int new_y){
        this.x_pos = new_x;
        this.y_pos = new_y;
    }

}
