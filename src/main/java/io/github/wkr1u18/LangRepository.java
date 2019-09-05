package io.github.wkr1u18;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class LangRepository {
    private List<Lang> languages;

    LangRepository() {
        languages = new ArrayList<Lang>();
        languages.add(new Lang(1L, "Hello", "en"));
        languages.add(new Lang(2L, "Siemanko", "pl"));
    }

    Optional<Lang> findById (Long id) {
        return languages
                .stream()
                .filter(l -> l.getId().equals(id))
                .findFirst();
    }
}
