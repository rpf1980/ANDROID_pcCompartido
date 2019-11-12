package com.example.pizzeria_v04;

import android.widget.Toast;

public class GetToast
{
    private static GetToast singleInstance;

    public String msg;
    public Toast toast;

    private GetToast(String msg, Toast toast)
    {
        this.msg = msg;
        this.toast = toast;

        //toast.makeText()
    }

    public static GetToast getInstance(String str)
    {
        if(singleInstance == null)
        {
            //singleInstance = new GetToast("");
        }
        return singleInstance;
    }
}
