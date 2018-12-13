package com.example.daemon.hardlibrary;

public class HardControl
{
	public static native int ledCtrl(int which,int status);
	public static native int ledOpen();
	public static native void ledClose();
	static 
	{
		System.loadLibrary("hardcontrol");
	}
}