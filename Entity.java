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
