package org.infobip.mobile.messaging.geo;

public class ConfigurationException extends RuntimeException {

    public ConfigurationException(String detailMessage) {
        super(detailMessage);
    }

    public ConfigurationException(Reason reason) {
        super(reason.message());
    }

    public ConfigurationException(Reason reason, String component) {
        super(String.format(reason.message(), component));
    }

    public ConfigurationException(Throwable throwable) {
        super(throwable);
    }

    public ConfigurationException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public enum Reason {
        MISSING_REQUIRED_SERVICE("Missing required service in AndroidManifest.xml, add: %s"),

        MISSING_REQUIRED_PERMISSION("Missing required permission in AndroidManifest.xml, add: %s"),

        CHECK_LOCATION_SETTINGS("Check your location settings.");

        private String message;

        Reason(String message) {
            this.message = message;
        }

        public String message() {
            return this.message;
        }

    }
}
