**Test scenarios**
Main task: 

1) A drop-down list in the “Questions about important things” section. 
Need to test: when you click on the arrow, the corresponding text opens.

2) Scooter ordering. 
Need to check the whole floo of a positive scenario with two sets of data. 
Check the entry points to the scenario, there are two of them: the “Order” button at the top of the page and at the bottom.
What the positive scenario consists of:
- Click the “Order” button. There are two order buttons on the page.
- Fill out the order form.
- Verify that a pop-up window appears with a message that the order was successfully created.

Additional task:

Additional test scenarios
1) Test: if you click on the “Scooter” logo, you will get to the main page of “Scooter”.
2) Test: if you click on the Yandex logo, the Yandex home page will open in a new window.
3) Check errors for all fields of the order form.
4) Check: if you enter an incorrect order number, you will get to the order status page. 
5) It should say that there is no such order.

**Directories and classes description.

The **browsers** directory contains the **WebDriverVendors** class, 
which contains drivers for launching Environments and running the browser in full-screen mode.

The **constants** directory contains all sorts of constants.

The **page** directory contains POM objects, divided by page type:
1. main 
2. Order page “For whom the scooter is for”
3. Order page “About renting”
4. Order page after all data has been entered - finalization
5. Order number search page

The tests are placed in the test folder.
Main task:
The **QuestionTest** class tests the FAQ block: when you click on the arrow, 
the corresponding text opens.

The **ScooterOrderTest** class tests the entire floo of a positive scenario with two data sets and on two buttons.

Additional assignment: 
Class **ClickLogoScooterTest** verifies that clicking on the Scooter logo will take you to the Scooter homepage

Class **ClickYandexTest** checks that clicking on the Yandex logo will open the Yandex home page in a new window.

The **ErrorsWithIncorrectOrderFieldsTest** class checks for errors in order fields.

The **SearchEmptyStatusOrderTest** class checks that if you enter an incorrect order number, you will get to the order status page. 
It should say that there is no such order.
