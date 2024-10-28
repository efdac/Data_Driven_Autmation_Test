package DataDrivenTest;

public class DataProvider_Class {


    @org.testng.annotations.DataProvider(name = "LoginData")
    public static Object[][] getUserCredentials() {
        return new Object[][]{
                {"Admin","admin123"},   //Valid
                {"adminnnn","admin123"},//Invalid Email
                {"Admin","admin"},      //Invalid Password
                {" ","admin123"},       //Empty Email
                {"Admin"," "}           //Empty password
        };
    }
}
