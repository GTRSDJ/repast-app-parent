package com.aaa.lee.app.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/7/30 12:30
 * @Description
 *      Ftp上传工具类
 **/
public class FtpUtil {

    public static Boolean uploadFile(String host, int port, String username, String password, String basePath,
                                     String filePath, String filename, InputStream input) throws IOException {
        // 1.创建临时目录
        String tempPath = "";
        // 2.创建FTPClient对象:作用就是通过FTPClient对象实现对ftp服务器的连接以及上传和下载
        FTPClient ftp = new FTPClient();
        try {
            // 3.定义返回码
            int reply;
            // 4.连接ftp，需要传入ftp服务器的IP地址以及端口号
            ftp.connect(host, port);
            // 5.登录ftp服务器
            ftp.login(username, password);
            // 6.如果连接登录成功后则返回230，如果连接和登录失败则返回503
            reply = ftp.getReplyCode();
            // 7.判断状态码
                // 通过isPositiveCompletion()方法判断状态码：返回值为Boolean类型，如果返回为true则说明连接和登录成功，如果返回false则失败
            if (!FTPReply.isPositiveCompletion(reply)) {
                // 8.确保已经退出连接，手动执行失去连接
                ftp.disconnect();
                return false;
            }
            // 表示连接ftp服务器并且已经处于登录成功状态
            // 9.创建所需要上传文件夹
                // 调用changeWorkingDirectory():判断所要上传的路径是否存在
                // 2019/10/21
                // 返回值类型为Boolean类型，true：该目录存在，false:该目录不存在，需要创建
            if (!ftp.changeWorkingDirectory(basePath + filePath)) {
                // 10.进行分割:
                    // 2019/10/21-->因为要一级一级的创建，必须要分割目录["2019","10","21"]
                String[] dirs = filePath.split("/");
                // basePath:/home/ftp/www
                tempPath = basePath;
                // 做循环创建目录，相当于在Linux服务器上使用mkdir命令
                for (String dir : dirs) {
                    // 第一次循环dir是2019
                    // 第二次循环dir是10
                    // 第三次循环dir是21
                    if(null == dir || "".equals(dir))
                        continue;// 跳出本次循环，继续下一次循环
                    // tempPath:/home/ftp/www
                    // tempPath:/home/ftp/www/2019
                    tempPath += "/" + dir;
                    // 11.再次判断该路径是否存在/home/ftp/www/2019
                    if (!ftp.changeWorkingDirectory(tempPath)) {
                        // 12.调用makeDirectory()方法创建目录:相当于在Linux中执行mkdir命令
                            // 返回值仍然为Boolean类型，true:创建成功，false:创建失败
                        if (!ftp.makeDirectory(tempPath)) {
                            return false;
                        } else {
                            // 13.再次判断所创建的目录是否存在
                            ftp.changeWorkingDirectory(tempPath);
                        }
                    }
                }
            }
            // 13.开启以二进制的形式进行上传文件(速度会非常快)
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            // ！！！！真正的上传：14.调用storeFile()方法实现文件的上传
                // 返回值类型是Boolean类型，true:上传成功，false:上传失败
            if (!ftp.storeFile(filename, input)) {
                return false;
            }
            // 14.关闭输入流
            input.close();
            // 15.退出ftp(相当于数据库中释放资源)
            ftp.logout();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException(e);
        } finally {
            if (ftp.isConnected()) {
                try {
                    // 16.断开连接
                    ftp.disconnect();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
        return true;
    }
}
