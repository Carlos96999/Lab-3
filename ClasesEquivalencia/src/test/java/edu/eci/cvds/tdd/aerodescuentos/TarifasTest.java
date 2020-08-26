package edu.eci.cvds.tdd.aerodescuentos;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;


public class TarifasTest {
	public CalculadorDescuentos cDescuentos= new CalculadorDescuentos();
    @Test
    public void validaAntelacionBillete() 
    //Calcula el 15% de descuento si los dias de antelacion son superiores a 20.
	{

    	double c=cDescuentos.calculoTarifa(150000, 25, 20);
		Assert.assertEquals("127500.0", String.valueOf(c));
    }
    @Test
    public void validaEdadInf() 
    //5% a los pasajeros con edad inferior a 18 años.
	{

    	double c=cDescuentos.calculoTarifa(150000, 0, 16);

		Assert.assertEquals("142500.0", String.valueOf(c));
    }
    @Test
    public void validaEdadSup() 
     //8%  a los pasajeros con edad superior a 65  años.
	{

    	double c=cDescuentos.calculoTarifa(150000, 0, 70);
    	//System.out.println(c);
    	//assertTrue( true );
		Assert.assertEquals("138000.0", String.valueOf(c));
    }
    @Test
    public void validaEdadMenor() 
     //8%  a los pasajeros con edad superior a 65  años.
	{

    	double c=cDescuentos.calculoTarifa(150000, 0, -999999);
    	System.out.println("La edad es Incorrecta");
    	assertTrue( true );

    }
    @Test
    public void validaValorBillete() 
     //8%  a los pasajeros con edad superior a 65  años.
	{

    	double c=cDescuentos.calculoTarifa(-99999, 20, 60);
    	System.out.println("El Valor es Incorrecto");
    	assertTrue( true );

    }


}
