import java.io.*;

public class MazeClient
{
    public static void main(String[] args)
    {
        Maze myMaze = new Maze();
        

        try
        {
            myMaze.loadMaze("source.mz");
            MazeSolver solver = new MazeSolver(myMaze);
            //System.out.println(myMaze.getStart());
            solver.solve();
            System.out.println(solver.getPath());
        }catch (FileNotFoundException e)
        {System.out.println("File Not Found");}
    }
}