import java.util.Scanner;

public class Main
{
    public static void Main()
    {
        int x = 0;
        int y = 0;
        String Command = "";
        Scanner Scanner1 = new Scanner(System.in);
        Grid currentGrid = new Grid();
        while(true)
        {
            System.out.println("========================================");
            System.out.println("Write x,y to input a coordinate");
            System.out.println("Write display to show the grid");
            System.out.println("Write end to end the game");
            System.out.println("========================================\n\n");
            
            System.out.println("Command: ");
            Command = Scanner1.nextLine();
            
            if(Command.equals("end"))
            {
                break;
            }
            if(Command.contains(","))
            {
                try
                {
                    String[] variables = Command.split(",");
                    String StringX = variables[0];
                    String StringY = variables[1];
                    x = Integer.parseInt(StringX);
                    y = Integer.parseInt(StringY);
                    System.out.println("You've inputted: " + x + ", " + y);
                    currentGrid.Shoot(x, y);
                }
                catch (NumberFormatException ex)
                {
                    System.out.println("Invalid input, you must input two integers x and y in the format x,y, neither bigger than 10\n");
                }
            }
            if(Command.equals("display"))
            {
                currentGrid.DisplayGrid();
            }
        }
    }
}
