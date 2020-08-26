package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;
import edu.eci.cvds.tdd.aerodescuentos.*;

public class RegistryTest 
{
    private Registry registry = new Registry();
    
    @Test
    public void validateRegistryResult() 
	{
    	//Vamo a Probar
        Person person = new Person("Carlos", 1, 24, Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }

	@Test
	public void validateAlive()
	{
		Person person = new Person("Carlos", 12, 24, Gender.MALE, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
	}
	
	@Test
	public void validateAge()
	{
		Person person = new Person("Carlos", 123, 240, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
	}

	@Test
	public void validateDuplicated()
	{
		Person person = new Person("Carlos", 1234, 24, Gender.MALE, true);
        RegisterResult result1 = registry.registerVoter(person);
		Person person2 = new Person("Andres", 1234, 24, Gender.MALE, true);
        RegisterResult result2 = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.DUPLICATED, result2);	
	}

	@Test
	public void validateUnderage()
	{
		Person person = new Person("Carlos", 123456, 17, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
	}	
}