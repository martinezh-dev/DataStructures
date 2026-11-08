import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Maze
{
    private MazeSquare[][] maze;

    Maze()
    {
        maze = null;
    }

    public boolean loadMaze(String fName) throws FileNotFoundException
    {
        File myFile = new File(fName);
        Scanner scan = new Scanner(myFile);

        String curLine;

        if(scan.hasNext())
        {
            int rows = Integer.parseInt(scan.next());
            int cols = Integer.parseInt(scan.next());
            maze = new MazeSquare[rows][cols];
            scan.nextLine();
        }
        else
        {
            return false;
        }

        int row = 0;
        while(scan.hasNext())
        {
            curLine = scan.nextLine();
            String[] parts = curLine.split(" ");
            for(int i = 0; i < parts.length; i++)
            {
                maze[row][i] = new MazeSquare(row, i, Integer.parseInt(parts[i]));
            }
            row++;
        }
        return true;
    }

    public ArrayList<MazeSquare> getNeighbors(MazeSquare sq)
    {
        int row = sq.getRow();
        int col = sq.getCol();

        
    }

    public String toString()
    {
        String ret = "";
        for(MazeSquare[] r : maze)
        {
            ret += "[";
            for(MazeSquare s : r)
            {
                ret += s + ", ";
            }
            ret += "]\n";
        }

        return ret;
    }
}