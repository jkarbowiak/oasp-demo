package org.zosia.oasp.to;

import org.zosia.oasp.type.AudioBookFormat;

public class AudioBookExemplarTo extends BookExemplarTo {

    public AudioBookExemplarTo(String serialNumber, AudioBookFormat format) {
        super(serialNumber);
        this.format = format;
    }

    public AudioBookExemplarTo(Long id, String serialNumber, AudioBookFormat format) {
        super(id, serialNumber);
        this.format = format;
    }

    private AudioBookFormat format;

    public AudioBookFormat getFormat() {
        return format;
    }

    public void setFormat(AudioBookFormat format) {
        this.format = format;
    }
}
