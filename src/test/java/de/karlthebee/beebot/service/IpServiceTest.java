package de.karlthebee.beebot.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IpServiceTest {

    private final IPService ipService = new IPService();

    @Test
    public void testFlags(){
        assertEquals(ipService.countryCodeToEmoji("us"),"\uD83C\uDDFA\uD83C\uDDF8");
        assertEquals(ipService.countryCodeToEmoji("de"),"\uD83C\uDDE9\uD83C\uDDEA");
        assertEquals(ipService.countryCodeToEmoji("DE"),"\uD83C\uDDE9\uD83C\uDDEA");
        System.out.println(ipService.countryCodeToEmoji("DE"));
    }
}
