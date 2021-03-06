package com.redorb.aemfuturecompiler;

import com.redorb.aemfuturecompiler.compilers.SassCompiler;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SassCompilerTest {

    @Test
    public void testBasicCompileFile() {
        SassCompiler sass = new SassCompiler();
        try {
            assertEquals(".selector {\n  margin: 10px; }\n  .selector .nested {\n    margin: 5px; }\n",
                         sass.compileFile("src/test/java/com/redorb/testingResources/basic_test.scss"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testBasicCompileString() {
        SassCompiler sass = new SassCompiler();
        try {
            assertEquals(".selector {\n  margin: 10px; }\n  .selector .nested {\n    margin: 5px; }\n",
                    sass.compileString("$foo: 10px;\n" +
                            ".selector {\n" +
                            "  margin: $foo;\n" +
                            "  .nested {\n" +
                            "    margin: $foo / 2;\n" +
                            "  }\n" +
                            "}"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testExtendCompileFile() {
        SassCompiler sass = new SassCompiler();
        try {
            assertEquals(".message, .success, .error, .warning {\n" +
                            "  border: 1px solid #ccc;\n" +
                            "  padding: 10px;\n" +
                            "  color: #333; }\n" +
                            "\n" +
                            ".success {\n" +
                            "  border-color: green; }\n" +
                            "\n" +
                            ".error {\n" +
                            "  border-color: red; }\n" +
                            "\n" +
                            ".warning {\n" +
                            "  border-color: yellow; }\n",
                    sass.compileFile("src/test/java/com/redorb/testingResources/extend_test.scss"));
        } catch (Exception e) {
            fail();
        }
    }
}
