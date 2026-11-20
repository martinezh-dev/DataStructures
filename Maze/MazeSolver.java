import java.util.ArrayList;

public abstract class MazeSolver
{
    protected Maze maze;
    protected boolean solved;
    protected String pathString;

    abstract void makeEmpty();
    abstract boolean isEmpty();
    abstract void add(MazeSquare sq);
    abstract MazeSquare next();

    MazeSolver(Maze maze)
    {
        this.maze = maze;
        makeEmpty();
        add(maze.getStart());
        solved = false;
    }

    boolean isSolved()
    {
        return solved;
    }

    String getPath()
    {
        if(solved)
        {
            MazeSquare cur = maze.getFinish();
            Stack<MazeSquare> temp = new Stack<MazeSquare>();
            String ret = "";

            while(cur != maze.getStart())
            {
                temp.push(cur);
                cur = cur.getPrev();
            }
            while(!temp.isEmpty())
            {
                cur = temp.pop();
                ret += ("(" + cur.getRow() + ", " + cur.getCol() + ")");
            }
            pathString = ret;
        }
        return (solved)? pathString : "Not Solved";
    }

    public MazeSquare step()
    {
        MazeSquare cur = null;
        if(!isEmpty())
        {
            cur = next();
            cur.setStatus('.');
            if(!(cur.getType() == 3))
            {
                ArrayList<MazeSquare> adj = maze.getNeighbors(cur);
                for(MazeSquare sq : adj)
                {
                    if(sq.getPrev() == null && sq.getType() != 1)
                    {
                        sq.setPrev(cur);
                        sq.setStatus('o');
                        add(sq);
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
        solved = (cur != null && cur.getType() == 3);
        if(solved)
        {
            System.out.println("Maze solved");
        }
        else
        {
            System.out.println("Maze Not Solved");
        }
    }
}