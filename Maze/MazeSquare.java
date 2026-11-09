public class MazeSquare
{
    private int row, col, type;
    private char status;

    MazeSquare(int row, int col, int type)
    {
        this.row = row;
        this.col = col;
        this.type = type;
        status = (char)0;
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
    }
    
    public String toString()
    {
        return (char)(type + 48) + "";
    }
}