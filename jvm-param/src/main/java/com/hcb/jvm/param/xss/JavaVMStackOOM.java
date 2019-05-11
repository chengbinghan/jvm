package com.hcb.jvm.param.xss;

/**
 * VM Args：-Xss2M(这时候不妨设置大些)
 *
 * @author zzm
 */
public class JavaVMStackOOM {

    int i = 0;
    private void dontStop() {
        while (true) {
            if(i >=999){
                break;
            }
        // byte[] bytes =  new byte[1024*1000*10];
        }
    }

    public void stackLeakByThread() {

        while (i < 10) {
            ++i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            }
            );
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}