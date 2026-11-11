import java.util.ArrayList;

public class MazeSolver
{
    private Maze maze;
    private Stack<MazeSquare> worklist;
    private boolean solved;

    public void makeEmpty()
    {
        worklist = new Stack<MazeSquare>();
    }
    public boolean isEmpty()
    {
        return worklist.isEmpty();
    }
    public void add(MazeSquare sq)
    {
        sq.setStatus('o');
        worklist.push(sq);
    }
    public MazeSquare next()
    {
        return worklist.pop();
    }
    public MazeSolver(Maze maze)
    {
        this.maze = maze;
        makeEmpty();
        add(maze.getStart());
        solved = false;
    }
    //TODO: implement this
    public boolean isSolved()
    {
        return solved;
    }
    public String getPath()
    {
        if(!solved)
        {
            return "Maze Not Solved";
        }
        MazeSquare cur = maze.getFinish();
        String ret = "";
        while(cur != maze.getStart())
        {
            cur.setStatus('x');
            ret += ("(" + cur.getRow() + ", " + cur.getCol() + ")");
            cur = cur.getPrev();
        }
        return ret;
    }

    public MazeSquare step()
    {
        MazeSquare cur = null;
        if(!worklist.isEmpty())
        {
            cur = worklist.pop();
            if(cur.getType() == 3)
            {
                System.out.println(getPath());
            }
            else
            {
                ArrayList<MazeSquare> adj = maze.getNeighbors(cur);
                for(MazeSquare sq : adj)
                {
                    if(sq.getPrev() == null && sq.getType() != 1)
                    {
                        sq.setPrev(cur);
                        worklist.push(sq);
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