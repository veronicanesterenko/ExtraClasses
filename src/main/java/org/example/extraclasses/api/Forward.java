package org.example.extraclasses.api;

public class Forward {
    private String url;
    private boolean redirect;

    public boolean isRedirect() {
        return redirect;
    }

    public String getUrl() {
        return url;
    }

    public Forward(String url) {
        this.url = url;
    }
}
