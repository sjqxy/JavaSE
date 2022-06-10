package at.sjq.com.tcp;
import java.io.*;
import java.net.Socket;
import java.time.LocalDate;

//服务器端处理客户端文件上传请求的线程任务
public class ServeFileUploadRunnable implements Runnable{
    private final Socket socket;

    public ServeFileUploadRunnable(Socket socket) {
        this.socket = socket;
    }
    /*根据本地磁盘路径 生成服务器的磁盘路径
   @param localFilePathName 客户端上传的本地磁盘路径
   @return 服务器的磁盘路径
    */
    public String generatorServerPathName(String localFilePathName){
        StringBuffer  serverPathName= new StringBuffer("D:\\test\\");
        //获取当前时间
        LocalDate localDate =LocalDate.now();
        //拼接当前时间
        serverPathName.append(localDate.getYear()).append("\\");
        serverPathName.append(localDate.getMonthValue()).append("\\");
        serverPathName.append(localDate.getDayOfMonth()).append("\\");

        File file =new File(serverPathName.toString());
        //如果目录不存在
        if (!file.exists()){
            //那么创建
            file.mkdirs();
        }
        serverPathName.append(System.currentTimeMillis());
        //文件名后缀
        final String suffixName=localFilePathName.substring(localFilePathName.lastIndexOf("."));
        serverPathName.append(suffixName);
        return serverPathName.toString();


    }

    @Override
    public void run() {
        System.out.println("服务器线程"+Thread.currentThread().getName()+"开始处理文件上传任务");
        long stime = System.currentTimeMillis();
        try{


            if (null!=socket){
                System.out.println("服务器：服务器接收到了客户端的文件上传请求，客户端的信息："+socket);

                /*                                     获取客户端上传的本地文件路径            */
                final InputStream inputStream = socket.getInputStream();
                byte[] buffer = new byte[1024];

                int bytelength = inputStream.read(buffer);

                //获取客户端上传文件的本地文件路径名
                String localFilePathName = new String(buffer,0,bytelength);

                //服务器告诉客户端 我收到了你上传的本地文件路径
                final OutputStream outputStream = socket.getOutputStream();


                String responseDate="服务器已经收到了客户端上上传文件的本地路径，本地路径为"+localFilePathName;
                outputStream.write(responseDate.getBytes());

                /*                                     处理上传的文件            */
                //根据本地上传的路径生成服务器的磁盘路径
                final String serverFilepathName = generatorServerPathName(localFilePathName);

                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(serverFilepathName));

                System.out.println("服务器：开始将本地客户端文件上传的文件写到"+serverFilepathName);
                while((bytelength=inputStream.read(buffer))!=-1){
                    bufferedOutputStream.write(buffer,0,bytelength);
                }
                System.out.println("服务器：结束将本地客户端文件上传的文件写到"+serverFilepathName);

                responseDate="服务器处理客户端上传的文件处理成功";
                outputStream.write(responseDate.getBytes());

                socket.shutdownOutput();





            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long etime = System.currentTimeMillis();
        System.out.println("服务器线程"+Thread.currentThread().getName()+"结束处理文件上传任务"+" 执行时长："+(etime-stime)+"毫秒");
    }
}
