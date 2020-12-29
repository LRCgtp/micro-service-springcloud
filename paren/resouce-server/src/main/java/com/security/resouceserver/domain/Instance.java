package com.security.resouceserver.domain;

/**
 * @author ruicai.li@hand-china.com
 */
public class Instance {
    private String serviceId;
    private String Host;
    private int port;

    public Instance() {
    }

    public Instance(String serviceId, String host, int port) {
        this.serviceId = serviceId;
        Host = host;
        this.port = port;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getHost() {
        return Host;
    }

    public void setHost(String host) {
        Host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "Instance{" +
            "serviceId='" + serviceId + '\'' +
            ", Host='" + Host + '\'' +
            ", port=" + port +
            '}';
    }
}
