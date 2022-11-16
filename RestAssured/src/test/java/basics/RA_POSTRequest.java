package basics;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import basicsPOJO.POJO_User;
import basicsPOJO.POJO_UserCompany;
import basicsPOJO.POJO_UserContact;
import io.restassured.RestAssured;


public class RA_POSTRequest {
	

	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.basePath = "/api";
	}
	
	@Test
	public void POSTRequestString() {
		given()
			.log().all()
			.pathParam("pparam", "users")
			.header("Content-Type", "application/json")
			.body("{\r\n"
					+ "    \"name\": \"morpheus\",\r\n"
					+ "    \"job\": \"leader\"\r\n"
					+ "}")
		.when()
			.post("/{pparam}")
		.then()
			.log().all()
			.assertThat()
			.statusCode(201);
	}
	
	@Test
	public void POSTRequestStaticFile() throws IOException {
		given()
			.pathParam("pparam", "users")
			.header("Content-Type", "application/json")
			.body(generateStringFromFile(System.getProperty("user.dir") + "\\src\\test\\resources\\jsonFiles\\bodyAddUser.json"))
		.when()
			.post("/{pparam}")
		.then()
			.log().all()
			.assertThat()
			.statusCode(201);
	}

	@Test
	public void POSTRequestStaticFile2() throws IOException {
		given()
			.pathParam("pparam", "users")
			.header("Content-Type", "application/json")
			.body(generateStringFromFile(System.getProperty("user.dir") + "\\src\\test\\resources\\jsonFiles\\aa.json"))
		.when()
			.post("/{pparam}")
		.then()
			.log().all()
			.assertThat()
			.statusCode(201);
	}

	@Test
	public void POSTRequestJsonObject() throws IOException {
		
		JsonObject lalala = new JsonObject();
		lalala.addProperty("name", "morpheus");
		lalala.addProperty("job", "leader");
		
		given()
			.pathParam("pparam", "users")
			.header("Content-Type", "application/json")
			.body(lalala)
		.when()
			.post("/{pparam}")
		.then()
			.log().all()
			.assertThat()
			.statusCode(201);
	}

	@Test
	public void POSTRequestJsonObjectArray() throws IOException {
		
		JsonObject lalala = new JsonObject();
		lalala.addProperty("name", "morpheus");
		lalala.addProperty("job", "leader");

		JsonObject infoEmpresa = new JsonObject();
		infoEmpresa.addProperty("name", "GFT");
		infoEmpresa.addProperty("city", "Sorocaba");
		infoEmpresa.addProperty("address", "skdjhkjsahkfjhaskhd");
		
		lalala.add("company", infoEmpresa);
		
		JsonArray listContact = new JsonArray();
	
		JsonObject contact1 = new JsonObject();
		contact1.addProperty("local", "celular");
		contact1.addProperty("ddd", 15);
		contact1.addProperty("telefone", "99999-5544");
		
		listContact.add(contact1);
		
		JsonObject contact2 = new JsonObject();
		contact2.addProperty("local", "casa");
		contact2.addProperty("ddd", 11);
		contact2.addProperty("telefone", "2222-5544");
		
		listContact.add(contact2);
		
		JsonObject contact3 = new JsonObject();
		contact3.addProperty("local", "comercial");
		contact3.addProperty("ddd", 12);
		contact3.addProperty("telefone", "2223-5544");
		
		listContact.add(contact3);
		
		lalala.add("contact", listContact);
		
		given()
			.log().all()
			.pathParam("pparam", "users")
			.header("Content-Type", "application/json")
			.body(lalala)
		.when()
			.post("/{pparam}")
		.then()
			.log().all()
			.assertThat()
			.statusCode(201);
	}

	//Pojo
	@Test
	public void POSTRequestPOJOClass() throws IOException {
		
		POJO_User bodylalala = new POJO_User();
		bodylalala.setName("morpheus");
		bodylalala.setJob("leader");
		
		POJO_UserCompany empresa = new POJO_UserCompany();
		empresa.setName("GFT");
		empresa.setCity("Sorocaba");
		empresa.setAddress("dskjhfkjsdhfkjh");
		
		bodylalala.setCompany(empresa);
		
		List<POJO_UserContact> listaContatos = new ArrayList<POJO_UserContact>();
		
		POJO_UserContact contato1 = new POJO_UserContact();
		contato1.setLocal("celular");
		contato1.setDdd(15);
		contato1.setTelefone("99999-4411");
		listaContatos.add(contato1);
		
		POJO_UserContact contato2 = new POJO_UserContact();
		contato2.setLocal("casa");
		contato2.setDdd(15);
		contato2.setTelefone("2222-4411");
		listaContatos.add(contato2);
		
		POJO_UserContact contato3 = new POJO_UserContact();
		contato3.setLocal("comercial");
		contato3.setDdd(15);
		contato3.setTelefone("2223-4411");
		listaContatos.add(contato3);
		
		bodylalala.setContact(listaContatos);
		
		given()
			.log().all()
			.pathParam("pparam", "users")
			.header("Content-Type", "application/json")
			.body(bodylalala)
		.when()
			.post("/{pparam}")
		.then()
			.log().all()
			.assertThat()
			.statusCode(201);
	}

	//Via hashmap
	@Test
	public void POSTRequestMap() {
		
		//body principal
		Map<String, Object> bodylalala = new HashMap<String, Object>();
		bodylalala.put("name", "morpheus");
		bodylalala.put("job", "leader");
		
		//company
		Map<String, Object> jsonCompany = new HashMap<String, Object>();
		jsonCompany.put("name", "GFT3");
		jsonCompany.put("city", "Sorocaba");
		jsonCompany.put("address", "lkjsldkalksjdlkasjdlj");
		
		bodylalala.put("company", jsonCompany);

		//contact
		List<Object> listaContato = new ArrayList<Object>();
		
		Map<String, Object> jsonContact = new HashMap<String, Object>();
		jsonContact.put("local", "casa");
		jsonContact.put("ddd", 15);
		jsonContact.put("telefone", "2222-3434");
		
		listaContato.add(jsonContact);
		
		Map<String, Object> jsonContact2 = new HashMap<String, Object>();
		jsonContact2.put("local", "empresa");
		jsonContact2.put("ddd", 15);
		jsonContact2.put("telefone", "2223-3434");
		
		listaContato.add(jsonContact2);
		
		Map<String, Object> jsonContact3 = new HashMap<String, Object>();
		jsonContact3.put("local", "celular");
		jsonContact3.put("ddd", 15);
		jsonContact3.put("telefone", "99999-3434");
		
		listaContato.add(jsonContact3);
		
		bodylalala.put("contact", listaContato);
		
		given()
			.log().all()
			.pathParam("pparam", "users")
			.header("Content-Type", "application/json")
			.body(bodylalala)
		.when()
			.post("/{pparam}")
		.then()
			.log().all()
			.assertThat()
			.statusCode(201);
	}

	//Pojo
	@Test
	public void POSTRequestPOJOClassWithFaker() throws IOException {
		
		Faker geradorDados = new Faker();
		
		POJO_User bodylalala = new POJO_User();
		bodylalala.setName(geradorDados.name().firstName());
		bodylalala.setJob(geradorDados.job().position());
		
		POJO_UserCompany empresa = new POJO_UserCompany();
		empresa.setName(geradorDados.company().name());
		empresa.setCity(geradorDados.address().cityName());
		empresa.setAddress(geradorDados.address().fullAddress());
		
		bodylalala.setCompany(empresa);
		
		List<POJO_UserContact> listaContatos = new ArrayList<POJO_UserContact>();
		
		POJO_UserContact contato1 = new POJO_UserContact();
		contato1.setLocal("celular");
		contato1.setDdd(15);
		contato1.setTelefone("99999-4411");
		listaContatos.add(contato1);
		
		POJO_UserContact contato2 = new POJO_UserContact();
		contato2.setLocal("casa");
		contato2.setDdd(15);
		contato2.setTelefone("2222-4411");
		listaContatos.add(contato2);
		
		POJO_UserContact contato3 = new POJO_UserContact();
		contato3.setLocal("comercial");
		contato3.setDdd(15);
		contato3.setTelefone("2223-4411");
		listaContatos.add(contato3);
		
		bodylalala.setContact(listaContatos);
		
		given()
			.log().all()
			.pathParam("pparam", "users")
			.header("Content-Type", "application/json")
			.body(bodylalala)
		.when()
			.post("/{pparam}")
		.then()
			.log().all()
			.assertThat()
			.statusCode(201);
	}

	//Pojo
	@Test(dataProvider = "usuarios")
	public void POSTRequestPOJOClassWithExcel(String camponame, String campojob) throws IOException {
		
			
		POJO_User bodylalala = new POJO_User();
		bodylalala.setName(camponame);
		bodylalala.setJob(campojob);
		
		POJO_UserCompany empresa = new POJO_UserCompany();
		empresa.setName("GFT");
		empresa.setCity("Sorocaba");
		empresa.setAddress("shkjhkjhskjdhfkhsdkfhsdf");
		
		bodylalala.setCompany(empresa);
		
		List<POJO_UserContact> listaContatos = new ArrayList<POJO_UserContact>();
		
		POJO_UserContact contato1 = new POJO_UserContact();
		contato1.setLocal("celular");
		contato1.setDdd(15);
		contato1.setTelefone("99999-4411");
		listaContatos.add(contato1);
		
		POJO_UserContact contato2 = new POJO_UserContact();
		contato2.setLocal("casa");
		contato2.setDdd(15);
		contato2.setTelefone("2222-4411");
		listaContatos.add(contato2);
		
		POJO_UserContact contato3 = new POJO_UserContact();
		contato3.setLocal("comercial");
		contato3.setDdd(15);
		contato3.setTelefone("2223-4411");
		listaContatos.add(contato3);
		
		bodylalala.setContact(listaContatos);
		
		given()
			.log().all()
			.pathParam("pparam", "users")
			.header("Content-Type", "application/json")
			.body(bodylalala)
		.when()
			.post("/{pparam}")
		.then()
			.log().all()
			.assertThat()
			.statusCode(201);
	}

    @DataProvider(name = "usuarios")
    public Object[][] readExcel() throws IOException {
       
        DataFormatter formatter = new DataFormatter();
       
        // Caminho da planilha
        FileInputStream arquivoExcel = new FileInputStream( System.getProperty("user.dir") + "\\src\\test\\resources\\excelFiles\\users.xlsx" );
       
        XSSFWorkbook workbook = new XSSFWorkbook(arquivoExcel); // Abre a planilha
        XSSFSheet worksheet = workbook.getSheet("Sheet1"); // Abre a sheet que vai usar
        XSSFRow header = worksheet.getRow(0); // Pega o cabeçalho
       
        int rowNum = worksheet.getPhysicalNumberOfRows(); //Pegar a última linha
        int colNum = header.getLastCellNum(); // Pegar a última coluna
       
        Object data[][] = new Object[rowNum - 1][colNum];
       
        for(int i = 0; i < rowNum - 1; i++) {
            XSSFRow currentRow = worksheet.getRow(i + 1);
           
            for(int j = 0; j < colNum; j++) {
                if(currentRow == null) {
                    data[i][j] = "";
                } else {
                    XSSFCell cell = currentRow.getCell(j);
                   
                    if(cell == null) {
                        data[i][j] = "";
                    } else {
                        String value = formatter.formatCellValue(cell);
                        data[i][j] = value;
                    }
                }
            }
        }
       
        workbook.close();
       
        return data;
    }
	
	public static String generateStringFromFile(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}
}
