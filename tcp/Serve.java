package at.sjq.com.tcp;

public class Server {
    /*
    线程池 用于处理多个客户端上传文件的请求
     */
    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);



    public void doFileUpload(){
        try{
            //使用8888端口创建服务器
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务器：服务器启动成功，为客户端提供文件传输功能，等待客户端请求连接加载套接字模块");
            while(true){
                //等待客户端连接
                final Socket socket = serverSocket.accept();

                ServeFileUploadRunnable serveFileUploadRunnable = new ServeFileUploadRunnable(socket);
                executorService.submit(serveFileUploadRunnable);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
