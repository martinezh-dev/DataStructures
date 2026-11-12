import java.io.*;

public class MazeClient
{
    public static void main(String[] args)
    {
        Maze myMaze = new Maze();
        

        try
        {
            myMaze.loadMaze("source.mz");
            MazeSolverS solverS = new MazeSolverS(myMaze);
            
            MazeSolverQ solverQ = new MazeSolverQ(myMaze);
            solverS.solve();
            System.out.println(solverS.isSolved());
            solverS.getPath();

            myMaze.reset();

            solverQ.solve();
            System.out.println(solverS.getPath());
            solverQ.getPath();

            System.out.println(solverQ.getPathString());
            System.out.println(solverS.getPathString());
        }catch (FileNotFoundException e)
        {System.out.println("File Not Found");}
    }
}