package seedu.addressbook.commands;

import seedu.addressbook.model.person.ReadOnlyPerson;

import java.util.*;
import java.util.regex.Pattern;

import static seedu.addressbook.TextUi.LS;
import static seedu.addressbook.TextUi.getMessageForPersonListShownSummary;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case sensitive.
 */
public class FindPersonsByWordsInNameCommand extends Command {

    public static final String COMMAND_WORD = "find";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose names contain any of "
            + "the specified keywords (case-sensitive) and displays them as a list with index numbers."
            + LS + "Parameters: KEYWORD [MORE_KEYWORDS]..."
            + LS + "Example: " + COMMAND_WORD + " alice bob charlie";

    public static final Pattern ARGS_FORMAT =
            Pattern.compile("(?<keywords>\\S+(?:\\s+\\S+)*)"); // one or more keywords separated by whitespace

    private final Set<String> keywords;

    public FindPersonsByWordsInNameCommand(Set<String> keywords) {
        this.keywords = keywords;
    }


    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = getPersonsWithNameContainingAnyKeyword(keywords);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }

    /**
     * Retrieve all persons in the address book whose names contain some of the specified keywords.
     *
     * @param keywords for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithNameContainingAnyKeyword(Set<String> keywords) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            final Set<String> wordsInName = new HashSet<>(person.getName().getWordsInName());
            if (!Collections.disjoint(wordsInName, keywords)) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }

}
