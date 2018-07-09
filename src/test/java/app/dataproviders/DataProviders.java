package app.dataproviders;

public class DataProviders {

    private final   int TR_EQUILATERAL = 1; // равносторонний
    private final  int TR_ISOSCELES = 2;   // равнобедренный
    private final int TR_ORDYNARY = 4;    // обычный
    private final  int TR_RECTANGULAR = 8; // прямоугольный
    private final   int TR_EQUILATERALAndTR_ISOSCELES = 3;
    private final   int TR_ISOSCELESAndTR_RECTANGULAR = 10;

    public DataProviders() {
    }

    @org.testng.annotations.DataProvider(
            name = "DataProviderForCheckTriangleMethodPositive"
    )
    public static Object[][] dataProvider() {
        return new Object[][]{
                // подаставляем граничное (дробное) значение сторонам
                {0.1, 10d, 10.05},
                {10.05, 0.1, 10d},
                {10d, 10.05, 0.1},
                //  // подаставляем граничное (целое) значение сторонам
                {1, 10, 10},
                {10, 1, 10},
                {10, 10, 1}
        };
    }

    @org.testng.annotations.DataProvider(
            name = "DataProviderTriangleMethodNegative"
    )
    public Object[][] dataProvider1() {
        // {сторона а, сторона b, сторона с}
        return new Object[][]{
                // подаставляем сторонам значение 0 ожидаемый результат false
                {0, 3d, 3d},
                {3d, 0, 3d},
                {3d, 3d, 0},
                //подаставляем сторонам значение -1 ожидаемый результат false
                {-1d, 4d, 2d},
                {2d, -1d, 4d},
                {4d, 2d, -1d},
                // подаставляем граничное (дробное) значение сторонам
                {-0.1, 4d, 2d},
                {2d, -0.1, 4d},
                {4d, 2d, -0.1},
                //подставляем сторонам NaN ожидаемый результат false в данном случае будет найден баг
                {Double.NaN, 3d, 2.0},
                {2, Double.NaN, 3d},
                {3d, 2, Double.NaN},
                ////подставляем сторонам Double.POSITIVE_INFINITY ожидаемый результат false
                {Double.POSITIVE_INFINITY, 3d, 2.0},
                {2, Double.POSITIVE_INFINITY, 3d},
                {3d, 2, Double.POSITIVE_INFINITY},
                // Срусл sum of the two sides <= 0
                {10d, 10d, 100d},
                {100d, 10d, 10d},
                {10d, 100d, 10d}
        };
    }

    // проверим (негативным тестом) возможность постороения треугольника
    @org.testng.annotations.DataProvider(
            name = "CheckDetectTriangleMethodPositive"
    )
    public Object[][] dataProvider2 () {
        return new Object[][]{
                {TR_EQUILATERALAndTR_ISOSCELES, 3d, 3d, 3d},//равносторонний и равнобедренный
                {TR_RECTANGULAR, 5d, 4d, 3d},// прямоугольный гипотенуза a
                {TR_RECTANGULAR, 3d, 5d, 4d},// прямоугольный гипотенуза b
                {TR_RECTANGULAR, 3d, 4d, 5d},// прямоугольный гипотенуза c
                {TR_ISOSCELES, 3d, 4d, 4d},  // равнобедренный  основание а
                {TR_ISOSCELES, 4d, 3d, 4d},  // равнобедренный основание b
                {TR_ISOSCELES, 4d, 4d, 3d},  // равнобедренный основание с
                {TR_ISOSCELESAndTR_RECTANGULAR, 1d, 1d, Math.sqrt(2)},//Корректный прямоугольный и равнобедренный треугольник
                {TR_ORDYNARY, 2d, 3d, 4d},// обычный
        };
    }

    @org.testng.annotations.DataProvider(
            name = "checkGetSquareMethodPositive"
    )
    public Object[][]dataProvider3(){
        return new Object[][]{
                {3.897114317029974, 3d, 3d, 3d},
                {4.993746088859544, 1d, 10, 10d},
                {6, 3, 4, 5}

        };
    }
}




