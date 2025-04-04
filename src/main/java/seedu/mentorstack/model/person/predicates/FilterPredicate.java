package seedu.mentorstack.model.person.predicates;

import java.util.function.Predicate;

import seedu.mentorstack.model.person.Person;

/**
 * Generates filter predicates for student search.
 */
public class FilterPredicate {

    /**
     * Creates a filter predicate for student search.
     */
    public static Predicate<Person> createPredicate(String filterType, String filterValue) {
        switch (filterType) {
        case "n":
            return person -> person.getName().fullName.toLowerCase().contains(filterValue.toLowerCase());
        case "p":
            return person -> person.getPhone().value.toLowerCase().contains(filterValue.toLowerCase());
        case "e":
            return person -> person.getEmail().value.toLowerCase().contains(filterValue.toLowerCase());
        case "s":
            return person -> person.getSubjects().stream()
                    .map(subject -> subject.subjectName.toLowerCase()) // Extract subject name
                    .anyMatch(subjectName -> subjectName.contains(filterValue.toLowerCase())); // Match substring
        case "g":
            return person -> person.getGender().value.equalsIgnoreCase(filterValue);
        case "a":
            return person -> filterValue.equalsIgnoreCase("t")
                    ? person.getIsArchived().isArchived.equals("true")
                    : !person.getIsArchived().isArchived.equals("true");
        default:
            return null; // Invalid filter type
        }
    }
}
