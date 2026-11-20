public class MSQ extends MazeSolver
{
    private Qeue<MazeSquare> worklist;

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
    public MSQ(Maze maze)
    {
        super(maze);
    }
    public boolean isSolved()
    {
        return solved;
    }

    public String getPathString()
    {
        return pathString;
    }
}