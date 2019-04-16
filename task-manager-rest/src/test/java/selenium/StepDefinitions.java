package selenium;

import static org.junit.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	private WebDriver driver;

	@Before
	public void before() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
		driver = new ChromeDriver();
		System.out.println(System.getProperty("webdriver.chrome.driver"));

//    	driver = new RemoteWebDriver("http://localhost:9515", DesiredCapabilities.chrome());
		driver.navigate().to("http://localhost:4200");
	}

	@After
	public void after() {
		driver.quit();
	}

	@Given("^user navigates to task manager app$")
	public void user_navigates_to_task_manager_app() {
//    	System.out.println("user_navigates_to_task_manager_app");
	}

	@When("^do point list of tasks$")
	public void do_point_list_of_tasks() {
		WebElement viewTaskLink = driver.findElement(By.id("viewtask"));
		viewTaskLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@Then("^it should load with list of tasks$")
	public void it_should_load_with_list_of_tasks() {
		WebElement results = driver.findElement(By.id("0"));
		assertNotNull(results.findElement(By.id("taskName")).getText());
	}

	@When("^filter task list using task name as \"(.*)\"$")
	public void filter_task_list_using_task_name_as_task(String serachString) {
		driver.findElement(By.xpath("//*[@id='taskName1']")).sendKeys(serachString);
	}

	@Then("^should display task with search string as \"(.*)\"$")
	public void should_display_task_with_search_string(String serachString) {
		WebElement results = driver.findElement(By.id("0"));
		assertNotNull(results.findElement(By.id("taskName")).getText().startsWith(serachString));
	}

	@Given("^navigate to add task$")
	public void navigate_to_add_task() {
		WebElement viewTaskLink = driver.findElement(By.id("addtask"));
		viewTaskLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@When("^add task taskName as \"(.*)\" parentTask as \"(.*)\"$")
	public void add_task_taskName_as_priority_as_parentTask_as(String taskName, String parentTask) {
		driver.findElement(By.xpath("//*[@id='taskName']")).sendKeys(taskName);
		driver.findElement(By.xpath("//*[@id='priority']")).sendKeys("20");
		driver.findElement(By.xpath("//*[@id='parentTask']")).sendKeys(parentTask);
		driver.findElement(By.xpath("//*[@id='startDate']")).sendKeys("01/10/2018");
		driver.findElement(By.xpath("//*[@id='endDate']")).sendKeys("01/10/2019");
		driver.findElement(By.id("add")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@Then("^should be added new task$")
	public void should_be_added_new_task() {
		WebElement results = driver.findElement(By.tagName("span"));
		assertNotNull(results.getText().startsWith("Success"));
	}

}
