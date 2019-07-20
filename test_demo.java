		import java.lang.*;
		import java.io.*;
		import java.util.*;
		import java.net.*;
		import java.awt.*;
		//import *;
		
		
    class test_demo
    {
		// 定义 win32exts 接口对象
		public static win32exts_class win32exts = null;

		// 定义 一块公用缓冲区
    	public static int g_buf = 0;

		// 定义 需要调用的API
        public static int pMessageBoxW = 0;
        public static int pGetWindowTextW = 0;
        
        public static String OnEnumWindowsStaticCallback(int args)
        {
        		int hWnd  = win32exts.arg(args, 1);
        		int param = win32exts.arg(args, 2);
        		
        		win32exts.push_value(hWnd);
        		win32exts.push_value(g_buf);
        		win32exts.push_value(260);
        		win32exts.call(pGetWindowTextW);
        		String strText = win32exts.read_wstring(g_buf, 0, -1);
        		
        		System.out.println("hWnd = " + String.valueOf(hWnd) + ", Text = " + strText);
        		
        		return "1, 8";
        }
        
        public static void main(String []args) {
        		String sym = "call.test_demo.main()";
				// 创建 win32exts 对象
        		win32exts = win32exts_class.create_object();
        		
        		g_buf = win32exts.malloc(2*260, false);
        		pMessageBoxW = win32exts.load_sym("user32", "MessageBoxW", false);
        		win32exts.load_sym("kernel32", "*", false);
        		win32exts.load_sym("kernelbase", "*", false);
        		pGetWindowTextW = win32exts.load_sym("user32", "GetWindowTextW", false);
        		
				// 调用 MessageBoxW
        		win32exts.push_value(0);
        		win32exts.push_wstring("Java Text");
        		win32exts.push_wstring("Java Title");
        		win32exts.push_value(1);
        		win32exts.call(pMessageBoxW);
        		
				// 枚举所有窗口信息
        		int pEnumWindows = win32exts.load_sym("user32", "EnumWindows", false);
        		win32exts.push_function("test_demo", null, "OnEnumWindowsStaticCallback");
        		win32exts.push_value(233);
        		win32exts.call(pEnumWindows);
        		
        		
        }
    };
