package jp.co.chooyan.commander.core.config;

import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.*; 
import static org.junit.Assert.*;

/**
 *
 * @author chooyan_eng
 */
public class ConfigTest {
    
    Config mConfig;
    
    @Before
    public void init() throws IOException, URISyntaxException {
        mConfig = Config.parse(Paths.get("src", "test", "resources", "config.yml").toString());
    }
    
    @Test
    public void canGetAnalyzerName() {
        assertThat(mConfig.getInputFile(), is("test_command.txt"));
        assertThat(mConfig.getAnalyzerName(), is("jp.co.chooyan.commander.plugin.analyze.HistoryCountAnalyzer"));
        assertThat(mConfig.getParserName(), is("jp.co.chooyan.commander.plugin.parse.SimpleCommandParser"));
        assertThat(mConfig.getOutputterName(), is("jp.co.chooyan.commander.plugin.output.JsonOutputter"));
    }    
}
