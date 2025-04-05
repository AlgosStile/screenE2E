package core.ui;

public class TodoPage {
    public static final Target TODO_INPUT = new Target(
            "Todo input",
            "input[placeholder='What needs to be done?']"
    );

    public static final Target ADD_BUTTON = new Target(
            "Add button",
            "button.btn-primary"
    );

    public static final Target TODO_ITEMS = new Target(
            "Todo items",
            "ul.list-group li"
    );
}