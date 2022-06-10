package at.sjq.com.tcp;

public class ServerSocketConfig {

    private String ip="192.168.64.1";
    private Integer port=8888;

    public String getIp() {
        return ip;
    }

    public ServerSocketConfig() {
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
