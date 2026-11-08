import java.io.*;

public class MazeClient
{
    public static void main(String[] args)
    {
        Maze myMaze = new Maze();

        try
        {
            myMaze.loadMaze("source.mz");
            System.out.println(myMaze);
        }catch (FileNotFoundException e)
        {System.out.println("File Not Found");}
    }
}