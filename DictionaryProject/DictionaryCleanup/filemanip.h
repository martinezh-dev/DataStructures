#include <iostream>
#include <fstream>
#include <array>

const int MAX_SIZE = 1023;  //idfk why this needs to be here

class fmanip
{
private:                //the fmanip object keeps a number of internal variables for proper operation
    std::fstream file;  //source file
    char delim;         //chunking character used by internal functions
    std::string buffer; //the copy of the fstream, which is operated on by all internal functions. call "flush()"to syncornize
    std::array<int,2> lastPulledBlock;  //the start and ending characters of the last pulled block
    std::string filename;   //used by the constructor to attatch the file
public:
    fmanip(std::string filename, char delim = '\n');
    fmanip();
    ~fmanip();

    std::array<int,2> getBlock(int dataBlock);
    void readBlock(int startOn = 0, int endOn = 0, bool useLastBlock = true); //prints out a block of data
    void writeBlock(const std::string block, int blockNum);
    void rmBlock(int blockNum);
    std::string& readTo(std::string &outVar, int blockNum= 0, bool print= false);   //writes a block of data to "outVar"
    bool checkFileValid() {if(buffer[0]){return true;}else{return false;}};
    
    void flush();   //syncronize the buffer and actual file
    void refresh(); //syncronize the file and buffer

    void cleanup() {file.close();}; //DO NOT DELETE!!! ERRORS WILL COME

    void operator=(fmanip &arg);    //probably could be written better. Results in clunky assignment when 
};                                  //fmanip is used as a property

fmanip::fmanip(){}  //bad things happen when this is deleted

fmanip::fmanip(std::string filename, char delim):
delim(delim), filename(filename)
{
    file = std::fstream(filename, std::ios::in);

    char temp[MAX_SIZE];
    file.getline(temp, MAX_SIZE, '\0'); //write full file contents into the buffer
    buffer = std::string(temp); //stupid conversion. dont ask

    lastPulledBlock[0] = 0;
    lastPulledBlock[1] = 1;
}

fmanip::~fmanip()
{
    file.close();   //again. bad things
}

std::array<int,2>fmanip::getBlock(int dataBlock)    //finds the first and last characters of a data block
{
    int startOn = 0;
    int endOn = 0;
    char marker[2];
    marker[0] = 0;
    marker[1] = 0;

    for(int i = dataBlock; i > 0; i--)  
    {
        for(int j = endOn; buffer[j+1] != delim; j++) //moves "endOn" to the next delim character
        {                                               //pushes it back again each time the large loop runs
            endOn = j;
        }
        endOn++;
        if(i < dataBlock)
        { 
            for(int j = startOn + 1; buffer[j] != delim; j++)   //does a similar thing as the main loop
            {                                                   //TODO: optimize this loop
                startOn = j;
            }
            startOn += 2;
        }
    }
    lastPulledBlock[0] = startOn;   //set the "lastPulledBlock" variable and the function's return value
    lastPulledBlock[1] = endOn;
    //cout << endOn + '0' << endl;
    marker[0] = lastPulledBlock[0];
    marker[1] = lastPulledBlock[1];
    return lastPulledBlock;
}

void fmanip::readBlock(int startOn, int endOn, bool useLastBlock)
{
    int returnSize = 0;

    if(useLastBlock)
    {
        startOn = lastPulledBlock[0];
        endOn = lastPulledBlock[1];
    }
    
    returnSize = endOn - startOn + 1;
    char returnChar[returnSize];
    for(int i = startOn, j = 0; i <= endOn; i++, j++)
    {
        returnChar[j] = buffer[i];
    }
    returnChar[returnSize] = ' ';
    returnChar[returnSize + 1] = 0;
    std::cout << returnChar << '\n';
}

void fmanip::writeBlock(std::string block, int blockNum)
{
    getBlock(blockNum);
    int startOn = lastPulledBlock[0];
    int endOn = lastPulledBlock[1];
    char wBuffer[buffer.length()-startOn];

    for(int i = startOn, j = 0; i < buffer.length(); i++, j++)
    {
        wBuffer[j] = buffer[i];
        buffer[i] = 127;
    }

    char sTemp[MAX_SIZE];
    for(int i = 0; buffer[i] != char(127); i++)
    {
        sTemp[i] = buffer[i];
    }
    buffer = sTemp;
    buffer += block + delim;
    buffer += wBuffer;
}

void fmanip::rmBlock(int blockNum)
{
    getBlock(blockNum);
    int startOn = lastPulledBlock[0];
    int endOn = lastPulledBlock[1];
    char wBuffer[buffer.length()-startOn];

    for(int i = endOn, j = 0; i < buffer.length(); i++, j++)
    {
        wBuffer[j] = buffer[i];
        buffer[i] = char(127);
    }
    
    char sTemp[MAX_SIZE];
    for(int i = 0; buffer[i] != char(127); i++)
    {
        sTemp[i] = buffer[i];
    }
    buffer = sTemp;
    buffer += wBuffer;
    flush();
}

std::string& fmanip::readTo(std::string &outVar, int blockNum, bool print)
{
    int startOn = 0;
    if(blockNum > 0)  
        getBlock(blockNum);
    for(int i = lastPulledBlock[0], j= startOn; buffer[i] != delim; i++, j++)
    {
        outVar += buffer[i];
    }
    return outVar;
}

/*int* fmanip::readTo(int *outVar, int blockNum, bool print)
{
    int temp[MAX_SIZE];
    int counter = 0;
    for(int i = lastPulledBlock[0], j =0; buffer[i] != delim; i++, j++, counter++)
    {
        temp[j] = buffer[i];
    }
    for(int i = 0; i < counter; i++)
    {
        outVar[i] = temp[i];
    }
    return outVar;
}*/

void fmanip::flush()
{
    //while there are characters left in buffer, if active char isnt null, write to file
    std::ofstream fTemp(filename);
    fTemp << buffer;
    fTemp.flush();
    fTemp.close();
}

void fmanip::refresh()
{
    char temp[MAX_SIZE];
    file.getline(temp, MAX_SIZE, '\0'); //write full file contents into the buffer
    buffer = std::string(temp); //stupid conversion. dont ask
}

void fmanip::operator=(fmanip &arg)
{
    this->buffer = arg.buffer;
    this->delim = arg.delim;
    this->file = std::fstream(arg.filename, std::ios::in);
    this->filename = arg.filename;
    this->lastPulledBlock[0] = arg.lastPulledBlock[0];
    this->lastPulledBlock[1] = arg.lastPulledBlock[1];
    
    flush();
}