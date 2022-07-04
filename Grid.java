import java.util.List;
import java.util.ArrayList;
import java.util.Random;

// Grid syntax:
// 0 = Undiscovered territory, without enemies = .
// 1 = Undiscovered territory, with enemy = .
// 2 = Shot territory, without enemy = X
// 3 = Shot territory, with enemy = *

public class Grid
{
    private List<List<Integer>> GridArray = new ArrayList<>();
    Random rn = new Random();
    private int enemies_left = 0;
    
    public Grid()
    {
        for(int i = 0; i < 10; i++)
        {
            List<Integer> current_array = new ArrayList<>();
            GridArray.add(current_array);
            for(int j = 0; j < 10; j++)
            {
                int random_state = rn.nextInt(20 - 0 + 20) + 0;
                
                if(random_state == 2)
                {
                    current_array.add(1);
                }
                else
                {
                    current_array.add(0);
                }
                
                if(random_state == 1)
                {
                    enemies_left += 1;
                }
            }
        }
    }
    
    public void DisplayGrid()
    {
        System.out.println("Displaying grid:");
        
        for(List<Integer> line : GridArray)
        {
            for(int thisPosition : line)
            {
                if(thisPosition == 0 || thisPosition == 1)
                {
                    System.out.print(". ");
                }
                if(thisPosition == 2)
                {
                    System.out.print("X ");
                }
                if(thisPosition == 3)
                {
                    System.out.print("* ");
                }
            }
            System.out.print("\n");
        }
    }
    
    public double ClosestDistance(int x, int y)
    {
        double shortest_distance = 99999;
        
        for(int i = 0; i < GridArray.size(); i++)
        {
            for(int j = 0; j < GridArray.get(i).size(); j++)
            {
                int positionValue = GridArray.get(i).get(j);
                
                if(positionValue == 1)
                {
                    double distance = Math.sqrt(Math.pow(i + x, 2) + Math.pow(j + y, 2));
                    if(distance < shortest_distance)
                    {
                        shortest_distance = distance;
                    }
                }
            }
        }
        
        return shortest_distance;
    }
    
    public void Shoot(int x, int y)
    {
        int position_xy = GridArray.get(x).get(y);
        if(position_xy == 0 || position_xy == 1)
        {
            if(position_xy == 1)
            {
                enemies_left -= 1;
            }
            System.out.println("There are " + enemies_left + " enemies left to die.");
            System.out.println("You are " + ClosestDistance(x, y) + " positions away from an enemy");
            GridArray.get(x).set(y, position_xy+2);
            DisplayGrid();
            
            if(enemies_left == 0)
            {
                System.out.print("\n\n\n\n==========================================\n");
                System.out.print("You've won the game!!!!\n");
                System.out.print("==========================================");
                System.exit(0);
            }
        }
        else
        {
            System.out.println("You've already shot at this coordinate!");
            DisplayGrid();
        }
    }
}