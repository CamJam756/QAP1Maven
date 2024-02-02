import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SuggestionEngineTest {
    private SuggestionEngine suggestionEngine;

    @BeforeEach
    public void setUp() {
        suggestionEngine = new SuggestionEngine();
    }

    @Test
    public void testGenerateSuggestionsForExistingWord() {
        String suggestions = suggestionEngine.generateSuggestions("hello");
        assertEquals("", suggestions);
    }

    @Test
    public void testGenerateSuggestionsForNonExistingWord() {
        String suggestions = suggestionEngine.generateSuggestions("helo");
        assertNotNull(suggestions);
    }

    @Test
    public void testLoadDictionaryData() {
        assertDoesNotThrow(() -> suggestionEngine.loadDictionaryData(Paths.get("testDictionary.txt")));
    }

    @Test
    public void testWordSuggestionDBInitialization() {
        assertNotNull(suggestionEngine.getWordSuggestionDB());
    }

    @Test
    public void testWordSuggestionDBPopulation() {
        suggestionEngine.loadDictionaryData(Paths.get("testDictionary.txt"));
        assertTrue(suggestionEngine.getWordSuggestionDB().size() > 0);
    }
}