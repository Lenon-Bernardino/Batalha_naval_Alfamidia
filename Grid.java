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
    public Grid()
    {
        for(int i = 0; i < 10; i++)
        {
            List<Integer> current_array = new ArrayList<>();
            GridArray.add(current_array);
            for(int j = 0; j < 10; j++)
            {
                int random_state = rn.nextInt(1 - 0 + 1) + 0;
                
                current_array.add(random_state);
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
    
    public void Shoot(int x, int y)
    {
        int position_xy = GridArray.get(x).get(y);
        if(position_xy == 0 || position_xy == 1)
        {
            GridArray.get(x).set(y, position_xy+2);
            DisplayGrid();
        }
        else
        {
            System.out.println("You've already shot at this coordinate!");
        }
    }
}