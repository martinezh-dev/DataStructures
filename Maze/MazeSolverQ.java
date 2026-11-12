import java.util.ArrayList;

public class MazeSolverQ
{
    private Maze maze;
    private Qeue<MazeSquare> worklist;
    private boolean solved;
    private String pathString;

    public void makeEmpty()
    {
        worklist = new Qeue<MazeSquare>();
    }
    public boolean isEmpty()
    {
        return worklist.isEmpty();
    }
    public void add(MazeSquare sq)
    {
        sq.setStatus('o');
        worklist.append(sq);
    }
    public MazeSquare next()
    {
        return worklist.pop();
    }
    public MazeSolverQ(Maze maze)
    {
        this.maze = maze;
        makeEmpty();
        add(maze.getStart());
        solved = false;
    }
    public boolean isSolved()
    {
        return solved;
    }
    public boolean getPath()
    {
        if(!solved)
        {
            return false;
        }
        MazeSquare cur = maze.getFinish();
        String ret = "";
        while(cur != maze.getStart())
        {
            cur.setStatus('x');
            ret += ("(" + cur.getRow() + ", " + cur.getCol() + ")");
            cur = cur.getPrev();
        }
        pathString = ret;
        return true;
    }

    public String getPathString()
    {
        return pathString;
    }

    public MazeSquare step()
    {
        MazeSquare cur = null;
        if(!worklist.isEmpty())
        {
            cur = worklist.pop();
            if(cur.getType() == 3)
            {
                //System.out.println(getPath());
            }
            else
            {
                ArrayList<MazeSquare> adj = maze.getNeighbors(cur);
                for(MazeSquare sq : adj)
                {
                    if(sq.getPrev() == null && sq.getType() != 1)
                    {
                        sq.setPrev(cur);
                        worklist.append(sq);
                    }
                }
            }
        }
        return cur;
    }

    public void solve()
    {
        MazeSquare cur = step();
        while(cur != null && cur.getType() != 3)
        {
            cur = step();
        }
        solved = (cur.getType() == 3);
        System.out.println(cur.getType());
    }
}