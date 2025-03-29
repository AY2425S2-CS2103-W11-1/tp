package seedu.mentorstack.logic.parser;

import seedu.mentorstack.commons.core.index.Index;
import seedu.mentorstack.commons.exceptions.IllegalValueException;
import seedu.mentorstack.logic.commands.RemarkCommand;
import seedu.mentorstack.logic.parser.exceptions.ParseException;

import static java.util.Objects.requireNonNull;
import static seedu.mentorstack.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.mentorstack.logic.parser.CliSyntax.PREFIX_REMARK;

public class RemarkCommandParser {
    public RemarkCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args,
                PREFIX_REMARK);

        Index index;
        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    RemarkCommand.MESSAGE_USAGE), ive);
        }

        String remark = argMultimap.getValue(PREFIX_REMARK).orElse("");

        return new RemarkCommand(index, remark);
    }
}
