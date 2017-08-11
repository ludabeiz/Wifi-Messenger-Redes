package it.polimi.deib.p2pchat.discovery.services;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
//  import org.springframework.util.Assert;


@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter(AccessLevel.PACKAGE)
public class Hop {

    /**
     * Name of this hop.
     */
    private final String rel;

    /**
     * Collection of URI Template parameters.
     */
    private final @Wither Map<String, ? extends Object> parameters;

    /**
     * Creates a new {@link Hop} for the given relation name.
     *
     * @param rel must not be {@literal null} or empty.
     * @return
     */
    public static Hop rel(String rel) {

        //Assert.hasText(rel, "Relation must not be null or empty!");

        // return new Hop(rel, Collections.<String, Object> emptyMap());
    }

    /**
     * Add one parameter to the map of parameters.
     *
     * @param name must not be {@literal null} or empty.
     * @param value can be {@literal null}.
     * @return
     */
    public Hop withParameter(String name, Object value) {

        //Assert.hasText(name, "Name must not be null or empty!");

        HashMap<String, Object> parameters = new HashMap<String, Object>(this.parameters);
        parameters.put(name, value);

        return new Hop(rel, parameters);
    }

    /**
     * Returns whether the {@link Hop} has parameters declared.
     *
     * @return
     */
    boolean hasParameters() {
        return !this.parameters.isEmpty();
    }

    /**
     * Create a new {@link Map} starting with the supplied template parameters. Then add the ones for this hop. This
     * allows a local hop to override global parameters.
     *
     * @param globalParameters must not be {@literal null}.
     * @return a merged map of URI Template parameters, will never be {@literal null}.
     */
    Map<String, Object> getMergedParameters(Map<String, Object> globalParameters) {

        //Assert.notNull(globalParameters, "Global parameters must not be null!");

        Map<String, Object> mergedParameters = new HashMap<String, Object>();

        mergedParameters.putAll(globalParameters);
        mergedParameters.putAll(this.parameters);

        return mergedParameters;
    }
}
