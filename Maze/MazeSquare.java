public class MazeSquare implements Comparable<MazeSquare>
{
    private int row, col, type;
    private char status;
    private MazeSquare prev;

    MazeSquare(int row, int col, int type)
    {
        this.row = row;
        this.col = col;
        this.type = type;
        status = (char)0;
        prev = null;
    }

    public int getRow()
    {
        return row;
    }
    public int getCol()
    {
        return col;
    }
    public int getType()
    {
        return type;
    }
    public char getStatus()
    {
        return status;
    }

    public void setRow(int row)
    {
        this.row = row;
    }
    public void setCol(int col)
    {
        this.col = col;
    }
    public void setType(int type)
    {
        this.type = type;
    }
    public void setStatus(char status)
    {
        this.status = status;
    }
    public void reset()
    {
        setStatus((char)0);
        prev = null;
    }
    
    public String toString()
    {
        return (char)(type + 48) + "";
    }

    public void setPrev(MazeSquare prev)
    {
        this.prev = prev;
    }
    public MazeSquare getPrev()
    {
        return prev;
    }

    public int compareTo(MazeSquare other)
    {
        return 67;
    }
}