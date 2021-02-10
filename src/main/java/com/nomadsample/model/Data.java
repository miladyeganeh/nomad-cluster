package com.nomadsample.model;

public class Data {
    private String remoteAddr;
    private String remotePort;
    private String servername;
    private String serverPort;
    private String remoteHost;
    private String localAddr;
    private String localPort;
    private String version;

    public Data(String remoteAddr, String remotePort, String servername, String serverPort, String remoteHost,
                String localAddr, String localPort, String version) {
        this.remoteAddr = remoteAddr;
        this.remotePort = remotePort;
        this.servername = servername;
        this.serverPort = serverPort;
        this.remoteHost = remoteHost;
        this.localAddr = localAddr;
        this.localPort = localPort;
        this.version = version;
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    public String getRemotePort() {
        return remotePort;
    }

    public void setRemotePort(String remotePort) {
        this.remotePort = remotePort;
    }

    public String getServername() {
        return servername;
    }

    public void setServername(String servername) {
        this.servername = servername;
    }

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }

    public String getRemoteHost() {
        return remoteHost;
    }

    public void setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
    }

    public String getLocalAddr() {
        return localAddr;
    }

    public void setLocalAddr(String localAddr) {
        this.localAddr = localAddr;
    }

    public String getLocalPort() {
        return localPort;
    }

    public void setLocalPort(String localPort) {
        this.localPort = localPort;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Data{" +
                "remoteAddr= " + remoteAddr + ":" + remotePort + '\n' +
                ", remoteHost= " + remoteHost + '\n' +
                ", localAddr= " + localAddr + ":" + localPort + '\n' +
                ", version= " + version + '\n' +
                '}';
    }
}
