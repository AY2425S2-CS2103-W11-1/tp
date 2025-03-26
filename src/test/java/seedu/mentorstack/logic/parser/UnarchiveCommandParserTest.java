package seedu.mentorstack.logic.parser;

import static seedu.mentorstack.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.mentorstack.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.mentorstack.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.mentorstack.testutil.TypicalIndexSets.INDEX_SET_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.mentorstack.logic.commands.ArchiveCommand;
import seedu.mentorstack.logic.commands.UnarchiveCommand;

/**
 * As we are only doing white-box testing, our test cases do not cover path variations
 * outside of the UnarchiveCommand code. For example, inputs "1" and "1 abc" take the
 * same path through the UnarchiveCommand, and therefore we test only one of them.
 * The path variation for those two cases occur inside the ParserUtil, and
 * therefore should be covered by the ParserUtilTest.
 */
public class UnarchiveCommandParserTest {

    private UnarchiveCommandParser parser = new UnarchiveCommandParser();

    @Test
    public void parse_validArgs_returnsDeleteCommand() {
        assertParseSuccess(parser, "1", new UnarchiveCommand(INDEX_SET_FIRST_PERSON));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", String.format(MESSAGE_INVALID_COMMAND_FORMAT, UnarchiveCommand.MESSAGE_USAGE));
    }
}