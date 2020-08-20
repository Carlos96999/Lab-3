package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest 
{
    private Registry registry = new Registry();

    @Test
    public void validateRegistryResult() 
	{
        Person person = new Person();

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }

	@Test
	public void validateAlive()
	{
		Person person = new Person();
		person.setAlive(false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
	}
	
	@Test
	public void validateAge()
	{
		Person person = new Person();
		person.setAge(200);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
	}

	@Test
	public void validateDuplicated()
	{
		Person person = new Person();
        RegisterResult result1 = registry.registerVoter(person);
		Person person2 = new Person();
        RegisterResult result2 = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.DUPLICATED, result2);	
	}

	@Test
	public void validateUnderage()
	{
		Person person = new Person();
		person.setAge(17);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
	}	
}