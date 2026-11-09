import java.io.*;

public class MazeClient
{
    public static void main(String[] args)
    {
        Maze myMaze = new Maze();

        try
        {
            myMaze.loadMaze("source.mz");
            System.out.println(myMaze + "\n");
            System.out.println(myMaze.getNeighbors(myMaze.getSquare(1, 1)).size());
        }catch (FileNotFoundException e)
        {System.out.println("File Not Found");}
    }
}