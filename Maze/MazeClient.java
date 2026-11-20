import java.io.*;

public class MazeClient
{
    public static void main(String[] args)
    {
        Maze myMaze = new Maze();
        

        try
        {
            if(myMaze.loadMaze("source.mz"))
            {
                MSS solverS = new MSS(myMaze);
                
                MSQ solverQ = new MSQ(myMaze);
                solverS.solve();
                solverS.getPath();

                myMaze.reset();

                solverQ.solve();
                solverQ.getPath();

                System.out.println(solverQ.getPathString());
                System.out.println(solverS.getPathString());
            }
            else
            {
                System.out.println("Failed to load Maze");
            }
        }catch (FileNotFoundException e)
        {System.out.println("File Not Found");}
    }
}