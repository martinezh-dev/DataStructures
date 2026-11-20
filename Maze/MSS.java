public class MSS extends MazeSolver
{
    private Stack<MazeSquare> worklist;

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
    public MSS(Maze maze)
    {
        super(maze);
    }

    public String getPathString()
    {
        return pathString;
    }
}