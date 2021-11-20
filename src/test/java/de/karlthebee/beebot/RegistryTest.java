package de.karlthebee.beebot;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegistryTest {

    private final Registry registry = Registry.getInstance();

    @Test
    public void testRegistry() {
        assertTrue(registry.getBeeBotByUid("").isEmpty());
        assertEquals(0, registry.getBots().size());
        assertTrue(registry.getModules().size() > 0);
        assertEquals(registry.getModules().get(0), registry.getModuleByShortName(registry.getModules().get(0).getShortName()).get());
    }
}
