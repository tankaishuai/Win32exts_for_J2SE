		import java.lang.*;
		import java.io.*;
		import java.util.*;
		import java.net.*;
		import java.awt.*;
		//import *;
		
		
    class test_demo
    {
		// ���� win32exts �ӿڶ���
		public static win32exts_class win32exts = null;

		// ���� һ�鹫�û�����
    		public static int g_buf = 0;
        
        public static String OnEnumWindowsStaticCallback(int args)
        {
        		int hWnd  = win32exts.arg(args, 1);
        		int param = win32exts.arg(args, 2);
        		
        		win32exts.push_value(hWnd);
        		win32exts.push_value(g_buf);
        		win32exts.push_value(260);
        		win32exts.func_call("GetWindowTextW");
        		String strText = win32exts.read_wstring(g_buf, 0, -1);
        		
        		System.out.println("hWnd = " + String.valueOf(hWnd) + ", Text = " + strText);
        		
        		return "1, 8";
        }
        
        public static void main(String []args) {
			// ���� win32exts ����
        		win32exts = win32exts_class.create_object();
        		
        		g_buf = win32exts.malloc(2*260, false);
        		win32exts.load_sym("kernel32", "*", false);
        		win32exts.load_sym("kernelbase", "*", false);
			win32exts.load_sym("user32", "*", false);
        		
			// ���� MessageBoxW
        		win32exts.push_value(0);
        		win32exts.push_wstring("Java Text");
        		win32exts.push_wstring("Java Title");
        		win32exts.push_value(1);
        		win32exts.func_call("MessageBoxW");
        		
			// ö�����д�����Ϣ
        		win32exts.push_function("test_demo", null, "OnEnumWindowsStaticCallback");
        		win32exts.push_value(233);
        		win32exts.func_call("EnumWindows");
        		
        		
        }
    };
