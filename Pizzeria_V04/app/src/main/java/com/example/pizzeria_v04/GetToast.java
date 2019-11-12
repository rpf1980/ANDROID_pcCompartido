package com.example.pizzeria_v04;

import android.widget.Toast;

public class GetToast
{
    private static GetToast singleInstance;

    public String msg;

    private GetToast(String msg)
    {
        this.msg = msg;
    }

    public static GetToast getInstance(String str)
    {
        Toast toast;


        if(singleInstance == null)
        {
            singleInstance = new GetToast("");
        }
        return singleInstance;
    }
}
