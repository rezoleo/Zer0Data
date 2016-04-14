package com.rezoleo.zer0data.error;

/**
 * Created by Thomas on 8/01/16.
 */
public class ErrorReferential {
    protected static fr.applicationcore.error.ErrorReferential instance = fr.applicationcore.error.ErrorReferential.getInstance();

    public ErrorReferential() {
        fr.applicationcore.error.ErrorReferential.addError("ERROR 1", "Une erreur est survenue");
    }
}
