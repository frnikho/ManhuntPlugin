package fr.nikho.manhunt.exception.world;

import fr.nikho.manhunt.exception.ManhuntException;

public class ManhuntWorldGeneratorException extends ManhuntException {

    public ManhuntWorldGeneratorException(String msg) {
        super(msg, "WorldGeneratorException");
    }

}
