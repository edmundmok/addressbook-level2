package seedu.addressbook.ui;

import java.util.List;

/**
 * Formatter for printed outputs.
 */
public class Formatter {

	/** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";
    
    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";
    
    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    
    public Formatter(){
    }
    
    /**
     * Getter method for the line prefix when printing output.
     * @return the line prefix
     */
    public String getLinePrefix() {
    	return LINE_PREFIX;
    }
    
    /**
     * Getter method for the line separator when printing output.
     * @return the line separator
     */
    public String getLineSeparator() {
    	return LS;
    }
    
    /**
     * Getter method for the divider between states when printing output.
     * @return the divider
     */
    public String getDivider(){
    	return DIVIDER;
    }
    
    /** Formats a list of strings as a viewable indexed list. */
    public static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    public static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
}
