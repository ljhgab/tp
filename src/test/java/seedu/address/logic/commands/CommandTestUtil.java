package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CATEGORY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DEADLINE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRIORITY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.Sochedule;
import seedu.address.model.event.Event;
import seedu.address.model.event.EventNameContainsKeywordsPredicate;
import seedu.address.model.task.Task;
import seedu.address.model.task.TaskNameContainsKeywordsPredicate;

/**
 * Contains helper methods for testing commands.
 */
public class CommandTestUtil {

    // for logic in sochedule
    public static final String VALID_NAME_TASKONE = "Task One";
    public static final String VALID_NAME_TASKTWO = "Task Two";
    public static final String VALID_DEADLINE_TASKONE = "2022-01-01";
    public static final String VALID_DEADLINE_TASKTWO = "2022-01-02";
    public static final String VALID_PRIORITY_TASKONE = "5";
    public static final String VALID_PRIORITY_TASKTWO = "6";
    public static final String VALID_CATEGORY_HOMEWORK = "Homework";
    public static final String VALID_CATEGORY_PROJECT = "Project";
    public static final String VALID_TAG_IMPORTANT = "Important";
    public static final String VALID_TAG_DIFFICULT = "Difficult";
    // Task to input to parser
    public static final String NAME_DESC_TASKONE = " " + PREFIX_NAME + VALID_NAME_TASKONE;
    public static final String NAME_DESC_TASKTWO = " " + PREFIX_NAME + VALID_NAME_TASKTWO;
    public static final String DEADLINE_DESC_TASKONE = " " + PREFIX_DEADLINE + VALID_DEADLINE_TASKONE;
    public static final String DEADLINE_DESC_TASKTWO = " " + PREFIX_DEADLINE + VALID_DEADLINE_TASKTWO;
    public static final String PRIORITY_DESC_TASKONE = " " + PREFIX_PRIORITY + VALID_PRIORITY_TASKONE;
    public static final String PRIORITY_DESC_TASKTWO = " " + PREFIX_PRIORITY + VALID_PRIORITY_TASKTWO;
    public static final String CATEGORY_DESC_HOMEWORK = " " + PREFIX_CATEGORY + VALID_CATEGORY_HOMEWORK;
    public static final String CATEGORY_DESC_PROJECT = " " + PREFIX_CATEGORY + VALID_CATEGORY_PROJECT;
    public static final String TAG_DESC_IMPORTANT = " " + PREFIX_TAG + VALID_TAG_IMPORTANT;
    public static final String TAG_DESC_DIFFICULT = " " + PREFIX_TAG + VALID_TAG_DIFFICULT;
    // Invalid inputs
    public static final String INVALID_NAME_DESC = " " + PREFIX_NAME + "Invalid&"; // '&' is not allowed in names
    public static final String INVALID_DEADLINE_DESC = " " + PREFIX_DEADLINE + "2&20-01-02"; // not allowed in date
    public static final String INVALID_PRIORITY_DESC = " " + PREFIX_PRIORITY + "15"; // '15' is out of the bound
    public static final String INVALID_CATEGORY_DESC = " " + PREFIX_CATEGORY + "h@mework"; // not allowed in category
    public static final String INVALID_TAG_DESC = " " + PREFIX_TAG + "imp@rtant"; // not allowed in tag
    // Event
    public static final String VALID_EVENT_NAME_INTERVIEW = "Coding Interview";
    public static final String VALID_EVENT_STARTDATE_INTERVIEW = "2022-03-22";
    public static final String VALID_EVENT_STARTTIME_INTERVIEW = "13:00";
    public static final String VALID_EVENT_ENDDATE_INTERVIEW = "2022-03-22";
    public static final String VALID_EVENT_ENDTIME_INTERVIEW = "15:00";
    public static final String VALID_EVENT_TAG_INTERVIEW = "Final";
    public static final String VALID_EVENT_CATEGORY_INTERVIEW = "Work";
    public static final String VALID_EVENT_NAME_ORIENTATION = "SoC FOP";
    public static final String VALID_EVENT_STARTDATE_ORIENTATION = "2022-07-24";
    public static final String VALID_EVENT_STARTTIME_ORIENTATION = "07:00";
    public static final String VALID_EVENT_ENDDATE_ORIENTATION = "2022-07-31";
    public static final String VALID_EVENT_ENDTIME_ORIENTATION = "22:00";
    public static final String VALID_EVENT_TAG_ORIENTATION = "Fun";
    public static final String VALID_EVENT_CATEGORY_ORIENTATION = "School";

    public static final String PREAMBLE_WHITESPACE = "\t  \r  \n";
    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";


    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertCommandSuccess(Command command, Model actualModel, CommandResult expectedCommandResult,
            Model expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(Command command, Model actualModel, String expectedMessage,
            Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - the sochedule, filtered list and selected person in {@code actualModel} remain unchanged
     */
    public static void assertCommandFailure(Command command, Model actualModel, String expectedMessage) {
        Sochedule expectedSochedule = new Sochedule(actualModel.getSochedule());
        List<Task> expectedFilteredList = new ArrayList<>(actualModel.getFilteredTaskList());

        assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModel));
        assertEquals(expectedSochedule, actualModel.getSochedule());
        assertEquals(expectedFilteredList, actualModel.getFilteredTaskList());
    }

    /**
     * Updates {@code model}'s filtered list to show only the task at the given {@code targetIndex} in the
     * {@code model}'s sochedule.
     */
    public static void showTaskAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredTaskList().size());

        Task task = model.getFilteredTaskList().get(targetIndex.getZeroBased());
        final String[] splitName = task.getName().fullName.split("\\s+");
        model.updateFilteredTaskList(new TaskNameContainsKeywordsPredicate(Arrays.asList(splitName[0])));

        assertEquals(1, model.getFilteredTaskList().size());
    }

    /**
     * Updates {@code model}'s filtered list to show only the event at the given {@code targetIndex} in the
     * {@code model}'s sochedule.
     */
    public static void showEventAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredTaskList().size());

        Event event = model.getFilteredEventList().get(targetIndex.getZeroBased());
        final String[] splitName = event.getName().fullName.split("\\s+");
        model.updateFilteredEventList(new EventNameContainsKeywordsPredicate(Arrays.asList(splitName[0])));

        assertEquals(1, model.getFilteredTaskList().size());
    }

}
