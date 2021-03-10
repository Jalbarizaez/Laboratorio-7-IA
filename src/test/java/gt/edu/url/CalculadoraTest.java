package gt.edu.url;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class CalculadoraTest {

    Calculadora calculadora;

    @BeforeAll
    public static void startup(){
         System.out.println("Inicializacion global-------");
    }

    @BeforeEach
    public void init(){
        calculadora = new Calculadora();
        System.out.println("Iniciando test ----------");
    }

    @Test
    @DisplayName("Prueba de suma simple")
    public void probarSuma(){
        //Ejecutar y obtener
        assertEquals(25.0,calculadora.sumar(5.0,20.0));
        System.out.println("Sumando ............");
    }

    @Test
    @Disabled("No me gustan las restas")
    public void probarResta(){
        //Ejecutar y obtener
        assertEquals(30.0,calculadora.restar(50.0,20.0));
        System.out.println("Restando ............");
    }

    @Test
    public void probarMultiplicacion(){
        //Ejecutar y obtener
        assertEquals(25.0,calculadora.multiplicar(5.0,5.0));
        System.out.println("Multiplicado ............");
    }

    @Test
    public void probarDivision(){
        assertThrows(ArithmeticException.class,()->{
            var division = 100/0;
        });
    }

    @Test
    public void probarTabla5(){
        int[] numbers = {1,2,3,4,5};
        assertAll("Tabla del 5",
                () -> {assertEquals(5,calculadora.multiplicar(5,1));},
                () -> {assertEquals(10,calculadora.multiplicar(5,2));},
                () -> {assertEquals(15,calculadora.multiplicar(5,3));},
                () -> {assertEquals(20,calculadora.multiplicar(5,4));},
                () -> {assertEquals(25,calculadora.multiplicar(5,5));}
                );
    }


    /*@AfterEach
    public void shutdown(){
        System.out.println("Finalizando Test ............");
    }
*/
    /*@AfterAll
    public static void destroy(){
        System.out.println("Finalizacion global-------");
    }*/
}
