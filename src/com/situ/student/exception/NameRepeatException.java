package com.situ.student.exception;
/**
 * 姓名重复自定义异常类
 *
 */
@SuppressWarnings("serial")
public class NameRepeatException extends Exception{
	
	public NameRepeatException (String msg) {
		super(msg);
	}

}
