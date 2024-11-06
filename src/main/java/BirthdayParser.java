import java.util.Collections;
import java.util.List;

public class BirthdayParser {
    public String say() {
        return "World";
    }

    public List<Birthday> parse(String fileContent) {
        if(fileContent.isBlank())
            return Collections.emptyList();
        return null;
    }
}
