package org.rt.advent.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface BufferedReaderFactory {
    public BufferedReader openReader() throws IOException;
}
