// Game.java will be the main class, i.e, it will have main function.
import java.util.Scanner;
import java.util.Random;

public class Game{
    
    private static int size;
    public static Scanner sc = new Scanner(System.in);
    public static Random random = new Random();
    private static Entity[][] grid;
    private static Player p;
    private static Treasure t;
    
    public static void main(String[] args){

        startScreen();
        populateGrid();
        sc.nextLine();

        while (true){
            System.out.println("Distance to treasure = " + p.distanceToTreasure(t) + "\n");
            boolean gameContinues = gamePlayerMovement();
            if(!gameContinues){
                break;
            }
        }
    }

    // Function for welcoming the player and setting the grid size
    private static void startScreen(){
        
        System.out.println("Welcome to Regina Origins!\n");
        System.out.println("Please enter the size of the grid: ");
        size = sc.nextInt(); // scans for input of grid size
        System.out.println("\nIn this game you need to find the treasure (donut) while avoiding the monster\n");    
    
    }


    // the return type needs to determined 
    public static boolean gamePlayerMovement() {
        // getting player coordinates
        int tempX;
        int tempY;
        while (true){
            tempX = p.getX();
            tempY= p.getY();
            boolean moved = true;
            System.out.println("Enter your move : R - right, L - left , U - Up or D - Down");
            String movement = sc.nextLine().toLowerCase();   // Inputs the players movement     
            switch(movement) // use switch statement to update the temporary coordinates with users input
            {
                case "r" : tempX++; 
                            break;
                case "l" : tempX--;
                            break;
                case "u" : tempY++;
                            break;
                case "d" : tempY--;
                            break;
                default : moved = false;
                            break;
            }
            // use if statement to check temporary coordinates are still within the defined grid size 
            if(tempX >= size || tempY >= size || tempX < 0 || tempY < 0 || !moved) {
                System.out.println("\nNot a valid movement, please try again!\n");  // if temporary coordinates are not in grid the while loop restarts and asks for input again       
            } else{
                break; // if temporary coordinates are within grid break out of the while loop
            }

        }

        // once position in grid confirmed update the values of player position
        if (grid[tempX][tempY] == null){
            int oldX = p.getX();
            int oldY = p.getY();
            grid[oldX][oldY] = null; // clear old position
            grid[tempX][tempY] = p; // Update new position
            p.move(tempX, tempY);
            return true;
        } else{
            grid[tempX][tempY].printMessage();
            return false;
        }

    }
    
    // Function for populating the grid with player, monsters and treasure
    public static void populateGrid(){
        
        grid = new Entity[size][size];

        // assigining the player coordinates
        int rand_x = random.nextInt(size); //random number generator (0- size)
        int rand_y = random.nextInt(size); //random number generator (0- size)
        p = new Player(rand_x, rand_y, "");
        grid[rand_x][rand_y] = p;

        // assigining the treasure coordinates
        while (true){
            rand_x = random.nextInt(size); //random number generator (0- size)
            rand_y = random.nextInt(size); //random number generator (0- size)
            if (grid[rand_x][rand_y] == null){
                t = new Treasure(rand_x, rand_y, "You found me!");
                grid[rand_x][rand_y] = t;
                break;
            }
        }

        int noOfMonsters = (int) Math.ceil((size * size) / 10);

        for (int i = 0; i < noOfMonsters;){
            rand_x = random.nextInt(size); //random number generator (0- size)
            rand_y = random.nextInt(size); //random number generator (0- size)
            if (grid[rand_x][rand_y] == null){
                grid[rand_x][rand_y] = new Monster(rand_x, rand_y, "Regina found you! You're dead!");
                i++;
            }
        }
        
    }

}