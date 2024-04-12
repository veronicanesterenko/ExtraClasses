package org.example.extraclasses.api;

public class Forward {

    private String uri;
    private boolean redirect;

    public Forward(String uri, boolean redirect) {
        this.uri = uri;
        this.redirect = redirect;
    }

    public boolean isRedirect() {
        return redirect;
    }

    public String getUri() {
        return uri;
    }

    public Forward(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "Forward{" +
                "uri='" + uri + '\'' +
                ", redirect=" + redirect +
                '}';
    }
}
