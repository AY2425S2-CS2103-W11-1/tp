package seedu.mentorstack.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;
import seedu.mentorstack.commons.core.LogsCenter;

/**
 * Controller for a help page
 */
public class HelpWindow extends UiPart<Stage> {

    public static final String USERGUIDE_URL = "https://ay2425s2-cs2103-w11-1.github.io/tp/UserGuide.html";
    public static final String HELP_MESSAGE = "Refer to the user guide: " + USERGUIDE_URL;

    private static final Logger logger = LogsCenter.getLogger(HelpWindow.class);
    private static final String FXML = "HelpWindow.fxml";

    @FXML
    private Button copyButton;

    @FXML
    private Label helpMessage;

    @FXML
    private TitledPane commandExamplesPane;

    @FXML
    private TextArea addHelp;

    @FXML
    private TextArea deleteHelp;

    @FXML
    private TextArea archiveHelp;

    @FXML
    private TextArea editHelp;

    @FXML
    private TextArea findHelp;

    @FXML
    private TextArea viewHelp;

    @FXML
    private TextArea statsHelp;

    /**
     * Creates a new HelpWindow.
     *
     * @param root Stage to use as the root of the HelpWindow.
     */
    public HelpWindow(Stage root) {
        super(FXML, root);
        helpMessage.setText(HELP_MESSAGE);
        addHelp.setText("""
            add: Adds a student to Mentorstack.

            Parameters: n/NAME g/GENDER p/PHONE e/EMAIL s/SUBJECT...

            Example:
            add n/John Doe g/M p/98765432 e/johndoe@email.com
            s/CS2103 s/CS2101
            """);

        deleteHelp.setText("""
            delete: Deletes the students identified by the index number
            used in the displayed student list.

            Parameters:
            INDEX... (must be a positive integer)

            Example:
            delete 1 2
            """);

        archiveHelp.setText("""
            texts
            """);

        editHelp.setText("""
            texts
            """);

        findHelp.setText("""
            texts
            """);

        viewHelp.setText("""
            texts
            """);

        statsHelp.setText("""
            stats: Shows for the gender distribution of the students.

            Parameters:
            [s/SUBJECT]

            Example:
            stats (this will show the gender distribution of all students.)
            stats s/CS2103
            """);

        root.setMinWidth(600);
        root.setMinHeight(100);
        root.setWidth(600);
        root.setResizable(true);

        commandExamplesPane.expandedProperty().addListener((obs, wasExpanded, isNowExpanded) -> {
            if (isNowExpanded) {
                getRoot().setHeight(500);
            } else {
                getRoot().setHeight(300);
            }
        });
    }


    /**
     * Creates a new HelpWindow.
     */
    public HelpWindow() {
        this(new Stage());
    }

    /**
     * Shows the help window.
     *
     * @throws IllegalStateException <ul>
     *                               <li>
     *                               if this method is called on a thread other than the JavaFX Application Thread.
     *                               </li>
     *                               <li>
     *                               if this method is called during animation or layout processing.
     *                               </li>
     *                               <li>
     *                               if this method is called on the primary stage.
     *                               </li>
     *                               <li>
     *                               if {@code dialogStage} is already showing.
     *                               </li>
     *                               </ul>
     */
    public void show() {
        logger.fine("Showing help page about the application.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }

    /**
     * Copies the URL to the user guide to the clipboard.
     */
    @FXML
    private void copyUrl() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(USERGUIDE_URL);
        clipboard.setContent(url);
    }
}
