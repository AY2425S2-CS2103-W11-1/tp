package seedu.mentorstack.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import javafx.scene.input.Clipboard;
import javafx.stage.Stage;

public class HelpWindowTest {

    private final HelpWindow helpWindow = new HelpWindow(new Stage());

    @Test
    public void show_helpWindowIsShown() {
        // Ensure window is initially not shown
        assertFalse(helpWindow.isShowing());

        // Show window and check
        helpWindow.show();
        assertTrue(helpWindow.isShowing());
    }

    @Test
    public void hide_helpWindowIsHidden() {
        helpWindow.show();
        assertTrue(helpWindow.isShowing());

        helpWindow.hide();
        assertFalse(helpWindow.isShowing());
    }

    @Test
    public void copyUrl_correctUrlCopiedToClipboard() {
        helpWindow.copyUrl();
        Clipboard clipboard = Clipboard.getSystemClipboard();
        assertEquals(HelpWindow.USERGUIDE_URL, clipboard.getString());
    }
}
