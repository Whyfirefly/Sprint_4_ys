import browsers.WebDriverVendors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.HomePage;

import static constants.QuestionsHomePage.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class QuestionTest {

  private WebDriver driver;

  private final By question;
  private final By answer;
  private final By idQuestion;
  private final String expected;

  public QuestionTest(By question, By answer, By idQuestion, String expected) {
    this.question = question;
    this.answer = answer;
    this.idQuestion = idQuestion;
    this.expected = expected;
  }

  @Parameterized.Parameters
  public static Object[][] getTestData() {
    return new Object[][] {
            {QUESTION_0, ANSWER_0, ITEM_ANSWER_0, TEXT_ANSWER_0},
            {QUESTION_1, ANSWER_1, ITEM_ANSWER_1, TEXT_ANSWER_1},
            {QUESTION_2, ANSWER_2, ITEM_ANSWER_2, TEXT_ANSWER_2},
            {QUESTION_3, ANSWER_3, ITEM_ANSWER_3, TEXT_ANSWER_3},
            {QUESTION_4, ANSWER_4, ITEM_ANSWER_4, TEXT_ANSWER_4},
            {QUESTION_5, ANSWER_5, ITEM_ANSWER_5, TEXT_ANSWER_5},
            {QUESTION_6, ANSWER_6, ITEM_ANSWER_6, TEXT_ANSWER_6},
            {QUESTION_7, ANSWER_7, ITEM_ANSWER_7, TEXT_ANSWER_7},
    };
  }

  @Before
  public void setUp() {
    driver = WebDriverVendors.get("Chrome");
  }

  @After
  public void teardown() {
    driver.quit();
  }

  @Test
    public void checkAnswerQuestion() {
      new HomePage(driver)
              .waitForLoadHomePage()
              .clickAcceptCookie()
              .scrollToQuestions()
              .clickQuestion(question)
              .waitLoadAfterClickQuestion(idQuestion);
      String actualAnswer = driver.findElement(answer).getText();

      assertEquals("Некорретный текст ответа, необходимо проверить", expected, actualAnswer);
    }

}