public class Command 
{

	private String cmdWord;
	private String nextWord;

	public Command(String a, String b) 
	{
        cmdWord = a;
        nextWord = b;
    }

 	public String getCmdWord() 
 	{
        return cmdWord;
    }

    public String getNextWord() 
    {
    	return nextWord;
    }	
}