		import java.lang.*;
		import java.io.*;
		import java.util.*;
		import java.net.*;
		import java.awt.*;
		import javax.swing.JOptionPane;
		
		
    class win32exts_class
    {
    	public native int pop_edx();
        
        public native double pop_st0();
        
        public native int push_wstring( 
            String bstrVal);
        
        public native int push_bstr( 
            String bstrVal);
        
        public native int push_function( 
            String cls, Object obj, String func);
        
        public native int push_float( 
            float fVal);
        
        public native int push_double( 
            double fVal);
        
			  //-- no impl ***
        public native int push_variant( 
            Object obj);
        
        public native int push_value( 
            int intVal);
        
        public native int push_astring( 
            String bstrVal,
            int uAcp);
        
        public native int load_sym( 
            String bstrDll,
            String bstrFunc,
            boolean bAsRes);
        
        public native void free_sym( 
            String bstrFunc);
        
        public native String list_sym();
        
        public native int call( 
            int pfnFunc);
        
        public native int call_as_thiscall( 
            int pfnFunc);
        
        public native int call_as_fastcall( 
            int pfnFunc);
        
        public native int malloc( 
            int size,
            boolean bAllowExec);
        
        public native void free( 
            int pBuf);
        
        public native int access_memory( 
            int pBuf,
            int offset,
            int size,
            String bstrProtect);
        
        public native int global_function( 
            String cls, Object obj, String func,
            String bstrFlags);
        
        public native void global_destroy( 
            int pBuf);
        
        public native int read_value( 
            int pBuf,
            int offset,
            int size,
            boolean isSignExt);
            
        public native Object read_value_v2( 
            int pBuf,
            int offset,
            int size,
            boolean isSignExt);
        
        public native String read_astring( 
            int pBuf,
            int offset,
            int size,
            int uAcp);
        
        public native String read_wstring( 
            int pBuf,
            int offset,
            int size);
        
        public native int write_value( 
            int pBuf,
            int offset,
            int size,
            int iVal);
        
		    //-- no impl ***
        public native int write_value_v2( 
            int pBuf,
            int offset,
            int size,
            Object obj);
        
        public native int write_astring( 
            int pBuf,
            int offset,
            int size,
            String bstrVal,
            int uAcp);
        
        public native int write_wstring( 
            int pBuf,
            int offset,
            int size,
            String bstrVal);
        
        public native int convert_sym( 
            int hDll,
            String bstrFunc);
        
        public native void push_reset();
        
        public native int L( 
            String bstrText);
        
        public native int B( 
            String bstrText);
        
        public native int U( 
            String bstrText);
        
        public native int A( 
            String bstrText,
            int uAcp);
        
        public native int S( 
            String bstrText);
        
        public native int ptr( 
            Object obj);
        
        public native int strnlen( 
            int lText,
            int iChars);
        
        public native int wcsnlen( 
            int lText,
            int iChars);
        
        public native int create_dispatch( 
            int pfnCreate,
            int pfnGetIDsOfNames,
            int pfnInvoke,
            int pfnDelete);
        
        // create_object() is the only static method
        public static native win32exts_class create_object();
        
        public native int create_thread( 
            int pfnThread,
            int dwFlags,
            String bstrText);
        
        public native int arg( 
            int pBuf,
            int index);
        
        public native int current_dll();
        
        public native int last_error();
        
        public native int current_vm();
        
        public native int func_call(String strFunc);
        
        public native void destroy_object();
        
        public native int co_create_object(
						String bstrApp);

        public native int co_add_ref(
						int pDisp);

        public native int co_release(
						int pDisp);

        public native String co_list_sym(
						int pDisp);

        public native void co_push_start();

        public native Object co_pop_call(
						int pDisp,
						String bstrMember,
						int dwFlags);

        public native Object co_get(
						int pDisp,
						String bstrMember);

        public native Object co_invoke(
						int pDisp,
						String bstrMember);

        public native Object co_put(
						int pDisp,
						String bstrMember);

        public native Object co_put_ref(
						int pDisp,
						String bstrMember);

        public native int co_convert(
						Object pDisp);

        public native int co_query_interface(
						int pDisp,
						String bstrId);
						
	public native int shared_memory(
						String bstrName,
						int offset,
						int size,
						boolean bClose);

        public native void shared_destroy(
						int pBuf,
						int hHandle);
						
	public native Object set_seh_handler(
						Object pHandler);

		public native int create_ax_object(
						String strAppId, 
						int hWnd);

		public native int create_ax_object_v2(
						int pDisp, 
						int hWnd);

		public native int query_ax_object(
						String bstrName, 
						String bstrIID);

		public native String select_ax_object(
						String bstrName);

		public native void delete_ax_object(
						String bstrName);

		public native int pop_thread_id();

		public native void copy_memory(
						int lDst, 
						int lSrc, 
						int lSize);

		public native int realloc(
						int pBuf, 
						int size, 
						int bAllowExec);

		public native int push_raw_variant(
						int vt, 
						int lLowPart, 
						int lHighPart);

		public native int exec(
						String bstrExec, 
						int lType);

		public native int co_find_sym(
						int pDisp, 
						String bstrMember);

		public native int ref_sym( 
						String bstrFunc,
						String bstrSignature);
        
        private int __cpp_object = 0;
        
        static {
        try
				{
					System.loadLibrary("win32exts");
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null,"º”‘ÿwin32exts ß∞‹!!!", "º”‘ÿwin32exts ß∞‹", JOptionPane.PLAIN_MESSAGE);
				}
        }
    };
