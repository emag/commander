package jp.co.chooyan.commander;

import org.junit.Test;

/**
 *
 * @author chooyan_eng
 */
public class ExecutorTest {
    @Test
    public void testMain() {
        Executor.main(new String[]{"/usr/local/workdir/java/commander/src/test/resources"});
    }
}
