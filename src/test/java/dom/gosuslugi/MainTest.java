package dom.gosuslugi;

import org.junit.Assert;
import org.junit.Test;



public class MainTest extends BaseTest {

    private String header = "Поиск объектов на карте";
    private String findHome = "Найти дом по адресу";

    private String houseName = "Дома";
    private String oumkdName = "Организации,\n" + "управляющие МКД";
    private String roName = "Ресурсоснабжающие\n" + "организации";
    private String omsName = "Органы местного\n" + "самоуправления";
    private String reestrHouseName = "Дома в реестре лицензий,\n" + "размещенные по ст. 198 ЖК РФ";

    private String houseTypeLink = "Многоквартирный дом";
    private String houseAdress = "105062, Москва г, ул. Покровка, д. 31, строение 1";


    @Test
    public void test() throws Exception {
        MainPage mainpage = new MainPage(driver);
        MapPage map = mainpage.goToMap();

        Assert.assertEquals(map.getHeader(),header);
        Assert.assertEquals(map.getFindHome(), findHome);

        Assert.assertTrue(map.findBlockIsPresent());
        Assert.assertTrue(map.checkBox1Selected());

        Assert.assertEquals(map.houseGetName(), houseName);
        Assert.assertEquals(map.oumkdGetName(), oumkdName);
        Assert.assertEquals(map.roGetName(), roName);
        Assert.assertEquals(map.omsGetName(), omsName);
        Assert.assertEquals(map.reestrHouseGetName(), reestrHouseName);

        Assert.assertTrue(map.searchResultsPresent());
        Assert.assertTrue(map.yandexMapIsPresent());
        Assert.assertTrue(map.goBackIsPresent());

        map.moveToHouseClick();
        Assert.assertTrue(map.checkHouseCardElements());
        Assert.assertEquals(map.houseType(), houseTypeLink);
        Assert.assertEquals(map.houseAdress(), houseAdress);
    }
}
