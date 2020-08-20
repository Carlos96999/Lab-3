package edu.eci.cvds.tdd.registry;
import java.util.HashMap;

public class Registry 
{
	private HashMap<Integer, String> idPerson = new HashMap<Integer, String>();
	
	public RegisterResult registerVoter(Person p)
	{
		RegisterResult result = null;
        // TODO Validate person and return real result.
		if(!p.isAlive())
		{
			result = RegisterResult.DEAD;
		}
		else if(p.getAge() < 18)
		{
			result = RegisterResult.UNDERAGE;
		}
		else if(p.getAge() < 0 || p.getAge() > 130)
		{
			result = RegisterResult.INVALID_AGE;
		}
		else if(idPerson.containsKey(p.getId()))
		{
			result = RegisterResult.DUPLICATED;
		}
		else if(!idPerson.containsKey(p.getId()))
		{
			idPerson.put(p.getId(), p.getName());
		}
		else
		{
			result = RegisterResult.VALID;
		}
			
        return result;
    }
}