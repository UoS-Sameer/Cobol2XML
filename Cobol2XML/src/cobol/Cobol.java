/*
 * @(#)Cobol.java	 0.0.1
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

import utensil.*;

public class Cobol implements PubliclyCloneable {
	protected String commentLine;
	protected String program_id;
	protected String sectionName;
	protected String divisionName;
	protected int dayDateWritten = 0;
	protected String monthDateWritten;
	protected int yearDateWritten = 0;
	
	//ADDED BY GROUP 6, Constant Value
	protected String constantName;
	protected double constantValue;
	protected int lineNumber = 0;
	
	//Computing Line
	protected String computeVar_1;
	protected String computeVar_2;
	protected String computeOperator;
	protected String computeEqual;
	protected String computeSum;

	//Display
	protected String display1;
	protected String display2;
	protected int displayNumber = 0;
	protected String displayString1;
	protected String displayString2;
	protected String displayString3;
	
	//StopRun
	protected String stopRun;
	
	
	/**
	 * Return a copy of this object.
	 *
	 * @return a copy of this object
	 */
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// this shouldn't happen, since we are Cloneable
			throw new InternalError();
		}
	}
	/**
	 * Compares two objects for equality, treating nulls carefullly,
	 * and relying on the first object's implementation of <code>
	 * equals()</code>.
	 *
	 * @param   o1   one object
	 *
	 * @param   o2   the other
	 *
	 * @return  <code>true</code> if the objects are equal and
	 *          <code>false</code> otherwise.
	 */
	public static boolean ifCobolObjEqual(Object o1, Object o2) {
		if (o1 == null || o2 == null) {
			return o1 == null && o2 == null;
		}
		return o1.equals(o2);
	}
	/**
	 * Compares this object against the specified object. The 
	 * result is <code>true</code> if and only if the argument is 
	 * not <code>null</code> and is a <code>Coffee</code> object 
	 * whose attributes all equal this object's attributes.
	 *
	 * @param   o   the object to compare with.
	 *
	 * @return  <code>true</code> if the objects are equal and
	 *          <code>false</code> otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Cobol)) {
			return false;
		}
		Cobol c = (Cobol) o;
		
		
		if (!ifCobolObjEqual(program_id, c.program_id)) {
			return false;
		}
		
		if (!ifCobolObjEqual(sectionName, c.sectionName)) {
			return false;
		}
		

		return true;
	}
	
	 @Override
	  public int hashCode() {
	    return super.hashCode();
	  }


	/**
	 * Return line of commented text from the COBOL program.
	 *
	 * @return line of commented text from the COBOL program
	 */
	public String getCommentLine() {
		return commentLine;
	}
	

	/**
	 * Return the name of this COBOL program.
	 *
	 * @return the name of this COBOL program
	 */
	public String getProgram_ID() {
		return program_id;
	}

	/**
	 * Return the section name.
	 *
	 * @return the section name
	 */
	public String getSectionName() {
		return sectionName;
	}

	/**
	 * Return the division name.
	 *
	 * @return the division name
	 */
	public String getDivisionName() {
		return divisionName;
	}
	
	/**
	 * Return the dayDateWritten of this COBOL program.
	 *
	 * @return the dayDateWritten of this COBOL program
	 */
	public int getDayDateWritten() {
		return dayDateWritten;
	}

	
	/**
	 * Return the monthWritten of this COBOL program.
	 *
	 * @return the monthWritten of this COBOL program
	 */
	public String getMonthDateWritten() {
		return monthDateWritten;
	}
	
	/**
	 * Return the dayDateWritten of this COBOL program.
	 *
	 * @return the dayDateWritten of this COBOL program
	 */
	public int getYearDateWritten() {
		return yearDateWritten;
	}
	
	/**
	 * Return the constantName of this COBOL program.
	 *
	 * @return the constantName of this COBOL program
	 */
	public String getConstantName() {
		return constantName;
	}
	
	/**
	 * Return the constantValue of this COBOL program.
	 *
	 * @return the constantValue of this COBOL program
	 */
	public double getConstantValue() {
		return constantValue;
	}
	
	/**
	 * Return the lineNumber of this COBOL program.
	 *
	 * @return the lineNumber of this COBOL program
	 */
	public int getLineNumber() {
		return lineNumber;
	}
	
	/**
	 * Set a line of commented text from the COBOL program.
	 *
	 * @return line of commented text from the COBOL program
	 */
	public void setCommentLine(String commentLine) {
		this.commentLine = commentLine;
	}


	/**
	 * Set the name of this cobol file.
	 *
	 * @param   String   the name
	 */
	public void setProgram_ID(String program_idString) {
		this.program_id = program_idString;
	}

	/**
	 * Set the dayDateWritten of this COBOL program.
	 *
	 * @param the dayDateWritten of this COBOL program
	 */
	public void setDayDateWritten(int dayDateWritten) {
		this.dayDateWritten = dayDateWritten;
	}
	
	/**
	 * Return the monthWritten of this COBOL program.
	 *
	 * @return the monthWritten of this COBOL program
	 */
	public void setMonthDateWritten(String monthDateWritten) {
		this.monthDateWritten = monthDateWritten;
	}
	
	/**
	 * Set the yearDateWritten of this COBOL program.
	 *
	 * @param the yearDateWritten of this COBOL program
	 */
	public void setYearDateWritten(int yearDateWritten) {
		this.yearDateWritten = yearDateWritten;
	}
	

	/**
	 * Set the section name 
	 *
	 * @param  String sectionName
	 */
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	
	/**
	 * Set the division name 
	 *
	 * @param  String divisionName
	 */
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	
	/**
	 * Set the constant name 
	 *
	 * @param  String constantName
	 */
	public void setConstantName(String constantName) {
		this.constantName = constantName;
	}
	
	/**
	 * Set the constant value 
	 *
	 * @param  double constantValue
	 */
	public void setConstantValue(double constantValue) {
		this.constantValue = constantValue;
	}
	
	/**
	 * Set the line number
	 *
	 * @param  integer lineNumber
	 */
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	
	public String getComputeVar_1() {
		return computeVar_1;
	}
	
	public void setComputeVar_1(String computeVar_1) {
		this.computeVar_1 = computeVar_1;
	}
	
	public void setComputeVar_1(int computeVar_1) {
		this.computeVar_1 = "" + computeVar_1;
	}
	
	public String getComputeVar_2() {
		return computeVar_2;
	}
	
	public void setComputeVar_2(String computeVar_2) {
		this.computeVar_2 = computeVar_2;
	}
	
	public void setComputeVar_2(int computeVar_2) {
		this.computeVar_2 = "" + computeVar_2;
	}
	
	
	public String getComputeOperator() {
		return computeOperator;
	}
	
	public void setComputeOperator(String computeOperator) {
		this.computeOperator = computeOperator;
	}
	
	public String getComputeEqual() {
		return computeEqual;
	}
	
	public void setComputeEqual(String computeEqual) {
		this.computeEqual = computeEqual;
	}
	
	public String getComputeSum() {
		return computeSum;
	}
	
	public void setComputeSum(String computeSum) {
		this.computeSum = computeSum;
	}
	
	public String getDisplay1() {
		return display1;
	}
	
	public void setDisplay1(String display1) {
		this.display1 = display1;
	}
	
	public String getDisplay2() {
		return display2;
	}
	
	public void setDisplay2(String display2) {
		this.display2 = display2;
	}
	
	public int getDisplayNumber() {
		return displayNumber;
	}
	
	public void setDisplayNumber(int displayNumber) {
		this.displayNumber = displayNumber;
	}
	
	public String getDisplayString1() {
		return displayString1;
	}
	
	public void setDisplayString1(String displayString1) {
		this.displayString1 = displayString1;
	}
	
	public String getDisplayString2() {
		return displayString2;
	}
	
	public void setDisplayString2(String displayString2) {
		this.displayString2 = displayString2;
	}
	
	public String getDisplayString3() {
		return displayString3;
	}
	
	public void setDisplayString3(String displayString3) {
		this.displayString3 = displayString3;
	}
	
	public String getStopRun() {
		return stopRun;
	}
	
	public void setStopRun(String stopRun) {
		this.stopRun = stopRun;
	}
	

	/**
	 * Return a textual description of this cobol type.
	 * 
	 * @return a textual description of this cobol type
	 */
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append(program_id);
		buf.append(", ");
		buf.append(divisionName);
		buf.append(", ");
		buf.append(sectionName);
		
		return buf.toString();
	}
}
