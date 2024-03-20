/*
 * @(#)CobolParser.java	 0.1.0
 *
 * Copyright (c) 2019 Julian M. Bass
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *
 */
package cobol;

import parse.Alternation;
import parse.Empty;
import parse.Parser;
import parse.Repetition;
import parse.Sequence;
import parse.tokens.CaselessLiteral;
import parse.tokens.Num;
import parse.tokens.QuotedString;
import parse.tokens.Symbol;
import parse.tokens.Tokenizer;
import parse.tokens.Word;

public class CobolParser {
	/**
	 * Return a parser that will recognize the selected COBOL source code constructs:
	 * 
	 * 
	 * This parser creates a <code>COBOL</code> object
	 * as an assembly's target.
	 *
	 * @return a parser that will recognize and build a 
	 *         <object>COBOL</object> from a source code file.
	 */
	public Parser cobol() {
		Alternation a = new Alternation();
		
		Symbol fullstop = new Symbol('.');
		fullstop.discard();
		
		a.add( display() );
		a.add( computeLine() );	
		a.add( constantValue() );
		
		a.add( ProgramID() );
		
		a.add( DivisionName() );
		
		a.add( SectionName() );
		
		a.add( DateWritten() );
		
		a.add(new Empty());
		return a;
	}
	
	/*
	 * Return a parser that will recognize the grammar:
	 * 
	 *    Program Identifier = Word
	 *
	 */
	protected Parser ProgramID() {
		Sequence s = new Sequence();
		s.add(new CaselessLiteral("program-id") );
		s.add(new Symbol('.').discard());	
		s.add(new Word().setAssembler(new Program_idAssembler()));
		return s;
	}



	/*
	 * Return a parser that will recognise the grammar:
	 * 
	 *    <divisionName> division
	 *
	 */
	protected Parser DivisionName() {
		Sequence s = new Sequence();
		s.add(new Word().setAssembler(new DivisionAssembler()));
		s.add(new CaselessLiteral("division") );
		s.add(new Symbol('.').discard());
		return s;
	}
	
	/*
	 * Return a parser that will recognize the grammar:
	 * 
	 *    Section Name = Word
	 *
	 */
	protected Parser SectionName() {
		Sequence s = new Sequence();
		s.add(new Word().setAssembler(new SectionNameAssembler()));
		s.add(new CaselessLiteral("section") );
		s.add(new Symbol('.').discard());	

		return s;
	}
	
	/*
	 * Return a parser that will recognise the grammar:
	 * 
	 *    working-storage section
	 *
	 */
	protected Parser DateWritten() {
		Sequence s = new Sequence();
		s.add(new CaselessLiteral("date-written") );
		s.add(new Symbol('.').discard());
		s.add(new Num());
		s.add(new Symbol('-').discard());

		//This next Word actually contains month and year (which are extracted in DateAssembler
		s.add(new Word());
		s.add(new Symbol('-').discard());
		s.add(new Word().discard());
		s.add(new Symbol('.').discard());
		s.setAssembler(new DateAssembler());
		return s;
	}
	
	/*
	 * ADDED BY GROUP 6
	 * 
	 * Returns a parser that will recognise the grammar:
	 * 
	 * 			<line number> <constant name> "value" <constant value>.
	 * */
	protected Parser constantValue() {
		//System.out.println("constantValue()");
		Sequence s = new Sequence();
		s.add( new Num() );
		s.add( new Word() );
		s.add( new CaselessLiteral("value") );
		s.add( new Num() );
		s.setAssembler(new ConstantValueAssembler());
		return s;
		
	}
	
	/*
	 * ADDED BY GROUP 6
	 * 
	 * Returns a parser that will recognise the grammar:
	 * 
	 * 			compute <variable> = <variable> <operator> <variable>
	 * */
	protected Parser computeLine() {
		//System.out.println("computeLine()");
		Sequence s = new Sequence();
		
		s.add(new CaselessLiteral("compute"));
		s.add(new Word()); //sum
		s.add(new Symbol('='));
		s.add(new Word()); //num_1
		
		//Adding possible operators
		Alternation a = new Alternation();
		a.add(new Symbol('+'));
		a.add(new Symbol('-'));
		a.add(new Symbol('/'));
		a.add(new Symbol('*'));
		
		s.add(a);
		s.add(new Word()); //num_2
		s.setAssembler(new ComputeLineAssembler());
		
		return s;
		
	}
	
	/*
	 * ADDED BY GROUP 6
	 * 
	 * Returns a parser that will recognise the grammar:
	 * 
	 * 			display quotedString word/number quotedString word/number quotedString word/number
	 * */
	protected Parser display() {
		//System.out.println("display()");
		Sequence s = new Sequence();
		
		s.add(new CaselessLiteral("display"));
		
		
		Alternation a = new Alternation();
		a.add( new QuotedString() );
		a.add( new Word() );
		a.add( new Num() );

		
//		Alternation a1 = new Alternation();
//		a1.add( new QuotedString() );
//		a1.add( new Word() );
//		a1.add( new Num() );
//
//		
//		Alternation a2 = new Alternation();
//		a2.add( new QuotedString() );
//		a2.add( new Word() );
//		a2.add( new Num() );
//
//		
//		Alternation a3 = new Alternation();
//		a3.add( new QuotedString() );
//		a3.add( new Word() );
//		a3.add( new Num() );
//
//		
//		Alternation a4 = new Alternation();
//		a4.add( new QuotedString() );
//		a4.add( new Word() );
//		a4.add( new Num() );
//
//		
//		Alternation a5 = new Alternation();
//		a5.add( new QuotedString() );
//		a5.add( new Word() );
//		a5.add( new Num() );
		
		Repetition r = new Repetition(a);
		s.add(r);
		s.add(new Num());
		
//		s.add(a1);
//		s.add(a2);
//		s.add(a3);
//		s.add(a4);
//		s.add(a5);
		
		s.setAssembler(new DisplayAssembler());
		
		return s;
		
	}


	/**
	 * Return the primary parser for this class -- cobol().
	 *
	 * @return the primary parser for this class -- cobol()
	 */
	public static Parser start() {
		return new CobolParser().cobol();
	}

	/**
	 * Returns a tokenizer that does not allow spaces to appear inside
	 * the "words" that identify cobol's grammar.
	 *
	 * @return a tokenizer that does not allow spaces to appear inside
	 * the "words" that identify cobol grammar.
	 */
	public static Tokenizer tokenizer() {
		Tokenizer t = new Tokenizer();
		t.wordState().setWordChars(' ', ' ', false);
		return t;
	}
	

}
