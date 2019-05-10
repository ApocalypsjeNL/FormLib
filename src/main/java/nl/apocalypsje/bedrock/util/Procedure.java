package nl.apocalypsje.bedrock.util;

@FunctionalInterface
public interface Procedure {

    /**
     * Performs this operation on the given argument.
     */
    void accept();
}