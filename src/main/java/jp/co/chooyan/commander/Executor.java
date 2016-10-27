/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.chooyan.commander;

import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.chooyan.commander.core.ClassInstanciator;
import jp.co.chooyan.commander.core.analyze.Analyzer;
import jp.co.chooyan.commander.core.config.Config;
import jp.co.chooyan.commander.core.output.Outputter;
import jp.co.chooyan.commander.core.parse.Parser;

/**
 *
 * @author tsuyoshi-chujo
 */
class Executor {
    
    private static final String CONFIG_FILE = "config.yml";
    
    public static void main(String args[]) {
        if (args.length != 1) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, "[usage] only one argment is acceptable, and it must be path/to/basedir, which has config.xml");
            return;
        }
        
        String basepath = args[0];
        
        Config config = Config.parse(Paths.get(basepath, CONFIG_FILE).toString());

        Parser parser = (Parser) ClassInstanciator.instanciate(config.getParserName());
        Analyzer analyzer = (Analyzer) ClassInstanciator.instanciate(config.getAnalyzerName());
        Outputter outputter = (Outputter) ClassInstanciator.instanciate(config.getOutputterName());
        
        Object parsedObject = parser.parse(Paths.get(basepath, config.getInputFile()).toString());
        Object analyzedObject = analyzer.analyze(parsedObject);
        outputter.output(analyzedObject);
    }
}
