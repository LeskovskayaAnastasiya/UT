package app.tests;

import app.dataproviders.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;
import triangle.Triangle;


public class TriangleTests {

    public TriangleTests() {
    }

    //  проверим (позитивным тестом) side > 0
    @Test(
            dataProviderClass = DataProviders.class,
            dataProvider = "DataProviderForCheckTriangleMethodPositive"
    )
    public void tstCheckSidesPositive(double a, double b, double c) {
        Triangle triangle = new Triangle(a, b, c);
        Assert.assertTrue(triangle.checkTriangle());

    }

    //  проверим (негативным тестом) side > 0
    @Test(
            dataProviderClass = DataProviders.class,
            dataProvider = "DataProviderTriangleMethodNegative"
    )
    public void tstCheckSidesNegative(double a, double b, double c) {
        Triangle triangle = new Triangle(a, b, c);
        Assert.assertFalse(triangle.checkTriangle());
    }


    @Test(
            dataProviderClass = DataProviders.class,
            dataProvider = "CheckDetectTriangleMethodPositive"
    )
    public void tstCheckDetectTrianglePositive (int type, double a, double b, double c) {

            Triangle triangle = new Triangle(a, b, c );
            Assert.assertEquals(triangle.detectTriangle(), type);
    }

    @Test(
            dataProviderClass = DataProviders.class,
            dataProvider = "checkGetSquareMethodPositive"
    )
    public void createDataForGetSquareMethod(double result, double a, double b, double c) {
       Triangle triangle = new Triangle(a, b, c );
       Assert.assertEquals(triangle.getSquare(), result);
       }
}
