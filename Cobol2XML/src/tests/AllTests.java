package tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ CaselessLiteralTest.class, CobolTest.class, ComputeLineAssemblerTest.class,
		ConstantValueAssemblerTest.class, DateAssemblerTest.class, DisplayAssemblerTest.class,
		DivisionAssemblerTest.class, NumTest.class, ParserTest.class, Program_idAssemblerTest.class,
		QuotedStringTest.class, SectionNameAssemblerTest.class, StopRunAssemblerTest.class, SymbolTest.class,
		TokenAssemblyTest.class, TokenizerTest.class, TokenTest.class, WordTest.class, XMLPayloadTest.class })
public class AllTests {

}
