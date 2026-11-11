import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Maze
{
    private MazeSquare[][] maze;

    private MazeSquare start, finish;

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
                if(Integer.parseInt(parts[i]) == 2)
                {
                    start = maze[row][i];
                }
                if(Integer.parseInt(parts[i]) == 3)
                {
                    finish = maze[row][i];
                }
            }
            row++;
        }
        scan.close();
        return true;
    }


    public ArrayList<MazeSquare> getNeighbors(MazeSquare sq)
    {
        int row = sq.getRow();
        int col = sq.getCol();
        ArrayList<MazeSquare> ret = new ArrayList<MazeSquare>();

        if(row - 1 >= 0)
        {
            ret.add(maze[row - 1][col]);
        }        
        if(row + 1 < maze.length)
        {
            ret.add(maze[row + 1][col]);
        }

        if(col -1 >= 0)
        {
            ret.add(maze[row][col - 1]);
        }
        if(col + 1 < maze[0].length)
        {
            ret.add(maze[row][col+1]);
        }
        return ret;
    }

    public MazeSquare getSquare(int row, int col)
    {
        return maze[row][col];
    }

    public void reset()
    {
        for(MazeSquare[] row : maze)
        {
            for(MazeSquare square : row)
            {
                square.reset();
            }
        }
    }

    public MazeSquare getStart()
    {
        return start;
    }
    public MazeSquare getFinish()
    {
        return finish;
    }

    public String toString()
    {
        String ret = "";
        for(MazeSquare[] r : maze)
        {
            for(MazeSquare s : r)
            {
                switch(s.getType())
                {
                    case(0):
                        ret += "_";
                        break;
                    case(1):
                        ret += "#";
                        break;
                    case(2):
                        ret += "S";
                        break;
                    case(3):
                        ret += "E";
                        break;
                    default:
                        ret += "?";
                        break;
                }
            }
            ret += "\n";
        }

        return ret;
    }
}