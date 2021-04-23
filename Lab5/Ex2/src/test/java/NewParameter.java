import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;
import org.apiguardian.api.API;

import java.time.LocalDateTime;
import java.util.Locale;

@API(status = API.Status.STABLE)
@Deprecated
public class NewParameter implements TypeRegistryConfigurer {

    @Override
    public void configureTypeRegistry(TypeRegistry registry) {
        registry.defineParameterType(new ParameterType<>("datetest", "\\d{4}-\\d{2}-\\d{2}", LocalDateTime.class, (String s) -> LocalDateTime.parse(s.concat("T00:00:00"))));
    }

    public Locale locale() {
        return Locale.ENGLISH;
    }
}
