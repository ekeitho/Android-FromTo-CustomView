package com.ekeitho.from_to;

import android.databinding.BindingAdapter;

public class BindingUtil {

    /*
        If you don't have this then android studio throws an error:
        - Cannot find the setter for attribute 'bind:mode' with parameter type java.lang.String on com.ekeitho.from_to.CircleSquare.

        If you write "bind:mode" instead of just "mode", android studio throws a warning.
        - Lint error throw:Application namespace for attribute bind:mode will be ignored.
     */
    @BindingAdapter("bind:mode")
    public static void setUpItemMode(CircleSquare view, String mode) {
        view.setMode(mode);
    }
}
