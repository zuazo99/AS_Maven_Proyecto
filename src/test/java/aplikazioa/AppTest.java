package aplikazioa;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class AppTest extends TestCase {
    private static App app;


    @BeforeAll
    /*
        El metodo que se marque con @BeforeAll se ejecutara
        una unica vez antes que cualquier metodo de prueba
     */
    public static void init(){
        app = new App();
    }

    @AfterAll
    /*
        Un metodo de limpieza que se ejecute solo una vez
        despues de todos los metodos de test.
     */
    public static void finish(){
        app = null;
    }

    @org.junit.Test
    public void testSuma() {
        assertEquals(4,App.suma(2,2));
    }

    @org.junit.Test
    public void testSumaHamcrest() {
       // assertThat(app, notNullValue());
        assertThat(App.suma(2,3), is(5));
        assertThat(App.suma(4,4), equalTo(8));
    }


    @org.junit.Test
    public void testResta() {
        assertEquals(2,App.resta(4,2));
    }

    @org.junit.Test
    public void testMultiplicacion(){
        assertEquals(9, App.multiplicacion(3,3));
    }

    @org.junit.Test
    public void testMultiplicacionHamcrest(){
        assertThat(App.multiplicacion(4,3), is(12));
    }

    @org.junit.Test
    public void testDivision(){
        assertEquals(3, App.division(9,3));
    }

    public AppTest(String testName){
        super(testName);
    }

    public static Test suite(){
        return new TestSuite( AppTest.class);
    }

    public void testApp(){
        assertTrue(true);
    }



}
