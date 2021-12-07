package aplikazioa;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AppParamTest {

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

    /*
    Pruebas parametrizadas:

        Ahora creamos un método estático que devuelva las tuplas para cada una de las pruebas.
     */

    static Stream<Arguments> datos() {
        return Stream.of(
                Arguments.of(1, 1, 0),
                Arguments.of(2, 1, 1),
                Arguments.of(1, 2, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("datos")
    public void testRestaParam(int primerNum, int segundoNum, int resultado){
        assertThat(App.resta(primerNum,segundoNum), is(resultado));
    }

    static Stream<Arguments> datosSuma() {
        return Stream.of(
                Arguments.of(1, 1, 2),
                Arguments.of(2, 1, 3),
                Arguments.of(-1, -1, -2)
        );
    }

    @ParameterizedTest
    @MethodSource("datosSuma")
    public void testSumaParam(int primerNum, int segundoNum, int resultado){
        assertThat(App.suma(primerNum,segundoNum), is(resultado));
    }

    static Stream<Arguments> datosMultiplicacion() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(1, 1, 1),
                org.junit.jupiter.params.provider.Arguments.of(2, 4, 8),
                org.junit.jupiter.params.provider.Arguments.of(-2, -2, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("datosMultiplicacion")
    public void testMultiplicacionParam(int primerNum, int segundoNum, int resultado){
        assertThat(App.multiplicacion(primerNum,segundoNum), is(resultado));
    }



    static Stream<Arguments> datosDivision() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(1, 1, 1),
                org.junit.jupiter.params.provider.Arguments.of(8, 2, 4),
                org.junit.jupiter.params.provider.Arguments.of(-2, -2, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("datosDivision")
    public void testDivisionParam(int primerNum, int segundoNum, int resultado){
        assertThat(App.division(primerNum,segundoNum), is(resultado));
    }

}
