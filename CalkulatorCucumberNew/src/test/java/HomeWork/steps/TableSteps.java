package HomeWork.steps;

import HomeWork.page.InternalPage;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import HomeWork.page.Book;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static HomeWork.context.TestContext.scenario;


public class TableSteps {

    @DataTableType
    public Book booksEntryTransformer(Map<String, String> row) {
        return new Book(
                row.get("title"),
                row.get("author"),
                Integer.parseInt(row.get("yearOfPublishing")));
    }


    @Given("We are browsing the Library")
    public void weAreBrowsingTheLibrary() {
        System.out.println("Hallo");

    }

    @When("print the list")
    public void printTheList(List<Book> books) {
        for(Book book: books) {
            System.out.printf(
                    "'%s', published in %d, was written by %s\n",
                    book.title,
                    book.yearOfPublishing,
                    book.author
            );
        }
    }

    @Then("check that there are really {int} books")
    public void checkThatThereAreReallyBooks(int arg0, List<Book> books) {
        assertEquals(arg0, books.size());
    }


    @Given("The following table")
    public void theFollowingTable(Map<String, String> dataTable) {
        dataTable = processDataTable(dataTable);
        scenario.log(dataTable.toString());
        for(Map.Entry<String,String> entry: dataTable.entrySet()){
            System.out.printf("Key %s,   Value %s\n", entry.getKey(),entry.getValue());
        }
    }

    public Map<String,String> processDataTable(Map<String,String> dataTable) {
        Map<String, String> processedData = new LinkedHashMap<>();
        for (Map.Entry<String,String> entry: dataTable.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            processedData.put(key, processPlaceholder(value));
        }
        return processedData;
    }

    private String processPlaceholder(String placeholder){
        return  switch (placeholder.toLowerCase()){
            case "today" -> LocalDate.now().toString();
            case "randomnumber" -> String.valueOf(new Random().nextInt(1,200));
            case "emptystring" -> "";
            case "null" -> null;
            case "textofelement" -> new InternalPage().logBrandHeader.getText();
            default -> placeholder;
        };

    }
}
