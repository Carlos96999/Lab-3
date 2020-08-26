# Laboratorio 3 - PBT - 2020-2

## Carlos Andres Amorocho-Jonathan Paez

Agregamos las nuevas dependencias para JUnit

```xml
$   <!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api -->
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter-api</artifactId>
      <version>5.7.0-RC1</version>
      <scope>test</scope>
    </dependency>
```
## Comando para ejecutarlas pruebas unitarias

```mvn
$ mvn exec:java -Dexec.mainClass="edu.eci.cvds.patterns.App" -Dexec.args="Hola Mundo"
```

### Complete la implementación del método registerVoter en la clase Registry.java para retornar el resultado esperado según la entrada


 ```java
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

```
## Complete la implementación de la clase RegistryTest.java creando diferentes personas y validando que el resultado sea el esperado.

```java
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

## Pruebas para el aerodescuentos

Cliente 1:  	Ingreso: calculoTarifa(+250000, 10, 17)

Resultado esperado: “Aplica descuento del 5% por menor de 18 años, valor del tiquete $237.500”

Cliente 2: 	Ingreso: calculoTarifa(+250000, 20, 66)

Resultado esperado: “Aplica descuento del 8% por mayor de 65 años, valor del tiquete $230.000”

Cliente 3:	Ingreso: calculoTarifa(+250000, 20, -9999999999)

Resultado esperado: ExcepcionParametrosInvalidos

Cliente 4:	Ingreso: calculoTarifa(+250000, 21, 30)

Resultado esperado: “Aplica descuento del 15% por compra en antelación de vuelo, valor del tiquete $212.500”

Cliente 5:	Ingreso: calculoTarifa(-99999999, 20, 66)

Resultado esperado: ExcepcionParametrosInvalidos




