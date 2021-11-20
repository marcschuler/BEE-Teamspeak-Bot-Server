package de.karlthebee.beebot.dyn;

import com.github.theholywaffle.teamspeak3.api.wrapper.Channel;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class DynReplacerTest {
    private final Channel testChannel = new Channel(
            Map.of(
                    "cid","1",
                    "channel_name","Test Channel"
            ));

    @Test
    public void testNoReplace(){
        assertEquals("no string",DynReplacer.replaceAll("no string",null,null));
        assertNull(DynReplacer.replaceAll(null, null, null));
        assertEquals("",DynReplacer.replaceAll("", null, null));
        assertEquals("null",DynReplacer.replaceAll("null", null, null));
    }

    @Test
    public void testSimpleReplace(){
        assertEquals("You are in channel 'Test Channel'",
                DynReplacer.replaceAll("You are in channel '%channel_name%'",testChannel,null));
    }
}
