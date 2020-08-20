package edu.eci.cvds.tdd.registry;
import java.util.ArrayList;

public class Registry 
{
	private ArrayList<Integer> idPerson = new ArrayList<Integer>();
	
	private boolean duplicate(int id)
	{
		boolean result = false;
		int count = 0;
		
		for(int i = 0; i < idPerson.size(); i++)
		{
			if(id == idPerson.get(i)){ count += 1;}
		}
		if(count >= 2){ result = true;}
		return result;
	}
	
	public RegisterResult registerVoter(Person p)
	{
		RegisterResult result = null;
        idPerson.add(p.getId());
		
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
		else if(duplicate(p.getId()))
		{
			result = RegisterResult.DUPLICATED;
		}
		else
		{
			result = RegisterResult.VALID;
		}
			
        return result;
    }
}